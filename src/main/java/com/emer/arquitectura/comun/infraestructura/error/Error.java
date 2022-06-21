package com.emer.arquitectura.comun.infraestructura.error;

import lombok.Getter;

@Getter
public class Error extends Throwable{

    private final String nombreExcepcion;
    private final String mensaje;
    private final int code;

    public Error(String nombreExcepcion, String mensaje, int code) {
        this.nombreExcepcion = nombreExcepcion;
        this.mensaje = mensaje;
        this.code = code;
    }

}
