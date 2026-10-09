package com.talentotech;

import java.util.ArrayList;
import java.util.List;

import com.talentotech.Producto;
import com.talentotech.Validador;
import com.talentotech.ProductoNoEncontrado;

// Capa de servicio del sistema.
// Se encarga de administrar los productos, el mantenimiento, y la validacion de los datos.
public class ProductoService {
    // Lista donde se guardaran todos los productos.
    private List<Producto> productos = new ArrayList<>();

    private static int contadorId = 1;

    // Operaciones CRUD ( Create, read, update, delete )

    // Create: crear un nuevo producto
    public Producto guardar(Producto p){
        Validador.validarProducto(p);

        p.setId(contadorId);
        contadorId++;

        // Guardamos el producto
        productos.add(p);

        return p;
    }

    // Read: Lee la lista de los productos
    public List<Producto> listarTodos(){
        return productos;
    }

    // Busqueda: Busca un producto por Id.
    public Producto obtenerPorId(int id){
        for(Producto p : productos){
            if(p.getId() == id){
                return p;
            }
        }

        throw new ProductoNoEncontrado("No se pudo encontrar el producto con la ID " + id);
    }

    // Update:
    public Producto actualizar(int id, Producto nuevoProducto){
        // Primero buscamos el producto a actualizar.
        // Si no existe, lanza la excepcion 'ProductoNoEncontrado' y se cancela la operacion.
        Producto p = obtenerPorId(id);

        // Validamos los datos antes de modificar.
        Validador.validarProducto(nuevoProducto);

        // Finalmente actualizamos los datos del producto.
        p.setNombre(nuevoProducto.getNombre());
        p.setPrecio(nuevoProducto.getPrecio());
        p.setStock(nuevoProducto.getStock());
        p.setCategoria(nuevoProducto.getCategoria());

        return p;
    }

    // Delete
    public void eliminar(int id){
        Producto p = obtenerPorId(id);
        productos.remove(p);
    }
}
