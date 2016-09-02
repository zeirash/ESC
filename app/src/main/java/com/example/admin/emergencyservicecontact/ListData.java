package com.example.admin.emergencyservicecontact;

public class ListData {

    private String serviceType;
    private String phoneNumber;

    public ListData(String serviceType, String phoneNumber) {
        setServiceType(serviceType);
        setPhoneNumber(phoneNumber);
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
