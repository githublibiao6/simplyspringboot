package com.apps.omnipotent.business.config;
/*
 *  Created by cles on 2020/7/14 23:23
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author cles
 * @description:
 * @Date 2020/7/14 23:23
 * @version: 1.0.0
 */
@Configuration
@ConfigurationProperties(prefix = "alibaba.alipay")
public class AliPayConfig {

    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    /**
     *  netapp映射的地址，，，根据自己的需要修改
     */
    private String netUrl = "http://g5kike.natappfree.cc";

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号 按照我文章图上的信息填写
     */
    private String appId ;

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥  刚刚生成的私钥直接复制填写
     */
    private String merchantPrivateKey;

    /**
     * 支付宝公钥,对应APPID下的支付宝公钥。 按照我文章图上的信息填写支付宝公钥，别填成商户公钥
     */
    private String alipayPrivateKey ;
    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，其实就是你的一个支付完成后返回的页面URL
     * neturl+"/alipay/notify_url"
     */
    private String notifyUrl ="/alipay/notify_url";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，其实就是你的一个支付完成后返回的页面URL
     * neturl+"/alipay/return_url";
     */
    private String returnUrl = "/alipay/return_url";

    /**
     * 签名方式
     */
    private String signType ;

    /**
     * 字符编码格式
     */
    private String charset;

    /**
     * 支付宝网关
     */
    private String gatewayUrl ;


    public String getNetUrl() {
        return netUrl;
    }

    public void setNetUrl(String netUrl) {
        this.netUrl = netUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    public void setMerchantPrivateKey(String merchantPrivateKey) {
        this.merchantPrivateKey = merchantPrivateKey;
    }

    public String getAlipayPrivateKey() {
        return alipayPrivateKey;
    }

    public void setAlipayPrivateKey(String alipayPrivateKey) {
        this.alipayPrivateKey = alipayPrivateKey;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    //↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     */
    private static void logResult(String sWord) {
        FileWriter writer = null;
        try {
//            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
