package com.heroopsys.qrcode.service;

import com.heroopsys.qrcode.dao.AccountMapper;
import com.heroopsys.qrcode.entity.Account;
import com.heroopsys.qrcode.util.Pager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by time on 15-12-15.
 */
@Service
public class AccountService {
    @Resource
    private AccountMapper accountMapper;

    public void addAccount(Account account){
        accountMapper.addAccount(account);
    }

    public void updateAccount(Account account){
        accountMapper.updateStatus(account);
    }

    public Pager<Account> list(Account account, Pager<Account> pager){
        accountMapper.listAll(account, pager);
        return null;
    }

    public Account login(Account account){
        return accountMapper.queryByNameAndPwd(account);
    }

}
