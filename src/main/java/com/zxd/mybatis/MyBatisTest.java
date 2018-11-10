package com.zxd.mybatis;

import com.zxd.mybatis.mapper.ResultDao;
import com.zxd.mybatis.model.ResultDto;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class MyBatisTest
{
    public static void main( String[] args ){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            try{
                ResultDao resultDao = sqlSession.getMapper(ResultDao.class);
                List<ResultDto> resultDtoList =  resultDao.getAll();
                System.out.println(resultDtoList.size());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                sqlSession.close();
            }
            System.out.println("success!");
        } catch (IOException e) {
        }
        System.out.println( "Hello World!" );
    }
}
