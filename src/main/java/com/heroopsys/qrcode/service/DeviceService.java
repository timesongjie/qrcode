package com.heroopsys.qrcode.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heroopsys.qrcode.dao.DeviceMapper;
import com.heroopsys.qrcode.entity.Device;
import com.heroopsys.qrcode.entity.DeviceExample;
import com.heroopsys.qrcode.entity.DeviceExample.Criteria;
import com.heroopsys.qrcode.util.Pager;

import java.util.List;

@Service
public class DeviceService {

    @Resource
    private DeviceMapper deviceMapper;

    public void list(Device device, Pager<Device> pager) throws Exception {
        DeviceExample example = new DeviceExample();
        if (device != null) {
            Criteria criteria = example.createCriteria();
            if (device.getDeviceQrcode() != null) {
                criteria.andDeviceCodeEqualTo(device.getDeviceQrcode());
            }
            if (device.getDeviceCode() != null) {
                criteria.andDeviceCodeEqualTo(device.getDeviceCode());
            }
            if (device.getProjectName() != null) {
                criteria.andProjectNameLike(device.getProjectName());
            }
            if (device.getProjectLeader() != null) {
                criteria.andProjectLeaderLike(device.getProjectLeader());
            }
            if (device.getClientName() != null) {
                criteria.andClientNameLike(device.getClientName());
            }
            if (device.getSimPhone() != null) {
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

    public List<Device> findByQrcode(Device device){
        DeviceExample example = new DeviceExample();
        example.createCriteria().andDeviceQrcodeEqualTo(device.getDeviceQrcode());
        return deviceMapper.selectByExampleAndPager(example, null);
    }
}
