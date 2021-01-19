package com.cw.controller;

import com.cw.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.Date;
import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2021/1/14 9:10
 */
@Controller
/**
 * 名称： @RequestMapping
 * 类型： 类注解
 * 位置：处理器类定义上方
 * 作用：为当前处理器中所有方法设定公共的访问路径前缀
 * 访问路径： /user/requestURL1
 *
 * 如果加了该配置需要保证page.jsp在webapp的user目录下
 */
@RequestMapping("/user")
public class UserController {

    // 普通类型参数:参数名与处理器方法形参名保持一致
    // 方法传递普通类型参数，数量任意，类型必须匹配
    // http://localhost:8080/spring03/requestParam1?name=cw
    // http://localhost:8080/spring03/requestParam1?name=cw&age=14
    // http://localhost:8080/spring03/requestParam1?age=14&name=cw
    @RequestMapping("/requestParam1")
    public String requestParam1(String name, int age) {
        System.out.println(name + " " + age);
        return "page.jsp";
    }

    /**
     * 方法传递普通类型参数，使用@RequestParam参数匹配URL传参中的参数名称与方法形参名称
     * http://localhost:8080/spring03/requestParam2?userName=mike
     *
     * @RequestParam的使用 类型：形参注解
     * 位置：处理器类中的方法形参前方
     * 作用：绑定请求参数与对应处理方法形参间的关系
     * <p>
     * required:必须传userName这个参数，不传报错Required String parameter 'userName' is not present
     * defaultValue:默认值为cw(设置了这个后,required = true等于失效，因为不传参也会有默认值，不会报错)
     */
    @RequestMapping("/requestParam2")
    public String requestParam2(@RequestParam(value = "userName", required = true) String name) {
        System.out.println(name);
        return "page.jsp";
    }

    //
    //

    /**
     * 方法传递POJO类型参数，URL地址中的参数作为POJO的属性直接传入对象
     * http://localhost:8080/spring03/requestParam3?name=Jock&age=39
     */
    @RequestMapping("/requestParam3")
    public String requestParam3(User user) {
        System.out.println(user);
        return "page.jsp";
    }

    //
    //
    //

    /**
     * 当方法参数中具有POJO类型参数与普通类型参数时，URL地址传入的参数不仅给POJO对象属性赋值，也给方法的普通类型参数赋值
     * http://localhost:8080/spring03/requestParam4?name=Jock&age=39
     * 建议使用@RequestParam注解进行区分
     */
    @RequestMapping("/requestParam4")
    public String requestParam4(User user, int age) {
        System.out.println("user.age=" + user.getAge() + ",age=" + age);
        return "page.jsp";
    }

    /**
     * 使用对象属性名.属性名的对象层次结构可以为POJO中的POJO类型参数属性赋值
     * 当POJO中出现对象属性时，参数名称与对象层次结构名称保持一致
     * http://localhost:8080/spring03/requestParam5?address.city=beijing
     */
    @RequestMapping("/requestParam5")
    public String requestParam5(User user) {
        System.out.println(user.getAddress().getCity());
        return "page.jsp";
    }


    /**
     * 通过URL地址中同名参数，可以为POJO中的集合属性进行赋值，集合属性要求保存简单数据
     * 当POJO中出现集合，保存简单数据，使用多个同名参数为其进行赋值
     * http://localhost:8080/spring03/requestParam6?nick=Jock1&nick=Jockme&nick=zahc
     */
    @RequestMapping("/requestParam6")
    public String requestParam6(User user) {
        System.out.println(user.getNick());// [Jock1, Jockme, zahc]
        return "page.jsp";
    }


    /**
     * POJO中List对象保存POJO的对象属性赋值，使用[数字]的格式指定为集合中第几个对象的属性赋值
     * 当POJO中出现List保存对象数据时，参数名称与对象层次结构名称b保持一致，使用数组格式描述集合中对象的位置
     * http://localhost:8080/spring03/requestParam7?addresses[0].city=beijing&addresses[1].province=hebei
     * 直接使用上述地址可能报错，可以使用这个地址http://localhost:8080/spring03/requestParam7?addresses%5b0%5d.city=beijing&addresses%5b1%5d.province=hebei
     *
     * @param user
     * @return
     */
    @RequestMapping("/requestParam7")
    public String requestParam7(User user) {
        System.out.println(user.getAddresses());
        return "page.jsp";
    }


    /**
     * POJO中Map对象保存POJO的对象属性赋值，使用[key]的格式指定为Map中的对象属性赋值
     * 当POJO中出现Map保存对象数据时，参数名称与对象层次结构名称保持一致，使用映射格式描述集合中对象的位置
     * http://localhost:8080/spring03/requestParam8?addressMap['job'].city=beijing&addressMap['home'].province=henan
     */
    @RequestMapping("/requestParam8")
    public String requestParam8(User user) {
        System.out.println(user.getAddressMap());
        return "page.jsp";
    }


