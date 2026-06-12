package org.example;

import org.example.enums.TipoSimbolo;

public class SimboloEntrada {
    String nome;
    TipoSimbolo tipo;
    int deslocamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoSimbolo getTipo() {
        return tipo;
    }

    public void setTipo(TipoSimbolo tipo) {
        this.tipo = tipo;
    }

    public int getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(int deslocamento) {
        this.deslocamento = deslocamento;
    }

    public SimboloEntrada(String nome, TipoSimbolo tipo, int deslocamento) {
        this.nome = nome;
        this.tipo = tipo;
        this.deslocamento = deslocamento;
    }
}
