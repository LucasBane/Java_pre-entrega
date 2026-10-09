package com.talentotech;

// Excepcion personalizada, es arrojada cuando se busca un producto por ID y no se encuentra en la lista.
public class ProductoNoEncontrado extends RuntimeException{
    public ProductoNoEncontrado(String mensaje){
        super(mensaje);
    }
}
