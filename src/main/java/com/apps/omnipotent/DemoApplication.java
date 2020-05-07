package com.apps.omnipotent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 将进酒
 * 唐代：李白
 * 君不见，黄河之水天上来，奔流到海不复回。
 * 君不见，高堂明镜悲白发，朝如青丝暮成雪。
 * 人生得意须尽欢，莫使金樽空对月。
 * 天生我材必有用，千金散尽还复来。
 * 烹羊宰牛且为乐，会须一饮三百杯。
 * 岑夫子，丹丘生，将进酒，杯莫停。
 * 与君歌一曲，请君为我倾耳听。
 * 钟鼓馔玉不足贵，但愿长醉不愿醒。
 * 古来圣贤皆寂寞，惟有饮者留其名。
 * 陈王昔时宴平乐，斗酒十千恣欢谑。
 * 主人何为言少钱，径须沽取对君酌。
 * 五花马，千金裘，呼儿将出换美酒，与尔同销万古愁
 */

/*mongodb*/
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
/**
 * //开启异步调用
 */
@EnableAsync
@MapperScan("com.apps.omnipotent")
/**
 * @Description:  springboot 启动
 * @Author: cles
 * @Date: 2020/4/29 23:17
 */
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
