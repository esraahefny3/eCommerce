/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import DTOS.Card;
import DTOS.Order;
import DTOS.Product;
import Daos.CardDao;
import Daos.OrderDao;
import Daos.OrderProductDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author 3alilio
 */
public class AdminUtilities {
    
    public static void main(String[] args) {
//        AdminUtilities.generateCode();
//        CardDao cdao = new CardDao();
//        ArrayList<Card> list = cdao.selectAll();
//        for(Card temp : list)
//        {
//            System.out.println(temp.getCode());
//        }
        Order o = new Order();
        o.setId(1);
        OrderDao odao = new OrderDao();
        
        o = odao.select(o);
        OrderProductDao opdao = new OrderProductDao();
        
        HashMap<Integer,Product> orderdetails = new HashMap<>();
        orderdetails =    opdao.selectAllOrderProducts(o);
        
       System.out.println(AdminUtilities.calculateOrder(orderdetails));
    }
    
    public static String generateCode(){
        Random rn = new Random();
        String code="";
        for(int i=0;i<15;i++)
        {
            code+=rn.nextInt(10);
        }
        System.out.println(code+ "   "+code.length());
        return code;
    }
    
    public static double calculateOrder(HashMap<Integer,Product> order){
        double sum = 0;
        for(Integer qty : order.keySet())
        {
            sum+=qty*order.get(qty).getPrice();
        }
        return sum;
    }
    
    
    
    
}
