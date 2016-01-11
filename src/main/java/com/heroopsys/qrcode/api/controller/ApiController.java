package com.heroopsys.qrcode.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heroopsys.qrcode.api.bo.INotice;
import com.heroopsys.qrcode.api.bo.IUser;
import com.heroopsys.qrcode.common.converter.JacksonUtil;
import com.heroopsys.qrcode.common.vo.Result;
import com.heroopsys.qrcode.entity.Device;
import com.heroopsys.qrcode.entity.Service;
import com.heroopsys.qrcode.entity.ServiceType;

/**
 * Created by time on 15-12-22.
 */
@Controller
@RequestMapping("/api")
public class ApiController {

	@RequestMapping("/auth")
	public Result<IUser> login(String name, String pwd) {
		Result<IUser> result = new Result<IUser>();
		result.setStatus((byte) 0);
		result.setMsg("登陆成功!");
		IUser user = new IUser();
		user.setUserName("root");
		user.setEnable(new Byte[] { 1, 1, 1 });
		result.setData(user);
		return result;
	}

	@RequestMapping("/notice")
	public Result<INotice> notice() {
		Result<INotice> result = new Result<INotice>();
		result.setStatus((byte) 0);
		result.setMsg("获取公告成功!");
		INotice notice = new INotice();
		notice.setNotice("今天是个好天气!");
		result.setData(notice);
		return result;
	}

	@RequestMapping("/service")
	public Result<List<ServiceType>> service() {
		Result<List<ServiceType>> result = new Result<List<ServiceType>>();
		result.setStatus((byte) 0);
		result.setMsg("获取服务类型成功!");
		List<ServiceType> types = new ArrayList<ServiceType>();
		ServiceType type = new ServiceType();
		type.setServiceType("售前");
		type.setId(1);
		types.add(type);
		ServiceType type2 = new ServiceType();
		type2.setServiceType("售中");
		type2.setId(2);
		types.add(type2);
		ServiceType type3 = new ServiceType();
		type3.setServiceType("售后");
		type3.setId(3);
		types.add(type3);
		result.setData(types);
		return result;
	}

	@RequestMapping("/device/{qrcode}")
	public Result<Device> device(@PathVariable String qrcode) {
		Result<Device> result = new Result<Device>();
		if ("4938c918f9a24d5cb2df10fd898b8246".equals(qrcode)) {
			result.setStatus((byte) 0);
			result.setMsg("获取设备成功!");
			Device device = new Device();
			result.setData(device);

			List<Service> services = new ArrayList<Service>();
			Service sevice = new Service();
			sevice.setServiceType(new ServiceType());
			services.add(sevice);
			device.setServices(services);
		} else {
			result.setStatus((byte) 1);
			result.setMsg("设备不存在!");
		}
		return result;
	}

	@RequestMapping("/device/list")
	public Result<List<Device>> devices() {
		Result<List<Device>> result = new Result<List<Device>>();

		return result;
	}

	@RequestMapping("/device")
	public Result addDevice(HttpServletRequest request) {
		String data = request.getParameter("data");
		try {
			Device device = JacksonUtil.readValue(data, Device.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}