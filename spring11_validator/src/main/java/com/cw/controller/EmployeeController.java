package com.cw.controller;

import com.cw.controller.groups.GroupA;
import com.cw.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
public class EmployeeController {

    @RequestMapping(value = "/addemployee")
    /**
     * 开启校验
     *  名称：@Valid 、 @Validated
     *  类型：形参注解
     *  位置：处理器类中的实体类类型的方法形参前方
     *  作用：设定对当前实体类类型参数进行校验
     */
    //使用@Valid开启校验，使用@Validated也可以开启校验
    //Errors对象用于封装校验结果，如果不满足校验规则，对应的校验结果封装到该对象中，包含校验的属性名和校验不通过返回的消息
    public String addEmployee(@Valid Employee employee, Errors errors, Model m) {
        // 通过形参Errors获取校验结果数据，通过Model接口将数据封装后传递到页面显示
        //判定Errors对象中是否存在未通过校验的字段
        if (errors.hasErrors()) {
            //获取所有未通过校验规则的信息
            List<FieldError> fieldErrors = errors.getFieldErrors();
            System.out.println(fieldErrors.size());
            for (FieldError error : fieldErrors) {
                System.out.println(error.getField() + "--》" + error.getDefaultMessage());
                //将校验结果信息添加到Model对象中，用于页面显示，后期实际开发中无需这样设定，返回json数据即可
                m.addAttribute(error.getField(), error.getDefaultMessage());
            }
            //当出现未通过校验的字段时，跳转页面到原始页面，进行数据回显
            return "addemployee.jsp";
        }
        return "success.jsp";
    }

    // @Validated支持分组校验，@Valid不支持分组校验
    // 引用类型使用@Valid开启校验，控制器使用@Validated开启校验
    @RequestMapping(value = "/addemployee2")
    public String addEmployee2(@Validated({GroupA.class}) Employee employee, Errors errors, Model m) {
        // 通过形参Errors获取校验结果数据，通过Model接口将数据封装后传递到页面显示
        if (errors.hasErrors()) {
            List<FieldError> fieldErrors = errors.getFieldErrors();
            System.out.println(fieldErrors.size());
            for (FieldError error : fieldErrors) {
                System.out.println(error.getField() + "--》" + error.getDefaultMessage());
                m.addAttribute(error.getField(), error.getDefaultMessage());
            }
            return "addemployee.jsp";
        }
        return "success.jsp";
    }

}
