package com.emer.arquitectura.aplicacion.manejador;

import com.emer.arquitectura.dominio.useCase.TestUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ManejadorTest {
    private final TestUseCase testUseCase;

    public Mono<String> ejecutar() {
        return testUseCase.obtenerTest();
    }
}
