/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class login {
    
    Connection conn=ConnectionManager.getConnection();
    PreparedStatement stmt;
    ResultSet rs;
    int Result=0;
    
    
    public boolean LoginValid(String username ,String password){
       boolean res=false ;
               try {
            stmt=conn.prepareStatement("select * from login where IS_EXIST='true'");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                if(rs.getString("USERNAME").equals(username)&&rs.getString("PASSWORD").equals(password)){
                  res=true; 
                  break;
                }
                else{
                    res=false;
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
      return res;  
    }
    
}
