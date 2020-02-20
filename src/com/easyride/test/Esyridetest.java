/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easyride.test;

import com.easyride.Entite.Produit;
import com.easyride.Service.ServiceProduit;
import java.sql.*;
import java.util.List;



public class Esyridetest {
    
    public static void main(String[] args) {
        ServiceProduit ser = new ServiceProduit();
        
       
        try {
//         
     
          
         
            List<Produit> list = ser.readAll();
            System.out.println(list);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
