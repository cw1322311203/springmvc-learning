package com.cw.exception;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理方案
 * <p>
 * 业务异常：
 *  发送对应消息传递给用户，提醒规范操作
 * 系统异常：
 *  发送固定消息传递给用户，安抚用户
 *  发送特定消息给运维人员，提醒维护
 *  记录日志
 * 其他异常：
 *  发送固定消息传递给用户，安抚用户
 *  发送特定消息给编程人员，提醒维护
 *  纳入预期范围内
 *  记录日志
 */
@Component
@ControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public String doBusinessException(Exception ex, Model model) {
        //使用参数Model将要保存的数据传递到页面上，功能等同于ModelAndView
        //业务异常出现的消息要发送给用户查看
        model.addAttribute("msg", ex.getMessage());
        return "error.jsp";
    }

    @ExceptionHandler(SystemException.class)
    public String doSystemException(Exception ex, Model model) {
        //系统异常出现的消息不要发送给用户查看，发送统一的信息给用户看
        model.addAttribute("msg", "服务器出现问题，请联系管理员！");
        //实际的问题现象应该传递给redis服务器，运维人员通过后台系统查看
        return "error.jsp";
    }

    @ExceptionHandler(Exception.class)
    public String doException(Exception ex, Model model) {
        model.addAttribute("msg", ex.getMessage());
        //将ex对象保存起来
        return "error.jsp";
    }
}
