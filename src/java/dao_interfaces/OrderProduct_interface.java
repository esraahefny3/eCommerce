/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_interfaces;

import DTOS.Order;
import DTOS.OrderElemet;
import DTOS.Product;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author esraa
 */
public interface OrderProduct_interface {
    
    public boolean insertOrderProduct(Product product,int noOfItems,Order order);
    public boolean updateOrderProduct(Product product,int noOfItems,Order order);
    public HashMap<Integer,Product> selectAllOrderProducts(Order order);
    public boolean deleteOrderProduct(Product product,Order order);
     public ArrayList<OrderElemet> selectHistoryAllOrderProducts(Order order);
}