    /**
     * 方法传递普通类型的数组参数，URL地址中使用同名变量为数组赋值
     * 数据类型参数:请求参数名与处理器方法形参名保持一致
     * http://localhost:8080/spring03/requestParam9?nick=Jockme&nick=zahc
     */
    @RequestMapping("/requestParam9")
    public String requestParam9(String[] nick) {
        System.out.println(nick[0] + "," + nick[1]);
        return "page.jsp";
    }

    /**
     * TODO 方法传递保存普通类型的List集合时，无法直接为其赋值，需要使用@RequestParam参数对参数名称进行转换
     * http://localhost:8080/spring03/requestParam10?nick=Jockme&nick=zahc
     * <p>
     * 注意： SpringMVC默认将List作为对象处理，赋值前先创建对象，然后将nick作为对象的属性进行处理。由于
     * List是接口，无法创建对象，报无法找到构造方法异常；修复类型为可创建对象的ArrayList类型后，对象可
     * 以创建，但没有nick属性，因此数据为空。此时需要告知SpringMVC的处理器nick是一组数据，而不是一个单
     * 一数据。通过@RequestParam注解，将数量大于1个names参数打包成参数数组后， SpringMVC才能识别该数
     * 据格式，并判定形参类型是否为数组或集合，并按数组或集合对象的形式操作数据。
     */
    @RequestMapping("/requestParam10")
    public String requestParam10(@RequestParam("nick") List<String> nick) {
        System.out.println(nick);
        return "page.jsp";
    }


    /**
     * TODO 数据类型转换，使用自定义格式化器(SpringMVC配置文件中配置)或@DateTimeFormat注解设定日期格式
     * 两种方式都依赖springmvc的注解启动才能运行
     * http://localhost:8080/spring03/requestParam11?date=1999-09-09
     * <p>
     * 名称：@DateTimeFormat
     * 类型：形参注解、成员变量注解
     * 位置：形参前面 或 成员变量上方
     * 作用：为当前参数或变量指定类型转换规则
     * <p>
     * 注意：需要开启依赖注解驱动支持
     * <mvc:annotation-driven />
     * <p>
     * 在pojo类的成员变量上配置日期数据类型覆盖转换
     *
     * @DateTimeFormat(pattern = "yyyy-MM-dd")
     * private Date birthday;
     */
    @RequestMapping("/requestParam11")
    public String requestParam11(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        System.out.println(date);
        return "page.jsp";
    }

    /**
     * TODO 数据类型转换，使用自定义类型转换器，需要配置后方可使用
     * http://localhost:8080/spring03/requestParam12?date=1999-09-09
     */
    @RequestMapping("/requestParam12")
    public String requestParam12(Date date) {
        System.out.println(date);
        return "page.jsp";
    }

    /**
     * TODO 无类映射地址访问格式
     * http://localhost:8080/spring03/requestURL1
     *
     * @RequestMapping 类型： 方法注解
     * 位置：处理器类中的方法定义上方
     * 作用：绑定请求地址与对应处理方法间的关系
     */
    @RequestMapping("/requestURL1")
    public String requestURL1() {
        return "page.jsp";// 访问的user目录下的page.jsp
    }

    /**
     * 带有类映射地址访问格式，需要将类映射地址作为前缀添加在实际映射地址的前面
     * 最终返回的页面如果未设定绝对访问路径，将从类映射地址所在目录中查找
     * http://localhost:8080/spring03/user/requestURL2     （注意：要配合类上定义的路径使用）
     */
    @RequestMapping("/requestURL2")
    public String requestURL2() {
        return "/page.jsp";// 访问的根目录下的page.jsp
    }


    /**
     * @RequestMapping参数，一个路径参数，6个访问限定性参数（了解） http://localhost:8080/spring03/user/requestURL3?name=cw
     * @RequestMapping( value="/requestURL3", //设定请求路径，与path属性、 value属性相同
     * method = RequestMethod.GET, //设定请求方式
     * params = "name", //设定请求参数条件,请求参数必须携带name参数
     * headers = "content-type=text/*", //设定请求消息头条件
     * consumes = "text/*", //用于指定可以接收的请求正文类型（MIME类型）
     * produces = "text/*" //用于指定可以生成的响应正文类型（MIME类型）
     * )
     */
    @RequestMapping(value = "/requestURL3", params = "name")
    public String requestURL3(String name) {
        System.out.println("name = " + name);
        return "page.jsp";
    }
}
