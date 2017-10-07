/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mural.escolar.negocio;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Frank
 */
public class Hash {
    
    /** Javadoc
     *  
     * @param senha
     * @return senha hasheada
     * 
     * Função que faz recebe uma senha e faz o hashing dessa senha.
     * @throws java.io.UnsupportedEncodingException
     * @throws java.security.NoSuchAlgorithmException
     */
    public String HashSenha(String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        String resultado = "";
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(senha.getBytes("UTF-8"));
            return bytestoHex(hash);
        }catch(UnsupportedEncodingException | NoSuchAlgorithmException ex){
        }
        return resultado;
    }
    private String bytestoHex(byte[] hash){
        return DatatypeConverter.printHexBinary(hash);
    }
}
