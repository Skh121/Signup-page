
package com.groupc.saleberry.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mySqlConnection implements DbConnection {
    @Override
    public Connection openConnection() { 
        try{
            String username = "root";
            String password = "password";
            String database = "SignUpUser";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + database, username, password
            );
            if(connection == null){
                System.out.println("Database connection fail");
            }else{
                System.out.println("Database connection success");
            }
            return connection;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void closeConnection(Connection conn) {
        try{
            if(conn !=null && !conn.isClosed()){
                conn.close();
                System.out.println("Connection close");
            }
        }catch(Exception e){
            System.out.println(e);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResultSet runQuery(Connection conn, String query) {
        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            return result;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int executeUpdate(Connection conn, String query) {
        try{
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(query);
            return result;
        }catch(Exception e){
            System.out.println(e);
            return -1;
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
