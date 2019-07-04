package com.xlkj.website.mapper;

import com.xlkj.website.model.CommonSearch;
import com.xlkj.website.model.EquipmentDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EquipmentMapper {

    //新增设备
    Integer addEquipment(EquipmentDto dto);
    //修改设备
    Integer modifyEquipment(EquipmentDto dto);
    //列表查看
    EquipmentDto listEquipment(CommonSearch com);
}
