package com.xlkj.website.service;

import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.SearchUserDto;
import com.xlkj.website.model.UserDto;

import java.util.List;

public interface UserService {

    ResultVo<Integer> addUser(UserDto userDto);

    ResultVo<Integer> modifyUser(UserDto userDto);

    ResultVo<List<UserDto>> listUsers(SearchUserDto searchUserDto);

    ResultVo<List<UserDto>> listUser(SearchUserDto searchUserDto);

    ResultVo loginAdmin(UserDto userDto);

    ResultVo loginUserhs(UserDto userDto);

    ResultVo loginUserys(UserDto userDto);
}

