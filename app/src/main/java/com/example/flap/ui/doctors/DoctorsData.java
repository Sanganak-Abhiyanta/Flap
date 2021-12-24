package com.example.flap.ui.doctors;

public class DoctorsData {

    private String doctorName, doctorExperience, doctorAddress, doctorTiming, doctorRating, doctorImage, key, doctorConsultationFee;

    public DoctorsData() {
    }

    public DoctorsData(String doctorName, String doctorExperience,
                       String doctorAddress, String doctorTiming, String doctorRating, String doctorImage, String key, String doctorConsultationFee) {
        this.doctorName = doctorName;
        this.doctorExperience = doctorExperience;
        this.doctorAddress = doctorAddress;
        this.doctorTiming = doctorTiming;
        this.doctorRating = doctorRating;
        this.doctorImage = doctorImage;
        this.key = key;
        this.doctorConsultationFee = doctorConsultationFee;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorExperience() {
        return doctorExperience;
    }

    public void setDoctorExperience(String doctorExperience) {
        this.doctorExperience = doctorExperience;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public String getDoctorTiming() {
        return doctorTiming;
    }

    public void setDoctorTiming(String doctorTiming) {
        this.doctorTiming = doctorTiming;
    }

    public String getDoctorRating() {
        return doctorRating;
    }

    public void setDoctorRating(String doctorRating) {
        this.doctorRating = doctorRating;
    }

    public String getDoctorImage() {
        return doctorImage;
    }

    public void setDoctorImage(String doctorImage) {
        this.doctorImage = doctorImage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDoctorConsultationFee() {
        return doctorConsultationFee;
    }

    public void setDoctorConsultationFee(String doctorConsultationFee) {
        this.doctorConsultationFee = doctorConsultationFee;
    }
}
