package com.tang.test;

import com.tang.mapper.UserMapper;
import com.tang.pojo.Order;
import com.tang.pojo.QueryVo;
import com.tang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Testtwo {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void beforeTest() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

    }

    @Test
    public void selectUserById(){

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectUserById(26);

        sqlSession.close();

        System.out.println(user);
    }

    @Test
    public void addUser(){

        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("老王");
        user.setAddress("...");
        user.setSex("1");

        System.out.println("执行前"+user);

        mapper.addUser(user);

        System.out.println("执行后"+user);

        sqlSession.close();
    }

    @Test
    public void selectUserByCondition(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("小明");
        queryVo.setUser(user);

        List<User> list = mapper.selectUserByCondition(queryVo);
        for (User user1 : list) {
            System.out.println(user1);
        }

        sqlSession.close();
    }

    @Test
    public void selectUserByUsernameAndSex(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("小");
        user.setSex("1");

        List<User> users = mapper.selectUserByUsernameAndSex(user);

        for(User u : users){
            System.out.println(u);
        }
        sqlSession.close();
    }


    @Test
    public void dynamicUpdateUserById(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(45);
        user.setUsername("小李飞刀");
        user.setSex("女");

        mapper.dynamicUpdateUserById(user);
        sqlSession.close();
    }

    @Test
    public void batchInsertUser(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> list = new ArrayList<User>();
        for(int i = 0 ; i<2; i++ ){
            User user = new User();
            user.setUsername("用户:"+ i);
            user.setBirthday(new Date());
            user.setSex("1");
            user.setAddress("用户描述:"+i);

            list.add(user);
        }
        mapper.batchInsertUser(list);

        sqlSession.close();
    }

    @Test
    public void batchDeleteUser(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Integer[] array = {47,48};
        mapper.batchDeleteUser(array);

        sqlSession.close();
    }

    @Test
    public void selectAllOrderAndUser(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Order> list = mapper.selectAllOrderAndUser();

        for (Order order : list) {
            System.out.println(order);
        }
        sqlSession.close();
    }

    @Test
    public void selectAllUserAndOrder(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.selectAllUserAndOrder();

        for (User user : users) {
            System.out.println(user);

        }
        sqlSession.close();
    }
}
