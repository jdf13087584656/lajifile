package com.xlkj.website.controller;

import com.xlkj.website.annotation.AuthPass;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.SearchUserDto;
import com.xlkj.website.model.UserWithBLOBs;
import com.xlkj.website.service.RoleService;
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

    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "用户列表接口", httpMethod = "POST")
    @RequestMapping(value = "/listRoles", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<List<UserWithBLOBs>> listRoles(SearchUserDto searchUserDto) {
        ResultVo<List<UserWithBLOBs>> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("listRoles is start"));
            resultVo = roleService.listRoles(searchUserDto);
        }catch (Exception e){
            resultVo.resultFail("系统异常"+e.getMessage());
            logger.error("listRoles is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "用户信息修改接口", httpMethod = "POST")
    @RequestMapping(value = "/modifyRole", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<Integer> modifyRole(@RequestParam UserWithBLOBs user) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("modifyRole is start"));
            resultVo = roleService.modifyRole(user);
        }catch (Exception e){
            resultVo.resultFail("系统异常"+e.getMessage());
            logger.error("modifyRole is error", e.getMessage());
        }
        return resultVo;
    }


    @ApiOperation(value = "用户详情接口", httpMethod = "POST")
    @RequestMapping(value = "/listRole", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<UserWithBLOBs> listRole(@RequestBody String openId) {
        ResultVo<UserWithBLOBs> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("listRole is start"));
            resultVo = roleService.listRole(openId);
        }catch (Exception e){
            resultVo.resultFail("系统异常"+e.getMessage());
            logger.error("listRole is error", e.getMessage());
        }
        return resultVo;
    }
}
