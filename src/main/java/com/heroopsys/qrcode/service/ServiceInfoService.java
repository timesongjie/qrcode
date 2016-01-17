package com.heroopsys.qrcode.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heroopsys.qrcode.dao.ServiceMapper;
import com.heroopsys.qrcode.entity.ServiceExample;
import com.heroopsys.qrcode.entity.ServiceExample.Criteria;
import com.heroopsys.qrcode.util.Pager;

@Service
public class ServiceInfoService {

    @Resource
    private ServiceMapper serviceMapper;

    public void addService(com.heroopsys.qrcode.entity.ServiceInfo service) {
	serviceMapper.insert(service);
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

}
