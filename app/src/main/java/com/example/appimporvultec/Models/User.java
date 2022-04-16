package com.example.appimporvultec.Models;

public class User {

    private Long id;

    private Long idgoogle;

    private String cedula;

    private String name;

    private String email;

    private String rol;

    private String urlFoto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdgoogle() {
        return idgoogle;
    }

    public void setIdgoogle(Long idgoogle) {
        this.idgoogle = idgoogle;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
