package com.heroopsys.qrcode.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heroopsys.qrcode.dao.DeviceMapper;
import com.heroopsys.qrcode.entity.Device;
import com.heroopsys.qrcode.entity.DeviceExample;
import com.heroopsys.qrcode.entity.DeviceExample.Criteria;
import com.heroopsys.qrcode.util.Pager;

@Service
public class DeviceService {

    @Resource
    private DeviceMapper deviceMapper;

    public void list(Device device, Pager<Device> pager) throws Exception {
	DeviceExample example = new DeviceExample();
	if (device != null) {
	    Criteria criteria = example.createCriteria();
	    if (device.getDeviceCode() != null) {
		criteria.andDeviceCodeEqualTo(device.getDeviceCode());
	    }
	    if (device.getProjectName() != null) {
		criteria.andProjectNameEqualTo(device.getProjectName());
	    }
	    if (device.getProjectLeader() != null) {
		criteria.andProjectLeaderEqualTo(device.getProjectLeader());
	    }
	    if (device.getClientName() != null) {
		criteria.andClientNameEqualTo(device.getClientName());
	    }
	    if (device.getSimPhone() != null) {
		criteria.andSimPhoneEqualTo(device.getSimPhone());
	    }
	    // ....可以按照条件新增
	}
	pager.setTotal(deviceMapper.countByExample(example));
	pager.setDataList(deviceMapper.selectByExampleAndPager(example,pager));
    }
}
