package com.heroopsys.qrcode.dao;

import com.heroopsys.qrcode.entity.Account;
import com.heroopsys.qrcode.util.Pager;

import java.util.List;

/**
 * Created by time on 15-12-14.
 */
public interface AccountMapper {
    public int addAccount(Account account);

    public int updateStatus(Account account);

    public int delAccount(Account account);

    public List<Account> listAll(Account account, Pager<Account> pager);
    
    public Account queryByNameAndPwd(Account account);
}
