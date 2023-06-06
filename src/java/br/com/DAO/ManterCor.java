/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.controle.Cor;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Tonilson
 */
public class ManterCor extends DAO {
    
    public ArrayList<Cor> pesquisaTudoCor(){
        ArrayList<Cor> lista = new ArrayList<Cor>();
        try {
            abrirBanco();
            String query = "SELECT * FROM cores ORDER BY id";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Cor cor;
            while(rs.next()){
                cor = new Cor();
               cor.setCodigo(rs.getInt("id"));
               cor.setNome(rs.getString("nome"));
               lista.add(cor);
            }
            fecharBanco();
           
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return lista;
    }
    
     public Cor totalCor(){
        Cor func = new Cor();
        try {
            abrirBanco();
            String query = "select count(*) as totalId from cores;";
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
    
    public void cadastrarCor(Cor c){
         try {
             abrirBanco();
             String query = "INSERT INTO cores(id,nome) values(null,?)";
             ps = con.prepareStatement(query);
             ps.setString(1,c.getNome());
             ps.execute();
             
             fecharBanco();
         } catch (Exception e) {
             System.out.println("Error"+ e.getMessage());
         }
         
     }
   
    public void editarCor(Cor c){
        try {
            abrirBanco();
            String query="UPDATE cores set nome =? WHERE cores.id=?";
            ps= con.prepareStatement(query);
            ps.setString(1, c.getNome());
            ps.setInt(2, c.getCodigo());
            ps.executeUpdate();
            fecharBanco();
            
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
    
     public void deletarCor(Cor c){
        try {
            abrirBanco();
            String query = "DELETE FROM cores where id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, c.getCodigo());
            ps.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
}
