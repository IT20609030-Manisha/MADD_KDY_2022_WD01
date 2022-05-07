package com.example.navidrawer.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Needer implements Parcelable{

    private String RegistrationNumber;
    private String OrganizationName;
    private String Email;
    private String ContactNumber;
    private String Address;
    private String Name;
    private String Designation;
    private String EmergencyContactNumber;
    private String Password;
    private String Accept;
    private String NeederID;

    public Needer() {
    }

    public Needer(String registrationNumber, String organizationName, String email, String contactNumber, String address, String name, String designation, String emergencyContactNumber, String password, String accept, String neederID) {
        RegistrationNumber = registrationNumber;
        OrganizationName = organizationName;
        Email = email;
        ContactNumber = contactNumber;
        Address = address;
        Name = name;
        Designation = designation;
        EmergencyContactNumber = emergencyContactNumber;
        Password = password;
        Accept = accept;
        NeederID = neederID;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAccept() {
        return Accept;
    }

    public void setAccept(String accept) {
        Accept = accept;
    }

    public String getNeederID() {
        return NeederID;
    }

    public void setNeederID(String neederID) {
        NeederID = neederID;
    }

    protected Needer(Parcel in) {
        RegistrationNumber = in.readString();
        OrganizationName = in.readString();
        Email = in.readString();
        ContactNumber = in.readString();
        Address = in.readString();
        Name = in.readString();
        Designation = in.readString();
        EmergencyContactNumber = in.readString();
        Password = in.readString();
        Accept = in.readString();
        NeederID = in.readString();
    }

    public static final Creator<Needer> CREATOR = new Creator<Needer>() {
        @Override
        public Needer createFromParcel(Parcel in) {
            return new Needer(in);
        }

        @Override
        public Needer[] newArray(int size) {
            return new Needer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(RegistrationNumber);
        parcel.writeString(OrganizationName);
        parcel.writeString(Email);
        parcel.writeString(ContactNumber);
        parcel.writeString(Address);
        parcel.writeString(Name);
        parcel.writeString(Designation);
        parcel.writeString(EmergencyContactNumber);
        parcel.writeString(Password);
        parcel.writeString(Accept);
        parcel.writeString(NeederID);
    }
}
