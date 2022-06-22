package com.emer.arquitectura.comun.infraestructura.error;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
@Log4j2
public class ManejadorErrores {

    private static final int OCURRIO_UN_ERROR_INESPERADO_CODIGO = HttpStatus.BAD_REQUEST.value();
    private static final String OCURRIO_UN_ERROR_INESPERADO_MENSAJE = "Ocurrió un error inesperado, por favor contacte al administrador";
    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ManejadorErrores() {
        CODIGOS_ESTADO.put(
                TestError.class.getSimpleName(), HttpStatus.BAD_REQUEST.value()
        );
        CODIGOS_ESTADO.put(
                ProductoNoEncontrado.class.getSimpleName(), HttpStatus.NOT_FOUND.value()
        );
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> resultadoError;

        String nombreExcepcion = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer code = CODIGOS_ESTADO.get(nombreExcepcion);

        log.error(exception.getMessage(), exception);

        if (code != null) {
            Error error = new Error(nombreExcepcion, mensaje, code);
            error.setStackTrace(new StackTraceElement[]{});
            resultadoError = new ResponseEntity<>(error, HttpStatus.valueOf(code));
        } else {
            Error error = new Error(nombreExcepcion, OCURRIO_UN_ERROR_INESPERADO_MENSAJE, OCURRIO_UN_ERROR_INESPERADO_CODIGO);
            error.setStackTrace(new StackTraceElement[]{});
            resultadoError = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resultadoError;
    }
}
