package com.xlkj.website.service;

import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.SearchUserDto;
import com.xlkj.website.model.UserDto;
import com.xlkj.website.model.UserWithBLOBs;

import java.util.List;

public interface RoleService {

    ResultVo<Integer> addRole(UserWithBLOBs user);

    ResultVo<Integer> modifyRole(UserWithBLOBs user);

    ResultVo<UserWithBLOBs> listRole(String openId);

    ResultVo<List<UserWithBLOBs>> listRoles(SearchUserDto searchUserDto);


}