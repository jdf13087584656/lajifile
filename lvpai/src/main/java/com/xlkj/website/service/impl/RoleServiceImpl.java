package com.xlkj.website.service.impl;

import com.xlkj.website.mapper.RoleMapper;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.UserWithBLOBs;
import com.xlkj.website.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

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
}
