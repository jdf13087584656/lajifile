package com.xlkj.website.service;

import com.xlkj.website.model.AddAddress;
import com.xlkj.website.model.AddressDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.SearchAddressDto;

import java.util.List;

public interface SearchAddressService {

    ResultVo<List<AddressDto>> searchProvince(AddressDto dto);

    ResultVo<List<AddressDto>> searchCity(AddressDto dto);

    ResultVo<List<AddressDto>> searchArea(AddressDto dto);

    ResultVo<Integer> addAddress(AddAddress add);

    ResultVo<Integer> modifyAddress(AddAddress add);

    ResultVo<List<AddAddress>> listAddress(SearchAddressDto dto);
}
