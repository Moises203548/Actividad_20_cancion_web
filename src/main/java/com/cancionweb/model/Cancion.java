package com.cancionweb.model;

public class Cancion {

    private int id;
    private String nombre;
    private String ritmo;
    private int duracion;
    private String album;
    private int posicionEnAlbum;
    private String banda;
    private String interprete;
    private String autor;
    private String fechaLanzamiento;

    public Cancion() {
    }

    public Cancion(int id, String nombre, String ritmo, int duracion, String album,
                   int posicionEnAlbum, String banda, String interprete, String autor,
                   String fechaLanzamiento) {
        this.id = id;
        this.nombre = nombre;
        this.ritmo = ritmo;
        this.duracion = duracion;
        this.album = album;
        this.posicionEnAlbum = posicionEnAlbum;
        this.banda = banda;
        this.interprete = interprete;
        this.autor = autor;
        this.fechaLanzamiento = fechaLanzamiento;
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

    public String getRitmo() {
        return ritmo;
    }

    public void setRitmo(String ritmo) {
        this.ritmo = ritmo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getPosicionEnAlbum() {
        return posicionEnAlbum;
    }

    public void setPosicionEnAlbum(int posicionEnAlbum) {
        this.posicionEnAlbum = posicionEnAlbum;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
}