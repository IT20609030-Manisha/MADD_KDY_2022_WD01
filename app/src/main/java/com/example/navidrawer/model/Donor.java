package com.example.navidrawer.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Donor implements Parcelable {

    private String NIC;
    private String FirstName;
    private String LastName;
    private String Email;
    private String ContactNumber;
    private String Address;
    private String Password;
    private String DonorID;

    public Donor() {
    }

    public Donor(String NIC, String firstName, String lastName, String email, String contactNumber, String address, String password, String donorID) {
        this.NIC = NIC;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        ContactNumber = contactNumber;
        Address = address;
        Password = password;
        DonorID = donorID;
    }

    protected Donor(Parcel in) {
        NIC = in.readString();
        FirstName = in.readString();
        LastName = in.readString();
        Email = in.readString();
        ContactNumber = in.readString();
        Address = in.readString();
        Password = in.readString();
        DonorID = in.readString();
    }

    public static final Creator<Donor> CREATOR = new Creator<Donor>() {
        @Override
        public Donor createFromParcel(Parcel in) {
            return new Donor(in);
        }

        @Override
        public Donor[] newArray(int size) {
            return new Donor[size];
        }
    };

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

    public String getDonorID() {
        return DonorID;
    }

    public void setDonorID(String donorID) {
        DonorID = donorID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(NIC);
        parcel.writeString(FirstName);
        parcel.writeString(LastName);
        parcel.writeString(Email);
        parcel.writeString(ContactNumber);
        parcel.writeString(Address);
        parcel.writeString(Password);
        parcel.writeString(DonorID);
    }
}
