package com.cw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 拦截器（ Interceptor）是一种动态拦截方法调用的机制
 * 作用：
 * 1. 在指定的方法调用前后执行预先设定后的的代码
 * 2. 阻止原始方法的执行
 * <p>
 * 核心原理： AOP思想
 * 拦截器链：多个拦截器按照一定的顺序，对原始被调用功能进行增强
 * <p>
 * 拦截器VS过滤器
 *  归属不同： Filter属于Servlet技术， Interceptor属于SpringMVC技术
 *  拦截内容不同： Filter对所有访问进行增强， Interceptor仅针对SpringMVC的访问进行增强
 */
@Controller
public class InterceptorController {

    @RequestMapping("/handleRun")
    public String handleRun() {
        System.out.println("业务处理器运行------------main");
        return "page.jsp";
    }
}
