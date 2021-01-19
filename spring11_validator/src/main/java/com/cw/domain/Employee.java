package com.cw.domain;


import com.cw.controller.groups.GroupA;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Employee {

    // 设定校验器，设置校验不通过对应的消息，设定所参与的校验组
    @NotBlank(message = "姓名不能为空", groups = {GroupA.class})
    private String name;//员工姓名

    /**
     * 设置校验规则
     *  名称：@NotNull
     *  类型：属性注解 等
     *  位置：实体类属性上方
     *  作用：设定当前属性校验规则
     *  范例：
     * 每个校验规则所携带的参数不同，根据校验规则进行相应的调整
     * 具体的校验规则查看对应的校验框架进行获取
     * <p>
     * 3种判定空校验器的区别
     * ---------------------------------------------------------
     * | 表单数据            | @NotNull | @NotEmpty | @NotBlank |
     * | ------------------- | -------- | --------- | --------- |
     * | String s = null;    | false    | false     | false     |
     * | String s = "";      | true     | false     | false     |
     * | String s = "     "; | true     | true      | false     |
     * | String s = "Jock";  | true     | true      | true      |
     */
    // 一个属性可以添加多个校验器
    @NotNull(message = "请输入您的年龄", groups = {GroupA.class})
    @Max(value = 60, message = "年龄最大值不允许超过60岁")
    @Min(value = 18, message = "年龄最大值不允许低于18岁")
    private Integer age;//员工年龄

    // 实体类中的引用类型通过标注@Valid注解，设定开启当前引用类型字段中的属性参与校验
    @Valid
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
