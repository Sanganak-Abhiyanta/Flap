package com.example.flap.ui.DrawerSection.merchants.authentic;

public class Users {

    String userName, mail, password, phoneNumber, confirmPassword, userId, doctorClinicName, experience, consultationFee, areaPin,
            addressLine1, addressLine2, city, state, timing, dailyAvailableSeats, serviceType, firmName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDoctorClinicName() {
        return doctorClinicName;
    }

    public void setDoctorClinicName(String doctorClinicName) {
        this.doctorClinicName = doctorClinicName;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(String consultationFee) {
        this.consultationFee = consultationFee;
    }

    public String getAreaPin() {
        return areaPin;
    }

    public void setAreaPin(String areaPin) {
        this.areaPin = areaPin;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getDailyAvailableSeats() {
        return dailyAvailableSeats;
    }

    public void setDailyAvailableSeats(String dailyAvailableSeats) {
        this.dailyAvailableSeats = dailyAvailableSeats;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public Users(String userName, String mail, String password, String phoneNumber, String confirmPassword, String userId) {
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.confirmPassword = confirmPassword;
        this.userId = userId;
    }

    public Users() {
    }

    public Users(String userName, String mail, String password, String phoneNumber, String confirmPassword) {
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.confirmPassword = confirmPassword;
    }

    public Users(String mail, String password, String userId) {
        this.mail = mail;
        this.password = password;
        this.userId = userId;
    }

    public Users(String doctorClinicName, String experience, String consultationFee, String areaPin, String addressLine1, String addressLine2, String city, String state, String timing, String dailyAvailableSeats, String serviceType, String userId) {
        this.doctorClinicName = doctorClinicName;
        this.experience = experience;
        this.consultationFee = consultationFee;
        this.areaPin = areaPin;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.timing = timing;
        this.dailyAvailableSeats = dailyAvailableSeats;
        this.serviceType = serviceType;
        this.userId = userId;
    }

    public Users(String firmName, String areaPin, String addressLine1, String addressLine2, String city, String state, String serviceType, String userId) {
        this.firmName = firmName;
        this.areaPin = areaPin;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.serviceType = serviceType;
        this.userId = userId;
    }


}
