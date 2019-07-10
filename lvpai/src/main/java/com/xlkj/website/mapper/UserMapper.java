package com.xlkj.website.mapper;

import com.xlkj.website.model.SearchUserDto;
import com.xlkj.website.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {

    Integer addUser(UserDto userDto);

    Integer modifyUser(UserDto userDto);

    List<UserDto> listUsers(SearchUserDto searchUserDto);

    UserDto listUser(Integer uid);

    Integer quantityCompletion(Integer uid);

    UserDto searchAccount(String account);
}
