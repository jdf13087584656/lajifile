package com.xlkj.website.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlkj.website.mapper.UserMapper;
import com.xlkj.website.model.*;
import com.xlkj.website.service.UserService;
import com.xlkj.website.util.Md5Util;
import com.xlkj.website.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public ResultVo<Integer> addUser(UserDto userDto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        UserDto user = userMapper.searchAccount(userDto.getAccount());
        if(null != user){
            resultVo.resultFail("账号已存在");
            return resultVo;
        }
        String pwd = Md5Util.MD5Encode(userDto.getPassword(),"UTF-8",false);
        userDto.setPassword(pwd);
        Integer add = userMapper.addUser(userDto);
        resultVo.resultFlag(resultVo,add,"新增成功","新增失败");
        return resultVo;
    }

    @Override
    public ResultVo<Integer> modifyUser(UserDto userDto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer mod = userMapper.modifyUser(userDto);
        resultVo.resultFlag(resultVo,mod,"操作成功","操作失败");
        return null;
    }

    @Override
    public ResultVo<List<UserDto>> listUser(SearchUserDto searchUserDto) {
        PageHelper.startPage(searchUserDto.getCurrentPage(),searchUserDto.getPageSize());
        ResultVo<List<UserDto>> resultVo = new ResultVo<>();
        List<UserDto> userDtos = userMapper.listUser(searchUserDto);
        PageInfo<UserDto> pageInfo = new PageInfo<>(userDtos);
        resultVo.setTotal((int)pageInfo.getTotal());
        resultVo.resultSuccess(userDtos);
        return resultVo;
    }

    //账号登录
    @Override
    public ResultVo loginAdmin(UserDto userDto) {
        ResultVo<Object> resultVo = new ResultVo<>();
        UserDto user = userMapper.searchAccount(userDto.getAccount());
        if (null == user){
            resultVo.resultFail("无此账号,请联系管理员");
            return resultVo;
        }
        if (2 == user.getType()){
            resultVo.resultFail("此账号无权限登录");
            return resultVo;
        }
        if (!user.getPassword().equals(Md5Util.MD5Encode(userDto.getPassword(),"UTF-8",false))){
            resultVo.resultFail("密码错误请重试");
            return resultVo;
        }
        //到这一步说明登陆成功了,保存token和用户信息
        String token = UUID.randomUUID().toString().replace("-", "")+user.getUid();
        Object json = JSON.toJSON(user);
        Long time= Long.valueOf(30);
        boolean set = redisUtil.set(token, json, time);
        if (!set) {
            resultVo.resultFail("网络异常,请联系管理员");
            return resultVo;
        }
        resultVo.setData(token);
        resultVo.setSuccess(true);
        return resultVo;
    }

    //账号登录
    @Override
    public ResultVo<UserDto> loginUser(UserDto userDto) {
        ResultVo<UserDto> resultVo = new ResultVo<>();
        UserDto user = userMapper.searchAccount(userDto.getAccount());
        if (null == user){
            resultVo.resultFail("无此账号,请联系管理员");
            return resultVo;
        }
        if (!user.getPassword().equals(Md5Util.MD5Encode(userDto.getPassword(),"UTF-8",false))){
            resultVo.resultFail("密码错误请重试");
            return resultVo;
        }
        resultVo.setData(user);
        resultVo.setSuccess(true);
        return resultVo;
    }
}
