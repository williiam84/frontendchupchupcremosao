package com.systemorders.orders.dto;

import java.util.List;

public class PedidoDTO {
    String nome;
    String bairro;
    String rua;
    int numero;
    String observacao;
    Double total;
    private Integer id;
    String status;
    String formadepagamento;
    private List<ItensPedidosDTO> produto;

    public PedidoDTO(String nome, String bairro, String rua, int numero, String observacao, Double total, Integer id, String status, String formadepagamento) {
        this.nome = nome;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.observacao = observacao;
        this.total = total;
        this.id = id;
        this.status = status;
        this.formadepagamento = formadepagamento;
    }

    public PedidoDTO() {}

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public List<ItensPedidosDTO> getProduto() {
        return produto;
    }
    public void setProduto(List<ItensPedidosDTO> produto) {
        this.produto = produto;
    }
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getFormadepagamento(){
        return formadepagamento;
    }

    public void setFormadepagamento(String formadepagamento){
        this.formadepagamento = formadepagamento;
    }
}
