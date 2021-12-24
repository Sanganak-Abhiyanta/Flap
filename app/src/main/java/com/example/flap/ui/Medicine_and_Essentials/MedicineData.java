package com.example.flap.ui.Medicine_and_Essentials;

public class MedicineData {


    private String medicineName,medicinePrice,medicineDesc,medicineStock,medicineImage,key;

    public MedicineData() {
    }

    public MedicineData(String medicineName, String medicinePrice, String medicineDesc, String medicineStock, String medicineImage, String key) {
        this.medicineName = medicineName;
        this.medicinePrice = medicinePrice;
        this.medicineDesc = medicineDesc;
        this.medicineStock = medicineStock;
        this.medicineImage = medicineImage;
        this.key = key;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(String medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public String getMedicineDesc() {
        return medicineDesc;
    }

    public void setMedicineDesc(String medicineDesc) {
        this.medicineDesc = medicineDesc;
    }

    public String getMedicineStock() {
        return medicineStock;
    }

    public void setMedicineStock(String medicineStock) {
        this.medicineStock = medicineStock;
    }

    public String getMedicineImage() {
        return medicineImage;
    }

    public void setMedicineImage(String medicineImage) {
        this.medicineImage = medicineImage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
