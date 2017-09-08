/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mural.escolar.controller;
import java.util.List;
import mural.escolar.negocio.Aluno;
import mural.escolar.persistencia.AlunoDAOImp;
/**
 *
 * @author gustavo
 */
public class AlunoController {
    public String inserir(Aluno aluno){
        AlunoDAOImp dao = new AlunoDAOImp();
        return dao.inserir(aluno);
    }
    
    public String alterar(Aluno aluno){
        AlunoDAOImp dao = new AlunoDAOImp();
        return dao.alterar(aluno);
    }
    
    public String excluir(Aluno aluno){
        AlunoDAOImp dao = new AlunoDAOImp();
        return dao.excluir(aluno);
    }
    
    public List<Aluno> listarTodos(){
        AlunoDAOImp dao = new AlunoDAOImp();
        return dao.listarTodos();
    }
    
    public Aluno pesquisarAlunoPorEmail(String email){
        AlunoDAOImp dao = new AlunoDAOImp();
        return dao.pesquisarPorEmail(email);
    }
    
    public Integer login(String email, String senha){
        AlunoDAOImp dao = new AlunoDAOImp();
        return dao.login(email, senha);
    }
}
