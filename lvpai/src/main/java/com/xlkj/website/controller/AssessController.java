package com.xlkj.website.controller;

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
    public ResultVo<UserWithBLOBs> assess(@RequestBody UserWithBLOBs userWithBLOBs) {
        ResultVo<UserWithBLOBs> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("assess is start"));
            //获取信息的地址access_token和openId
            Map parseObject = AccessUtil.getAccessToken(userWithBLOBs);
              if(null != (String)parseObject.get("openid")){
                  roleService.addRole(userWithBLOBs);
              }
            UserWithBLOBs user = new UserWithBLOBs();
            user.setOpenId((String)parseObject.get("openid"));
            resultVo.setData(user);
        }catch (Exception e){
            resultVo.resultFail("网络异常,登录失败");
            logger.error("assess is error", e.getMessage());
        }
        return resultVo;
    }
}
