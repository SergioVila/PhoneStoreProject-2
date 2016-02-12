/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class AccountDao extends Dao{
    
    public void update(String email)
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "update table Account set attempts = attempts+1 where email = ?";
        
        try {
            ps = con.prepareStatement(query);
            
            ps.setString(1,email);
            
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
