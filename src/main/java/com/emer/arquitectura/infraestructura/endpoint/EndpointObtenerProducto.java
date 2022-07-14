package com.emer.arquitectura.infraestructura.endpoint;

import com.emer.arquitectura.aplicacion.manejador.ManejadorObtenerProducto;
import com.emer.arquitectura.comun.respuesta.ObjetoRespuesta;
import com.emer.arquitectura.dominio.modelo.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("productos")
@RequiredArgsConstructor
public class EndpointObtenerProducto {

    private final ManejadorObtenerProducto manejadorObtenerProducto;

    @GetMapping("/health")
    public Mono<String> test(@PathVariable String id) {
        return Mono.just("Ok");
    }

    @GetMapping("/{id}")
    public Mono<ObjetoRespuesta<Producto>> ejecutarObtenerProductoPorId(@PathVariable String id) {
        return manejadorObtenerProducto.ejecutarObtenerPorId(id);
    }

    @GetMapping("/all")
    public Flux<Producto> ejecutarObtenerTodosLosProductos() {
        return manejadorObtenerProducto.ejecutarObtenerTodos();
    }


}
