package com.cancionweb.model;

public class Usuario {

    private int id;
    private String nombre;
    private String email;
    private String clave;
    private String rol;
    private String tokenRecuperacion;
    private String tokenExpiracion;
    public Usuario() {
    }

    public Usuario(int id, String nombre, String email, String clave, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.clave = clave;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTokenRecuperacion() {
        return tokenRecuperacion;
    }

    public void setTokenRecuperacion(String tokenRecuperacion) {
        this.tokenRecuperacion = tokenRecuperacion;
    }

    public String getTokenExpiracion() {
        return tokenExpiracion;
    }

    public void setTokenExpiracion(String tokenExpiracion) {
        this.tokenExpiracion = tokenExpiracion;
    }
}
