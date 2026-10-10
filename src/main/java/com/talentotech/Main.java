package com.talentotech;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static ProductoService service = new ProductoService();

    public static void main(String[] args){
        // Instacias y variables

        Scanner sc = new Scanner(System.in);

        int opcion;
        // Loop
        do{
            menu();
            opcion = Validador.leerEntero(sc, "Elija una opcion: ");
            try {
                switch (opcion){
                    case 1 -> agregarProducto(sc);
                    case 2 -> listarProductos();
                    case 3 -> buscarProducto(sc);
                    case 4 -> actualizarProducto(sc);
                    case 5 -> eliminarProducto(sc);
                    case 6 -> mostrar("Fin del programa.");
                    default -> mostrar("Opcion invalida. Elija un numero del 1 al 6.");
                }
            } catch (ProductoNoEncontrado | StockInsuficienteException e){
                // Capturamos las excepciones personalizadas.
                mostrar(e.getMessage());
            } catch (IllegalArgumentException e) {
                // Validador de datos genericos invalidos.
                mostrar(e.getMessage());
            }
        } while (opcion != 6);
        // Fin del loop
        sc.close();
    }

    // Metodo auxiliar para println()
    private static void mostrar(String s){
        System.out.println(s);
    }

    // Muestra el menu por consola
    private static void menu(){
        mostrar("------------ Gestor de Productos ------------");
        mostrar("1 - Agregar un nuevo producto");
        mostrar("2 - Listar todos los productos");
        mostrar("3 - Buscar un producto por ID");
        mostrar("4 - Actualizar un producto");
        mostrar("5 - Eliminar un producto");
        mostrar("6 - Salir");
        mostrar("---------------------------------------------");
    }

    private static void agregarProducto(Scanner sc){
        mostrar("# Nuevo producto");
        String nombre = Validador.leerTexto(sc, "Nombre: ");
        double precio = Validador.leerDouble(sc, "Precio: ");
        int stock = Validador.leerEntero(sc, "Stock: ");
        String categoria = Validador.leerTexto(sc, "Categoría: ");

        Producto p = new Producto(nombre, precio, stock, categoria);
        // Guardamos el producto al servicio
        Producto guardado = service.guardar(p);

        mostrar("# Nuevo producto agregado: ID " + guardado.getId());
    }
    private static void listarProductos(){
        List<Producto> list = service.listarTodos();
        if(list.isEmpty()){
            mostrar("La lista esta vacia.");
            return;
        }

        mostrar("# Catalogo");
        for(Producto p : list){
            p.print();
        }
    }
    private static void buscarProducto(Scanner sc){
        mostrar("# Busqueda de producto");
        int id = Validador.leerEntero(sc, "Ingrese la ID del producto: ");

        Producto encontrado = service.obtenerPorId(id);
        if(encontrado != null){
            encontrado.print();
        }
    }
    private static void actualizarProducto(Scanner sc){
        mostrar("# Actualizar producto");
        int id = Validador.leerEntero(sc, "Ingrese la ID del producto a actualizar: ");

        String nombre = Validador.leerTexto(sc, "Nombre: ");
        double precio = Validador.leerDouble(sc, "Precio: ");
        int stock = Validador.leerEntero(sc, "Stock: ");
        String categoria = Validador.leerTexto(sc, "Categoría: ");

        Producto p = service.actualizar(id, new Producto(nombre, precio, stock, categoria));

        mostrar("# Producto actualizado con éxito | " + p);
    }
    private static void eliminarProducto(Scanner sc){
        mostrar("# Eliminar producto");
        int id = Validador.leerEntero(sc, "Ingrese la ID del producto a eliminar: ");

        service.eliminar(id);
        mostrar("# Producto eliminado");
    }


}
