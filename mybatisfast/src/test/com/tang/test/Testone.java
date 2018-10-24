package com.tang.test;

import com.tang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Testone {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void beforeTest() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);


    }

    @Test
    public  void findUserById() throws IOException {



        SqlSession session = this.sqlSessionFactory.openSession();

        User u = session.selectOne("test.findUserById", 24);

        System.out.println(u);

        session.close();

    }

    @Test
    public void findUserByUsername() throws IOException {


        SqlSession session = this.sqlSessionFactory.openSession();
        List<User> list = session.selectList("test.findUserByUsername", "%小明%");
        for (User user : list) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void addUser(){

        SqlSession sqlSession = this.sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("唐小星");
        user.setBirthday(new Date());
        user.setAddress("不可描述");
        user.setSex("男");

        System.out.println("执行之前:"+ user);
        sqlSession.insert("test.addUser", user);
        sqlSession.commit();
        System.out.println("执行之后:"+ user);

        sqlSession.close();
    }

    @Test
    public void updateUserById(){

        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);

        User user = new User();
        user.setUsername("唐小星");
        user.setSex("2");
        user.setId(35);

        sqlSession.update("test.updateUserById", user);

        sqlSession.close();
    }

    @Test
    public void deleteUserById(){

        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);

        sqlSession.delete("test.deleteUserById", 43);

        sqlSession.close();
    }
}
