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
    public ResultVo<List<CargoDto>> listCargo(Integer pid) {
        ResultVo<List<CargoDto>> resultVo = new ResultVo<>();
        // 查询所有的一级目录 pid为 -1
        List<CargoDto> childrenList = cargoMapper.listCargo(pid);
        if (-1 != pid ){
            for (CargoDto dto : childrenList) {
                // 递归查询 一级目录下的 所有子菜单
                List<CargoDto> basisTypeChildList = cargoMapper.listCargo(dto.getCid());
                // 将查询的子菜单封装到children
                dto.setChildren(basisTypeChildList);
            }
        }
        resultVo.resultSuccess(childrenList);
        return resultVo;
    }

    /**
     * 递归查询:根据父id查询所有子集
     */
    private List<CargoDto> getBasisTypeChildList(Integer pId) {
        // 当前pid下的所有子菜单
        List<CargoDto> childrenList = cargoMapper.kidCargo(pId);
        // 子菜单集合不为0，进行递归查询,子菜单为0时递归结束
        if (childrenList != null && childrenList.size() > 0) {
            // 获得每一子菜单
            for (CargoDto cargoDto : childrenList) {
                List<CargoDto> basisTypeChildList = cargoMapper.listCargo(cargoDto.getCid());
                // 将查询出的子集合封装到模型对象中
                cargoDto.setChildren(basisTypeChildList);
            }
        }
        return childrenList;
    }
}
