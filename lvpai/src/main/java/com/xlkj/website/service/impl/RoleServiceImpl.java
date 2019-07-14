package com.xlkj.website.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlkj.website.mapper.BalanceMapper;
import com.xlkj.website.mapper.RoleMapper;
import com.xlkj.website.model.*;
import com.xlkj.website.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private BalanceMapper balanceMapper;

    //用户新增(如果已存在信息,进行更新操作)
    @Override
    public ResultVo<Integer> addRole(UserWithBLOBs user) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer add = null;
        UserWithBLOBs userWithBLOBs = roleMapper.listRole(user.getOpenId());
        if(null != userWithBLOBs){
            add = roleMapper.modifyRole(user);
        }else{
            AddBalanceDto dto = new AddBalanceDto();
            dto.setOpenId(user.getOpenId());
            balanceMapper.addBalance(dto);
            add = roleMapper.addRole(user);
        }
        resultVo.resultFlag(resultVo,add,"操作成功","操作失败");
        return resultVo;
    }

    //用户信息更新
    @Override
    public ResultVo<Integer> modifyRole(UserWithBLOBs user) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer mod = roleMapper.modifyRole(user);
        resultVo.resultFlag(resultVo,mod,"修改成功","修改失败");
        return resultVo;
    }


    //用户信息详情
    @Override
    public ResultVo<UserWithBLOBs> listRole(String openId) {
        ResultVo<UserWithBLOBs> resultVo = new ResultVo<>();
        UserWithBLOBs user = roleMapper.listRole(openId);
        Integer quantityCompletion = roleMapper.quantityCompletion(openId);
        user.setQuantityCompletion(quantityCompletion);
        resultVo.resultSuccess(user);
        return resultVo;
    }

    //用户信息列表
    @Override
    public ResultVo<List<UserWithBLOBs>> listRoles(SearchUserDto searchUserDto) {
        PageHelper.startPage(searchUserDto.getCurrentPage(),searchUserDto.getPageSize());
        ResultVo<List<UserWithBLOBs>> resultVo = new ResultVo<>();
        List<UserWithBLOBs> user = roleMapper.listRoles(searchUserDto);
        PageInfo<UserWithBLOBs> pageInfo = new PageInfo<>(user);
        resultVo.setTotal((int) pageInfo.getTotal());
        resultVo.resultSuccess(user);
        return resultVo;
    }


}
