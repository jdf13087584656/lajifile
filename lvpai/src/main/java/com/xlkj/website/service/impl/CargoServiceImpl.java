package com.xlkj.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlkj.website.mapper.CargoMapper;
import com.xlkj.website.model.*;
import com.xlkj.website.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoMapper cargoMapper;

    @Override
    public ResultVo<Integer> addCargo(CargoDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        if(null != cargoMapper.searchCargo(dto.getCargoName())){
            resultVo.resultFail("货物名重复");
            return resultVo;
        }
        Integer add = cargoMapper.addCargo(dto);
        resultVo.resultFlag(resultVo,add,"添加成功","添加失败");
        return resultVo;
    }

    @Override
    public ResultVo<Integer> modifyCargo(CargoDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        Integer mod = cargoMapper.modifyCargo(dto);
        resultVo.resultFlag(resultVo,mod,"修改成功","修改失败");
        return resultVo;
    }

    @Override
    public ResultVo<List<CargoDto>> listCargo(GetCargoDto dto) {
        PageHelper.startPage(dto.getCurrentPage(),dto.getPageSize());
        ResultVo<List<CargoDto>> resultVo = new ResultVo<>();
        List<CargoDto> list = cargoMapper.listCargo(dto);
        PageInfo<CargoDto> pageInfo = new PageInfo<>(list);
        resultVo.setTotal((int)pageInfo.getTotal());
        resultVo.resultSuccess(list);
        return resultVo;
    }
}
