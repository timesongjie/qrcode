package com.heroopsys.qrcode;

import com.heroopsys.qrcode.dao.AccountMapper;
import com.heroopsys.qrcode.entity.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by time on 15-12-14.
 */
public class MapperTest {
    private ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[] { "spring*.xml" });
    private SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)ctx.getBean("sqlSessionFactory");

    @Test
    public void mapperTest(){
        SqlSession session = sqlSessionFactory.openSession();
        Account account = new Account();
        account.setName("hello");
        account.setPassword("123456");
        session.getMapper(AccountMapper.class).addAccount(account);
    }

}
