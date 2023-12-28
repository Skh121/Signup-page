
package com.groupc.saleberry.Dao;

import com.groupc.saleberry.Database.mySqlConnection;
import com.groupc.saleberry.Model.RegisterModel;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AuthDao extends mySqlConnection{
    public boolean register(RegisterModel user){
        try{
            PreparedStatement ps =null;
            Connection conn = openConnection();
            String sql = "INSERT INTO user(first_name,last_name,email,contact_no,password,confirm_password) VALUES(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirst_name());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getContact_no());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getConfirm_password());
            
            int result = ps.executeUpdate();
            if(result == -1){
                return false;
            }else{
                return true;
            }
            
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}
