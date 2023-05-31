/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.controle.FormaPagamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tonilson
 */
public class ManterFomarPagamento extends DAO{
    
    public void cadastrarFormaPagamento(FormaPagamento c){
         try {
             abrirBanco();
             String query = "INSERT INTO pagamentos(id,nome) values(null,?)";
             ps = con.prepareStatement(query);
             ps.setString(1,c.getNome());
             ps.execute();
             fecharBanco();
         } catch (Exception e) {
             System.out.println("Error"+ e.getMessage());
         }
    }
    
    public void deletarFormaPagamento(FormaPagamento c){
        try {
            abrirBanco();
            String query = "DELETE FROM pagamentos where id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, c.getCodigo());
            ps.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
    
     public ArrayList<FormaPagamento> pesquisaTudoForma(){
        ArrayList<FormaPagamento> lista = new ArrayList<FormaPagamento>();
        try {
            abrirBanco();
            String query = "SELECT * FROM pagamentos ";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            FormaPagamento func;
            while(rs.next()){
                func = new FormaPagamento();
               func.setCodigo(rs.getInt("id"));
               func.setNome(rs.getString("nome"));
               lista.add(func);
            }
            fecharBanco();
           
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return lista;
    }
     
     
    public ArrayList<FormaPagamento> pesquisaPagamagento(int start, int total){
        ArrayList<FormaPagamento> lista = new ArrayList<FormaPagamento>();
        try {
            abrirBanco();
            String query = "SELECT * FROM pagamentos limit "+(start)+","+(total);
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            FormaPagamento func;
            while(rs.next()){
                func = new FormaPagamento();
               func.setCodigo(rs.getInt("id"));
               func.setNome(rs.getString("nome"));
               lista.add(func);
            }
            fecharBanco();
           
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return lista;
    } 
     
     public void editarFormaPagamento(FormaPagamento c){
        try {
            abrirBanco();
            String query="UPDATE pagamentos set nome =? where id=?";
            ps= con.prepareStatement(query);
            ps.setString(1, c.getNome());
            ps.setInt(2, c.getCodigo());
            ps.executeUpdate();
            fecharBanco();
            
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
     
   public FormaPagamento totalFormaPagamento(){
        FormaPagamento func = new FormaPagamento();
        try {
            abrirBanco();
            String query = "select count(*) as totalId from pagamentos;";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
               func.setCodigo(rs.getInt("totalId"));
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return func;
    } 
}
