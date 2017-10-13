package mural.escolar.persistencia;

import java.util.List;
import mural.escolar.negocio.Professor;

/**
 *
 * @author Lucas Vieira
 */
public interface ProfessorDAO {
    public String inserir(Professor professor);
    public String alterar(Professor professor);
    public String excluir(Professor professor);
    public List<Professor> listarTodos();
    public Professor pesquisarPorEmail(String email);
    public List<Professor> pesquisarProfessor(String condicao, boolean nome, boolean siape);
    public Integer login(String email, String senha);
}
