/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_interfaces;

import DTOS.Category;
import DTOS.Product;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author esraa
 */
public interface ProductInterface extends GeneralInterface <Product> {
    
    public ArrayList<Product> selectAllCategoryProducts(Category category);
    public ArrayList<Product> selectLatestProducts(int noOfItems);
    public ArrayList<Product> search(String name);
    public ArrayList<Product> searchByPrice(String name,int from,int to);
    public ArrayList<Product> searchByName(String string);
    public ArrayList<Product> searchByCategoray(Category category , String string);
    public boolean insert(Product t,InputStream fileInputStream);
     public ArrayList<Product> searchByPriceCategory(String name,int from,int to, Category C);
    
    public boolean update(Product product,InputStream fileInputStream);
    
    
    
}
