package com.apps.omnipotent.system.db.config;
/**
 * Created by cles on 2020/5/6 23:24
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.stat.DruidDataSourceStatManager;
import com.apps.omnipotent.system.db.bean.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Set;

/**
 * @description: 动态数据源
 * https://blog.csdn.net/z357904947/article/details/89157281
 * @author cles
 * @Date 2020/5/6 23:24
 */
@Slf4j
public class DbConfig extends AbstractRoutingDataSource {

    private boolean debug = true;
    private final String ORACLE_DERIVE_CLASS = "oracle.jdbc.driver.OracleDriver";
    private final String MYSQL_DERIVE_CLASS = "com.mysql.cj.jdbc.Driver";
    private Map<Object, Object> dynamicTargetDataSources;
    private Object dynamicDefaultTargetDataSource;

    @Override
    protected Object determineCurrentLookupKey() {
        String datasource = DbSourceHolder.getDataSource();
        if (!StringUtils.isEmpty(datasource)) {
            Map<Object, Object> dynamicTargetDataSources = this.dynamicTargetDataSources;
            if (dynamicTargetDataSources.containsKey(datasource)) {
                log.info("---当前数据源：" + datasource + "---");
            } else {
                log.info("不存在的数据源：");
                return null;
//                    throw new ADIException("不存在的数据源："+datasource,500);
            }
        } else {
            log.info("---当前数据源：默认数据源---");
        }
        return datasource;
    }

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
        this.dynamicTargetDataSources = targetDataSources;

    }

    /**
     * 添加数据源
     * @param key
     * @param driveClass
     * @param url
     * @param username
     * @param password
     * @param databasetype
     * @return
     */
    public boolean createDataSource(String key, String driveClass, String url, String username, String password, String databasetype) {
        try {
            try { // 排除连接不上的错误
                Class.forName(driveClass);
                // 相当于连接数据库
                DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                return false;
            }
//            HikariDataSource druidDataSource = new HikariDataSource();
            @SuppressWarnings("resource")
            DruidDataSource druidDataSource = new DruidDataSource();
            if("mysql".equalsIgnoreCase(databasetype)) {
                driveClass = MYSQL_DERIVE_CLASS;
            } else if("oracle".equalsIgnoreCase(databasetype)){
                driveClass = ORACLE_DERIVE_CLASS;
                //是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。
                druidDataSource.setPoolPreparedStatements(true);
                druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(50);
//                int sqlQueryTimeout = ADIPropUtil.sqlQueryTimeOut();
                //对于耗时长的查询sql，会受限于ReadTimeout的控制，单位毫秒
//                druidDataSource.setConnectionProperties("oracle.net.CONNECT_TIMEOUT=6000;oracle.jdbc.ReadTimeout="+sqlQueryTimeout);
            }

            druidDataSource.setName(key);
            druidDataSource.setDriverClassName(driveClass);
            druidDataSource.setUrl(url);
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            //初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时
            druidDataSource.setInitialSize(50);
            //最大连接池数量
            druidDataSource.setMaxActive(200);
            //获取连接时最大等待时间，单位毫秒。当链接数已经达到了最大链接数的时候，应用如果还要获取链接就会出现等待的现象，等待链接释放并回到链接池，如果等待的时间过长就应该踢掉这个等待，不然应用很可能出现雪崩现象
            druidDataSource.setMaxWait(60000);
            //最小连接池数量
            druidDataSource.setMinIdle(40);
            String validationQuery = "select 1 from dual";

            // 申请连接时执行validationQuery检测连接是否有效，这里建议配置为TRUE，防止取到的连接不可用
            druidDataSource.setTestOnBorrow(true);
            // 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
            druidDataSource.setTestWhileIdle(true);
            // 用来检测连接是否有效的sql，要求是一个查询语句。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会起作用。
            druidDataSource.setValidationQuery(validationQuery);
            // 属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有：监控统计用的filter:stat日志用的filter:log4j防御sql注入的filter:wall
            druidDataSource.setFilters("stat");
            // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
            druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
            // 配置一个连接在池中最小生存的时间，单位是毫秒，这里配置为3分钟180000
            druidDataSource.setMinEvictableIdleTimeMillis(180000);
            // 打开druid.keepAlive之后，当连接池空闲时，池中的minIdle数量以内的连接，空闲时间超过minEvictableIdleTimeMillis，则会执行keepAlive操作，即执行druid.validationQuery指定的查询SQL，一般为select * from dual，只要minEvictableIdleTimeMillis设置的小于防火墙切断连接时间，就可以保证当连接空闲时自动做保活检测，不会被防火墙切断
            druidDataSource.setKeepAlive(true);
            // 是否移除泄露的连接/超过时间限制是否回收。
            druidDataSource.setRemoveAbandoned(true);
            // 泄露连接的定义时间(要超过最大事务的处理时间)；单位为秒。这里配置为1小时
            druidDataSource.setRemoveAbandonedTimeout(3600);
            // 移除泄露连接发生是是否记录日志
            druidDataSource.setLogAbandoned(true);

//            DataSource createDataSource = druidDataSource;
            druidDataSource.init();
//            Map<Object, Object> dynamicTargetDataSources2 = this.dynamicTargetDataSources;
//            dynamicTargetDataSources2.put(key, createDataSource);// 加入map
            this.dynamicTargetDataSources.put(key, druidDataSource);
            // 将map赋值给父类的TargetDataSources
            setTargetDataSources(this.dynamicTargetDataSources);
//            setTargetDataSources(dynamicTargetDataSources2);// 将map赋值给父类的TargetDataSources
            // 将TargetDataSources中的连接信息放入resolvedDataSources管理
            super.afterPropertiesSet();
            log.info(key+"数据源初始化成功");
            //log.info(key+"数据源的概况："+druidDataSource.dump());
            return true;
        } catch (Exception e) {
            log.error(e + "");
            return false;
        }
    }
    /** 
    * @Description: 删除数据源 
    * @Param: [datasourceid] 
    * @return: boolean 
    * @Author: cles
    * @Date: 2020/5/9 23:42
    */ 
    public boolean delDataSources(String key) {
        Map<Object, Object> dynamicTargetDataSources = this.dynamicTargetDataSources;
        if (dynamicTargetDataSources.containsKey(key)) {
            Set<DruidDataSource> druidDataSourceInstances = DruidDataSourceStatManager.getDruidDataSourceInstances();
            for (DruidDataSource l : druidDataSourceInstances) {
                if (key.equals(l.getName())) {
                    dynamicTargetDataSources.remove(key);
                    DruidDataSourceStatManager.removeDataSource(l);
                    // 将map赋值给父类的TargetDataSources
                    setTargetDataSources(dynamicTargetDataSources);
                    // 将TargetDataSources中的连接信息放入resolvedDataSources管理
                    super.afterPropertiesSet();
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    // 测试数据源连接是否有效
    public boolean testDatasource(String key, String driveClass, String url, String username, String password) {
        try {
            Class.forName(driveClass);
            DriverManager.getConnection(url, username, password);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Specify the default target DataSource, if any.
     * <p>
     * The mapped value can either be a corresponding
     * {@link javax.sql.DataSource} instance or a data source name String (to be
     * resolved via a {@link #setDataSourceLookup DataSourceLookup}).
     * <p>
     * This DataSource will be used as target if none of the keyed
     * {@link #setTargetDataSources targetDataSources} match the
     * {@link #determineCurrentLookupKey()} current lookup key.
     */
    @Override
    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        this.dynamicDefaultTargetDataSource = defaultTargetDataSource;
    }

    /**
     * @param debug
     *            the debug to set
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    /**
     * @return the debug
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * @return the dynamicTargetDataSources
     */
    public Map<Object, Object> getDynamicTargetDataSources() {
        return dynamicTargetDataSources;
    }

    /**
     * @param dynamicTargetDataSources
     *            the dynamicTargetDataSources to set
     */
    public void setDynamicTargetDataSources(Map<Object, Object> dynamicTargetDataSources) {
        this.dynamicTargetDataSources = dynamicTargetDataSources;
    }

    /**
     * @return the dynamicDefaultTargetDataSource
     */
    public Object getDynamicDefaultTargetDataSource() {
        return dynamicDefaultTargetDataSource;
    }

    /**
     * @param dynamicDefaultTargetDataSource
     *            the dynamicDefaultTargetDataSource to set
     */
    public void setDynamicDefaultTargetDataSource(Object dynamicDefaultTargetDataSource) {
        this.dynamicDefaultTargetDataSource = dynamicDefaultTargetDataSource;
    }

    public void createDataSourceWithCheck(DataSource dataSource) throws Exception {
        String datasourceId = dataSource.getDatasourceId();
        log.info("准备创建数据源"+datasourceId);
        Map<Object, Object> dynamicTargetDataSources2 = this.dynamicTargetDataSources;
        if (dynamicTargetDataSources2.containsKey(datasourceId)) {
            log.info("数据源"+datasourceId+"之前已经创建，准备测试数据源是否正常...");
            //DataSource druidDataSource = (DataSource) dynamicTargetDataSources2.get(datasourceId);
            DruidDataSource druidDataSource = (DruidDataSource) dynamicTargetDataSources2.get(datasourceId);
            boolean rightFlag = true;
            Connection connection = null;
            try {
                log.info(datasourceId+"数据源的概况->当前闲置连接数："+druidDataSource.getPoolingCount());
                long activeCount = druidDataSource.getActiveCount();
                log.info(datasourceId+"数据源的概况->当前活动连接数："+activeCount);
                if(activeCount > 0) {
                    log.info(datasourceId+"数据源的概况->活跃连接堆栈信息："+druidDataSource.getActiveConnectionStackTrace());
                }
                log.info("准备获取数据库连接...");
                connection = druidDataSource.getConnection();
                log.info("数据源"+datasourceId+"正常");
            } catch (Exception e) {
                log.error(e.getMessage(),e); //把异常信息打印到日志文件
                rightFlag = false;
                log.info("缓存数据源"+datasourceId+"已失效，准备删除...");
                if(delDataSources(datasourceId)) {
                    log.info("缓存数据源删除成功");
                } else {
                    log.info("缓存数据源删除失败");
                }
            } finally {
                if(null != connection) {
                    connection.close();
                }
            }
            if(rightFlag) {
                log.info("不需要重新创建数据源");
                return;
            } else {
                log.info("准备重新创建数据源...");
                createDataSource(dataSource);
                log.info("重新创建数据源完成");
            }
        } else {
            createDataSource(dataSource);
        }

    }

    private  void createDataSource(DataSource dataSource) throws Exception {
        String datasourceId = dataSource.getDatasourceId();
        log.info("准备创建数据源"+datasourceId);
        String databasetype = dataSource.getDatabasetype();
        String username = dataSource.getUserName();
        String password = dataSource.getPassWord();
//        password = new String(SecurityTools.decrypt(Base64.decode(password)));
        String url = dataSource.getUrl();
        String driveClass = "com.mysql.cj.jdbc.Driver";
//        if("mysql".equalsIgnoreCase(databasetype)) {
//            driveClass = DBUtil.mysqldriver;
//        } else if("oracle".equalsIgnoreCase(databasetype)){
//            driveClass = DBUtil.oracledriver;
//        }  else if("sqlserver2000".equalsIgnoreCase(databasetype)){
//            driveClass = DBUtil.sql2000driver;
//        } else if("sqlserver".equalsIgnoreCase(databasetype)){
//            driveClass = DBUtil.sql2005driver;
//        }
        if(testDatasource(datasourceId,driveClass,url,username,password)) {
            boolean result = this.createDataSource(datasourceId, driveClass, url, username, password, databasetype);
            if(!result) {
                log.error("数据源"+datasourceId+"配置正确，但是创建失败");
//                throw new ADIException("数据源"+datasourceId+"配置正确，但是创建失败",500);
            }
        } else {
            log.error("数据源配置有错误");
//            throw new ADIException("数据源配置有错误",500);
        }
    }
}
