package com.xlkj.website.mapper;

import com.xlkj.website.model.UserWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleMapper {

    Integer addRole(UserWithBLOBs user);

    Integer modifyRole(UserWithBLOBs user);

    UserWithBLOBs listRole(String openId);

    List<UserWithBLOBs> listRoles();
}