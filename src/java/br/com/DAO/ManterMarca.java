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
    
    public ArrayList<Marca> pesquisaTudoMarca(){
        ArrayList<Marca> lista = new ArrayList<Marca>();
        try {
            abrirBanco();
            String query = "SELECT * FROM marcas";
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
}
