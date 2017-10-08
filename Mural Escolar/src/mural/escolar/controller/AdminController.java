/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mural.escolar.controller;

import mural.escolar.persistencia.AdminDAOImp;

/**
 *
 * @author Lukas
 */
public class AdminController {
    
    public Integer login(String email, String senha){
        AdminDAOImp dao = new AdminDAOImp();
        return dao.login(email, senha);
    }
}
