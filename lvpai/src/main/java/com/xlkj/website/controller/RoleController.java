package com.xlkj.website.controller;

import com.xlkj.website.mapper.RoleMapper;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.UserWithBLOBs;
import com.xlkj.website.service.RoleService;
import com.xlkj.website.util.AccessUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/role")
@CrossOrigin
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(AssessController.class);

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "列表接口", httpMethod = "POST")
    @RequestMapping(value = "/listRoles", method = RequestMethod.POST)
    public ResultVo<List<UserWithBLOBs>> listRoles() {
        ResultVo<List<UserWithBLOBs>> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("listRole is start"));
            resultVo = roleService.listRoles();
        }catch (Exception e){
            resultVo.resultFail("系统异常,登录失败");
            logger.error("listRole is error", e.getMessage());
        }
        return resultVo;
    }
}
