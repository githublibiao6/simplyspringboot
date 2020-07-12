package com.apps.omnipotent.manager.controller;

import com.apps.omnipotent.manager.service.ProjectService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 业务项目 controller
 * @author lb
 * @date 2018年6月24日 下午6:58:58
 */
@RequestMapping("img")
@Controller
public class ImgController {


    @RequestMapping(value = "/get",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage() throws IOException {
        File file = new File("D:/voice/picture/2018/827.jpg");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
    
}
