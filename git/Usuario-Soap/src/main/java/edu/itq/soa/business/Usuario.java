package edu.itq.soa.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.itq.soa.ValidarRequest;
import edu.itq.soa.ValidarResponse;
import edu.itq.soa.dao.UsuarioDao;
import edu.itq.soa.dao.Usuarios; 

@Service
public class Usuario {

    @Autowired
    private UsuarioDao usuarioDao;

    public ValidarResponse validar(ValidarRequest request) {
       
        Usuarios usuario = usuarioDao.encontrarPorCredenciales(request.getNombreUsuario(), request.getPassword());
        
     
        ValidarResponse response = new ValidarResponse();
        
        if (usuario != null) {
            response.setEsValido(true);
        } else {
            response.setEsValido(false);
            response.setID("No encontrado");
        }
        
        return response;
    }
}

