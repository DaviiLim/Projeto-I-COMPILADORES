package org.example;

import java.util.HashMap;

public class TabelaSimbolos {
    private HashMap<String, SimboloEntrada> tabelaSimbolo;
    private TabelaSimbolos pai;
    private int deslocamentoAtual;

    public TabelaSimbolos(HashMap<String, SimboloEntrada> tabelaSimbolo, TabelaSimbolos pai, int deslocamentoAtual) {
        this.tabelaSimbolo = tabelaSimbolo;
        this.pai = pai;
        this.deslocamentoAtual = deslocamentoAtual;
    }

    public void inserir(String nome, String tipo) {
        // ...
    }

    public SimboloEntrada buscar(String nome) {
        // ...
    }
}
