/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mural.escolar.persistencia;

import java.util.List;
import mural.escolar.negocio.Aluno;

/**
 *
 * @author gustavo
 */
public interface AlunoDAO {
    public String inserir(Aluno aluno);
    public String alterar(Aluno p);
    public String excluir(Aluno p);
    public List<Aluno> listarTodos();
    public Aluno pesquisarPorEmail(String email);
    public Integer login(String email, String senha);
}
