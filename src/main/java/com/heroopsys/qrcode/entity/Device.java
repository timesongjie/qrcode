package com.heroopsys.qrcode.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by time on 15-12-22.
 */
public class Device {
    private Long id = 0l;
    private String deviceCode = "4938c918f9a24d5cb2df10fd898b8246";
    private String deviceModel = "4938c918f9a24d5cb2df10fd898b8246";
    private String deviceQrcode ="4938c918f9a24d5cb2df10fd898b8246";
    private String projectName ="设备1";
    private String projectLeader ="hk";
    private String projectOthers="hk";
    private Date debugDate = new Date();
    private Date finishDate= new Date();
    private String contractPoint = "合同指标";
    private String clientName = "hk公司";
    private String clientSite ="湖南长沙";
    private String client="hk";
    private String clientTel="07318888888";
    private String activationCode="4938c918f9a24d5cb2df10fd898b8246";
    private String activationCode2;
    private String activationCode3;
    private String activationCode4;
    private String wlan="hk";
    private String simPhone="13800000000";
    private String simFee="120元/月";
    private String bak="xxxxxxxxxx";
    private List<DeviceService> services;


    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceQrcode() {
        return deviceQrcode;
    }

    public void setDeviceQrcode(String deviceQrcode) {
        this.deviceQrcode = deviceQrcode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }

    public String getProjectOthers() {
        return projectOthers;
    }

    public void setProjectOthers(String projectOthers) {
        this.projectOthers = projectOthers;
    }

    public Date getDebugDate() {
        return debugDate;
    }

    public void setDebugDate(Date debugDate) {
        this.debugDate = debugDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getContractPoint() {
        return contractPoint;
    }

    public void setContractPoint(String contractPoint) {
        this.contractPoint = contractPoint;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSite() {
        return clientSite;
    }

    public void setClientSite(String clientSite) {
        this.clientSite = clientSite;
    }

    public String getClientTel() {
        return clientTel;
    }

    public void setClientTel(String clientTel) {
        this.clientTel = clientTel;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getActivationCode2() {
        return activationCode2;
    }

    public void setActivationCode2(String activationCode2) {
        this.activationCode2 = activationCode2;
    }

    public String getActivationCode3() {
        return activationCode3;
    }

    public void setActivationCode3(String activationCode3) {
        this.activationCode3 = activationCode3;
    }

    public String getActivationCode4() {
        return activationCode4;
    }

    public void setActivationCode4(String activationCode4) {
        this.activationCode4 = activationCode4;
    }

    public String getWlan() {
        return wlan;
    }

    public void setWlan(String wlan) {
        this.wlan = wlan;
    }

    public String getSimPhone() {
        return simPhone;
    }

    public void setSimPhone(String simPhone) {
        this.simPhone = simPhone;
    }

    public String getSimFee() {
        return simFee;
    }

    public void setSimFee(String simFee) {
        this.simFee = simFee;
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak;
    }

    public List<DeviceService> getServices() {
        return services;
    }

    public void setServices(List<DeviceService> services) {
        this.services = services;
    }
}
