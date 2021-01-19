package com.cw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 陈小哥cw
 * @date 2021/1/13 8:51
 *
 * 具体流程
 * 1.导入SpringMVC相关坐标
 * 2.定义表现层业务处理器Controller，并配置成spring的bean（等同于Servlet）
 * 3.web.xml中配置SpringMVC核心控制器，用于将请求转发到对应的具体业务处理器Controller中（等同于Servlet配置）
 * 4.设定具体Controller的访问路径（等同于Servlet在web.xml中的配置）
 * 5.设置返回页面
 *
 * 六大核心组件
 * 1.DispatcherServlet：前端控制器，是整体流程控制的中心，由其调用其它组件处理用户的请求，有效的降低了组件间的耦合性
 * 2.HandlerMapping：处理器映射器， 负责根据用户请求找到对应具体的Handler处理器
 * 3.Handler：处理器，业务处理的核心类，通常由开发者编写，描述具体的业务
 * 4.HandlAdapter：处理器适配器，通过它对处理器进行执行
 * 5.View Resolver：视图解析器， 将处理结果生成View视图
 * 6.View：视图，最终产出结果， 常用视图如jsp、 html
 */
@Controller
public class UserController {
    //设定当前方法的访问映射地址
    @RequestMapping("/save")
    //设置当前方法返回值类型为String，用于指定请求完成后跳转的页面
    public String save() {
        System.out.println("user mvc controller is running...");
        //设定具体跳转的页面
        return "success.jsp";
    }
}
