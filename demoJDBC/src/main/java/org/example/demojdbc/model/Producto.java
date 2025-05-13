package org.example.demojdbc.model;

import java.math.BigDecimal;

/**
 * Modelo de datos para la entidad Producto.
 */
public class Producto {
    private int id;
    private String nombre;
    private Double precio;

    public Producto() {
    }

    // Constructor sin id (para inserciones)
    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Constructor completo
    public Producto(int id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String tomate) {
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}