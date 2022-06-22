package com.emer.arquitectura.comun.infraestructura.error;

public class ProductoNoEncontrado extends RuntimeException{
    public ProductoNoEncontrado(String mensaje){super(mensaje);}
}
