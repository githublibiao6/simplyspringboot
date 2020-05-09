package com.apps.omnipotent.system.controller;

import com.apps.omnipotent.system.db.config.DbConfig;
import com.apps.omnipotent.system.global.controller.GlobalController;
import com.apps.omnipotent.system.global.entity.Result;
import com.apps.omnipotent.system.threadpool.service.impl.AsyncServiceImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @Description:  刚开始测试用的，没啥用
* @Author: cles
* @Date: 2020/4/17 23:46
*/
@Controller
@RequestMapping("/test")
public class TestController  extends GlobalController {

    @Autowired
    private AsyncServiceImpl asyncService;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @Author cles
     * @Description 
     * @Date 23:14 2019/7/10
     * @return java.lang.String
     **/
    @RequestMapping("/index")
    @ResponseBody
    public Result say() {
        asyncService.executeAsync();
        return result;
    }

    @RequestMapping("/mongo")
    @ResponseBody
    public Result mongo() {
        Query query = new Query();
        DbConfig db = new DbConfig();
        //数据库表名称
        MongoCollection<Document> dbCollection = mongoTemplate.getCollection("user");
        //创建文档
        Document document = new Document("name","张三")
                .append("sex", "男")
                .append("age", 18);
        dbCollection.insertOne(document);
        FindIterable<Document> list = dbCollection.find();
        result.setData(list);
        return result;
    }

}
