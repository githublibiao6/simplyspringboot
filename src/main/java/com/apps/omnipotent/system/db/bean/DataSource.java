package com.apps.omnipotent.system.db.bean;
/**
 * Created by cles on 2020/5/9 23:00
 */

import lombok.Data;

/**
 * @description:
 * @author cles
 * @Date 2020/5/9 23:00
 */
@Data
public class DataSource {
    String datasourceId;
    String url;
    String userName;
    String passWord;
    String code;
    String databasetype;
}
