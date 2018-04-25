/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

import java.sql.Date;


/**
 *
 * @author 3alilio
 */
public class User {
    private String fullName;
    private String password;
    private int noOfUsedCards;
    private double credit;
    private String address;
    private String phone;
    private String email;
    private String job;
    private int id;
    private Date birthDate; 
    private String country;
    private int isAdmin;

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
    public User() {
    }

    public User(String fullName, String password, double credit, String address, String phone, String email) {
        this.fullName = fullName;
        this.password = password;
        this.credit = credit;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNoOfUsedCards() {
        return noOfUsedCards;
    }

    public void setNoOfUsedCards(int noOfUsedCards) {
        this.noOfUsedCards = noOfUsedCards;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
}
