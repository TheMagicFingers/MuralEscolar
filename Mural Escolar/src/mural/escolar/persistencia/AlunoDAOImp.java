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
import java.util.ArrayList;
import java.util.List;
import mural.escolar.controller.SQLiteConnectionFactory;
import mural.escolar.negocio.Aluno;


/**
 *
 * @author gustavo
 */
public class AlunoDAOImp implements AlunoDAO{

    @Override
    public String inserir(Aluno aluno) {
        String sql = "insert into aluno (nome,email,senha,matricula,curso) values(?,?,?,?,?)";
        Connection conn = SQLiteConnectionFactory.getConnection();
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, aluno.getNome());
            pst.setString(2, aluno.getEmail());
            pst.setString(3, aluno.getSenha());
            pst.setString(4, aluno.getMatricula());
            pst.setString(5, aluno.getCurso());
            
            int res = pst.executeUpdate();
            
            if(res > 0){
                return "Aluno cadastrado com sucesso!";
            }else{
                return "Erro ao cadastrar aluno";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            SQLiteConnectionFactory.close(conn);
        }
    }

    @Override
    public String alterar(Aluno aluno) {
        String sql = "update aluno set nome=?,matricula=?,email=?,curso=?,senha=? where email=?";
        Connection conn = SQLiteConnectionFactory.getConnection();
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, aluno.getNome());
            pst.setString(2, aluno.getMatricula());
            pst.setString(3, aluno.getEmail());
            pst.setString(4, aluno.getCurso());
            pst.setString(5, aluno.getSenha());
            pst.setString(6, aluno.getEmail());
            
            int res = pst.executeUpdate();
            
            if(res > 0){
                return "Alterado com sucesso!";
            }else{
                return "Erro ao alterar!";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            SQLiteConnectionFactory.close(conn);
        }

    }

    @Override
    public String excluir(Aluno aluno) {
        String sql = "delete from aluno where email=?";
        Connection conn = SQLiteConnectionFactory.getConnection();
        
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, aluno.getEmail());
            int res = pst.executeUpdate();
            if(res > 0){
                return "Aluno " + aluno.getNome() +" excluido com sucesso!";
            }else{
                return "Erro ao excluir!";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            SQLiteConnectionFactory.close(conn);
        }
    }

    @Override
    public List<Aluno> listarTodos() {
        String sql = "select * from aluno";
        Connection conn = SQLiteConnectionFactory.getConnection();
        List<Aluno> lista = new ArrayList<>();
        
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs != null){
                while(rs.next()){
                    Aluno aluno = new Aluno();
                    
                    aluno.setNome(rs.getString(1));
                    aluno.setEmail(rs.getString(2));
                    //aluno.setSenha(rs.getString(3));
                    aluno.setMatricula(rs.getString(4));
                    aluno.setCurso(rs.getString(5));
                    lista.add(aluno);
                }
                
                return lista;
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
    public Aluno pesquisarPorEmail(String email) {
        String sql = "select * from aluno where email = ?";
        Connection conn = SQLiteConnectionFactory.getConnection();
        
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setNome(rs.getString(2));
                aluno.setEmail(rs.getString(3));
                aluno.setSenha(rs.getString(4));
                aluno.setMatricula(rs.getString(5));
                aluno.setCurso(rs.getString(6));
                
                return aluno;
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
    public Integer login(String email, String senha){
        Aluno aluno = pesquisarPorEmail(email);
        if(aluno != null){
            
            if(aluno.getSenha().equals(senha)){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
}
