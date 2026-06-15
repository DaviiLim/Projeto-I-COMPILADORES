package org.example;

import org.example.enums.TipoInstrucao;

public class Instrucao3AC {

    public TipoInstrucao tipo;
    public String destino;
    public String operando1;
    public String operando2;
    public String operador;

    public Instrucao3AC(TipoInstrucao tipo, String destino,String operando1, String operando2, String operador) {
        this.tipo = tipo;
        this.destino = destino;
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operador = operador;
    }

    @Override
    public String toString() {
        if (tipo == TipoInstrucao.ATRIBUICAO) {
            return destino + " = " + operando1;
        } else if (tipo == TipoInstrucao.OPERACAO) {
            return destino + " = " + operando1 + " " + operador + " " + operando2;
        } else if (tipo == TipoInstrucao.DESVIO_COND) {
            return "IF " + operando1 + " == 0 GOTO " + destino;
        } else if (tipo == TipoInstrucao.DESVIO_INCOND) {
            return "GOTO " + destino;
        } else if (tipo == TipoInstrucao.ROTULO) {
            return destino + ":";
        } else if (tipo == TipoInstrucao.CHAMADA_WRITE) {
            return "WRITE(" + operando1 + ")";
        } else if (tipo == TipoInstrucao.CHAMADA_READ) {
            return "READ(" + operando1 + ")";
        } else {
            return "";
        }
    }

    public TipoInstrucao getTipo() {
        return tipo;
    }

    public void setTipo(TipoInstrucao tipo) {
        this.tipo = tipo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOperando1() {
        return operando1;
    }

    public void setOperando1(String operando1) {
        this.operando1 = operando1;
    }

    public String getOperando2() {
        return operando2;
    }

    public void setOperando2(String operando2) {
        this.operando2 = operando2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
}