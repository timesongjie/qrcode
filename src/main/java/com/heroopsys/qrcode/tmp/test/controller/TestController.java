package com.bbkmobile.iqoo.tmp.test.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbkmobile.iqoo.common.constants.SystemConstants;
import com.bbkmobile.iqoo.common.logging.Lg;
import com.bbkmobile.iqoo.common.vo.Result;
import com.bbkmobile.iqoo.tmp.test.entity.Test;
import com.bbkmobile.iqoo.tmp.test.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
    @Resource
    private TestService testService;

    /**
     * Description: <br>
     * 例子
     * 
     * @author XXX<br>
     * @param path
     * @param openid
     * @param token
     * @param imei
     * @param request
     * @param response
     * @return <br>
     */
    @RequestMapping("/m/{path}")
    public Result<List<Test>> test1(@PathVariable String path, Integer pageNumber, Integer pageSize, HttpServletRequest request, HttpServletResponse response) {
        Result<List<Test>> re = new Result<List<Test>>();
        try {
            List<Test> data = testService.test(pageNumber, pageSize);
            re.setResult(true);
            re.setData(data);
        }
        catch (Exception e) {
            re.setResult(false);
            re.setMsg(SystemConstants.DEF_ERROR_MSG);
            Lg.error(this.getClass(), e.getLocalizedMessage(), e);
        }
        return re;
    }

}
