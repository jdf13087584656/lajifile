package com.xlkj.website.config;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.xlkj.website.annotation.AuthPass;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.User;
import com.xlkj.website.model.UserWithBLOBs;
import com.xlkj.website.util.JSonUtils;
import com.xlkj.website.util.RedisUtil;
import com.xlkj.website.util.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录token验证拦截器
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    /*
     * 方法请求前拦截url是否需要权限认证 token 不再 或者获取用户失败  表示没有权限
     */
    @Autowired
    private RedisUtil redisDao;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            AuthPass authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPass.class);
            if (authPassport != null && authPassport.validate() == true) {
                System.out.println(request.getContextPath() + "不需要权限拦截");
                return true;
            } else {
                //token有效性的验证
                return validateToken(request, response);

            }
        }

        return true;
    }

    private Boolean validateToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = UserUtils.getToken(request);
        logger.info("method is " + request.getMethod());
        logger.info("token is " + token);

        if (!(!"".equals(token) && null != token && !"null".equals(token))) {
            response.setStatus(403);
            ResultVo result = new ResultVo<>();
            result.resultFail("您没有请求该链接的权限，请重新登录！");
            result.setMsg("您没有请求该链接的权限，请重新登录！");
            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(result));
            return false;
        }

        String s1 = JSON.toJSONString(redisDao.get(token));

        if (null==s1 || s1.equals("")) {
        	response.setStatus(403);
            ResultVo result = new ResultVo<>();
            result.resultFail("token已失效，请重新登录！");
            result.setMsg("token已失效，请重新登录！");
            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(result));
            return false;
		}
        UserWithBLOBs user = JSonUtils.readValue(s1, UserWithBLOBs.class);
        logger.info("where null==user result = " + (null == user) + " if true then user is null else user is not null!");
        if (user == null) {
            response.setStatus(403);
            ResultVo<Boolean> result = new ResultVo<Boolean>();
            result.resultFail("noValid");
            PrintWriter out = response.getWriter();
            out.println(new Gson().toJson(result));
            return false;
        }
        logger.info("user is " + user.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }
}
