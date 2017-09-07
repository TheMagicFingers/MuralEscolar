/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mural.escolar.persistencia;

import java.util.List;
import mural.escolar.negocio.Pessoa;
/**
 *
 * @author gustavo
 */
public interface PessoaDAO {
    public String inserir(Pessoa p);
    public String alterar(Pessoa p);
    public String excluir(Pessoa p);
    public List<Pessoa> listarTodos();
    public Pessoa pesquisarPorCpf(String email);
}
