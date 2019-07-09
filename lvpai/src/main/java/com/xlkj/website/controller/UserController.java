package com.xlkj.website.controller;

import com.xlkj.website.annotation.AuthPass;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.SearchUserDto;
import com.xlkj.website.model.UserDto;
import com.xlkj.website.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @Description: 回收员
 */
@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {

    private Logger logger = LoggerFactory.getLogger(AddressController.class);
    @Autowired
    private UserService userService;

    @ApiOperation(value = "回收员新增", httpMethod = "POST")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<Integer> addUser(@RequestBody UserDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("addUser is start"));
            resultVo = userService.addUser(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("addUser is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "回收员修改", httpMethod = "POST")
    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<Integer> modifyUser(@RequestBody UserDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("modifyUser is start"));
            resultVo = userService.addUser(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("modifyUser is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "回收员列表", httpMethod = "POST")
    @RequestMapping(value = "/listUser", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<List<UserDto>> listUser(@RequestBody SearchUserDto dto) {
        ResultVo<List<UserDto>> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("listUser is start"));
            resultVo = userService.listUser(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("listUser is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "pc管理员登录请求接口", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<String> adminLogin(@RequestBody UserDto userDto) {
        ResultVo<String> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("adminLogin is start"));
            resultVo = userService.loginAdmin(userDto);
        }catch (Exception e){
            resultVo.resultFail("网络异常,登录失败");
            logger.error("adminLogin is error", e.getMessage());
        }
        return resultVo;
    }
}
