/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Business.Account;
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
        
        String query = "update Account set attempts = attempts+1 where email = ?";
        
        try {
            ps = con.prepareStatement(query);
            
            ps.setString(1,email);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Account getStatus(String email){
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = this.getConnection();
            
            if (email == null) {
                return null;
            }
            
            String query = "select * from Account where email = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, email);
            
            rs = ps.executeQuery();
            if(rs.next()){
                Account a = new Account(); 
                
                a.setAccountStatus(rs.getString("AccountStatus"));
                a.setAttempts(rs.getInt("Attempts"));
                a.setDate(rs.getTime("Time"));
                a.setEmail(rs.getString("email"));
                
                return a;
                
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
        

    }
    
}
