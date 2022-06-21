package com.emer.arquitectura.infraestructura.persistencia.repositorio;

import com.emer.arquitectura.dominio.repositorio.TestRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class RepositorioTestImpl implements TestRepositorio {
    @Override
    public Mono<String> obtenerTest() {
        return Mono.just("Endpoint de infraestructura probada correctamente.");
    }
}
