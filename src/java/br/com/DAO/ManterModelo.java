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
                           "inner join marcas as MA ON MO.marcas_id = Ma.id;";
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
    
}
