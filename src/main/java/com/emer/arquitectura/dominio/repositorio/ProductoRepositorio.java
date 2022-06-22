package com.emer.arquitectura.dominio.repositorio;

import com.emer.arquitectura.dominio.modelo.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoRepositorio {

    Mono<Producto> guardarProducto(Producto producto);
    Mono<Producto> obtenerProductoPorId(String id);
    Flux<Producto> obtenerTodos();
    Mono<Void> eliminarPorId(String id);
    Mono<Void> eliminarTodos();
}
