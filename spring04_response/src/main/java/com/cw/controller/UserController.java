package com.cw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    //测试服务器是否正常工作使用
    // 当处理器方法的返回值类型为String类型,即可通过具体的返回值设置访问的页面

    @RequestMapping("/showPage")
    public String showPage() {
        System.out.println("user mvc controller is running ...");
        return "page.jsp";
    }

    /**
     * TODO forward:page.jsp转发访问，支持访问WEB-INF下的页面forward:/WEB-INF/page/page.jsp
     * 不加前缀则默认为转发(forward)的方式
     * 注意：页面访问地址中所携带的/
     */
    @RequestMapping("/showPage1")
    public String showPage1() {
        System.out.println("user mvc controller is running ...");
        return "forward:/WEB-INF/page/page.jsp";
//        return "forward:page.jsp";
    }

    /**
     * TODO redirect:page.jsp重定向访问，不支持访问WEB-INF下的页面
     * 不支持访问WEB-INF下的页面，因为重定向会改变访问地址为http://localhost:8080/spring04/WEB-INF/page/page.jsp
     * 所以如果想要访问WEB-INF下的页面，需要使用forward的方式来进行访问,forward前缀可以不写，默认为forward
     */
    @RequestMapping("/showPage2")
    public String showPage2() {
        System.out.println("user mvc controller is running ...");
//        return "redirect:page.jsp";
        return "redirect:/WEB-INF/page/page.jsp";
    }


    /**
     * 页面简化配置格式，使用前缀+页面名称+后缀的形式进行，类似于字符串拼接
     * <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
     * <property name="prefix" value="/WEB-INF/page/"/>
     * <property name="suffix" value=".jsp"/>
     * </bean>
     */
    @RequestMapping("/showPage3")
    public String showPage3() {
        System.out.println("user mvc controller is running ...");
        return "page";
    }

    // TODO 页面简化配置格式不支持书写forward
    @RequestMapping("/showPage4")
    public String showPage4() {
        System.out.println("user mvc controller is running ...");
        return "forward:page";
    }

    // TODO 最简页面配置方式，使用访问路径作为页面名称，省略返回值
    // 如果未设定了返回值，使用void类型，则默认使用访问路径作页面地址的前缀后缀
    // 本例访问的是/WEB-INF/page/showPage5.jsp，由前缀(/WEB-INF/page/)+访问路径(showPage5)+后缀(.jsp)组成
    @RequestMapping("/showPage5")
    public void showPage5() {
        System.out.println("user mvc controller is running ...");
    }
}
