/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_interfaces;

import DTOS.Order;
import DTOS.User;
import java.util.ArrayList;


/**
 *
 * @author esraa
 */
public interface OrderInterface extends GeneralInterface <Order> {
    
    public Order selectLastUncheckedOrder(Order order);
    public ArrayList<Order> selectAllUserOrders(Order order);//feha userId
    public Order selectRecentCreatedOrder(Order order);
    public ArrayList<Order> selectAllUserSubmittedOrders(User user);
}
