package com.emer.arquitectura.infraestructura.endpoint;

import com.emer.arquitectura.aplicacion.manejador.ManejadorTest;
import com.emer.arquitectura.comun.respuesta.RespuestaBase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class EndpointTest {

    private final ManejadorTest manejadorTest;

    @GetMapping
    public Mono<RespuestaBase> ejecutarEndpointTest () {
        return Mono.just(RespuestaBase.ok(manejadorTest.ejecutar().block()));
    }

}
