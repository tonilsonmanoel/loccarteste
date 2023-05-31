/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle;

/**
 *
 * @author Tonilson
 */
public class Locacoes {
    int codigo, placa_id,cliente_id;
    String data_inicio,data_termino,data_inicioFormat,data_terminoFormat, statusLocacoes,cliente,placa,modelo,cor;
    double valor_diaria, valor_locacao, valor_pago;
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPlaca_id() {
        return placa_id;
    }

    public void setPlaca_id(int placa_id) {
        this.placa_id = placa_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

   

    public String getData_inicio() {
        return data_inicio;
    }

    public String getData_inicioFormat() {
        return data_inicioFormat;
    }

    public void setData_inicioFormat(String data_inicioFormat) {
        this.data_inicioFormat = data_inicioFormat;
    }

    public String getData_terminoFormat() {
        return data_terminoFormat;
    }

    public void setData_terminoFormat(String data_terminoFormat) {
        this.data_terminoFormat = data_terminoFormat;
    }
    
    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_termino() {
        return data_termino;
    }

    public void setData_termino(String data_termino) {
        this.data_termino = data_termino;
    }

    public String getStatusLocacoes() {
        return statusLocacoes;
    }

    public void setStatusLocacoes(String statusLocacoes) {
        this.statusLocacoes = statusLocacoes;
    }

    public double getValor_diaria() {
        return valor_diaria;
    }

    public void setValor_diaria(double valor_diaria) {
        this.valor_diaria = valor_diaria;
    }

    public double getValor_locacao() {
        return valor_locacao;
    }

    public void setValor_locacao(double valor_locacao) {
        this.valor_locacao = valor_locacao;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    
}
