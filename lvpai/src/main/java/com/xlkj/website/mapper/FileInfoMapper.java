package com.xlkj.website.mapper;

import com.xlkj.website.model.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Auther: Admin
 * @Date: 2019/7/7 17:57
 * @Description:
 */
@Component
@Mapper
public interface FileInfoMapper {

  int  addFile(FileInfo fileInfo);

  FileInfo getFileByAdr(String filepath);
}
