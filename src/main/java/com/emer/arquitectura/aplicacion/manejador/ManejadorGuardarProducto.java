package com.emer.arquitectura.aplicacion.manejador;

import com.emer.arquitectura.aplicacion.comando.ProductoComando;
import com.emer.arquitectura.comun.infraestructura.error.ProductoNoEncontrado;
import com.emer.arquitectura.comun.mapper.ProductoMapper;
import com.emer.arquitectura.comun.respuesta.ObjetoRespuesta;
import com.emer.arquitectura.dominio.modelo.Producto;
import com.emer.arquitectura.dominio.useCase.ProductoUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ManejadorGuardarProducto {

    private final ProductoUseCase productoUseCase;
    private final ProductoMapper productoMapper;

    public Mono<ObjetoRespuesta<Producto>> ejecutarGuardar(ProductoComando productoComando) {
        Producto producto = productoMapper.productoComandoToProducto(productoComando);
        return productoUseCase.guardarProducto(producto).map(p -> new ObjetoRespuesta<>(p));
    }

    public Mono<ObjetoRespuesta<Producto>> ejecutarActualizar(ProductoComando productoComando, String id) {

        return productoUseCase.obtenerProductoPorId(id)
                .switchIfEmpty(Mono.error(new ProductoNoEncontrado("Producto no encontrado.")))
                .flatMap(p -> {
                    Producto producto = productoMapper.productoComandoToProducto(productoComando);
                    producto.setId(id);
                    return productoUseCase.guardarProducto(producto);
                }).map(p -> new ObjetoRespuesta<>(p));
    }
}
