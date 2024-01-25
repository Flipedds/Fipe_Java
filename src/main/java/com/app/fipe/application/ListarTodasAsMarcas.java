package com.app.fipe.application;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import com.app.fipe.domain.IConverteDados;
import com.app.fipe.domain.Marca;
import com.app.fipe.infra.ConsumoApi;
import com.app.fipe.infra.ConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ListarTodasAsMarcas {
    private static IConverteDados<Marca[]> converteDados = new ConverteDados<>();

    public static void executa(String tipo) throws JsonMappingException, JsonProcessingException {
        String url = "https://parallelum.com.br/fipe/api/v1/" + tipo + "/marcas";
        String json = ConsumoApi.executa(url);
        List<Marca> marcas = Arrays.asList(converteDados.obterDados(json, Marca[].class));
        marcas.stream()
                .sorted(Comparator.comparingInt(marca -> Integer.parseInt(marca.codigo())))
                .forEach(marca -> {
                    System.out.println("Cód: " + marca.codigo() + " Descrição: " + marca.nome());
                });
    }
}