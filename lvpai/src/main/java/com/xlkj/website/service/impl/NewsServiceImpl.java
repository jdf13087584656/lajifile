package com.xlkj.website.service.impl;

import com.xlkj.website.mapper.NewSMapper;
import com.xlkj.website.model.NewsDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Admin
 * @Date: 2019/8/7 17:36
 * @Description:
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewSMapper newSMapper;


    @Override
    public ResultVo<Integer> addnews(NewsDto newsDto) {
        ResultVo<Integer> resultVo = new ResultVo();
        int i = newSMapper.AddNews(newsDto);
        resultVo.resultFlag(resultVo,i,"新增成功","新增失败");
        return resultVo;
    }

    @Override
    public ResultVo<List<NewsDto>> getListsNew() {
        ResultVo<List<NewsDto>> resultVo = new ResultVo<>();
        List<NewsDto> news = newSMapper.findNews();
        resultVo.resultSuccess(news);
        return resultVo;
    }
}
