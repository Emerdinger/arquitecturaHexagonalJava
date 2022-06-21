package com.emer.arquitectura.dominio.repositorio;

import reactor.core.publisher.Mono;

public interface TestRepositorio {

    Mono<String> obtenerTest();
}
