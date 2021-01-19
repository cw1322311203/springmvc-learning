package com.cw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author 陈小哥cw
 * @date 2021/1/19 15:20
 */
@Configuration
//等同于<context:component-scan base-package="com.cw.controller"/>
@ComponentScan("com.cw.controller")
/**
 * 等同于<mvc:annotation-driven/>，还不完全相同
 * @EnableWebMvc的用处
 * 1. 支持ConversionService的配置，可以方便配置自定义类型转换器
 * 2. 支持@NumberFormat注解格式化数字类型
 * 3. 支持@DateTimeFormat注解格式化日期数据，日期包括Date,Calendar,JodaTime（JodaTime要导包）
 * 4. 支持@Valid的参数校验(需要导入JSR-303规范)
 * 5. 配合第三方jar包和SpringMVC提供的注解读写XML和JSON格式数据
 */
@EnableWebMvc
public class SpringMvcConfig {
}
