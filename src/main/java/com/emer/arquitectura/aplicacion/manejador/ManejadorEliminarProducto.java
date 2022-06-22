package com.emer.arquitectura.aplicacion.manejador;

import com.emer.arquitectura.comun.respuesta.ObjetoRespuesta;
import com.emer.arquitectura.dominio.useCase.ProductoUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ManejadorEliminarProducto {

    private final ProductoUseCase productoUseCase;

    public Mono<ObjetoRespuesta<String>> ejecutarEliminarPorId(String id) {
        productoUseCase.eliminarPorId(id).subscribe();
        return Mono.just(new ObjetoRespuesta<>("Se ha eliminado el producto con id: "+ id));
    }

    public Mono<ObjetoRespuesta<String>> ejecutarEliminarTodos() {
        productoUseCase.eliminarTodos().subscribe();
        return Mono.just(new ObjetoRespuesta<>("Se han eliminado todos los productos"));
    }
}
