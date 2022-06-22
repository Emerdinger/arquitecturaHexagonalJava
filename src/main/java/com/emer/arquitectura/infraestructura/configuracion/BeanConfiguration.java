package com.emer.arquitectura.infraestructura.configuracion;

import com.emer.arquitectura.aplicacion.manejador.ManejadorEliminarProducto;
import com.emer.arquitectura.aplicacion.manejador.ManejadorGuardarProducto;
import com.emer.arquitectura.aplicacion.manejador.ManejadorObtenerProducto;
import com.emer.arquitectura.aplicacion.manejador.ManejadorTest;
import com.emer.arquitectura.comun.mapper.ProductoMapper;
import com.emer.arquitectura.dominio.repositorio.ProductoRepositorio;
import com.emer.arquitectura.dominio.repositorio.TestRepositorio;
import com.emer.arquitectura.dominio.useCase.ProductoUseCase;
import com.emer.arquitectura.dominio.useCase.TestUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    // Manejadores

    @Bean
    public ManejadorTest manejadorTest(TestUseCase testUseCase){
        return new ManejadorTest(testUseCase);
    }

    @Bean
    public ManejadorGuardarProducto manejadorGuardarProducto(ProductoUseCase productoUseCase, ProductoMapper productoMapper) {
        return new ManejadorGuardarProducto(productoUseCase, productoMapper);
    }

    @Bean
    public ManejadorObtenerProducto manejadorObtenerProducto(ProductoUseCase productoUseCase) {
        return new ManejadorObtenerProducto(productoUseCase);
    }

    @Bean
    public ManejadorEliminarProducto manejadorEliminarProducto(ProductoUseCase productoUseCase) {
        return new ManejadorEliminarProducto(productoUseCase);
    }

    // Use Cases

    @Bean
    public TestUseCase testUseCase(TestRepositorio testRepositorio) {
        return new TestUseCase(testRepositorio);
    }

    @Bean
    public ProductoUseCase productoUseCase(ProductoRepositorio productoRepositorio) { return new ProductoUseCase(productoRepositorio); }

}
