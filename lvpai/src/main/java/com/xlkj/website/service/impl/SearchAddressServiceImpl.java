package com.xlkj.website.service.impl;

import com.xlkj.website.mapper.SearchAddressMapper;
import com.xlkj.website.model.AddAddress;
import com.xlkj.website.model.AddressDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.SearchAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchAddressServiceImpl implements SearchAddressService {

    @Autowired
    private SearchAddressMapper searchAddressMapper;



    @Override
    public ResultVo<List<AddressDto>> searchProvince(AddressDto dto) {
        ResultVo<List<AddressDto>> resultVo = new ResultVo<>();
        List<AddressDto> provinces = searchAddressMapper.searchProvince(dto);
        resultVo.resultSuccess(provinces);
        return resultVo;
    }

    @Override
    public ResultVo<List<AddressDto>> searchCity(AddressDto dto) {
        ResultVo<List<AddressDto>> resultVo = new ResultVo<>();
        List<AddressDto> cites = searchAddressMapper.searchCity(dto);
        resultVo.resultSuccess(cites);
        return resultVo;
    }

    @Override
    public ResultVo<List<AddressDto>> searchArea(AddressDto dto) {
        ResultVo<List<AddressDto>> resultVo = new ResultVo<>();
        List<AddressDto> areas = searchAddressMapper.searchArea(dto);
        resultVo.resultSuccess(areas);
        return resultVo;
    }

    @Override
    public ResultVo<Integer> addAddress(AddAddress add) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer ins = searchAddressMapper.addAddress(add);
        resultVo.resultFlag(resultVo,ins,"新增成功","新增失败");
        return resultVo;
    }

    @Override
    public ResultVo<Integer> modifyAddress(AddAddress add) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer mod = searchAddressMapper.modifyAddress(add);
        resultVo.resultFlag(resultVo,mod,"修改成功","修改失败");
        return resultVo;
    }

    @Override
    public ResultVo<List<AddAddress>> listAddress(Integer roleId) {
        ResultVo<List<AddAddress>> resultVo = new ResultVo<>();
        List<AddAddress> lists = searchAddressMapper.listAddress(roleId);
        resultVo.resultSuccess(lists);
        return resultVo;
    }
}
