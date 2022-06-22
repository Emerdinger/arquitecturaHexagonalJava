package com.emer.arquitectura.infraestructura.persistencia.dao;

import com.emer.arquitectura.infraestructura.persistencia.entidad.ProductoEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductoDao extends ReactiveMongoRepository<ProductoEntity, String> {
}
