package com.bridgelabz.addressbook;
public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String Address;
    private String city;
    private int zip;
    private String state;

    public Person(String firstName, String lastName, String phoneNumber, String address, String city, int zip, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        Address = address;
        this.city = city;
        this.zip = zip;
        this.state = state;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAddress() { return Address; }

    public void setAddress(String address) { Address = address; }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Address='" + Address + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                ", state='" + state + '\'' +
                '}';
    }
}
