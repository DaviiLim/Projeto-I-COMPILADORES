package org.example;

import org.example.enums.TipoSimbolo;

import java.util.HashMap;

public class TabelaSimbolos {
    private HashMap<String, SimboloEntrada> tabelaSimbolo;
    private TabelaSimbolos pai;

    private int deslocamentoAtual;

    public TabelaSimbolos(TabelaSimbolos pai) {
        this.tabelaSimbolo = new HashMap<>();
        this.pai = pai;
        this.deslocamentoAtual = 0;
    }

    public void inserir(String nome, TipoSimbolo tipo) {
       SimboloEntrada simbolo = new SimboloEntrada(nome, tipo, this.deslocamentoAtual);
       this.tabelaSimbolo.put(nome, simbolo);

       if (tipo.equals(TipoSimbolo.BOOLEAN)){
           this.deslocamentoAtual += 1;
       }else {
           this.deslocamentoAtual += 2;
           // String vai ficar com 2 bytes por ora, revisar depois
       }
    }

    public SimboloEntrada buscar(String nome) {
       SimboloEntrada simbolo1 = this.tabelaSimbolo.get(nome);

       if (simbolo1 != null){
           return simbolo1;
       }
       if (this.pai != null){
           return this.pai.buscar(nome);
        }

       return null;
    }

    public HashMap<String, SimboloEntrada> getTabelaSimbolo() {
        return tabelaSimbolo;
    }

    public void setTabelaSimbolo(HashMap<String, SimboloEntrada> tabelaSimbolo) {
        this.tabelaSimbolo = tabelaSimbolo;
    }

    public TabelaSimbolos getPai() {
        return pai;
    }

    public void setPai(TabelaSimbolos pai) {
        this.pai = pai;
    }

    public int getDeslocamentoAtual() {
        return deslocamentoAtual;
    }

    public void setDeslocamentoAtual(int deslocamentoAtual) {
        this.deslocamentoAtual = deslocamentoAtual;
    }
}
