package com.app.fipe.application;

import java.util.Comparator;
import java.util.List;
import com.app.fipe.domain.IConverteDados;
import com.app.fipe.domain.Modelo;
import com.app.fipe.domain.ModeloWrapper;
import com.app.fipe.infra.ConsumoApi;
import com.app.fipe.infra.ConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ListarModelos {
    private static IConverteDados<ModeloWrapper> converteDados = new ConverteDados<>();

    public static void executa(String tipo, int codigo) throws JsonMappingException, JsonProcessingException {
        String url = "https://parallelum.com.br/fipe/api/v1/" + tipo + "/marcas/" + codigo + "/modelos";
        String json = ConsumoApi.executa(url);
        ModeloWrapper modeloWrapper = converteDados.obterDados(json, ModeloWrapper.class);
        List<Modelo> modelos = modeloWrapper.getModelos();
        modelos.stream()
                .sorted(Comparator.comparingInt(modelo -> Integer.parseInt(modelo.codigo())))
                .forEach(modelo -> {
                    System.out.println("Cód: " + modelo.codigo() + " Descrição: " + modelo.nome());
                });
    }
}