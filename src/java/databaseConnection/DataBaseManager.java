/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseConnection;

import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3alilio
 */
public class DataBaseManager {
    
    private Connection con;

    public DataBaseManager() {
        
        try {
            DriverManager.registerDriver(new Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","");
        } catch (SQLException ex) {
            //Logger.getLogger(dataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
             System.err.println("Connection Failed");
            ex.printStackTrace();
        }finally{System.out.println("Connected");}
    }

    public Connection getCon() {
        return con;
    }
    
    public void closeCon(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
