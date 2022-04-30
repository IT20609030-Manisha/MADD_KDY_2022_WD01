package com.example.navidrawer.model;

public class Needer {

    private String RegistrationNumber;
    private String OrganizationName;
    private String Email;
    private Integer ContactNumber;
    private String Address;
    private String Name;
    private String Designation;
    private Integer EmergencyContactNumber;
    private String Password;

    public Needer() {
    }

    public Needer(String registrationNumber, String organizationName, String email, Integer contactNumber, String address, String name, String designation, Integer emergencyContactNumber, String password) {
        RegistrationNumber = registrationNumber;
        OrganizationName = organizationName;
        Email = email;
        ContactNumber = contactNumber;
        Address = address;
        Name = name;
        Designation = designation;
        EmergencyContactNumber = emergencyContactNumber;
        Password = password;
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

    public Integer getEmergencyContactNumber() {
        return EmergencyContactNumber;
    }

    public void setEmergencyContactNumber(Integer emergencyContactNumber) {
        EmergencyContactNumber = emergencyContactNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
