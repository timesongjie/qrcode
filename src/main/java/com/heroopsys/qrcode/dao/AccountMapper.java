package com.heroopsys.qrcode.dao;

import com.heroopsys.qrcode.entity.Account;
import com.heroopsys.qrcode.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by time on 15-12-14.
 */
public interface AccountMapper {
    public Integer addAccount(Account account);

    public Integer updateStatus(Account account);

    public Integer delAccount(Account account);

    public List<Account> listAllByPager(@Param("account")Account account, @Param("page")Pager<Account> pager);
    
    public Account queryByNameAndPwd(Account account);

    public Integer count(Account account);

}
