package com.xlkj.website.service;

import com.xlkj.website.model.NewsDto;
import com.xlkj.website.model.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: Admin
 * @Date: 2019/8/7 17:07
 * @Description:
 */
public interface NewsService {

    ResultVo addnews(NewsDto newsDto);

    ResultVo<List<NewsDto>> getListsNew(HttpServletRequest request, HttpServletResponse response);
}
