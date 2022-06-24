package com.emer.arquitectura.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoComando {

    private String nombre;
    private String descripcion;
    private String marca;
    private String categoria;
    private int cantidad;
    private double precio;
    private String img;

}
