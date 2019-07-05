package com.xlkj.website.mapper;

import com.xlkj.website.model.UserWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    Integer addRole(UserWithBLOBs user);

    Integer modifyRole(UserWithBLOBs user);

    List<UserWithBLOBs> listRole(String openId);

    List<UserWithBLOBs> listRoles();
}