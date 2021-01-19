package com.cw.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 陈小哥cw
 * @date 2021/1/15 15:02
 * 使用注解实现异常分类管理
 *  名称： @ControllerAdvice
 *  类型： 类注解
 *  位置：异常处理器类上方
 *  作用：设置当前类为异常处理器类
 * <p>
 * 两种异常处理方式对比
 * 1.注解处理器可以拦截到入参类型转换异常
 * 2.非注解处理器无法拦截到入参类型转换异常
 */
@Component
//使用注解开发异常处理器
//声明该类是一个Controller的通知类，声明后该类就会被加载成异常处理器
//@ControllerAdvice
public class ExceptionAdvice {

    /**
     *  名称： @ExceptionHandler
     *  类型： 方法注解
     *  位置：异常处理器类中针对指定异常进行处理的方法上方
     *  作用：设置指定异常的处理方式
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String doNullException(Exception ex) {
        return "空指针异常";
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public String doArithmeticException(Exception ex) {
        return "ArithmeticException";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String doException(Exception ex) {
        return "all";
    }
}
