package com.talentotech;

// Excepcion personalizada, es arrojada cuando se intenta asignar un stock invalido.
public class StockInsuficienteException extends RuntimeException{
    public StockInsuficienteException (String mensaje){
        super(mensaje);
    }
}
