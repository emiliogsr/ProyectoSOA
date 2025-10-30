package edu.itq.soa.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao {
    private static final List<Usuarios> USUARIOS_ESTATICOS = Arrays.asList(
        new Usuarios("1", "admin", "admin123"),
        new Usuarios("2", "emilio", "clave456"),
        new Usuarios("3", "enrique", "guest123")
    );

    public Usuarios encontrarPorCredenciales(String nombreUsuario, String password) {
        return USUARIOS_ESTATICOS.stream()
            .filter(u -> u.getNombreUsuario().equals(nombreUsuario) && u.getPassword().equals(password))
            .findFirst()
            .orElse(null);
    }
}
