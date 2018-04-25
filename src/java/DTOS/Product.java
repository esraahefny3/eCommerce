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
public class Product {
   
    private int id;
    private String companyName;
    private int quantity;
     private int requested_quantity;
    private String description;
    private String name;
    private double price;
    private byte[] image;
    private int categoryId;
    private Date postedDate;
    private int available;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

 
    
    public int getRequested_quantity() {
        return requested_quantity;
    }

    public void setRequested_quantity(int requested_quantity) {
        this.requested_quantity = requested_quantity;
    }

    public Product() {
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Product(String companyName, int quantity, String description, String name, double price, int categoryId, Date postedDate) {
        this.companyName = companyName;
        this.quantity = quantity;
        this.description = description;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.postedDate = postedDate;
    }

    public Product(String companyName, int quantity, String description, String name, double price, byte[] image, int categoryId, Date postedDate) {
        this.companyName = companyName;
        this.quantity = quantity;
        this.description = description;
        this.name = name;
        this.price = price;
        this.image = image;
        this.categoryId = categoryId;
        this.postedDate = postedDate;
    }

    
    
    
    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }
    
   
}
