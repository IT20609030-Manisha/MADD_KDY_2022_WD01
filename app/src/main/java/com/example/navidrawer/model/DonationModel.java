package com.example.navidrawer.model;

public class DonationModel {

    String DonorName;
    String DonorLocation;
    String FoodTitle;
    String Quantity;
    String ExpDate;
    String SpecialNote;
    String Status;
    String image;
    String Category;

    public DonationModel() {
    }

    public DonationModel(String donorName, String donorLocation, String foodTitle, String quantity, String expDate, String specialNote, String status, String image, String category) {
        DonorName = donorName;
        DonorLocation = donorLocation;
        FoodTitle = foodTitle;
        Quantity = quantity;
        ExpDate = expDate;
        SpecialNote = specialNote;
        Status = status;
        this.image = image;
        Category = category;
    }

    public String getDonorName() {
        return DonorName;
    }

    public void setDonorName(String donorName) {
        DonorName = donorName;
    }

    public String getDonorLocation() {
        return DonorLocation;
    }

    public void setDonorLocation(String donorLocation) {
        DonorLocation = donorLocation;
    }

    public String getFoodTitle() {
        return FoodTitle;
    }

    public void setFoodTitle(String foodTitle) {
        FoodTitle = foodTitle;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getExpDate() {
        return ExpDate;
    }

    public void setExpDate(String expDate) {
        ExpDate = expDate;
    }

    public String getSpecialNote() {
        return SpecialNote;
    }

    public void setSpecialNote(String specialNote) {
        SpecialNote = specialNote;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
