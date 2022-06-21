package com.emer.arquitectura.comun.respuesta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjetoRespuesta<T> extends  RespuestaBase implements Serializable {

    private T dato;

    public ObjetoRespuesta(T dato) {
        this(HttpStatus.OK, dato);
    }

    public ObjetoRespuesta(String mensaje, T dato) {
        super(mensaje);
        this.dato = dato;
    }

    public ObjetoRespuesta(@NotNull HttpStatus status, T dato) {
        super(status.getReasonPhrase());
        this.dato = dato;
    }

    public ObjetoRespuesta(HttpStatus status, String mensaje, T dato) {
        super(mensaje);
        this.dato = dato;
    }
}
