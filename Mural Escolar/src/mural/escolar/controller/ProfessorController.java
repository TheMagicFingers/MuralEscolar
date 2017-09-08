package mural.escolar.controller;

import java.util.List;
import mural.escolar.negocio.Professor;
import mural.escolar.persistencia.ProfessorDAOImp;

/**
 *
 * @author Lucas Vieira
 */
public class ProfessorController {
    public String inserir(Professor professor){
        ProfessorDAOImp dao = new ProfessorDAOImp();
        return dao.inserir(professor);
    }
    
    public String alterar(Professor professor){
        ProfessorDAOImp dao = new ProfessorDAOImp();
        return dao.alterar(professor);
    }
    
    public String excluir(Professor professor){
        ProfessorDAOImp dao = new ProfessorDAOImp();
        return dao.excluir(professor);
    }
    
    public List<Professor> listarTodos(){
        ProfessorDAOImp dao = new ProfessorDAOImp();
        return dao.listarTodos();
    }
    
    public Professor pesquisarProfessorPorEmail(String email){
        ProfessorDAOImp dao = new ProfessorDAOImp();
        return dao.pesquisarPorEmail(email);
    }
}
