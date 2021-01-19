package com.cw.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 陈小哥cw
 * @date 2021/1/15 14:50
 */
//@Component
public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {
        System.out.println("my exception is running ...." + ex);
        System.out.println("my exception is running ...." + ex.getClass());
        ModelAndView modelAndView = new ModelAndView();

        // 定义异常现象出现后，反馈给用户查看的信息
        if (ex instanceof NullPointerException) {
            modelAndView.addObject("msg", "空指针异常");
        } else if (ex instanceof ArithmeticException) {
            modelAndView.addObject("msg", "算数运算异常");
        } else {
            modelAndView.addObject("msg", "未知的异常");
        }

        // 定义异常现象出现后，反馈给用户查看的页面
        modelAndView.setViewName("error.jsp");
        return modelAndView;
    }
}
