package com.bbkmobile.iqoo.tmp.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbkmobile.iqoo.tmp.test.dao.TestDao;
import com.bbkmobile.iqoo.tmp.test.entity.Test;
import com.bbkmobile.iqoo.tmp.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestDao testDao;

    @Override
    public List<Test> test(Integer pageNumber, Integer pageSize) throws Exception {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        if (pageSize == null) {
            pageSize = 1;
        }
        Integer offset = (pageNumber - 1) * pageSize;
        Integer limit = pageSize;
        String cacheKey = new StringBuffer("k").append(offset).append(":").append(limit).toString();
        List<Test> re = testDao.test(cacheKey, offset, limit);
        return re;
    }

}
