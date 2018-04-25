/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_interfaces;

import java.util.ArrayList;

/**
 *
 * @author esraa
 * @param <T>
 */
public interface GeneralInterface <T>{
    
   public boolean insert(T t);
   public boolean update(T t);
   public boolean delete(T t);
   public T select(T t);
   public ArrayList<T> selectAll();
}
