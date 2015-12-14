package com.bbkmobile.iqoo.tmp.test.dao;

import java.util.List;

import com.bbkmobile.iqoo.tmp.test.entity.Test;

public interface TestDao {

    public List<Test> test(String cacheKey, Integer offset, Integer limit) throws Exception;

}
