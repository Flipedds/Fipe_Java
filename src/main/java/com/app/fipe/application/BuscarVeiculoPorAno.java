package com.app.fipe.application;
import com.app.fipe.domain.IConverteDados;
import com.app.fipe.domain.Veiculo;
import com.app.fipe.infra.ConsumoApi;
import com.app.fipe.infra.ConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class BuscarVeiculoPorAno {
    private static IConverteDados<Veiculo> converteDados = new ConverteDados<>();

    public static void executa(String tipo, int codigo, int modeloCode, String ano) throws JsonMappingException, JsonProcessingException{
        String url = "https://parallelum.com.br/fipe/api/v1/" + tipo
                + "/marcas/" + codigo
                + "/modelos/" + modeloCode
                + "/anos/" + ano;
        String json = ConsumoApi.executa(url);
        Veiculo veiculo = converteDados.obterDados(json, Veiculo.class);
        System.out.println(veiculo);
    }
}