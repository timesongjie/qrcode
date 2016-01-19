package com.heroopsys.qrcode.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heroopsys.qrcode.dao.DeviceMapper;
import com.heroopsys.qrcode.entity.Device;
import com.heroopsys.qrcode.entity.DeviceExample;
import com.heroopsys.qrcode.entity.DeviceExample.Criteria;
import com.heroopsys.qrcode.util.Pager;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DeviceService {

    @Resource
    private DeviceMapper deviceMapper;

    public void list(Device device, Pager<Device> pager) throws Exception {
        DeviceExample example = new DeviceExample();
        if (device != null) {
            Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(device.getDeviceQrcode())) {
                criteria.andDeviceCodeEqualTo(device.getDeviceQrcode());
            }
            if (!StringUtils.isEmpty(device.getDeviceCode())) {
                criteria.andDeviceCodeEqualTo(device.getDeviceCode());
            }
            if (!StringUtils.isEmpty(device.getProjectName())) {
                criteria.andProjectNameLike(device.getProjectName());
            }
            if (!StringUtils.isEmpty(device.getProjectLeader())) {
                criteria.andProjectLeaderLike(device.getProjectLeader());
            }
            if (!StringUtils.isEmpty(device.getClientName())) {
                criteria.andClientNameLike(device.getClientName());
            }
            if (!StringUtils.isEmpty(device.getSimPhone())) {
                criteria.andSimPhoneEqualTo(device.getSimPhone());
            }
            // ....可以按照条件新增
        }
        pager.setTotal(deviceMapper.countByExample(example));
        pager.setDataList(deviceMapper.selectByExampleAndPager(example, pager));
    }

    public void addOrUpdateDevice(Device device) {
        if (device.getId() != null) {
            deviceMapper.updateByPrimaryKey(device);
        } else {
            deviceMapper.insert(device);
        }
    }

    public List<Device> findByDevice(Device device) {
        DeviceExample example = new DeviceExample();
        Criteria criteria = example.createCriteria();
        if (device.getDeviceQrcode() != null) {
            criteria.andDeviceQrcodeEqualTo(device.getDeviceQrcode());
        }
        if (device.getId() != null) {
            criteria.andIdEqualTo(device.getId());
        }
        return deviceMapper.selectByExampleAndPager(example, null);
    }
}
