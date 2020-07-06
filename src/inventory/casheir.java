/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Administrator
 */
public class casheir {

    Connection conn = ConnectionManager.getConnection();
    PreparedStatement stmt;
    ResultSet rs;

    public void ProductSelect(JList list, String product) {
        String sql = "select * from productlist";
        int result = 0;

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            DefaultListModel dm = new DefaultListModel();
            dm.removeAllElements();
            while (rs.next()) {
                if (rs.getString("PRODUCT_NAME").equals(product) || rs.getString("PRODUCT_CODE").equals(product)) {
                    dm.addElement(rs.getString("PRODUCT_NAME") + "-" + rs.getString("DETAIL"));
                    result = 1;
                } else {
                    dm.addElement(new Object[]{"Can't find product"});

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
