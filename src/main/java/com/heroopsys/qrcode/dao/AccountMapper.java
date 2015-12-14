package com.heroopsys.qrcode.dao;

import com.heroopsys.qrcode.entity.Account;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by time on 15-12-14.
 */
public interface AccountMapper {
    @Insert("insert into t_auth_account(account_id, password) values(#{name}, #{password})")
    public int add(Account account);
}
