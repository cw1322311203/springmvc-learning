package com.cw.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cw.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {

    // 使用原生response对象响应数据
    @RequestMapping("/showData1")
    public void showData1(HttpServletResponse response) throws IOException {
        response.getWriter().write("message");
    }

    // 使用@ResponseBody将返回的结果作为响应内容，而非响应的页面名称
    @RequestMapping("/showData2")
    @ResponseBody
    public String showData2() {
        return "{'name':'jock'}";
    }

    // 方式一：使用jackson进行json数据格式转化
    @RequestMapping("/showData3")
    @ResponseBody
    public String showData3() throws JsonProcessingException {
        Book book = new Book();
        book.setName("SpringMVC入门案例");
        book.setPrice(66.66d);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(book);
    }

    //

    /**
     * 方式二:使用SpringMVC注解驱动，对标注@ResponseBody注解的控制器方法进行结果转换，由于返回值为引用类型，自动调用jackson提供的类型转换器进行格式转换
     * 使用步骤
     * 1.在spring-mvc.xml中配置注解驱动<mvc:annotation-driven/>
     * 2.将要转json的地方加上@ResponseBody
     * 3.将要转为json的数据或对象直接return出去
     * <p>
     * 需要手工添加信息类型转换器
     * <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
     * <property name="messageConverters">
     * <list>
     * <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"/>
     * </list>
     * </property>
     * </bean>
     * 或者使用SpringMVC注解驱动简化配置，已经将jackson的坐标导入，则会自动使用jackson提供的类型转换器
     * <mvc:annotation-driven/>
     * <p>
     * 注解驱动格式@EnableWebMvc
     */
    @RequestMapping("/showData4")
    @ResponseBody
    public Book showData4() {
        Book book = new Book();
        book.setName("SpringMVC入门案例");
        book.setPrice(66.66d);
        return book;
    }

    //转换集合类型数据
    @RequestMapping("/showData5")
    @ResponseBody
    public List showData5() {
        Book book1 = new Book();
        book1.setName("SpringMVC入门案例1");
        book1.setPrice(66.66d);

        Book book2 = new Book();
        book2.setName("SpringMVC入门案例2");
        book2.setPrice(88.88d);

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        return books;
    }
}
