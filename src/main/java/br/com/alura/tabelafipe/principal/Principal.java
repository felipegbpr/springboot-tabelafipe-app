package br.com.alura.tabelafipe.principal;

import br.com.alura.tabelafipe.service.ConsumoApi;

import java.util.Scanner;

public class Principal {

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoApi consumo = new ConsumoApi();
    Scanner leitura = new Scanner(System.in);

    public void exibeMenu() {
        var menu = """
                *** Opções ***
                Carro 
                Moto
                Caminhão
                
                Digite uma das opções para consultar:  
                """;

        System.out.println(menu);
        var opcao = leitura.nextLine();
        String endereco;

        if (opcao.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);
    }

}
