/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mural.escolar.controller;

import mural.escolar.persistencia.PessoaDAOImp;
import mural.escolar.negocio.Pessoa;

/**
 *
 * @author gustavo
 */
public class PessoaController {
    public String inserir(Pessoa p){
        PessoaDAOImp dao = new PessoaDAOImp();
        return dao.inserir(p);
    }
}
