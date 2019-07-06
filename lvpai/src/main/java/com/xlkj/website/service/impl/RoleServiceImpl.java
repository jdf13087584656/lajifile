package com.xlkj.website.service.impl;

import com.alibaba.fastjson.JSON;
import com.xlkj.website.mapper.RoleMapper;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.UserWithBLOBs;
import com.xlkj.website.service.RoleService;
import com.xlkj.website.util.Md5Util;
import com.xlkj.website.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RedisUtil redisUtil;

    //用户新增(如果已存在信息,进行更新操作)
    @Override
    public ResultVo<Integer> addRole(UserWithBLOBs user) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer add = null;
        UserWithBLOBs userWithBLOBs = roleMapper.listRole(user.getOpenId());
        if(null != userWithBLOBs){
            add = roleMapper.modifyRole(user);
        }else{
            add = roleMapper.addRole(user);
        }
        resultVo.resultFlag(resultVo,add,"操作成功","操作失败");
        return resultVo;
    }

    @Override
    public ResultVo<Integer> modifyRole(UserWithBLOBs user) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer add = roleMapper.modifyRole(user);
        resultVo.resultFlag(resultVo,add,"修改成功","修改失败");
        return resultVo;
    }

    @Override
    public ResultVo<UserWithBLOBs> listRole(String openId) {
        ResultVo<UserWithBLOBs> resultVo = new ResultVo<>();
        UserWithBLOBs user = roleMapper.listRole(openId);
        resultVo.resultSuccess(user);
        return resultVo;
    }

    @Override
    public ResultVo<List<UserWithBLOBs>> listRoles() {
        ResultVo<List<UserWithBLOBs>> resultVo = new ResultVo<>();
        List<UserWithBLOBs> user = roleMapper.listRoles();
        resultVo.resultSuccess(user);
        return resultVo;
    }

    @Override
    public ResultVo loginAdmin(UserWithBLOBs userWithBLOBs) {
        ResultVo<Object> resultVo = new ResultVo<>();
        UserWithBLOBs user = roleMapper.listRole(userWithBLOBs.getOpenId());
        if (null==user){
            resultVo.resultFail("无此账号,请联系管理员");
            return resultVo;
        }
        if (!user.getPwd().equals(Md5Util.MD5Encode(userWithBLOBs.getPwd(),"UTF-8",false))){
            resultVo.resultFail("密码错误请重试");
            return resultVo;
        }
        //到这一步说明登陆成功了,保存token和用户信息

        String token = UUID.randomUUID().toString().replace("-", "")+user.getId();
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
}
