package com.heroopsys.qrcode.tmp.test.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heroopsys.qrcode.common.constants.SystemConstants;
import com.heroopsys.qrcode.common.vo.Result;
import com.heroopsys.qrcode.tmp.test.entity.Test;
import com.heroopsys.qrcode.tmp.test.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @Resource
    private TestService testService;

    /**
     * Description: <br>
     * 例子
     *
     * @param path
     * @param request
     * @param response
     * @return <br>
     * @author XXX<br>
     */
    @RequestMapping("/m/{path}")
    public Result<List<Test>> test1(@PathVariable String path, Integer pageNumber, Integer pageSize, HttpServletRequest request, HttpServletResponse response) {
        Result<List<Test>> re = new Result<List<Test>>();
        try {
            List<Test> data = testService.test(pageNumber, pageSize);
            re.setResult(true);
            re.setData(data);
        } catch (Exception e) {
            re.setResult(false);
            re.setMsg(SystemConstants.DEF_ERROR_MSG);
        }
        return re;
    }

}
