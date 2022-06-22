package com.emer.arquitectura.dominio.useCase;

import com.emer.arquitectura.dominio.modelo.Producto;
import com.emer.arquitectura.dominio.repositorio.ProductoRepositorio;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class ProductoUseCase {

    private final ProductoRepositorio productoRepositorio;

    public Mono<Producto> guardarProducto (Producto producto) {
        return productoRepositorio.guardarProducto(producto);
    }

    public Mono<Producto> obtenerProductoPorId(String id) {
        return productoRepositorio.obtenerProductoPorId(id);
    }

    public Flux<Producto> obtenerTodos() {
        return productoRepositorio.obtenerTodos();
    }

    public Mono<Void> eliminarPorId(String id) {
        return productoRepositorio.eliminarPorId(id);
    }

    public Mono<Void> eliminarTodos() {
        return productoRepositorio.eliminarTodos();
    }
}
