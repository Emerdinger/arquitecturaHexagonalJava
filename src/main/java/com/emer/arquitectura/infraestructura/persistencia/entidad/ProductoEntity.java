package com.emer.arquitectura.infraestructura.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter @Setter
@Document(collection = "productos")
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEntity {

    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private String marca;
    private String categoria;
    private int cantidad;
    private double precio;
    private LocalDate createdAt;
    private String img;

}
