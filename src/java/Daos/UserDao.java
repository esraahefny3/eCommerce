 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import databaseConnection.DataBaseManager;
import DTOS.Card;
import DTOS.User;
import dao_interfaces.UserInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3alilio
 */
public class UserDao implements UserInterface{
    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet results;
    private DataBaseManager dbm;
    private Connection con;

    @Override
    public boolean insert(User user) {
         dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
             PreparedStatement pst = 
    con.prepareStatement("insert into eCommerce.user(fullName,password,email,phone,country,credit,job,noOfUsedCards,birthDate,address,isAdmin) values (?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, user.getFullName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPhone());
            pst.setString(5, user.getCountry());
            pst.setDouble(6, user.getCredit());
            pst.setString(7, user.getJob());
            pst.setInt(8, user.getNoOfUsedCards());
            pst.setDate(9, user.getBirthDate());
            pst.setString(10, user.getAddress());
            pst.setInt(11, user.getIsAdmin());
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
    public boolean update(User user) {
        dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
             PreparedStatement pst = 
   con.prepareStatement("Update eCommerce.user set fullName=?,password=?,email=?,phone=?,country=?,credit=?,job=?,noOfUsedCards=?,birthDate=?,address=?, isadmin=? where id = ?");
            pst.setString(1, user.getFullName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPhone());
            pst.setString(5, user.getCountry());
            pst.setDouble(6, user.getCredit());
            pst.setString(7, user.getJob());
            pst.setInt(8, user.getNoOfUsedCards());
            pst.setDate(9, user.getBirthDate());
            pst.setString(10, user.getAddress());
            pst.setInt(11, user.getIsAdmin());
            pst.setInt(12, user.getId());
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
    public boolean delete(User t) {
         dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             PreparedStatement pst = 
   con.prepareStatement("delete from  eCommerce.user where email=?");
            User temp =new User();
            pst.setString(1, t.getEmail());
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
    public User select(User t) {
        dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
             PreparedStatement pst = 
   con.prepareStatement("select id,fullname,password,phone,address,country,credit,job,noofusedcards,birthdate,email,isAdmin from  eCommerce.user where email=? and password=?");
            User temp =null;
            pst.setString(1, t.getEmail());
            pst.setString(2, t.getPassword());
            results =pst.executeQuery();
            if(results.isBeforeFirst())
            {
                temp=new User();
                while (results.next()) {
                temp.setId((results.getInt(1)));
                temp.setFullName(results.getString(2));
                temp.setPassword(results.getString(3));
                temp.setPhone(results.getString(4));
                temp.setAddress(results.getString(5));
                temp.setCountry(results.getString(6));
                temp.setCredit(results.getDouble(7));
                temp.setJob(results.getString(8));
                temp.setNoOfUsedCards(results.getInt(9));
                temp.setBirthDate(results.getDate(10));
                temp.setEmail(results.getString(11));
                temp.setIsAdmin(results.getInt(12));     
             }
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
    public ArrayList<User> selectAll() 
    {
            dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
             PreparedStatement pst = 
   con.prepareStatement("select id,fullname,password,phone,address,country,credit,job,noofusedcards,birthdate,email,isadmin from  eCommerce.user");
            ArrayList<User> userlist = new ArrayList<>();
            results =pst.executeQuery();
             while (results.next()) {
                User temp =new User();
                temp.setFullName(results.getString(2));
                temp.setPassword(results.getString(3));
                temp.setPhone(results.getString(4));
                temp.setAddress(results.getString(5));
                temp.setCountry(results.getString(6));
                temp.setCredit(results.getDouble(7));
                temp.setJob(results.getString(8));
                temp.setBirthDate(results.getDate(10));
                temp.setNoOfUsedCards(results.getInt(9));
                temp.setId((results.getInt(1)));
                temp.setEmail(results.getString(11));
                temp.setIsAdmin((results.getInt(12)));
                userlist.add(temp);
             }
            dbm.closeCon(con);
            return userlist;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return null;   
         } 
    }

    @Override
    public User selectUserbyid(User user) {
        dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
             PreparedStatement pst = 
   con.prepareStatement("select id,fullname,password,phone,address,country,credit,job,noofusedcards,birthdate,isadmin from  eCommerce.user where id=? ");
            User temp =new User();
            pst.setInt(1, user.getId());
            results =pst.executeQuery();
             while (results.next()) {
                temp.setId((results.getInt(1)));
                temp.setFullName(results.getString(2));
                temp.setPassword(results.getString(3));
                temp.setPhone(results.getString(4));
                temp.setAddress(results.getString(5));
                temp.setCountry(results.getString(6));
                temp.setCredit(results.getDouble(7));
                temp.setJob(results.getString(8));
                temp.setBirthDate(results.getDate(10));
                temp.setNoOfUsedCards(results.getInt(9));
                temp.setIsAdmin(results.getInt(11));
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
     public User selectUserbyEmail(User user) {
        dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
             PreparedStatement pst = 
   con.prepareStatement("select id,fullname,password,phone,address,country,credit,job,noofusedcards,birthdate,email,isAdmin from  eCommerce.user where email=? ");
            
            pst.setString(1, user.getEmail());
             User temp=null;
            results =pst.executeQuery();
           if(results.isBeforeFirst())
            {
                temp=new User();
                while (results.next()) {

                    temp.setId((results.getInt(1)));
                    temp.setFullName(results.getString(2));
                    temp.setPassword(results.getString(3));
                    temp.setPhone(results.getString(4));
                    temp.setAddress(results.getString(5));
                    temp.setCountry(results.getString(6));
                    temp.setCredit(results.getDouble(7));
                    temp.setJob(results.getString(8));
                    temp.setBirthDate(results.getDate(10));
                    temp.setNoOfUsedCards(results.getInt(9));
                    temp.setEmail(results.getString(11));
                    temp.setIsAdmin(results.getInt(12));
                 }
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
