/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

/**
 *
 * @author 3alilio
 */
public class Card {
    
    private int value;
    private String code;
    private int charged;
    private int user_id;

    

    public Card(int value, String code, int charged) {
        this.value = value;
        this.code = code;
        this.charged = charged;
    }

    public Card() {
    }
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCharged() {
        return charged;
    }

    public void setCharged(int charged) {
        this.charged = charged;
    }

    
    
    
}
