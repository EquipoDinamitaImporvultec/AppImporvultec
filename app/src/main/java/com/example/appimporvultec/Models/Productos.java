package com.example.appimporvultec.Models;


public class Productos {

    private Long id_producto;

    private String name;

    private String description;

    private Double price;

    private Long id_categoria;

    private String urlFoto;

    public Productos() {
    }

    public Productos(Long id_producto, String name, String description, Double price) {
        this.id_producto = id_producto;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
