package com.xlkj.website.mapper;

import com.xlkj.website.model.AddAddress;
import com.xlkj.website.model.AddressDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchAddressMapper {

    List<AddressDto> searchProvince(AddressDto dto);

    List<AddressDto> searchCity(AddressDto dto);

    List<AddressDto> searchArea(AddressDto dto);

    Integer addAddress(AddAddress add);

    Integer modifyAddress(AddAddress add);

    List<AddAddress> listAddress(String openId);
}
