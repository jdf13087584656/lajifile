package com.xlkj.website.mapper;

import com.xlkj.website.model.AddAddress;
import com.xlkj.website.model.AddressDto;
import com.xlkj.website.model.SearchAddressDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchAddressMapper {

//    List<AddressDto> searchProvince(AddressDto dto);
//
//    List<AddressDto> searchCity(AddressDto dto);
//
//    List<AddressDto> searchArea(AddressDto dto);

    Integer addAddress(AddAddress add);

    Integer modifyAddress(AddAddress add);

    Integer modifyDefault(String openId);

    List<AddAddress> listAddress(SearchAddressDto dto);
}
