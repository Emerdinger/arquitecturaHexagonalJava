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

    public Mono<String> testVirtual(String plate) {

        return Mono.just(HttpUrl.parse("https://www.virtualllantas.com/llantas/bancolombia/obtenervehiculoporplaca?placa=" + plate).newBuilder()
                        .build())
                .map(url -> postResponse("GET", url, null))
                .map(vehicle -> vehicle);
    }

    public String postResponse(String method, HttpUrl url, RequestBody requestBody) {
        String credentials = Credentials.basic("integracionbancolombia", "7K7pCnwsXR");
        Request request = new Request.Builder()
                .url(url)
                .method(method, requestBody)
                .addHeader("Authorization", credentials)
                .addHeader("Content-Type", CONTENT_TYPE)
                .addHeader("accept", CONTENT_TYPE)
                .build();

        try {
            return client.newCall(request).execute().body().string();
        }
        catch (IOException e) {
            return null;
        }
    }
}
