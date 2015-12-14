package com.bbkmobile.iqoo.tmp.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bbkmobile.iqoo.cache.annotation.CacheConfig;
import com.bbkmobile.iqoo.tmp.test.dao.TestDao;
import com.bbkmobile.iqoo.tmp.test.entity.Test;

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
