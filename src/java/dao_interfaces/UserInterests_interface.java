/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_interfaces;

import DTOS.Category;
import DTOS.User;
import java.util.ArrayList;

/**
 *
 * @author esraa
 */
public interface UserInterests_interface {
    public boolean insertUserInterests(User user,ArrayList<Category> categoryList);
    public boolean deleteAllUserInterests(User user);
    public ArrayList<Category> selectAllUserInterests(User user);
}
