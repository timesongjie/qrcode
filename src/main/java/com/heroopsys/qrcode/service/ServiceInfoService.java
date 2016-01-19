package com.heroopsys.qrcode.service;

import javax.annotation.Resource;

import com.heroopsys.qrcode.entity.ServiceInfo;
import org.springframework.stereotype.Service;

import com.heroopsys.qrcode.dao.ServiceMapper;
import com.heroopsys.qrcode.entity.ServiceExample;
import com.heroopsys.qrcode.entity.ServiceExample.Criteria;
import com.heroopsys.qrcode.util.Pager;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ServiceInfoService {

    @Resource
    private ServiceMapper serviceMapper;

    public void addOrUpdateService(com.heroopsys.qrcode.entity.ServiceInfo service) {
        if (service.getId() == null) {
            serviceMapper.insert(service);
        } else {
            serviceMapper.updateByPrimaryKey(service);
        }
    }

    public void list(com.heroopsys.qrcode.entity.ServiceInfo service,
                     Pager<com.heroopsys.qrcode.entity.ServiceInfo> pager) {
        ServiceExample example = new ServiceExample();
        if (service != null) {
            Criteria criteria = example.createCriteria();
            if (service.getSserviceDate() != null && service.getEserviceDate() != null) {
                criteria.andServiceDateBetween(service.getSserviceDate(), service.getEserviceDate());
            }
            // ....可以按照条件新增
        }
        pager.setTotal(serviceMapper.countByExample(example));
        pager.setDataList(serviceMapper.selectByExampleAndPager(example, pager));
    }
    public List<ServiceInfo> list(ServiceInfo service) {
        ServiceExample example = new ServiceExample();
        if (service != null) {
            Criteria criteria = example.createCriteria();
            if (service.getSserviceDate() != null && service.getEserviceDate() != null) {
                criteria.andServiceDateBetween(service.getSserviceDate(), service.getEserviceDate());
            }
            if(!StringUtils.isEmpty(service.getDeviceCode())){
                criteria.andDeviceCodeEqualTo(service.getDeviceCode());
            }
            // ....可以按照条件新增
        }
        return serviceMapper.selectByExampleAndPager(example,null);
    }
}
