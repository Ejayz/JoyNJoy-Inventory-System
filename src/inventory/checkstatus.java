/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.io.File;
import java.sql.Connection;
import javax.swing.JLabel;

/**
 *
 * @author Administrator
 */
public class checkstatus {

    
     Connection conn =ConnectionManager.getConnection();
     
    
    public boolean CheckFile(JLabel stat) {
    boolean  result=false;
        try{
        File file = new File("C://SSD.SIMPLE_ITEM_INVENTORY");

        if (file.exists()) {
            stat.setText("Directory check:OK");
            File log = new File("C://SSD.SIMPLE_ITEM_INVENTORY/Log.txt");
            if (log.exists()) {
                result=true;
                stat.setText("File check:Ok");
            } else {
                result=true;
                log.createNewFile();
            }
        } else {
            result=true;
            file.mkdir();
        }
        stat.setText("File directory check is done.");
      }
      catch(Exception e){
          result=false;
          stat.setText(e.toString());
      }
        return result;
    }

    public boolean CheckDb (JLabel stat) {
   boolean result=false;
        try{
        if(conn.isClosed()){
           result=false;
           stat.setText("Checking Database Connection:Error Closed Connection");
       }
        else{
            result=true;
            stat.setText("Checking Database Connection:Ok");
        }
    }
    catch(Exception e){
        stat.setText(e.toString());
    }
        return result;
    }

}
