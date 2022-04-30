package com.zhbit.hospital.interceptor;

import com.zhbit.hospital.bean.Doctor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lzy
 * 2022/4/30 11:07
 */
@Component
public class DoctorInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 从session中获取用户名,如果获取得到说明已登录,放行
         * 否则跳转到登录页面
         */
        HttpSession session = request.getSession();
        Doctor doctor = (Doctor) session.getAttribute("Logined_User");
        if (doctor == null){
            //重定向跳回登录页面
            response.sendRedirect("Login");
        }else {
            return true;
        }
        return false;
    }
}
