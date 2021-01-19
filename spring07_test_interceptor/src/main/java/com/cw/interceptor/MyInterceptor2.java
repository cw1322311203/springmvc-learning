package com.cw.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor2 implements HandlerInterceptor {

    /**
     * 参数
     *  request:请求对象
     *  response:响应对象
     *  handler:被调用的处理器对象，本质上是一个方法对象，对反射中的Method对象进行了再包装
     * 返回值
     *  返回值为false，被拦截的处理器将不执行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("前置运行------a2");
        return true;
    }

    /**
     * 原始方法运行后运行，如果原始方法被拦截，则不执行
     * 参数
     *  modelAndView:如果处理器执行完成具有返回结果，可以读取到对应数据与页面信息，并进行调整
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("后置运行------b2");
    }

    /**
     * 拦截器最后执行的方法，无论原始方法是否执行
     * 参数
     *  ex:如果处理器执行过程中出现异常对象，可以针对异常情况进行单独处理
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        System.out.println("完成运行------c2");
    }
}
