package com.example.navidrawer.model;

public class Driver {

    private String Firstname;
    private String Lastname;
    private String Email;
    private Integer ContactNumber;
    private String Address;
    private String VahicleRegNo;
    private String VehicleColour;
    private String VehicleType;
    private String Password;

    public Driver() {
    }

    public Driver(String firstname, String lastname, String email, Integer contactNumber, String address, String vahicleRegNo, String vehicleColour, String vehicleType, String password) {
        Firstname = firstname;
        Lastname = lastname;
        Email = email;
        ContactNumber = contactNumber;
        Address = address;
        VahicleRegNo = vahicleRegNo;
        VehicleColour = vehicleColour;
        VehicleType = vehicleType;
        Password = password;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getVahicleRegNo() {
        return VahicleRegNo;
    }

    public void setVahicleRegNo(String vahicleRegNo) {
        VahicleRegNo = vahicleRegNo;
    }

    public String getVehicleColour() {
        return VehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        VehicleColour = vehicleColour;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
