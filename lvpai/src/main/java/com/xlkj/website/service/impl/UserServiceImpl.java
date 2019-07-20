package com.xlkj.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlkj.website.config.RedisDao;
import com.xlkj.website.mapper.UserMapper;
import com.xlkj.website.model.*;
import com.xlkj.website.service.UserService;
import com.xlkj.website.util.JSonUtils;
import com.xlkj.website.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserMapper userMapper;
    @Autowired
    private RedisDao redis;

    //创建
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

    //修改
    @Override
    public ResultVo<Integer> modifyUser(UserDto userDto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        if ((null != userDto.getPassword())) {
            String pwd = Md5Util.MD5Encode(userDto.getPassword(), "UTF-8", false);
            userDto.setPassword(pwd);
        }
        Integer mod = userMapper.modifyUser(userDto);
        resultVo.resultFlag(resultVo,mod,"操作成功","操作失败");
        return resultVo;
    }

    //回收员验收员列表
    @Override
    public ResultVo<List<UserDto>> listUsers(SearchUserDto searchUserDto) {
        PageHelper.startPage(searchUserDto.getCurrentPage(),searchUserDto.getPageSize());
        ResultVo<List<UserDto>> resultVo = new ResultVo<>();
        List<UserDto> userDtos = userMapper.listUsers(searchUserDto);
        PageInfo<UserDto> pageInfo = new PageInfo<>(userDtos);
        resultVo.setTotal((int)pageInfo.getTotal());
        resultVo.resultSuccess(userDtos);
        return resultVo;
    }

    //回收员验收员详情
    @Override
    public ResultVo<List<UserDto>> listUser(SearchUserDto searchUserDto) {
        PageHelper.startPage(searchUserDto.getCurrentPage(),searchUserDto.getPageSize());
        ResultVo<List<UserDto>> resultVo = new ResultVo<>();
        List<UserDto> userDto = userMapper.listUser(searchUserDto);
        PageInfo<UserDto> pageInfo = new PageInfo<>(userDto);
        resultVo.setTotal((int)pageInfo.getTotal());
        resultVo.resultSuccess(userDto);
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
        if (1 != user.getType()){
            resultVo.resultFail("此账号无权限登录");
            return resultVo;
        }
        if (!user.getPassword().equals(Md5Util.MD5Encode(userDto.getPassword(),"UTF-8",false))){
            resultVo.resultFail("密码错误请重试");
            return resultVo;
        }
        //到这一步说明登陆成功了,保存token和用户信息
        String token = UUID.randomUUID().toString().replace("-", "")+user.getUid();
        //Long time= Long.valueOf(30);

        redis.setKey(token, JSonUtils.toJSon(user));
//        if (!set) {
//            resultVo.resultFail("网络异常,请联系管理员");
//            return resultVo;
//        }
        HashMap<String,Integer> map = new HashMap<>();
        map.put(token,user.getUid());
        resultVo.setData(map);
        resultVo.setSuccess(true);
        return resultVo;
    }

    //账号登录
    @Override
    public ResultVo loginUser(UserDto userDto) {
        ResultVo<Object> resultVo = new ResultVo<>();
        UserDto user = userMapper.searchAccount(userDto.getAccount());
        if (null == user){
            resultVo.resultFail("无此账号,请联系管理员");
            return resultVo;
        }
        if (2 != user.getType() || 3 != user.getType()){
            resultVo.resultFail("此账号无权限登录");
            return resultVo;
        }
        if (!user.getPassword().equals(Md5Util.MD5Encode(userDto.getPassword(),"UTF-8",false))){
            resultVo.resultFail("密码错误请重试");
            return resultVo;
        }
        //到这一步说明登陆成功了,保存token和用户信息
        String token = UUID.randomUUID().toString().replace("-", "")+user.getUid();
        //Long time= Long.valueOf(30);

        redis.setKey(token, JSonUtils.toJSon(user));
//        if (!set) {
//            resultVo.resultFail("网络异常,请联系管理员");
//            return resultVo;
//        }
        HashMap<String,Integer> map = new HashMap<>();
        map.put(token,user.getUid());
        resultVo.setData(map);
        resultVo.setSuccess(true);
        return resultVo;
    }
}
