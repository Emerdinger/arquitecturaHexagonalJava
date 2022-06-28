package com.emer.arquitectura.comun.mapper.impl;

import com.emer.arquitectura.aplicacion.comando.ProductoComando;
import com.emer.arquitectura.comun.mapper.ProductoMapper;
import com.emer.arquitectura.dominio.modelo.Producto;
import com.emer.arquitectura.infraestructura.persistencia.entidad.ProductoEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProductoMapperImpl  implements ProductoMapper {
    @Override
    public ProductoEntity productoToProductoEntity(Producto producto) {
        if (producto == null) return null;

        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setId(producto.getId());
        productoEntity.setNombre(producto.getNombre());
        productoEntity.setCantidad(producto.getCantidad());
        productoEntity.setCategoria(producto.getCategoria());
        productoEntity.setMarca(producto.getMarca());
        productoEntity.setPrecio(producto.getPrecio());
        productoEntity.setDescripcion(producto.getDescripcion());
        productoEntity.setCreatedAt(producto.getCreatedAt());
        productoEntity.setImg(producto.getImg());
        return productoEntity;
    }

    @Override
    public Producto productoEntityToProducto(ProductoEntity productoEntity) {
        if (productoEntity == null) return null;

        Producto producto = new Producto();
        producto.setId(productoEntity.getId());
        producto.setNombre(productoEntity.getNombre());
        producto.setCantidad(productoEntity.getCantidad());
        producto.setCategoria(productoEntity.getCategoria());
        producto.setMarca(productoEntity.getMarca());
        producto.setPrecio(productoEntity.getPrecio());
        producto.setDescripcion(productoEntity.getDescripcion());
        producto.setCreatedAt(productoEntity.getCreatedAt());
        producto.setImg(productoEntity.getImg());
        return producto;
    }

    @Override
    public Producto productoComandoToProducto(ProductoComando productoComando) {
        if (productoComando == null) return null;

        Producto producto = new Producto();
        producto.setId(null);
        producto.setNombre(productoComando.getNombre());
        producto.setCantidad(productoComando.getCantidad());
        producto.setCategoria(productoComando.getCategoria());
        producto.setMarca(productoComando.getMarca());
        producto.setPrecio(productoComando.getPrecio());
        producto.setDescripcion(productoComando.getDescripcion());
        producto.setCreatedAt(LocalDate.now());
        producto.setImg(productoComando.getImg());
        return producto;
    }
}
