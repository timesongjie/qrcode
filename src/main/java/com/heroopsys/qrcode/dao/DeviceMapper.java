package com.heroopsys.qrcode.dao;

import com.heroopsys.qrcode.entity.Device;
import com.heroopsys.qrcode.entity.DeviceExample;
import java.util.List;

public interface DeviceMapper {
    int countByExample(DeviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Device record);

    int insertSelective(Device record);

    List<Device> selectByExample(DeviceExample example);

    Device selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}