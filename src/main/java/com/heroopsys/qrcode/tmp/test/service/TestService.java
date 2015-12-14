package com.bbkmobile.iqoo.tmp.test.service;

import java.util.List;

import com.bbkmobile.iqoo.tmp.test.entity.Test;

public interface TestService {
    public List<Test> test(Integer pageNumber, Integer pageSize) throws Exception;
}
