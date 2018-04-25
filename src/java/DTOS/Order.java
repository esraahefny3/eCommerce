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
public class Order {
    
    private int id;
    private int checkSubmitted;
    private Date orderDate;
    private int userId;
    private String orderAddress;

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public Order() {
    }

    public Order(int checkSubmitted,  int userId,Date d,String orderAddress) {
        this.checkSubmitted = checkSubmitted;
        this.userId = userId;
        this.orderDate = d;
        this.orderAddress=orderAddress;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getId() {
        return id;
    }

 

    public int getCheckSubmitted() {
        return checkSubmitted;
    }

    public void setCheckSubmitted(int checkSubmitted) {
        this.checkSubmitted = checkSubmitted;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    

  

  
   
    
    
}
