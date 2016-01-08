package com.heroopsys.qrcode.dao;

import com.heroopsys.qrcode.entity.DeviceServiceType;

public interface DeviceServiceTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeviceServiceType record);

    int insertSelective(DeviceServiceType record);

    DeviceServiceType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeviceServiceType record);

    int updateByPrimaryKey(DeviceServiceType record);
}