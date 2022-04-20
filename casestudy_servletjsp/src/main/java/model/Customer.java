package model;

import java.util.Date;

public class Customer{
    private Integer id;
    private Integer customerTypeId;
    private String name;
    private String dateOfBirth;
    private Integer gender;
    private String idCard;
    private String phone;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(Integer id, Integer customerTypeId, String name, String dateOfBirth, Integer gender, String phone,String email, String address, String id_card) {
        this.id = id;
        this.customerTypeId = customerTypeId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.idCard = id_card;
    }

//    public Customer(Integer customerTypeId, String name, String dateOfBirth, Integer gender, String phone, String email, String address ,String idCard) {
//        this.customerTypeId = customerTypeId;
//        this.name = name;
//        this.dateOfBirth = dateOfBirth;
//        this.gender = gender;
//        this.idCard = idCard;
//        this.phone = phone;
//        this.email = email;
//        this.address = address;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

