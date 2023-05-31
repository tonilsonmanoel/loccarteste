/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.controle.Veiculos;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Tonilson
 */
public class ManterVeiculo extends DAO{
    
    public void cadastrarVeiculo(Veiculos c){
         try {
             abrirBanco();
             String query = "INSERT INTO veiculos(id,placa,ano,disponibilidade,modelos_id ,cores_id ,marcas_id) values(null,?,?,?,?,?,?) ";
             ps = con.prepareStatement(query);
             ps.setString(1, c.getPlaca());
             ps.setInt(2, c.getAno());
             ps.setString(3, c.getDisponibilidade());
             ps.setInt(4,c.getModelo_id());
             ps.setInt(5, c.getCores_id());
             ps.setInt(6, c.getMarcas_id());
             ps.execute();
             fecharBanco();
         } catch (Exception e) {
             System.out.println("Error"+ e.getMessage());
         }
    }
    
    
    public ArrayList<Veiculos> pesquisaTudoVeiculo(){
        ArrayList<Veiculos> lista = new ArrayList<Veiculos>();
        try {
            abrirBanco();
            String query = "SELECT L.*, M.nome as Modelo, C.nome as Cor, MA.nome as Marca From veiculos as L \n" +
                            "inner join modelos as M ON L.modelos_id = M.id \n" +
                            "inner join cores as C ON L.cores_id = C.id\n" +
                            "inner join marcas as MA ON L.marcas_id  = MA.id ;";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Veiculos func;
            while(rs.next()){
                func = new Veiculos();
               func.setId(rs.getInt("id"));
               func.setPlaca(rs.getString("placa"));
               func.setAno(rs.getInt("ano"));
               func.setDisponibilidade(rs.getString("disponibilidade"));
               func.setModelo_id(rs.getInt("modelos_id"));
               func.setCores_id(rs.getInt("cores_id"));
               func.setMarcas_id(rs.getInt("marcas_id"));
               func.setMarcas(rs.getString("Marca"));
               func.setModelo(rs.getString("Modelo"));
               func.setCor(rs.getString("Cor"));
               lista.add(func);
            }
            fecharBanco();
           
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return lista;
    }
    
    
     public void atulizarStatusVeiculo(Veiculos c){
        try {
            abrirBanco();
            String query="UPDATE veiculos set disponibilidade = ? where id=?";
            ps= con.prepareStatement(query);
            ps.setString(1, c.getDisponibilidade());
            ps.setInt(2, c.getId());
            ps.executeUpdate();
            fecharBanco();
            
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
   
      
    
    public ArrayList<Veiculos> pesquisaVeiculoDisponivel(){
        ArrayList<Veiculos> lista = new ArrayList<Veiculos>();
        try {
            abrirBanco();
            String query = "SELECT L.*, M.nome as Modelo, C.nome as Cor, MA.nome as Marca From veiculos as L \n" +
                            "inner join modelos as M ON L.modelos_id = M.id\n" +
                            "inner join cores as C ON L.cores_id = C.id\n" +
                            "inner join marcas as MA ON L.marcas_id  = MA.id  WHERE disponibilidade= \"DISPONIVEL\";";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Veiculos func;
            while(rs.next()){
                func = new Veiculos();
               func.setId(rs.getInt("id"));
               func.setPlaca(rs.getString("placa"));
               func.setAno(rs.getInt("ano"));
               func.setDisponibilidade(rs.getString("disponibilidade"));
               func.setModelo_id(rs.getInt("modelos_id"));
               func.setCores_id(rs.getInt("cores_id"));
               func.setMarcas_id(rs.getInt("marcas_id"));
               func.setMarcas(rs.getString("Marca"));
               func.setModelo(rs.getString("Modelo"));
               func.setCor(rs.getString("Cor"));
               lista.add(func);
            }
            fecharBanco();
           
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return lista;
    }
}
