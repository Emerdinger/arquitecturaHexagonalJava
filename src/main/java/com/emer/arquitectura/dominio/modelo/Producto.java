package com.emer.arquitectura.dominio.modelo;

import com.emer.arquitectura.comun.persistencia.Modelo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Producto extends Modelo<String> {

    private String nombre;
    private String descripcion;
    private String marca;
    private String categoria;
    private int cantidad;
    private double precio;
    private LocalDate createdAt;
    private String img;

    public Producto(){super(null);}

    public Producto(String id,
                    String nombre,
                    String descripcion,
                    String marca,
                    String categoria,
                    int cantidad,
                    double precio,
                    LocalDate createdAt,
                    String img) {
        super(id);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
        this.createdAt = createdAt;
        this.img = img;
    }

}
