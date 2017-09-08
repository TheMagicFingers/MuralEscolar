/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mural.escolar.controller;

import mural.escolar.persistencia.MuralDAOImp;
import mural.escolar.negocio.Professor;
/**
 *
 * @author gustavo
 */
public class MuralController {
    public String inserir(Professor professor, String texto){
        MuralDAOImp dao = new MuralDAOImp();
        return dao.inserir(professor, texto);
    }
    
    
}
