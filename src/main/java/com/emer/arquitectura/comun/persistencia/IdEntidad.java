package com.emer.arquitectura.comun.persistencia;

public interface IdEntidad<ID>{

    public interface Atributos {
        String ID = "id";
    }

    ID getId();

    void setId(ID id);
}
