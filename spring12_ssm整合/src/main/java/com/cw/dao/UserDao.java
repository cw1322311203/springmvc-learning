package com.cw.dao;

import com.cw.domain.User;
import org.apache.ibatis.annotations.Param;

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
    public boolean save(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    public boolean update(User user);

    /**
     * 删除用户
     *
     * @param uuid
     * @return
     */
    public boolean delete(Integer uuid);

    /**
     * 查询单个用户信息
     *
     * @param uuid
     * @return
     */
    public User get(Integer uuid);

    /**
     * 查询全部用户信息
     *
     * @return
     */
    public List<User> getAll();

    /**
     * 根据用户名密码查询用户信息
     *
     * @param userName
     * @param password
     * @return
     */
    public User getByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
