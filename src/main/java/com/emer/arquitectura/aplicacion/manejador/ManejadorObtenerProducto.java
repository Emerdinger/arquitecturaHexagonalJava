package com.emer.arquitectura.aplicacion.manejador;

import com.emer.arquitectura.comun.infraestructura.error.ProductoNoEncontrado;
import com.emer.arquitectura.comun.respuesta.ObjetoRespuesta;
import com.emer.arquitectura.dominio.modelo.Producto;
import com.emer.arquitectura.dominio.useCase.ProductoUseCase;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import okhttp3.OkHttpClient;

import java.io.IOException;

@AllArgsConstructor
public class ManejadorObtenerProducto {

    private final OkHttpClient client;
    private final ProductoUseCase productoUseCase;

    private static final String CONTENT_TYPE = "application/json";

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
