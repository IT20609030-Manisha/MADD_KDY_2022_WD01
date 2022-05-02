package com.example.navidrawer.model;

public class Vacancy {

    private String VacancyType;
    private String Location;
    private String VehicleType;
    private String Availability;

    public Vacancy() {
    }

    public Vacancy(String vacancyType, String location, String vehicleType, String availability) {
        VacancyType = vacancyType;
        Location = location;
        VehicleType = vehicleType;
        Availability = availability;
    }

    public String getVacancyType() {
        return VacancyType;
    }

    public void setVacancyType(String vacancyType) {
        VacancyType = vacancyType;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }
}
