package com.heroopsys.qrcode.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.heroopsys.qrcode.common.controller.BaseController;
import com.heroopsys.qrcode.entity.Device;
import com.heroopsys.qrcode.service.DeviceService;
import com.heroopsys.qrcode.util.Grid;
import com.heroopsys.qrcode.util.Pager;

@Controller
@RequestMapping("/device")
public class DeviceController extends BaseController {

    @Resource
    private DeviceService deviceService;
    private Logger log = LoggerFactory.getLogger(DeviceController.class);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Grid<Device> list(Integer page, Integer rows) {
	if (page == null) {
	    page = 1;
	}
	if (rows == null) {
	    rows = 20;
	}
	Device device = new Device();
	Pager<Device> pager = new Pager<Device>();
	pager.setPage(page);
	pager.setRows(rows);
	Grid<Device> grid = new Grid<Device>();
	try {
	    deviceService.list(device, pager);
	} catch (Exception e) {
	    e.printStackTrace();
	    log.error("查询设备列表报错，联系管理员!" + e.getMessage());
	}
	grid.setRows(pager.getDataList());
	grid.setTotal(pager.getTotal());
	return grid;
    };
}
