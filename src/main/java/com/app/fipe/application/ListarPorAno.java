package com.app.fipe.application;

import java.util.Arrays;
import java.util.List;
import com.app.fipe.domain.Ano;
import com.app.fipe.domain.IConverteDados;
import com.app.fipe.infra.ConsumoApi;
import com.app.fipe.infra.ConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ListarPorAno {
    private static IConverteDados<Ano[]> converteDados = new ConverteDados<>();

    public static void executa(String tipo, int codigo, int modeloCode)
            throws JsonMappingException, JsonProcessingException {
        String url = "https://parallelum.com.br/fipe/api/v1/" + tipo
                + "/marcas/" + codigo
                + "/modelos/" + modeloCode
                + "/anos";
        String json = ConsumoApi.executa(url);
        List<Ano> anos = Arrays.asList(converteDados.obterDados(json, Ano[].class));
        anos.stream()
                .forEach(
                        ano -> {
                            try {
                                BuscarVeiculoPorAno.executa(tipo, codigo, modeloCode, ano.codigo());
                            } catch (JsonProcessingException e) {
                                System.out.println(
                                        "Erro -> erro ao buscar veículo por ano !" + e.getMessage());
                            }
                        });
    }
}