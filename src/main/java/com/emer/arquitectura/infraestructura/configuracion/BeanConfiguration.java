package com.emer.arquitectura.infraestructura.configuracion;

import com.emer.arquitectura.aplicacion.manejador.ManejadorTest;
import com.emer.arquitectura.dominio.repositorio.TestRepositorio;
import com.emer.arquitectura.dominio.useCase.TestUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ManejadorTest manejadorTest(TestUseCase testUseCase){
        return new ManejadorTest(testUseCase);
    }

    @Bean
    public TestUseCase testUseCase(TestRepositorio testRepositorio) {
        return new TestUseCase(testRepositorio);
    }
}
