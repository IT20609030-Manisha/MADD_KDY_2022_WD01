package com.example.navidrawer.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Needer {

    private String RegistrationNumber;
    private String OrganizationName;
    private String Email;
    private String ContactNumber;
    private String Address;
    private String Name;
    private String Designation;
    private String EmergencyContactNumber;

    public Needer() {
    }

    public Needer(String registrationNumber, String organizationName, String email, String contactNumber, String address, String name, String designation, String emergencyContactNumber) {
        RegistrationNumber = registrationNumber;
        OrganizationName = organizationName;
        Email = email;
        ContactNumber = contactNumber;
        Address = address;
        Name = name;
        Designation = designation;
        EmergencyContactNumber = emergencyContactNumber;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        RegistrationNumber = registrationNumber;
    }

    public String getOrganizationName() {
        return OrganizationName;
    }

    public void setOrganizationName(String organizationName) {
        OrganizationName = organizationName;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getEmergencyContactNumber() {
        return EmergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        EmergencyContactNumber = emergencyContactNumber;
    }

}
