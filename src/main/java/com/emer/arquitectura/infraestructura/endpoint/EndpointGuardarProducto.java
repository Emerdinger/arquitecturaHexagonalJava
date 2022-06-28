package com.emer.arquitectura.infraestructura.endpoint;

import com.emer.arquitectura.aplicacion.comando.ProductoComando;
import com.emer.arquitectura.aplicacion.manejador.ManejadorGuardarProducto;
import com.emer.arquitectura.comun.respuesta.ObjetoRespuesta;
import com.emer.arquitectura.dominio.modelo.Producto;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
@RequestMapping("productos")
@RequiredArgsConstructor
public class EndpointGuardarProducto {

    private final ManejadorGuardarProducto manejadorGuardarProducto;

    @PostMapping
    public Mono<ObjetoRespuesta<Producto>> ejecutarGuardarProducto(@NotNull @RequestBody ProductoComando productoComando) {
        return manejadorGuardarProducto.ejecutarGuardar(productoComando);
    }

    @PutMapping("/{id}")
    public Mono<ObjetoRespuesta<Producto>> ejecutarActualizarProducto(@PathVariable String id, @NotNull @RequestBody ProductoComando productoComando) {
        return manejadorGuardarProducto.ejecutarActualizar(productoComando, id);
    }
}
