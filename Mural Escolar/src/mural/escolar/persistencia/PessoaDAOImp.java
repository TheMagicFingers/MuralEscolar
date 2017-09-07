/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mural.escolar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import mural.escolar.controller.SQLiteConnectionFactory;
import mural.escolar.negocio.Pessoa;

/**
 *
 * @author gustavo
 */
public class PessoaDAOImp implements PessoaDAO{

    @Override
    public String inserir(Pessoa p) {
        String sql = "insert into pessoa (nome,email,senha) values(?,?,?)";
        Connection conn = SQLiteConnectionFactory.getConnection();
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, p.getNome());
            pst.setString(2, p.getEmail());
            pst.setString(3, p.getSenha());
            int res = pst.executeUpdate();
            
            if(res > 0){
                return "inserido com sucesso!";
            }else{
                return "erro ao inserir!";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            SQLiteConnectionFactory.close(conn);
        }
    }

    @Override
    public String alterar(Pessoa p) {
        return null;
    }

    @Override
    public String excluir(Pessoa p) {
        return null;
    }

    @Override
    public List<Pessoa> listarTodos() {
        return null;
    }

    @Override
    public Pessoa pesquisarPorCpf(String email) {
        return null;
    }
    
}
