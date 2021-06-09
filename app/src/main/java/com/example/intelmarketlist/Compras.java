package com.example.intelmarketlist;

import java.util.ArrayList;
import java.util.List;

public class Compras {
    public String nome;
    public float valor;

    public Compras(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getValor() {
        return String.valueOf(valor);
    }

    public static List<Compras> getCompras(){
        List<Compras> compras = new ArrayList<Compras>();

        for (int i = 0; i < 20; i++)
            compras.add(new Compras("Compra "+i, (float) 1.0));

        return compras;
    }
}
