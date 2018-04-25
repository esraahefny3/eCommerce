/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_interfaces;

import DTOS.User;

/**
 *
 * @author esraa
 */
public interface UserInterface extends GeneralInterface <User>{
    public User selectUserbyid(User user);
    public User selectUserbyEmail(User user);
}
