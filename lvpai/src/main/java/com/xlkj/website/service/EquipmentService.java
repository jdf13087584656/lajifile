package com.xlkj.website.service;

import com.xlkj.website.model.SearchEquDto;
import com.xlkj.website.model.EquipmentDto;
import com.xlkj.website.model.ResultVo;

public interface EquipmentService {

    //新增设备
    public ResultVo<Integer> addEquipment(EquipmentDto dto);
    //修改设备
    public ResultVo<Integer> modifyEquipment(EquipmentDto dto);
    //列表查看
    public ResultVo<EquipmentDto> listEquipment(SearchEquDto searchEquDto);
}
