/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.controle.Marca;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Tonilson
 */
public class ManterMarca extends DAO {
    
    public ArrayList<Marca> pesquisaTudoMarcaTabela(int start, int total){
        ArrayList<Marca> lista = new ArrayList<Marca>();
        try {
            abrirBanco();
            String query = "SELECT * FROM marcas ORDER BY id limit "+(start)+","+(total);
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Marca ma;
            while(rs.next()){
               ma = new Marca();
               ma.setCodigo(rs.getInt("id"));
               ma.setNome(rs.getString("nome"));
               lista.add(ma);
            }
            fecharBanco();
           
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return lista;
    }
    
    public ArrayList<Marca> pesquisaTudoMarca(){
        ArrayList<Marca> lista = new ArrayList<Marca>();
        try {
            abrirBanco();
            String query = "SELECT * FROM marcas ORDER BY id";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Marca ma;
            while(rs.next()){
               ma = new Marca();
               ma.setCodigo(rs.getInt("id"));
               ma.setNome(rs.getString("nome"));
               lista.add(ma);
            }
            fecharBanco();
           
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return lista;
    }
    
    public Marca totalMarca(){
        Marca func = new Marca();
        try {
            abrirBanco();
            String query = "select count(*) as totalId from marcas;";
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
    
    public void cadastrarMarca(Marca c){
         try {
             abrirBanco();
             String query = "INSERT INTO marcas(id,nome) values(null,?)";
             ps = con.prepareStatement(query);
             ps.setString(1,c.getNome());
             ps.execute();
             
             fecharBanco();
         } catch (Exception e) {
             System.out.println("Error"+ e.getMessage());
         }
         
     }
    
    public void deletarMarca(Marca c){
        try {
            abrirBanco();
            String query = "DELETE FROM marcas where id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, c.getCodigo());
            ps.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
    
    public void editarMarca(Marca c){
        try {
            abrirBanco();
            String query="UPDATE marcas set nome =? WHERE marcas.id=?";
            ps= con.prepareStatement(query);
            ps.setString(1, c.getNome());
            ps.setInt(2, c.getCodigo());
            ps.executeUpdate();
            fecharBanco();
            
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
}
