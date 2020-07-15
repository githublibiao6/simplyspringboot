package com.apps.omnipotent.business.service.impl;
/*
 *  Created by cles on 2020/7/14 23:24
 */

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.apps.omnipotent.business.config.AliPayConfig;
import com.apps.omnipotent.business.service.AlipayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author cles
 * @description:
 * @Date 2020/7/14 23:24
 * @version: 1.0.0
 */
@Slf4j
@Service
public class AlipayServiceImpl implements AlipayService {
    /**
     * 功能描述：
     *  < 测试service >
     * @Description: index
     * @Author: cles
     * @Date: 2020/7/14 23:25
     * @return: void
     * @version: 1.0.0
     */
    @Override
    public void index(){
        System.err.println("test service!");
//        https://blog.csdn.net/HUDCHSDI/article/details/91442480
        // 构建支付数据信息
        Map<String, String> data = new HashMap<>();
        //订单标题
        data.put("subject", "测试订单");
        //商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复      //此处模拟订单号为时间
        data.put("out_trade_no", UUID.randomUUID().toString());
        //该笔订单允许的最晚付款时间
        data.put("timeout_express", "2020-10-01 00:00:00");
        //订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
        data.put("total_amount","200");
        //销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
        data.put("product_code", "FAST_INSTANT_TRADE_PAY");

        AliPayConfig aliPayConfig = new AliPayConfig();
        //构建客户端
        DefaultAlipayClient alipayRsa2Client = new DefaultAlipayClient(
                AliPayConfig.gatewayUrl,
                AliPayConfig.appId,
                AliPayConfig.merchantPrivateKey,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipayPublicKey,
                AliPayConfig.signType);
        System.err.println(AliPayConfig.appId);
        System.err.println(AliPayConfig.signType);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();  // 网页支付
//        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();// APP支付
//        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();  //移动h5

        request.setNotifyUrl(AliPayConfig.notifyUrl);
        request.setReturnUrl(AliPayConfig.returnUrl);
        request.setBizContent(JSON.toJSONString(data));
        log.info(JSON.toJSONString(data));
        String response = null;
        try {
            AlipayTradePagePayResponse alipayTradePagePayResponse = alipayRsa2Client.pageExecute(request);
            response = alipayTradePagePayResponse.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        log.info(response);
    }
}
