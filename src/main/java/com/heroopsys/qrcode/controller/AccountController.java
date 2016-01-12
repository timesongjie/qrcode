package com.heroopsys.qrcode.controller;

import com.heroopsys.qrcode.common.controller.BaseController;
import com.heroopsys.qrcode.entity.Account;
import com.heroopsys.qrcode.service.AccountService;
import com.heroopsys.qrcode.util.Grid;
import com.heroopsys.qrcode.util.Pager;
import com.heroopsys.qrcode.util.Result;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by time on 15-12-15.
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(String username, String password, HttpServletRequest request) {
	Account account = new Account(username, password);
	if (accountService.findByAccount(account) != null) {
	    account.setPassword(null);
	    request.getSession().setAttribute("account_info", account);
	    return new Result("登陆成功!", true);
	} else {
	    return new Result("登陆失败!", false);
	}
    }

    @RequestMapping("/logout")
    public Result logout(HttpServletRequest request) {
	request.getSession().removeAttribute("account_info");
	return new Result("退出成功", true);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Grid<Account> list(Integer page, Integer rows) {
	if (page == null) {
	    page = 1;
	}
	if (rows == null) {
	    rows = 20;
	}
	Account account = new Account();
	Pager<Account> pager = new Pager<Account>();
	pager.setPage(page);
	pager.setRows(rows);
	Grid<Account> grid = new Grid<Account>();
	accountService.list(account, pager);
	grid.setRows(pager.getDataList());
	grid.setTotal(pager.getTotal());
	return grid;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result addAccount(Account account, Model model) {
	accountService.addAccount(account);
	doClear(model, "account");
	return new Result("添加成功!", true);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delAccount(@PathVariable Integer id) {
	accountService.delAccount(id);
	return new Result("删除成功!", true);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Result updateAccount(Account account, Model model) {
	accountService.updateAccount(account);
	doClear(model, "account");
	return new Result("更新成功!", true);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getAccountById(@PathVariable Long id, Model model) {
	Account account = new Account();
	account.setId(id);
	account = accountService.findByAccount(account);
	model.addAttribute("account", account);
	return "account/accountEdit";
    }
}
