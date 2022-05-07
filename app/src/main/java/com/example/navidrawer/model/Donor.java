package com.example.navidrawer.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Donor{

    private String NIC;
    private String FirstName;
    private String LastName;
    private String Email;
    private String ContactNumber;
    private String Address;
    private String Password;

    public Donor() {
    }

    public Donor(String NIC, String firstName, String lastName, String email, String contactNumber, String address, String password) {
        this.NIC = NIC;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        ContactNumber = contactNumber;
        Address = address;
        Password = password;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

}
