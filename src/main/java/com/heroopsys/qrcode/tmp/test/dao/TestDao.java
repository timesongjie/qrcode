package com.heroopsys.qrcode.tmp.test.dao;

import com.heroopsys.qrcode.tmp.test.entity.Test;

import java.util.List;


public interface TestDao {

    public List<Test> test(String cacheKey, Integer offset, Integer limit) throws Exception;

}
