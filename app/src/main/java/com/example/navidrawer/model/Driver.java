package com.example.navidrawer.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Driver implements Parcelable {

    private String NIC;
    private String Firstname;
    private String Lastname;
    private String Email;
    private String ContactNumber;
    private String Address;
    private String VahicleRegNo;
    private String VehicleColour;
    private String VehicleType;
    private String Password;
    private String DriverID;

    public Driver(String NIC, String firstname, String lastname, String email, String contactNumber, String address, String vahicleRegNo, String vehicleColour, String vehicleType, String password, String driverID) {
        this.NIC = NIC;
        Firstname = firstname;
        Lastname = lastname;
        Email = email;
        ContactNumber = contactNumber;
        Address = address;
        VahicleRegNo = vahicleRegNo;
        VehicleColour = vehicleColour;
        VehicleType = vehicleType;
        Password = password;
        DriverID = driverID;
    }

    public Driver() {
    }

    protected Driver(Parcel in) {
        NIC = in.readString();
        Firstname = in.readString();
        Lastname = in.readString();
        Email = in.readString();
        ContactNumber = in.readString();
        Address = in.readString();
        VahicleRegNo = in.readString();
        VehicleColour = in.readString();
        VehicleType = in.readString();
        Password = in.readString();
        DriverID = in.readString();
    }

    public static final Creator<Driver> CREATOR = new Creator<Driver>() {
        @Override
        public Driver createFromParcel(Parcel in) {
            return new Driver(in);
        }

        @Override
        public Driver[] newArray(int size) {
            return new Driver[size];
        }
    };

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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDriverID() {
        return DriverID;
    }

    public void setDriverID(String driverID) {
        DriverID = driverID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(NIC);
        parcel.writeString(Firstname);
        parcel.writeString(Lastname);
        parcel.writeString(Email);
        parcel.writeString(ContactNumber);
        parcel.writeString(Address);
        parcel.writeString(VahicleRegNo);
        parcel.writeString(VehicleColour);
        parcel.writeString(VehicleType);
        parcel.writeString(Password);
        parcel.writeString(DriverID);
    }
}
