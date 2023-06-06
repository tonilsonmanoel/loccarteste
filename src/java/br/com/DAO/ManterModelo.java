/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.controle.Modelo;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Tonilson
 */
public class ManterModelo extends DAO {
    
    public ArrayList<Modelo> pesquisaTudoModelo(){
        ArrayList<Modelo> lista = new ArrayList<Modelo>();
        try {
            abrirBanco();
            String query = "SELECT MO.*, MA.nome as Marcas FROM modelos as MO\n" +
                           "inner join marcas as MA ON MO.marcas_id = Ma.id ORDER BY id ;";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Modelo modelo;
            while(rs.next()){
                modelo = new Modelo();
               modelo.setId(rs.getInt("id"));
               modelo.setNome(rs.getString("nome"));
               modelo.setMarca(rs.getString("Marcas"));
               modelo.setMarcas_id(rs.getInt("marcas_id"));
               lista.add(modelo);
            }
            fecharBanco();
           
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return lista;
    }
    public Modelo totalModelo(){
        Modelo func = new Modelo();
        try {
            abrirBanco();
            String query = "select count(*) as totalId from modelos;";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
               func.setId(rs.getInt("totalId"));
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return func;
    } 
    
    
    public void cadastrarModelo(Modelo c){
         try {
             abrirBanco();
             String query = "INSERT INTO modelos(id,nome,marcas_id) values(null,?,?)";
             ps = con.prepareStatement(query);
             ps.setString(1,c.getNome());
             ps.setInt(2,c.getMarcas_id());
             ps.execute();
             
             fecharBanco();
         } catch (Exception e) {
             System.out.println("Error"+ e.getMessage());
         }
         
     }
    
    public void editarModelo(Modelo c){
        try {
            abrirBanco();
            String query="UPDATE modelos set nome =?, marcas_id = ? WHERE modelos.id=?";
            ps= con.prepareStatement(query);
            ps.setString(1, c.getNome());
            ps.setInt(2, c.getMarcas_id());
            ps.setInt(3, c.getId());
            ps.executeUpdate();
            fecharBanco();
            
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
    
    public void deletarModelo(Modelo c){
        try {
            abrirBanco();
            String query = "DELETE FROM modelos where id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, c.getId());
            ps.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
}
