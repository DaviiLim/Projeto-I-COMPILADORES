package org.example;

import org.example.enums.TipoSimbolo;

import java.util.HashMap;
import java.util.Map;

public class GeradorAssembly {

    public StringBuilder gerarSecaoDados(TabelaSimbolos tabelaGlobal) {
        StringBuilder sb = new StringBuilder();
        sb.append(".data\n");

        HashMap<String, SimboloEntrada> tabela = tabelaGlobal.getTabelaSimbolo();
        for (Map.Entry<String, SimboloEntrada> entrada : tabela.entrySet()) {
            String diretiva;
            String nomeVar = entrada.getKey();
            SimboloEntrada simbolo = entrada.getValue();

            if (simbolo.getTipo() == TipoSimbolo.BOOLEAN) {
                diretiva = "db";
            } else {
                diretiva = "dw";
            }

            sb.append(nomeVar + " " + diretiva + " ?\n");

        }
        return sb;
    }
}