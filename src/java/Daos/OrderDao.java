/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import databaseConnection.DataBaseManager;
import DTOS.Order;
import DTOS.User;
import dao_interfaces.OrderInterface;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3alilio
 */
public class OrderDao implements OrderInterface{
    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet results;
    private DataBaseManager dbm = new DataBaseManager();
    private Connection con;

  //==========================================
    @Override
    public Order selectLastUncheckedOrder(Order order) {
        dbm = new DataBaseManager();
        Order ord =null;
        con=dbm.getCon();
         try { 
            PreparedStatement pst = 
            con.prepareStatement("select id,userid,orderDate,checkedout from eCommerce.order where checkedout=0 and userid=?");
            pst.setInt(1, order.getUserId());
            results=pst.executeQuery();
            if(results.isBeforeFirst()==true)
            {
                 ord = new Order();
                 results.next();
                 ord.setCheckSubmitted(results.getInt(4));
                 ord.setOrderDate(new Date((results.getTimestamp(3)).getTime()));
                 ord.setId(results.getInt(1));
                 ord.setUserId(results.getInt(2));
            }
            dbm.closeCon(con);
            return ord;
            
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return null;   
         }       
    }

    @Override
    public ArrayList<Order> selectAllUserOrders(Order order) {
        dbm = new DataBaseManager();
        ArrayList<Order> list = new ArrayList<>();
        con=dbm.getCon();
         try { 
            PreparedStatement pst = 
            con.prepareStatement("select id,userid,orderDate,checkedout from eCommerce.order where userid=?");
            pst.setInt(1, order.getUserId());
            results=pst.executeQuery();
            while(results.next())
            {
                Order ord = new Order();
                ord.setCheckSubmitted(results.getInt(4));
                ord.setOrderDate(new Date((results.getTimestamp(3)).getTime()));
                ord.setId(results.getInt(1));
                ord.setUserId(results.getInt(2));
                list.add(ord);
            }
            
            dbm.closeCon(con);
            return list;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return null;   
         }  
    }

    @Override
    public Order selectRecentCreatedOrder(Order ord) {
   
        dbm = new DataBaseManager();
        con=dbm.getCon();
        Order order=null;
         try {
             
            PreparedStatement pst = 
            con.prepareStatement("select id,userId,orderDate,checkedOut from eCommerce.order where  id=(select max(id)from eCommerce.order where userId=?)");
            pst.setInt(1, ord.getUserId());
            results=pst.executeQuery();
            if(results.isBeforeFirst()==true)
            {
                order=new Order();
                results.next();
                order.setCheckSubmitted(results.getInt(4));
                order.setOrderDate(new Date((results.getTimestamp(3)).getTime()));
                order.setId(results.getInt(1));
                order.setUserId(results.getInt(2));
            }
            dbm.closeCon(con);
            return order;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return null;   
         } 
    
    }

    @Override
    public boolean insert(Order t) {
        dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
            PreparedStatement pst = 
            con.prepareStatement("insert into eCommerce.order(userid,orderDate,checkedout,orderAddress) values (?,?,?,?)");
            pst.setInt(1, t.getUserId());
            pst.setTimestamp(2, new Timestamp(t.getOrderDate().getTime()));
            pst.setInt(3, t.getCheckSubmitted());
             pst.setString(4, t.getOrderAddress());
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
    public boolean update(Order t) {
 dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
            PreparedStatement pst = 
            con.prepareStatement("update eCommerce.order set userid=?,orderDate=?,checkedout=? where id=?");
            pst.setInt(1, t.getUserId());
            pst.setTimestamp(2, new Timestamp(t.getOrderDate().getTime()));
            pst.setInt(3, t.getCheckSubmitted());
            pst.setInt(4, t.getId());
            pst.execute();
            dbm.closeCon(con);
            return true;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return false;   
         }     }

    @Override
    public boolean delete(Order t) {
        dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
            PreparedStatement pst = 
            con.prepareStatement("delete from eCommerce.order where id=?");
            pst.setInt(1, t.getId());
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
    public Order select(Order t) {
 dbm = new DataBaseManager();
 Order order = new Order();
        con=dbm.getCon();
         try {
             
            PreparedStatement pst = 
            con.prepareStatement("select id,userid,orderDate,checkedout from eCommerce.order where id=? ");
            pst.setInt(1, t.getId());
            results=pst.executeQuery();
            results.next();
            order.setCheckSubmitted(results.getInt(4));
            order.setOrderDate(new Date((results.getTimestamp(3)).getTime()));
            order.setId(results.getInt(1));
            order.setUserId(results.getInt(2));
            dbm.closeCon(con);
            return order;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return null;   
         }         }

    @Override
    public ArrayList<Order> selectAll() {
         dbm = new DataBaseManager();
        ArrayList<Order> list = new ArrayList<>();
        con=dbm.getCon();
         try { 
            PreparedStatement pst = 
            con.prepareStatement("select id,userid,orderDate,checkedout from eCommerce.order");
            results=pst.executeQuery();
            while(results.next())
            {
                Order ord = new Order();
                ord.setCheckSubmitted(results.getInt(4));
                ord.setOrderDate(new Date((results.getTimestamp(3)).getTime()));
                ord.setId(results.getInt(1));
                ord.setUserId(results.getInt(2));
                list.add(ord);
            }
            
            dbm.closeCon(con);
            return list;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return null;   
         }  
    }

    @Override
    public ArrayList<Order> selectAllUserSubmittedOrders(User user) {

     dbm = new DataBaseManager();
        ArrayList<Order> list = new ArrayList<>();
        con=dbm.getCon();
         try { 
            PreparedStatement pst = 
            con.prepareStatement("select id,userid,orderDate,checkedout from eCommerce.order where userid=? and checkedout=1");
            pst.setInt(1, user.getId());
            results=pst.executeQuery();
            while(results.next())
            {
                Order ord = new Order();
                ord.setCheckSubmitted(results.getInt(4));
                ord.setOrderDate(new Date((results.getTimestamp(3)).getTime()));
                ord.setId(results.getInt(1));
                ord.setUserId(results.getInt(2));
                list.add(ord);
            }
            dbm.closeCon(con);
            return list;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return null;   
         }  
    }
    
    
    
    
}
