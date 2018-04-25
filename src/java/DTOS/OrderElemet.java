/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

/**
 *
 * @author 3alilio
 */
public class OrderElemet {
    
    Product product;
    int no_items;
    double pur_price;

    public OrderElemet(Product product, int no_items, double pur_price) {
        this.product = product;
        this.no_items = no_items;
        this.pur_price = pur_price;
    }

    public OrderElemet() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNo_items() {
        return no_items;
    }

    public void setNo_items(int no_items) {
        this.no_items = no_items;
    }

    public double getPur_price() {
        return pur_price;
    }

    public void setPur_price(double pur_price) {
        this.pur_price = pur_price;
    }
    
    
}
