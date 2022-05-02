package com.example.navidrawer.model;

public class Donor {

    private String FirstName;
    private String LastName;
    private String Email;
    private Integer ContactNumber;
    private String Address;
    private String Password;

    public Donor() {
    }

    public Donor(String firstName, String lastName, String email, Integer contactNumber, String address, String password) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        ContactNumber = contactNumber;
        Address = address;
        Password = password;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
