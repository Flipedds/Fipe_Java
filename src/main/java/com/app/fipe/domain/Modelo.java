package com.app.fipe.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelo(@JsonAlias("codigo") String codigo, 
                     @JsonAlias("nome") String nome){}