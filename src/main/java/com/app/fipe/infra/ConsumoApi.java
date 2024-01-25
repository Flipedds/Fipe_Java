package com.app.fipe.infra;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public static String executa(String url){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
        HttpResponse<String> response = null;
         try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("Erro -> erro ao consumir api" + e.getMessage());
        }
        String json = response.body();
        return json;
    }
}