package com.apps.omnipotent.system.global.entity;

import com.apps.omnipotent.system.core.BaseModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 基础model(默认参数)
* @Description 
* @MethodName  GlobalModel
* @author lb
* @date 2018年8月20日 下午10:50:54
*
 */
@Data
public class GlobalModel extends BaseModel {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sys001;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sys002;
    private String sys003;
    private String sys004;
    private String sys005;
    private String sys006;
    private int sys007;
}
