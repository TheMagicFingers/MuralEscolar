/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mural.escolar.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gustavo
 */
public class SQLiteConnectionFactory {
    public static Connection getConnection(){
        String db_path = System.getProperty("user.dir");
        String url = "jdbc:sqlite:" +db_path + "/config/muralEscolar.db";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
    public static void close(Connection conn){
        try{
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
