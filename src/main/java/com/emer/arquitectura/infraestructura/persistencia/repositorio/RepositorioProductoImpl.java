package com.emer.arquitectura.infraestructura.persistencia.repositorio;

import com.emer.arquitectura.comun.infraestructura.error.ProductoNoEncontrado;
import com.emer.arquitectura.comun.mapper.ProductoMapper;
import com.emer.arquitectura.dominio.modelo.Producto;
import com.emer.arquitectura.dominio.repositorio.ProductoRepositorio;
import com.emer.arquitectura.infraestructura.persistencia.dao.ProductoDao;
import com.emer.arquitectura.infraestructura.persistencia.entidad.ProductoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class RepositorioProductoImpl implements ProductoRepositorio {

    private final ProductoDao productoDao;
    private final ProductoMapper productoMapper;

    @Override
    public Mono<Producto> guardarProducto(Producto producto) {
        ProductoEntity product = productoMapper.productoToProductoEntity(producto);
        return productoDao.save(product).map(p -> productoMapper.productoEntityToProducto(p));
    }

    @Override
    public Mono<Producto> obtenerProductoPorId(String id) {
        return productoDao.findById(id).map(p -> productoMapper.productoEntityToProducto(p));
    }

    @Override
    public Flux<Producto> obtenerTodos() {
        return productoDao.findAll().map(p -> productoMapper.productoEntityToProducto(p));
    }

    @Override
    public Mono<Void> eliminarPorId(String id) {
        return productoDao.deleteById(id);
    }

    @Override
    public Mono<Void> eliminarTodos() {
        return productoDao.deleteAll();
    }
}
