package com.cw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Rest（ REpresentational State Transfer） 一种网络资源的访问风格，定义了网络资源的访问方式
 * 传统风格访问路径
 *  http://localhost/user/get?id=1
 *  http://localhost/deleteUser?id=1
 * Rest风格访问路径
 *  http://localhost/user/1
 * Restful是按照Rest风格访问网络资源
 * 优点
 *  隐藏资源的访问行为，通过地址无法得知做的是何种操作
 *  书写简化
 * Rest行为约定方式
 *  GET（查询） http://localhost/user/1 GET
 *  POST（保存） http://localhost/user POST
 *  PUT（更新） http://localhost/user PUT
 *  DELETE（删除） http://localhost/user DELETE
 * 注意：上述行为是约定方式，约定不是规范，可以打破，所以称Rest风格，而不是Rest规范
 */
//@Controller
// @ResponseBody：直接将return里的内容返回到页面
//@ResponseBody
//设置rest风格的控制器,@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
@RestController
// 设置公共访问路径，配合下方访问路径使用
@RequestMapping("/user/")
public class UserController {

    // rest风格访问路径完整书写方式
    @RequestMapping("/user/{id}")
    //使用@PathVariable注解获取路径上配置的具名变量，该配置可以使用多次
    public String restLocation(@PathVariable Integer id) {
        System.out.println("restful is running ....restLocation" + id);
        return "success.jsp";
    }

    // rest风格访问路径简化书写方式，配合类注解@RequestMapping使用
    @RequestMapping("{id}")
    public String restLocation2(@PathVariable Integer id) {
        System.out.println("restful is running ....restLocation2" + id);
        return "success.jsp";
    }

    //接收GET请求配置方式
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    //接收GET请求简化配置方式
    @GetMapping("{id}")
    public String get(@PathVariable Integer id) {
        System.out.println("restful is running ....get:" + id);
        return "success.jsp";
    }

    //接收POST请求配置方式
    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    //接收POST请求简化配置方式
    @PostMapping("{id}")
    public String post(@PathVariable Integer id) {
        System.out.println("restful is running ....post:" + id);
        return "success.jsp";
    }

    //接收PUT请求简化配置方式
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    //接收PUT请求简化配置方式
    @PutMapping("{id}")
    public String put(@PathVariable Integer id) {
        System.out.println("restful is running ....put:" + id);
        return "success.jsp";
    }

    //接收DELETE请求简化配置方式
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    //接收DELETE请求简化配置方式
    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println("restful is running ....delete:" + id);
        return "success.jsp";
    }
}
