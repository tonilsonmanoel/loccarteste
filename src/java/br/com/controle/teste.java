/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle;

import br.com.DAO.ManterLocacoes;

/**
 *
 * @author Tonilson
 */
public class teste {
    public static void main(String[] args) throws Exception {
        
        ManterLocacoes dao = new ManterLocacoes();
        
        double valor = dao.valorPagoLocacao(7);
        System.out.println("Valor: " +valor );
    }
}
