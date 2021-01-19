package com.cw.dao;

import com.cw.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 陈小哥cw
 * @date 2021/1/18 15:17
 */
public interface UserDao {

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Insert("insert into user(userName,password,realName,gender,birthday) values(#{userName},#{password},#{realName},#{gender},#{birthday})")
    public boolean save(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Update("update user set userName=#{userName},password=#{password},realName=#{realName},gender=#{gender},birthday=#{birthday} where uuid=#{uuid}")
    public boolean update(User user);

    /**
     * 删除用户
     *
     * @param uuid
     * @return
     */
    @Delete("delete from user where uuid = #{uuid}")
    public boolean delete(Integer uuid);

    /**
     * 查询单个用户信息
     *
     * @param uuid
     * @return
     */
    @Select("select * from user where uuid= #{uuid}")
    public User get(Integer uuid);

    /**
     * 查询全部用户信息
     *
     * @return
     */
    @Select("select * from user")
    public List<User> getAll();

    /**
     * 根据用户名密码查询用户信息
     *
     * @param userName
     * @param password
     * @return
     */
    @Select("select * from user where userName=#{userName} and password=#{password}")
    public User getByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
