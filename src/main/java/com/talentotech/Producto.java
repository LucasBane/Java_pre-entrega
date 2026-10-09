package com.talentotech;

// LAS CLASES SON CONSIDERADAS COMO UN CONTRATO, ES DECIR, SE PROPONEN A CUMPLIR CON ALGO ACORDADO.
public class Producto {

    // Atributos
    private long id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;


    // Constructores
    public Producto(String nombre, double precio, int stock, String categoria){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }
    // Constructor vacío. Crea una instancia vacia que se completa con getters y setters.
    public Producto() {}

    // Getters & Setters
    public long getId(){
        return this.id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) { this.categoria = categoria; }

    // Mostrar
    public void print(){
        System.out.println("# ID: " + id +
                "; Nombre: " + nombre +
                "; Precio: " + precio +
                "; Stock: " + stock +
                "; Categoria: " + categoria);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", " + nombre +
                ", $" + precio +
                ", Stock: " + stock +
                ", Categoria: " + categoria;
    }
}

