package com.heroopsys.qrcode;

import com.heroopsys.qrcode.dao.AccountMapper;
import com.heroopsys.qrcode.entity.Account;
import com.heroopsys.qrcode.util.Pager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * Created by time on 15-12-14.
 */
public class MapperTest {
    private ApplicationContext ctx = new ClassPathXmlApplicationContext(
            new String[] { "spring*.xml" });
    private SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)ctx.getBean("sqlSessionFactory");

    private AccountMapper accountMapper = (AccountMapper)ctx.getBean("accountMapper");
    @Test
    public void mapperTest(){
//        SqlSession session = sqlSessionFactory.openSession();
//        Account account = new Account();
//        account.setName("hello");
//        account.setPassword("123456");
//        session.getMapper(AccountMapper.class).addAccount(account);
//        Integer count = 0;
        Account account = new Account();
        account.setName("hello");
//        count = accountMapper.count(account);
//        System.out.println(count);

        Pager<Account> pager = new Pager<Account>();
        pager.setPage(1);
        pager.setRows(20);
        accountMapper.listAllByPager(account,pager);
    }

}
