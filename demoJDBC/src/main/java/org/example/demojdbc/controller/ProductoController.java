package org.example.demojdbc.controller;

import org.example.demojdbc.model.Producto;
import org.example.demojdbc.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping
    public List<Producto> listarTodas() {
        return productoRepository.buscarTodos();
    }

    @GetMapping("/{nombre}")
    public Producto buscarPorNombre(@PathVariable String nombre) {
        return productoRepository.buscarUno(nombre);
    }

    @PostMapping
    public void insertar(@RequestBody Producto producto) {
        productoRepository.insertar(producto);
    }

    @DeleteMapping("/{nombre}")
    public void borrar(@PathVariable String nombre) {
        Producto producto = productoRepository.buscarUno(nombre);
        if (producto != null) {
            productoRepository.borrar(producto);
        }
    }

    @DeleteMapping
    public void borrarTodos() {
        productoRepository.borrarTodos();
    }
}