package com.example.appimporvultec.Utils;

import com.example.appimporvultec.Models.Categoria;

public class Apis {

    public static final String URL="http://192.168.18.9:8080/";

    public static UserService getPersonaService(){
        return Cliente.getCliente(URL).create(UserService.class);
    }

    public static ProductService getProductoService(){
        return Producto.getProducto(URL).create(ProductService.class);
    }

    public static CategoriaService getCategoriaService(){
        return Cliente.getCliente(URL).create(CategoriaService.class);
    }

}
