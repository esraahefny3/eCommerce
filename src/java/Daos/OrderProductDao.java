/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DTOS.Order;
import DTOS.OrderElemet;
import DTOS.Product;
import dao_interfaces.OrderProduct_interface;
import databaseConnection.DataBaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3alilio
 */
public class OrderProductDao implements OrderProduct_interface{
    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet results;
    private DataBaseManager dbm = new DataBaseManager();
    private Connection con;
    
    @Override
    public boolean insertOrderProduct(Product product, int noOfItems, Order order) {
         dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
PreparedStatement pst =con.prepareStatement("insert into eCommerce.order_product(productid,orderid,noOfItems,purc_price) values (?,?,?,?)");
            pst.setInt(1, product.getId());
            pst.setInt(2, order.getId());
            pst.setInt(3, noOfItems); 
            pst.setDouble(4, product.getPrice()); 
            pst.execute();
            dbm.closeCon(con);
            return true;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return false;   
         } 
    
    }

    @Override
    public boolean updateOrderProduct(Product product, int noOfItems, Order order) {
 dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             PreparedStatement pst = 
    con.prepareStatement("update eCommerce.order_product set productid=?,orderid=?,noOfItems=? where orderid=? and productid=?");
            pst.setInt(1, product.getId());
            pst.setInt(2, order.getId());
            pst.setInt(3, noOfItems); 
            pst.setInt(4, order.getId()); 
            pst.setInt(5, product.getId());
            pst.execute();
            dbm.closeCon(con);
            return true;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return false;   
         }     }

    @Override
    public HashMap<Integer, Product> selectAllOrderProducts(Order order) {
       dbm = new DataBaseManager();
       ProductDao prodao = new ProductDao();
       con=dbm.getCon();
       HashMap<Integer,Product> temp = new HashMap<>();
       try {
            PreparedStatement pst = 
            con.prepareStatement("select productid,noofitems from eCommerce.order_product where orderid=?");
            pst.setInt(1, order.getId());
            results=pst.executeQuery();
            while(results.next())
            {   Product prouctTemp = new Product();
                prouctTemp.setId(results.getInt(1));
                prouctTemp = prodao.select(prouctTemp);
                temp.put(prouctTemp.getId(), prouctTemp);
            }
            dbm.closeCon(con);
            return temp;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return null;   
         }  
    }

    @Override
    public boolean deleteOrderProduct(Product product, Order order) {
        dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
             PreparedStatement pst = 
    con.prepareStatement("delete from eCommerce.order_product where productid=? and orderid=?");
            pst.setInt(1, product.getId());
            pst.setInt(2, order.getId());
            pst.execute();
            dbm.closeCon(con);
            return true;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return false;   
         } 
    
    }
    
    
     @Override
    public ArrayList<OrderElemet> selectHistoryAllOrderProducts(Order order) {
        
       dbm = new DataBaseManager();
       ProductDao prodao = new ProductDao();
       con=dbm.getCon();
       ArrayList<OrderElemet> temp = new ArrayList<>();
       try {
            PreparedStatement pst = 
            con.prepareStatement("select productid,noofitems,purc_price from eCommerce.order_product where orderid=?");
            pst.setInt(1, order.getId());
            results=pst.executeQuery();
            while(results.next())
            {   Product prouctTemp = new Product();
                prouctTemp.setId(results.getInt(1));
                prouctTemp = prodao.select(prouctTemp);
                OrderElemet element = new OrderElemet();
                element.setNo_items(results.getInt(2));
                element.setProduct(prouctTemp);
                element.setPur_price(results.getDouble(3));
                temp.add(element);
            }
            dbm.closeCon(con);
            return temp;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return null;   
         }  
    }
    
}
