package com.example.navidrawer.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Driver{

    private String NIC;
    private String Firstname;
    private String Lastname;
    private String Email;
    private String ContactNumber;
    private String Address;
    private String VahicleRegNo;
    private String VehicleColour;
    private String VehicleType;


    public Driver(String NIC, String firstname, String lastname, String email, String contactNumber, String address, String vahicleRegNo, String vehicleColour, String vehicleType) {
        this.NIC = NIC;
        Firstname = firstname;
        Lastname = lastname;
        Email = email;
        ContactNumber = contactNumber;
        Address = address;
        VahicleRegNo = vahicleRegNo;
        VehicleColour = vehicleColour;
        VehicleType = vehicleType;

    }

    public Driver() {
    }


    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
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

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
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

}
