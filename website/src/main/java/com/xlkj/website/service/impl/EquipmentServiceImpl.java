package com.xlkj.website.service.impl;

import com.xlkj.website.mapper.EquipmentMapper;
import com.xlkj.website.model.CommonSearch;
import com.xlkj.website.model.EquipmentDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    //设备新增
    @Override
    public ResultVo<Integer> addEquipment(EquipmentDto dto) {
        ResultVo resultVo = new ResultVo();
        Integer add = equipmentMapper.addEquipment(dto);
        resultVo.resultFlag(resultVo,add,"新增成功","新增失败");
        return resultVo;
    }

    //设备修改
    @Override
    public ResultVo<Integer> modifyEquipment(EquipmentDto dto) {
        ResultVo resultVo = new ResultVo();
        Integer mod = equipmentMapper.modifyEquipment(dto);
        resultVo.resultFlag(resultVo,mod,"修改成功","修改失败");
        return null;
    }

    //设备列表
    @Override
    public ResultVo<EquipmentDto> listEquipment(CommonSearch commonSearch) {
        ResultVo<EquipmentDto> resultVo = new ResultVo<>();
        equipmentMapper.listEquipment(commonSearch);
        return null;
    }
}
