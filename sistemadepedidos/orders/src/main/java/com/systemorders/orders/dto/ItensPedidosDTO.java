package com.systemorders.orders.dto;

public class ItensPedidosDTO {
    String nome;
    int quantidade;
    Double preco;
    public ItensPedidosDTO(String produto, int quantidade , Double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return preco;
    }
    
}
