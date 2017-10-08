/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mural.escolar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mural.escolar.controller.SQLiteConnectionFactory;
import mural.escolar.negocio.Admin;

/**
 *
 * @author Frank
 */
public class AdminDAOImp implements AdminDAO {
    
    public Admin pesquisarPorEmail(String email) {
        String sql = "select * from Admin where email = ?";
        Connection conn = SQLiteConnectionFactory.getConnection();
        
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Admin admin = new Admin();
                admin.setNome(rs.getString(2));
                admin.setEmail(rs.getString(3));
                admin.setSenha(rs.getString(4));
               
                return admin;
            }else{
                return null;
            }
        }catch(SQLException e){
            return null;
        }finally{
            SQLiteConnectionFactory.close(conn);
        }
    }
    @Override
    public Integer login(String email, String senha) {
        Admin admin = pesquisarPorEmail(email);
        if(admin != null){
            
            if(admin.getSenha().equals(senha)){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
    
}
