/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DTOS.Category;
import DTOS.User;
import dao_interfaces.UserInterests_interface;
import databaseConnection.DataBaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3alilio
 */
public class UserInterestDao implements UserInterests_interface{
    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet results;
    private DataBaseManager dbm;
    private Connection con;
    CategoryDao categoryDao = new CategoryDao();

    
    @Override
    public boolean insertUserInterests(User user, ArrayList<Category> categoryList) {
        dbm = new DataBaseManager();
        con = dbm.getCon();
        Category c = new Category();
        try {
            Iterator it = categoryList.iterator();
            while (it.hasNext()) {
                c = (Category) it.next();
                PreparedStatement pst = con.prepareStatement("insert into eCommerce.customer_interests (userId,categoryId) values(?,?)");
                pst.setInt(1, user.getId());
                pst.setInt(2, c.getId());
                pst.executeUpdate();
            }
            dbm.closeCon(con);
            return true;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            System.out.println("cannot insert this interests");
            ex.printStackTrace();
        }
        return false;

    }
@Override
    public boolean deleteAllUserInterests(User user) {
        dbm = new DataBaseManager();
        con = dbm.getCon();
        try {
            PreparedStatement pst = con.prepareStatement("delete from eCommerce.customer_interests where userId = ?");
            pst.setInt(1, user.getId());
            pst.executeUpdate();
            dbm.closeCon(con);
            return true;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            System.out.println("cannot delete this card");
            ex.printStackTrace();
        }
        return false;

    }

  @Override
    public ArrayList<Category> selectAllUserInterests(User user) {
        dbm = new DataBaseManager();
        con = dbm.getCon();
        ArrayList<Category> List = new ArrayList<Category>();
        ArrayList<Integer> mygroupsId = new ArrayList<Integer>();

        try {
            pst = con.prepareStatement("Select * from eCommerce.customer_interests where userId = ?   ");
            pst.setInt(1, user.getId());
            results = pst.executeQuery();
            while (results.next()) {
                mygroupsId.add(results.getInt(2));
            }
            for (int i = 0; i < mygroupsId.size(); i++) {
                pst = con.prepareStatement("Select name,description,id from eCommerce.category where id=?");

                pst.setInt(1, mygroupsId.get(i));
                results = pst.executeQuery();
                while (results.next()) {
                    Category c = new Category();
                    c.setName(results.getString(1));
                    c.setDescription(results.getString(2));
                    c.setId(results.getInt(3));
                    List.add(c);
                }
            }

            dbm.closeCon(con);
            return List;

        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    } 
     
}
