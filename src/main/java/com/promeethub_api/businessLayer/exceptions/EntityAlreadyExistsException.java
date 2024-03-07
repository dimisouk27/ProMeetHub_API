package com.promeethub_api.businessLayer.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(String uniqueField, Object value) {
        super("L'entité avec le champ {" +uniqueField+" = "+value+"} existe déjà");
    }

    public EntityAlreadyExistsException(String uniqueField, Object value, String where) {
        super("L'entité avec le champ {" +uniqueField+" = "+value+"} existe déjà "+ where);
    }

    public EntityAlreadyExistsException(List<String> uniqueFields, List<Object> values) {
        super("L'entité avec les champs "+uniqueFields+" = "+values+ " existe déjà");
    }
}
