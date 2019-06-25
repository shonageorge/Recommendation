package com.stackroute.recommendation.domain;

public class Address {

   private String buildingNumber;
   private String area;
   private String city;
   private String state;
   private String country;
   private int pincode;

    public Address() {
    }

    public Address(String buildingNumber, String area, String city, String state, String country, int pincode) {
        this.buildingNumber = buildingNumber;
        this.area = area;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public int getPincode() {
        return pincode;
    }
}
