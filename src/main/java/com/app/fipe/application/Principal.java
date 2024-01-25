package com.app.fipe.application;

import java.util.Scanner;

public class Principal {
    private static Scanner leitura = new Scanner(System.in);

    public static void executa() {
        try {
            menu();
            String tipo = leitura.next();
            ListarTodasAsMarcas.executa(tipo);
            System.out.println("Digite o codigo da marca que deseja ver os modelos:");
            int codigo = leitura.nextInt();
            ListarModelos.executa(tipo, codigo);
            System.out.println("Digite um trecho do nome do veículo para consulta:");
            String nomeVeiculo = leitura.next();
            FiltrarModelos.executa(tipo, codigo, nomeVeiculo);
            System.out.println("Digite o código do modelo para consultar valores:");
            int modeloCode = leitura.nextInt();
            ListarPorAno.executa(tipo, codigo, modeloCode);
        } catch (Exception e) {
            System.out.println("Erro -> erro na aplicação" + e.getMessage());
        }
    }

    private static void menu() {
        System.out.println(
                "**** OPÇÕES ****\r\n" + //
                        "\r\n" + //
                        "carros\r\n" + //
                        "\r\n" + //
                        "motos\r\n" + //
                        "\r\n" + //
                        "caminhoes\r\n" + //
                        "\r\n" + //
                        "Digite uma das opções para consultar as marcas:");
    }
}