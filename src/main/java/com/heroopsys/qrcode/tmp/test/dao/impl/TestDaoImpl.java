package com.heroopsys.qrcode.tmp.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import com.heroopsys.qrcode.tmp.test.dao.TestDao;
import com.heroopsys.qrcode.tmp.test.entity.Test;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bbkmobile.iqoo.cache.annotation.CacheConfig;

@Repository
public class TestDaoImpl implements TestDao {
    @Resource
    private SqlSession session;

    @CacheConfig(cacheName = "demo", keyArgsIndex = "0")
    public List<Test> test(String cacheKey, Integer offset, Integer limit) throws Exception {
        RowBounds bounds = new RowBounds(offset, limit);
        List<Test> list = session.selectList("testMapper.demo", null, bounds);
        return list;
    }
}
