package com.xlkj.website.controller;

import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.UserWithBLOBs;
import com.xlkj.website.util.AccessUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping(value = "/login")
@CrossOrigin
public class AssessController {
    private Logger logger = LoggerFactory.getLogger(AssessController.class);

    @ApiOperation(value = "登录请求接口", httpMethod = "POST")
    @RequestMapping(value = "/assess", method = RequestMethod.POST)
    public ResultVo<UserWithBLOBs> assess(@RequestParam String code, @RequestParam String appId, @RequestParam String secret) {
        ResultVo<UserWithBLOBs> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("assess is start"));
            //获取信息的地址access_token和openId
            Map parseObject = AccessUtil.getAccessToken(code,appId,secret);
            String accessToken = (String)parseObject.get("access_token");
            String id = (String)parseObject.get("openid");
            UserWithBLOBs user = AccessUtil.getUserInfo(id,accessToken);
            resultVo.setData(user);
        }catch (Exception e){
            resultVo.resultFail("网络异常,登录失败");
            logger.error("assess is error", e.getMessage());
        }
        return resultVo;
    }
}
