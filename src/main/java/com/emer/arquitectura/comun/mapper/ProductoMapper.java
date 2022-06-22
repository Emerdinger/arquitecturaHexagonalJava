package com.emer.arquitectura.comun.mapper;

import com.emer.arquitectura.aplicacion.comando.ProductoComando;
import com.emer.arquitectura.dominio.modelo.Producto;
import com.emer.arquitectura.infraestructura.persistencia.entidad.ProductoEntity;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ProductoMapper {
    ProductoEntity productoToProductoEntity(Producto producto);
    Producto productoEntityToProducto(ProductoEntity productoEntity);
    Producto productoComandoToProducto(ProductoComando productoComando);

    default List<Producto> toProductoList(List<ProductoEntity> productoEntityList) {
        if (productoEntityList == null) {
            return new ArrayList<>();
        }

        return productoEntityList.stream().map(this::productoEntityToProducto).collect(Collectors.toList());
    }
}
