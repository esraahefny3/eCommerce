/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_interfaces;

import DTOS.Card;
import DTOS.User;
import java.util.ArrayList;

/**
 *
 * @author esraa
 */
public interface CardInterface extends GeneralInterface <Card> {
   
    public ArrayList<Card> selectAllUserCards(User user);
    
}
