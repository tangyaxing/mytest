package com.tang.mapper;

import com.tang.pojo.Order;
import com.tang.pojo.QueryVo;
import com.tang.pojo.User;

import java.util.List;

public interface UserMapper {

    User selectUserById(int id);

    void addUser(User user);

    List<User> selectUserByCondition(QueryVo queryVo);

    List<User> selectUserByUsernameAndSex(User user);

    void dynamicUpdateUserById(User user);

    void batchInsertUser(List<User> list);

    void batchDeleteUser(Integer[] array );

    List<Order> selectAllOrderAndUser();

    List<User> selectAllUserAndOrder();
}
