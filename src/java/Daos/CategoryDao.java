/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DTOS.Category;
import dao_interfaces.CategoryInterface;
import databaseConnection.DataBaseManager;
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
public class CategoryDao implements CategoryInterface {
    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet results;
    private DataBaseManager dbm;
    private Connection con;
    
    @Override
    public boolean insert(Category t) {
        dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
             PreparedStatement pst = 
    con.prepareStatement("insert into eCommerce.category(name,description) values (?,?)");
            pst.setString(1, t.getName());
            pst.setString(2, t.getDescription());
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
    public boolean update(Category t) {
dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
             PreparedStatement pst = 
    con.prepareStatement("update eCommerce.category set name=?,description=? where id=?");
            pst.setString(1, t.getName());
            pst.setString(2, t.getDescription());
            pst.setInt(3, t.getId());
            pst.execute();
            dbm.closeCon(con);
            return true;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return false;   
         }     }
    
    @Override
    public boolean delete(Category t) {
        dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
             PreparedStatement pst = 
    con.prepareStatement("delete from eCommerce.category where id=?");
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
    public Category select(Category t) {
dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             
             PreparedStatement pst = 
    con.prepareStatement("Select name,description,id from eCommerce.category where id=?");
            Category categoryTemp = new Category();
            pst.setInt(1, t.getId());
            results = pst.executeQuery();
            results.next();
            categoryTemp.setName(results.getString(1).trim());
            categoryTemp.setDescription(results.getString(2).trim());
            categoryTemp.setId(results.getInt(3));
            dbm.closeCon(con);
            return categoryTemp;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return null;   
         }     }

    @Override
    public ArrayList<Category> selectAll() {
       
        ArrayList<Category> categoryList= null;
        dbm = new DataBaseManager();
        con=dbm.getCon();
         try {
             String query = "Select name,description,id from eCommerce.category";
             stmt = con.createStatement();
             results = stmt.executeQuery(query);
           if(results.isBeforeFirst())
            {
              categoryList=new ArrayList<>();
             while(results.next())
             {  
                  Category  categoryTemp = new Category();
                  categoryTemp.setName(results.getString(1));
                   categoryTemp.setDescription(results.getString(2));
                  categoryTemp.setId(results.getInt(3));
                  categoryList.add(categoryTemp);
             }
            }
           
            dbm.closeCon(con);
            return categoryList;
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
             return null;   
         }     
    }
    
}
