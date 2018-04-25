package Daos;

import DTOS.Category;
import DTOS.Product;
import dao_interfaces.ProductInterface;
import databaseConnection.DataBaseManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3alilio
 */
public class ProductDao implements ProductInterface {

    private DataBaseManager dbm;
    private Connection con;

    @Override
    public ArrayList<Product> selectAllCategoryProducts(Category category) {
        ArrayList<Product> products = new ArrayList<>();
        dbm = new DataBaseManager();
        con = dbm.getCon();
        try {
            String query = "Select name,categoryId,companyName,quantity,description,price,postedDate,id from eCommerce.product where categoryId = " + category.getId() + " ";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString(1));
                product.setCategoryId(resultSet.getInt(2));
                product.setCompanyName(resultSet.getString(3));
                product.setQuantity(resultSet.getInt(4));
                product.setDescription(resultSet.getString(5));
                product.setPrice(resultSet.getDouble(6));
                product.setPostedDate(new Date((resultSet.getTimestamp(7)).getTime()));
                product.setId(resultSet.getInt(8));
                products.add(product);
            }
            dbm.closeCon(con);
            return products;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Product> selectLatestProducts(int noOfItems) {
        ArrayList<Product> products = new ArrayList<>();
        dbm = new DataBaseManager();
        con = dbm.getCon();
        Calendar calendar = Calendar.getInstance();
        Timestamp currentDate = new Timestamp(calendar.getTime().getTime());
        Timestamp DateBefore =new Timestamp(calendar.getTime().getTime() - 7 * 24 * 3600 * 1000);
        //       System.out.println(currentDate.toLocalDate().toString());
        //       System.out.println(DateBefore.toLocalDate().toString());

        try {
            String query = "Select name,categoryId,companyName,quantity,description,price,postedDate,id from eCommerce.product where (postedDate between '" + DateBefore + "' and '" + currentDate + "')";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString(1));
                product.setCategoryId(resultSet.getInt(2));
                product.setCompanyName(resultSet.getString(3));
                product.setQuantity(resultSet.getInt(4));
                product.setDescription(resultSet.getString(5));
                product.setPrice(resultSet.getDouble(6));
                product.setPostedDate(new Date((resultSet.getTimestamp(7)).getTime()));
                product.setId(resultSet.getInt(8));
                products.add(product);
               }
            dbm.closeCon(con);
            return products;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Product> search(String name) {
        ArrayList<Product> products = new ArrayList<>();
        dbm = new DataBaseManager();
        con = dbm.getCon();
        try {
            String query = "Select name,categoryId,companyName,quantity,description,price,postedDate,id from eCommerce.product where name = '" + name + "' and quantity >0";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString(1));
                product.setCategoryId(resultSet.getInt(2));
                product.setCompanyName(resultSet.getString(3));
                product.setQuantity(resultSet.getInt(4));
                product.setDescription(resultSet.getString(5));
                product.setPrice(resultSet.getDouble(6));
                product.setPostedDate(new Date((resultSet.getTimestamp(7)).getTime()));
                product.setId(resultSet.getInt(8));
                products.add(product);
            }
            dbm.closeCon(con);
            return products;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Product> searchByPrice(String name, int from, int to) {
        ArrayList<Product> products = new ArrayList<>();
        dbm = new DataBaseManager();
        con = dbm.getCon();
        try {
            String query = "Select name,categoryId,companyName,quantity,description,price,postedDate,id from eCommerce.product where lower(name) like '%" + name.toLowerCase() + "%' and (price between " + from + " and " + to + ") and quantity >0";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString(1));
                product.setCategoryId(resultSet.getInt(2));
                product.setCompanyName(resultSet.getString(3));
                product.setQuantity(resultSet.getInt(4));
                product.setDescription(resultSet.getString(5));
                product.setPrice(resultSet.getDouble(6));
                product.setPostedDate(new Date((resultSet.getTimestamp(7)).getTime()));
                product.setId(resultSet.getInt(8));
                products.add(product);
            }
            dbm.closeCon(con);
            return products;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean insert(Product product) {
        try {
          //  File image = new File("C:\\Users\\HeshamMuhammed\\Desktop\\hqdefault.jpg");
          //  FileInputStream fileInputStream = new FileInputStream(image);
            dbm = new DataBaseManager();
            con = dbm.getCon();
            PreparedStatement preparedStatement = con.prepareStatement("insert into eCommerce.product(name,categoryId,companyName,"
                    + "quantity,description,price,postedDate ) values (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategoryId());
            preparedStatement.setString(3, product.getCompanyName());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setDouble(6, product.getPrice());
            preparedStatement.setTimestamp(7, new Timestamp(product.getPostedDate().getTime()));
           // preparedStatement.setBinaryStream(8, fileInputStream, image.length());
           // preparedStatement.setBinaryStream(8, null);
            preparedStatement.execute();
            dbm.closeCon(con);
            return true;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Product product) {
        dbm = new DataBaseManager();
        con = dbm.getCon();
        String query = "update eCommerce.product set name = ? , companyName = ? , quantity = ? , description = ? , price = ?  where id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, product.getName());
           //pst.setInt(2, product.getCategoryId());
            pst.setString(2, product.getCompanyName());
            pst.setInt(3, product.getQuantity());
            pst.setString(4, product.getDescription());
            pst.setDouble(5, product.getPrice());
           // pst.setTimestamp(6, new Timestamp(product.getPostedDate().getTime()));
            pst.setInt(6, product.getId());
            pst.execute();
            dbm.closeCon(con);
            return true;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
     @Override
    public boolean update(Product product,InputStream fileInputStream) {
        dbm = new DataBaseManager();
        con = dbm.getCon();
        String query = "update eCommerce.product set name = ? , companyName = ? , quantity = ? , description = ? , image = ? , price = ?  where id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, product.getName());
           //pst.setInt(2, product.getCategoryId());
            pst.setString(2, product.getCompanyName());
            pst.setInt(3, product.getQuantity());
            pst.setString(4, product.getDescription());
              pst.setBlob(5, fileInputStream);
            pst.setDouble(6, product.getPrice());
           
           // pst.setTimestamp(6, new Timestamp(product.getPostedDate().getTime()));
            pst.setInt(7, product.getId());
            pst.execute();
            dbm.closeCon(con);
            return true;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Product product) {
        try {
            dbm = new DataBaseManager();
            con = dbm.getCon();
            PreparedStatement preparedStatement = con.prepareStatement("delete from eCommerce.product where id = ?");
            preparedStatement.setInt(1, product.getId());
            preparedStatement.execute();
            dbm.closeCon(con);
            return true;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<Product> selectAll() {
        ArrayList<Product> products = new ArrayList<>();
        dbm = new DataBaseManager();
        con = dbm.getCon();
        try {
            String query = "Select name,categoryId,companyName,quantity,description,price,postedDate,id from eCommerce.product";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString(1));
                product.setCategoryId(resultSet.getInt(2));
                product.setCompanyName(resultSet.getString(3));
                product.setQuantity(resultSet.getInt(4));
                product.setDescription(resultSet.getString(5));
                product.setPrice(resultSet.getDouble(6));
                product.setPostedDate(new Date((resultSet.getTimestamp(7)).getTime()));
                product.setId(resultSet.getInt(8));
                products.add(product);
            }
            dbm.closeCon(con);
            return products;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Product select(Product pt) {
        dbm = new DataBaseManager();
        con = dbm.getCon();
        Product product = new Product();
        try {
            String query = "Select name,categoryId,companyName,quantity,description,price,postedDate,id,image from eCommerce.product where id = " + pt.getId();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                product.setName(resultSet.getString(1));
                product.setCategoryId(resultSet.getInt(2));
                product.setCompanyName(resultSet.getString(3));
                product.setQuantity(resultSet.getInt(4));
                product.setDescription(resultSet.getString(5));
                product.setPrice(resultSet.getDouble(6));
                product.setPostedDate(new Date((resultSet.getTimestamp(7)).getTime()));
                product.setId(resultSet.getInt(8));
                Blob imageBlob = resultSet.getBlob(9);
                if (imageBlob != null) {
                    int blobLength = (int) imageBlob.length();
                    byte[] blobAsBytes = imageBlob.getBytes(1, blobLength);
                    product.setImage(blobAsBytes);
                }
            }
            dbm.closeCon(con);
            return product;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     @Override
    public ArrayList<Product> searchByName(String string) {
               ArrayList<Product> products = new ArrayList<>();
        dbm = new DataBaseManager();
        con = dbm.getCon();
        try {
            String query = "Select name,categoryId,companyName,quantity,description,price,postedDate,id from eCommerce.product where name like '%"+string+"%' and quantity >0";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString(1));
                product.setCategoryId(resultSet.getInt(2));
                product.setCompanyName(resultSet.getString(3));
                product.setQuantity(resultSet.getInt(4));
                product.setDescription(resultSet.getString(5));
                product.setPrice(resultSet.getInt(6));
                product.setPostedDate(resultSet.getDate(7));
                product.setId(resultSet.getInt(8));
                products.add(product);
            }
            dbm.closeCon(con);
            return products;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public ArrayList<Product> searchByCategoray(Category category, String string) {
               ArrayList<Product> products = new ArrayList<>();
        dbm = new DataBaseManager();
        con = dbm.getCon();
        try {
            String query = "Select name,categoryId,companyName,quantity,description,price,postedDate,id from eCommerce.product where name like '%"+string+"%'"+" and categoryId="+category.getId();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString(1));
                product.setCategoryId(resultSet.getInt(2));
                product.setCompanyName(resultSet.getString(3));
                product.setQuantity(resultSet.getInt(4));
                product.setDescription(resultSet.getString(5));
                product.setPrice(resultSet.getInt(6));
                product.setPostedDate(resultSet.getDate(7));
                product.setId(resultSet.getInt(8));
                products.add(product);
            }
            dbm.closeCon(con);
            return products;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean insert(Product product ,InputStream fileInputStream) {
        try {
           // File image = new File("F:\\ITI\\v.jpg");
           // InputStream fileInputStream = new FileInputStream(image);
            dbm = new DataBaseManager();
            con = dbm.getCon();
            PreparedStatement preparedStatement = con.prepareStatement("insert into eCommerce.product(name,categoryId,companyName,"
                    + "quantity,description,price,postedDate,image ) values (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCategoryId());
            preparedStatement.setString(3, product.getCompanyName());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setDouble(6, product.getPrice());
              preparedStatement.setTimestamp(7, new Timestamp(product.getPostedDate().getTime()));
          
          // preparedStatement.setBinaryStream(7, fileInputStream, image.length());
       //   preparedStatement.setBinaryStream(7, fileInputStream, image.length());
            preparedStatement.setBlob(8, fileInputStream);
            preparedStatement.execute();
            dbm.closeCon(con);
            return true;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
       @Override
    public ArrayList<Product> searchByPriceCategory(String name, int from, int to, Category C) {
        ArrayList<Product> products = new ArrayList<>();
        dbm = new DataBaseManager();
        con = dbm.getCon();
        try {
            String query = "Select name,categoryId,companyName,quantity,description,price,postedDate,id from eCommerce.product where lower(name) like '%" + name.toLowerCase() + "%' and (price between " + from + " and " + to + ") and categoryid="+C.getId()+" and quantity >0";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString(1));
                product.setCategoryId(resultSet.getInt(2));
                product.setCompanyName(resultSet.getString(3));
                product.setQuantity(resultSet.getInt(4));
                product.setDescription(resultSet.getString(5));
                product.setPrice(resultSet.getDouble(6));
                product.setPostedDate(new Date((resultSet.getTimestamp(7)).getTime()));
                product.setId(resultSet.getInt(8));
                products.add(product);
            }
            dbm.closeCon(con);
            return products;
        } catch (SQLException ex) {
            dbm.closeCon(con);
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
