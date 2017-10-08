/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mural.escolar.persistencia;
import mural.escolar.negocio.Admin;
/**
 *
 * @author Lukas
 */
public interface AdminDAO {
    public Integer login(String email, String senha);
}
