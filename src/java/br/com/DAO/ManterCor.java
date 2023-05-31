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
            String query = "SELECT * FROM cores";
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
}
