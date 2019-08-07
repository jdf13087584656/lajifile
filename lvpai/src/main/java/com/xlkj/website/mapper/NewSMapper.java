package com.xlkj.website.mapper;

import com.xlkj.website.model.NewsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewSMapper {

        int AddNews(NewsDto newsDto);

        List<NewsDto> findNews();
}

