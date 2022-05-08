package com.example.navidrawer.model;

public class Orders {
    String Category;
    String FoodTitle;
    String Portion;
    String NeederName;
    String Address;

    public Orders() {
    }

    public Orders(String category, String foodTitle, String portion, String neederName, String address) {
        Category = category;
        FoodTitle = foodTitle;
        Portion = portion;
        NeederName = neederName;
        Address = address;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getFoodTitle() {
        return FoodTitle;
    }

    public void setFoodTitle(String foodTitle) {
        FoodTitle = foodTitle;
    }

    public String getPortion() {
        return Portion;
    }

    public void setPortion(String portion) {
        Portion = portion;
    }

    public String getNeederName() {
        return NeederName;
    }

    public void setNeederName(String neederName) {
        NeederName = neederName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
