package com.psh.utils;

import com.psh.login.entity.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
public class SessionUtils {


    public static LoginVO getLoginVO() throws Exception {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpSession session = request.getSession();

        String user = session.getAttribute("User").toString();
        String sessionId = session.getAttribute("uuid").toString();

        return new LoginVO(user, sessionId);
    }

    public static HttpSession getSession() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpSession session = request.getSession();
        return session;
    }


}