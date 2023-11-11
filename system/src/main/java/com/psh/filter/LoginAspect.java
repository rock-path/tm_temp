package com.psh.filter;


import com.psh.config.StaticConfig;
import com.psh.domain.BaseResultModel;
import com.psh.login.entity.LoginVO;
import com.psh.utils.RedisTemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpSession;

import static com.psh.utils.SessionUtils.getLoginVO;
import static com.psh.utils.SessionUtils.getSession;

//切面注解
@Aspect
@Component
@Slf4j
public class LoginAspect {


    private Integer timeOut;

    /**
     * 切入点表达式：execution([权限修饰符] [返回值类型] [简单类名、全类名] [方法名] ([参数列表]))
     * execution("* *(..)") 表示任意包下任意类的任意方法
     */

    @Pointcut("execution(public * com.psh.controller.*.*(..))")
    public void start() {

    }


    //	方法执行开始，表示目标方法是com.psh.controller包下的任意方法
    @Before("start()")
    public static void LogStart(JoinPoint joinPoint) {
        //执行之前验证session
        log.info("执行前置操作");

        LoginVO loginVO = null;
        try {
            loginVO = getLoginVO();
        } catch (Exception e) {
            log.info("获取session信息失败,登录失败");
            throw new RuntimeException(e);
        }

        String sessionId = RedisTemplateUtils.get(loginVO.getAccount()).toString();
        if (loginVO.getSessionId().equals(sessionId)) {
            //登录
            log.info("登录成功");

        } else {
            //登录失败
            log.info("登录失败");
            return;
        }

    }


    @Pointcut("execution(public * com.psh.controller.*.*(..))")
    public void after() {

    }

    //	方法正常执行完之后

    /**
     * 在程序正常执行完之后如果有返回值，我们可以对这个返回值进行接收
     * returning用来接收方法的返回值
     */
    @AfterReturning(pointcut = "after()", returning = "result")
    public static void LogReturn(JoinPoint joinPoint, Object result) {
        log.info("【" + joinPoint.getSignature().getName() + "】程序方法执行完毕了...结果是：" + result);
        BaseResultModel baseResultModel = (BaseResultModel) result;
        //方法调用成功,刷新session过期时间
        if ("0".equals(baseResultModel.getCode())) {
            LoginVO loginVO = null;
            try {
                loginVO = getLoginVO();
            } catch (Exception e) {
                log.info("获取session信息失败,登录失败");
                throw new RuntimeException(e);
            }
            //刷新redis session的过期时间
            RedisTemplateUtils.expire(loginVO.getAccount());
            //刷新session过期时间
            HttpSession session = getSession();
            session.setMaxInactiveInterval(10*60);
        }
    }


}
