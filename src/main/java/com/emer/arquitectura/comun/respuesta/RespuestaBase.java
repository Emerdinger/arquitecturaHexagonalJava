package com.emer.arquitectura.comun.respuesta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaBase {

    private String mensaje;
    public static RespuestaBase ok(String mensaje) {return new RespuestaBase(mensaje);}
}
