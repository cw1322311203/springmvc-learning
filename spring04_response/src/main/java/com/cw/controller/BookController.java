package com.cw.controller;

import com.cw.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 携带数据页面跳转设定
 * 1.String:仅封装跳转页面的基本信息，底层由ModelAndView实现
 * 2.Model:仅封装数据
 * 3.ModelAndView:封装数据并封装视图,包含Model和View两个对象
 * <p>
 * 参数HttpServletRequest传递数据，返回值String
 * 参数Model传递数据，返回值String
 * 参数ModelAndView传递数据与页面，返回值ModelAndView
 */
@Controller
public class BookController {
    // TODO 方式一：使用HttpServletRequest类型形参进行数据传递
    @RequestMapping("/showPageAndData1")
    public String showPageAndData1(HttpServletRequest request) {
        request.setAttribute("name", "cw");
        return "page";
    }

    // TODO 方式二：使用Model类型形参进行数据传递
    @RequestMapping("/showPageAndData2")
    public String showPageAndData2(Model model) {
        //添加数据的方式，key对value
        model.addAttribute("name", "wc");
        Book book = new Book();
        book.setName("SpringMVC入门案例");
        book.setPrice(66.66d);
        //添加数据的方式，key对value
        model.addAttribute("book", book);
        return "page";
    }

    // TODO 方式三：使用ModelAndView类型形参进行数据传递，将该对象作为返回值传递给调用者
    // modelAndView.setViewName("page");等同于 return "page"
    // modelAndView.setViewName("redirect:page.jsp");等同于 return "redirect:page.jsp"
    @RequestMapping("/showPageAndData3")
    public ModelAndView showPageAndData3(ModelAndView modelAndView) {
        // ModelAndView mav = new ModelAndView();    替换形参中的参数
        Book book = new Book();
        book.setName("SpringMVC入门案例");
        book.setPrice(66.66d);
        //添加数据的方式，key对value
        modelAndView.addObject("book", book);
        //添加数据的方式，key对value
        modelAndView.addObject("name", "Jockme");
        //设置页面的方式，该方法最后一次执行的结果生效
        modelAndView.setViewName("page");
        //返回值设定成ModelAndView对象

        return modelAndView;
    }

    // TODO ModelAndView对象支持转发的手工设定，该设定不会启用前缀后缀的页面拼接格式(不能开启页面访问快捷设定 (InternalResourceViewResolver))
    @RequestMapping("/showPageAndData4")
    public ModelAndView showPageAndData4(ModelAndView modelAndView) {
        modelAndView.setViewName("forward:page.jsp");
        //设置页面的方式，setViewName方法最后一次执行的结果生效
        modelAndView.setViewName("forward:/WEB-INF/page/page.jsp");
        return modelAndView;
    }

    // TODO ModelAndView对象支持重定向的手工设定，该设定不会启用前缀后缀的页面拼接格式
    @RequestMapping("/showPageAndData5")
    public ModelAndView showPageAndData6(ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:page.jsp");// redirect不能加/WEB-INF/page/
        return modelAndView;
    }
}
