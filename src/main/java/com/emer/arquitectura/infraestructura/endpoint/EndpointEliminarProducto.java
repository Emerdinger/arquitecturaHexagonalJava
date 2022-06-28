package com.emer.arquitectura.infraestructura.endpoint;

import com.emer.arquitectura.aplicacion.manejador.ManejadorEliminarProducto;
import com.emer.arquitectura.comun.respuesta.ObjetoRespuesta;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
@RequestMapping("productos")
@RequiredArgsConstructor
public class EndpointEliminarProducto {

    private final ManejadorEliminarProducto manejadorEliminarProducto;

    @DeleteMapping("/{id}")
    public Mono<ObjetoRespuesta<String>> ejecutarEliminarPorId(@PathVariable String id) {
        return manejadorEliminarProducto.ejecutarEliminarPorId(id);
    }

    @DeleteMapping("/all")
    public Mono<ObjetoRespuesta<String>> ejecutarEliminarTodos() {
        return manejadorEliminarProducto.ejecutarEliminarTodos();
    }
}
