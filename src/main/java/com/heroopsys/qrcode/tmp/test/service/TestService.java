package com.heroopsys.qrcode.tmp.test.service;

import com.heroopsys.qrcode.tmp.test.entity.Test;

import java.util.List;


public interface TestService {
    public List<Test> test(Integer pageNumber, Integer pageSize) throws Exception;
}
