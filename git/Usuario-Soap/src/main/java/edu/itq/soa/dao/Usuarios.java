package edu.itq.soa.dao;
public class Usuarios {
    private String id;
    private String nombreUsuario;
    private String password;

    public Usuarios(String id, String nombreUsuario, String password) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

   
    public String getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

   
    public String getPassword() {
        return password;
    }
}
