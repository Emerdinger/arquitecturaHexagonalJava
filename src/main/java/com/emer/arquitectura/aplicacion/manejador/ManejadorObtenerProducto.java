package com.emer.arquitectura.aplicacion.manejador;

import com.emer.arquitectura.comun.infraestructura.error.ProductoNoEncontrado;
import com.emer.arquitectura.comun.respuesta.ObjetoRespuesta;
import com.emer.arquitectura.dominio.modelo.Producto;
import com.emer.arquitectura.dominio.useCase.ProductoUseCase;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
public class ManejadorObtenerProducto {

    private final ProductoUseCase productoUseCase;

    public Mono<ObjetoRespuesta<Producto>> ejecutarObtenerPorId(String id) {
        return productoUseCase.obtenerProductoPorId(id)
                .switchIfEmpty(Mono.error(new ProductoNoEncontrado("Producto no encontrado")))
                .map(p -> new ObjetoRespuesta<>(p));
    }

    public Flux<Producto> ejecutarObtenerTodos() {
        return productoUseCase.obtenerTodos()
                .switchIfEmpty(Mono.error(new ProductoNoEncontrado("No existen productos")));
    }
}
