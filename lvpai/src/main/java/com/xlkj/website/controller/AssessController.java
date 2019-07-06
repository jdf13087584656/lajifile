package com.xlkj.website.controller;

import com.xlkj.website.annotation.AuthPass;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.UserWithBLOBs;
import com.xlkj.website.service.RoleService;
import com.xlkj.website.util.AccessUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping(value = "/login")
@CrossOrigin
public class AssessController {
    private Logger logger = LoggerFactory.getLogger(AssessController.class);
    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "登录请求接口", httpMethod = "POST")
    @RequestMapping(value = "/assess", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<String> assess(@RequestBody UserWithBLOBs userWithBLOBs) {
        ResultVo<String> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("assess is start"));
            //获取信息的地址access_token和openId
            Map parseObject = AccessUtil.getAccessToken(userWithBLOBs);
              if(null != (String)parseObject.get("openid")){
                  String openId = (String)parseObject.get("openid");
                  userWithBLOBs.setOpenId(openId);
                  roleService.addRole(userWithBLOBs);
                  resultVo.setData((String)parseObject.get("openid"));
              }else {
                  resultVo.resultFail("授权失败");
              }
        }catch (Exception e){
            resultVo.resultFail("网络异常,登录失败");
            logger.error("assess is error", e.getMessage());
        }
        return resultVo;
    }




    @ApiOperation(value = "pc管理员登录请求接口", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<String> adminLogin(@RequestBody UserWithBLOBs userWithBLOBs) {
        ResultVo<String> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("adminLogin is start"));
            resultVo = roleService.loginAdmin(userWithBLOBs);
        }catch (Exception e){
            resultVo.resultFail("网络异常,登录失败");
            logger.error("assess is error", e.getMessage());
        }
        return resultVo;
    }
}
