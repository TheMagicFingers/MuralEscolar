package mural.escolar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mural.escolar.controller.SQLiteConnectionFactory;
import mural.escolar.negocio.Professor;

/**
 *
 * @author Lucas Vieira
 */
public class ProfessorDAOImp implements ProfessorDAO{

    @Override
    public String inserir(Professor professor) {
        String sql = "insert into professor (nome, email, senha, cpf, siape) values (?,?,?,?,?)";
        Connection conn = SQLiteConnectionFactory.getConnection();
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, professor.getNome());
            pst.setString(2, professor.getEmail());
            pst.setString(3, professor.getSenha());
            pst.setString(4, professor.getCpf());
            pst.setString(5, professor.getSiape());
            
            int res = pst.executeUpdate();
            
            if(res > 0){
                return "Professor cadastrado com sucesso!";
            }else{
                return "Erro ao cadastrar professor";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            SQLiteConnectionFactory.close(conn);
        }
    }

    @Override
    public String alterar(Professor professor) {
        String sql = "update professor set nome=?, email=?, cpf=?, siape=? where email=?";
        Connection conn = SQLiteConnectionFactory.getConnection();
        
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, professor.getNome());
            pst.setString(2, professor.getEmail());
            pst.setString(3, professor.getCpf());
            pst.setString(4, professor.getSiape());
            pst.setString(5, professor.getEmail());
            int res = pst.executeUpdate();
            
            if(res > 0){
                return "Alteração feita com sucesso!";
            }else{
                return "Falha na alteração";
            }
            
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            SQLiteConnectionFactory.close(conn);
        }
    }

    @Override
    public String excluir(Professor professor) {
        String sql = "delete from professor where email=?";
        Connection conn = SQLiteConnectionFactory.getConnection();
        
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, professor.getEmail());
            
            int res = pst.executeUpdate();
            if(res > 0){
                return "Professor " + professor.getNome() + " excluído com sucesso";
            }else{
                return "Falha na exclusão";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            SQLiteConnectionFactory.close(conn);
        }
    }

    @Override
    public List<Professor> listarTodos() {
        String sql = "select * from professor";
        Connection conn = SQLiteConnectionFactory.getConnection();
        List<Professor> lista = new ArrayList<>();
        
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet listaProf = pst.executeQuery();
            if(listaProf != null){
                while(listaProf.next()){
                    Professor professor = new Professor();
                    professor.setId(listaProf.getInt(0));
                    professor.setNome(listaProf.getString(1));
                    professor.setEmail(listaProf.getString(2));
                    professor.setCpf(listaProf.getString(4));
                    professor.setSiape(listaProf.getString(5));
                    
                    lista.add(professor);
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
    public Professor pesquisarPorEmail(String email) {
        String sql = "select * from professor where email = ?";
        Connection conn = SQLiteConnectionFactory.getConnection();
        
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Professor professor = new Professor();
                professor.setId(rs.getInt(1));
                professor.setNome(rs.getString(2));
                professor.setEmail(rs.getString(3));
                professor.setSenha(rs.getString(4));
                professor.setCpf(rs.getString(5));
                professor.setSiape(rs.getString(6));
                
                return professor;
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
        Professor prof = pesquisarPorEmail(email);
        if(prof != null){
            
            if(prof.getSenha().equals(senha)){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
    
}
