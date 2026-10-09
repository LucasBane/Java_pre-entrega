package com.talentotech;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.talentotech.Producto;

import com.talentotech.StockInsuficienteException;

// Clase que integra todos los metodos de validacion. Asegura que los valores ingresados y/o procesados sean validos.
public class Validador {
    // Todos los metodos son estaticos, por lo que no se requiere crear una instancia de la clase.

    public static void validarNombre(String nombre){
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    public static void validarPrecios(double precio){
        if (precio < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
    }

    public static void validarStock(int stock){
        if (stock < 0){
            throw new StockInsuficienteException("El stock no puede ser negativo.");
        }
    }

    public static void validarCategoria(String categoria){
        if (categoria == null || categoria.isBlank()){
            throw new IllegalArgumentException("La categoria no puede estar vacía.");
        }
    }

    public static int leerEntero(Scanner sc, String mensaje){
        while(true){
            System.out.println(mensaje);
            try{
                int valor = sc.nextInt();
                sc.nextLine(); // Limpia el buffer
                return valor;
            } catch (InputMismatchException e){
                System.out.println("Valor invalido, debe ingresar un numero entero.");
                sc.nextLine();
            }
        }
    }

    public static double leerDouble(Scanner sc, String mensaje){
        while(true){
            System.out.println(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            } catch (Exception e){
                System.out.println("Valor invalido, debe ingresar un numero decimal.");
                sc.nextLine();
            }
        }
    }

    public static String leerTexto(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextLine();
    }

    public static void validarProducto(Producto producto){
        validarNombre(producto.getNombre());
        validarPrecios(producto.getPrecio());
        validarStock(producto.getStock());
        validarCategoria(producto.getCategoria());
    }
}
