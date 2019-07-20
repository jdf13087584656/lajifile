package com.xlkj.website.util;



import com.xlkj.website.config.RedisDao;
import com.xlkj.website.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
public class CommonControllerUtils {
/*
    @Autowired
    private CacheManager cacheManager;
*/

    @Autowired
    private RedisDao redisDao;

    public User methodHandler() {
        String token = getToken();
        String[] s = token.split(",");
        if (s.length == 2) {
            token = s[0];
        }
        User user = null;
        if (!"".equals(token) && null != token && !"null".equals(token)) {
            String s1 = redisDao.getValue(token);
            user = JSonUtils.readValue(s1, User.class);
            /*Object u = cacheManager.getCache(SecurityConstants.TOKEN_USER_DETAIL).get(token, Object.class);
            System.out.println(u);*/
        }
        if (s.length == 2) {
            user.setDeptId(Integer.parseInt(s[1]));
        }
        return user;
    }

    public static String getToken() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return UserUtils.getToken(request);
    }

    public String getUserTelephone() {
        User user = methodHandler();
        if (user != null) {
            return user.getTelephone();
        }
        return null;
    }

    public int getUserId() {
        User user = methodHandler();
        if (user != null) {
            return user.getId();
        }
        return 0;
    }

    public String getUserName() {
        User user = methodHandler();
        if (user != null) {
            return user.getUsername();
        }
        return null;
    }

    //获取用户直属部门或公司id
    public int getUserDeptId() {
        User user = methodHandler();
        if (user != null) {
            return user.getDeptId();
        }
        return 0;
    }
    


}
