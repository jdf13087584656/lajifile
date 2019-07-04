package com.xlkj.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Admin
 * @Date: 2019/4/9 16:45
 * @Description:
 */
@Controller
public class LocalController {

    @RequestMapping("/index")
    public String gotoIndex(){
        return "index";
    }

    @RequestMapping("/product")
    public String gotoproduct(){
        return "product-display";
    }

    @RequestMapping("/file_download")
    public String gotofile(){
        return "file_download";
    }
    @RequestMapping("/service")
    public String gotoService(){

        return "technical-services";
    }
    @RequestMapping("/usecase")
    public String gotoUsecase(){
        return "usecase";
    }
    @RequestMapping("/administrator")
    public String gotoAdministrator(){
        return "Administrator";
    }
}
