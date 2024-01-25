package com.app.fipe.infra;

import com.app.fipe.domain.IConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados<T> implements IConverteDados<T> {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public T obterDados(String json, Class<T> classe) throws JsonMappingException, JsonProcessingException {
        return mapper.readValue(json, classe);
    }
}