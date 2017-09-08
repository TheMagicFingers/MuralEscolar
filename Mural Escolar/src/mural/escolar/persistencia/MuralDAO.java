/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mural.escolar.persistencia;

import java.util.List;
import mural.escolar.negocio.Professor;
import mural.escolar.negocio.Mural;
/**
 *
 * @author gustavo
 */
public interface MuralDAO {
    public String inserir(Professor professor, String texto);
    public List<Mural> listarUltimos();
    
}
