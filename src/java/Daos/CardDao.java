/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import databaseConnection.DataBaseManager;
import DTOS.Card;
import DTOS.User;
import dao_interfaces.CardInterface;
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

   
public class CardDao implements  CardInterface{
    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet results;
    private DataBaseManager dbm = new DataBaseManager();
    private Connection con;

    
    
      @Override
    public ArrayList<Card> selectAllUserCards(User user) {
         dbm = new DataBaseManager();
        con=dbm.getCon();
        int id=user.getId();
        ArrayList<Card> cardList = new ArrayList<Card>();
        try {
             
             PreparedStatement pst = con.prepareStatement("Select * from eCommerce.creditcard where userId = ? ");
              pst.setInt(1, id);
              results = pst.executeQuery();
             while(results.next()){
                    Card card = new Card();
                    card.setCode(results.getString(1));
                    card.setValue(results.getInt(2));
                    card.setCharged(results.getInt(3));
                    cardList.add(card);
                }
             dbm.closeCon(con);
             return cardList;
             
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
         }
        return null;
    }

    @Override
    public boolean insert(Card t) {
        dbm = new DataBaseManager();
        con=dbm.getCon();
        try {
            PreparedStatement pst = con.prepareStatement("insert into eCommerce.creditcard(code,value,charged) values(?,?,?)");
            pst.setString(1, t.getCode());
            pst.setInt(2, t.getValue());
             pst.setInt(3, t.getCharged());
              
            pst.executeUpdate(); 
            dbm.closeCon(con);
            return true;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            System.out.println("cannot insert this card");
            ex.printStackTrace();
        }
        return false;
    }
 @Override
    public boolean update(Card t) {
       dbm = new DataBaseManager();
        con=dbm.getCon();
        try {
            PreparedStatement pst = con.prepareStatement("update eCommerce.creditcard set value= ?,Charged=?,userId=?  where code=?");
            pst.setInt(1, t.getValue());
            pst.setInt(2, t.getCharged());
            pst.setInt(3, t.getUser_id());
            pst.setString(4, t.getCode());
            pst.executeUpdate(); 
            dbm.closeCon(con);
            return true;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            System.out.println("cannot insert this card");
            ex.printStackTrace();
        }
        return false;  
    }
@Override
    public boolean delete(Card t) {
       dbm = new DataBaseManager();
        con=dbm.getCon();
        try {
            PreparedStatement pst = con.prepareStatement("delete from eCommerce.creditcard where code = ?");
            pst.setString(1, t.getCode());
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
    public Card select(Card t) {
           dbm = new DataBaseManager();
        con=dbm.getCon();
        Card card = new Card();
        try {
             
             PreparedStatement pst = con.prepareStatement("Select * from eCommerce.creditcard where code = ? ");
              pst.setString(1, t.getCode());
              results = pst.executeQuery();
             while(results.next()){
                    
                    card.setCode(results.getString(1));
                    card.setValue(results.getInt(2));
                    card.setCharged(results.getInt(3));
                    card.setUser_id(results.getInt(4));
                }
             dbm.closeCon(con);
             return card;
             
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
         }
        return null;
    }


    
    @Override
    public ArrayList<Card> selectAll() {
        dbm = new DataBaseManager();
        con=dbm.getCon();
        ArrayList<Card> cardList = new ArrayList<Card>();
        try {
             PreparedStatement pst = con.prepareStatement("Select * from eCommerce.creditcard  ");
              results = pst.executeQuery();
             while(results.next()){
                    Card card = new Card();
                    card.setCode(results.getString(1));
                    card.setValue(results.getInt(2));
                    card.setCharged(results.getInt(3));
                    card.setUser_id(results.getInt(4));
                    cardList.add(card);
                }
             dbm.closeCon(con);
             return cardList;
             
         } catch (SQLException ex) {
             dbm.closeCon(con);
             Logger.getLogger(CardDao.class.getName()).log(Level.SEVERE, null, ex);
         }
        return null;
       
    }
    
    
}
