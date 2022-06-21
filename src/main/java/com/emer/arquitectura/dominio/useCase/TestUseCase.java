package com.emer.arquitectura.dominio.useCase;

import com.emer.arquitectura.dominio.repositorio.TestRepositorio;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TestUseCase {

    private final TestRepositorio testRepositorio;

    public Mono<String> obtenerTest () {
        return testRepositorio.obtenerTest();
    }
}
