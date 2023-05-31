/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.controle.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Tonilson
 */
public class ManterCliente extends DAO{

     public void cadastrarCliente(Cliente c){
         try {
             abrirBanco();
             String query = "INSERT INTO cliente(id,nome,cpf,endereco,telefone,email,cep) values(null,?,?,?,?,?,?) ";
             ps = con.prepareStatement(query);
             ps.setString(1,c.getNome());
             ps.setString(2, c.getCpf());
             ps.setString(3, c.getEndereco());
             ps.setString(4, c.getTelefone());
             ps.setString(5, c.getEmail());
             ps.setString(6, c.getCep());
             ps.execute();
             
             fecharBanco();
         } catch (Exception e) {
             System.out.println("Error"+ e.getMessage());
         }
         
     }
    

    public ArrayList pesquisarTudoCliente(){
        ArrayList<Cliente> lista  = new ArrayList<Cliente>();
        try {
            abrirBanco();
            String query= "select * FROM cliente";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Cliente ntcben;
            while(rs.next()){
                ntcben = new Cliente();
                ntcben.setCodigo(rs.getInt("id"));
                ntcben.setNome(rs.getString("nome"));
                ntcben.setCpf(rs.getString("cpf"));
                ntcben.setEndereco(rs.getString("endereco"));
                ntcben.setTelefone(rs.getString("telefone"));
                ntcben.setEmail(rs.getString("email"));
                ntcben.setCep(rs.getString("cep"));
                lista.add(ntcben);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
        return lista;
    }
    
    public void deletarCliente(Cliente c){
        try {
            abrirBanco();
            String query = "DELETE FROM cliente where id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, c.getCodigo());
            ps.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
    
    public void editarCliente(Cliente c){
        try {
            abrirBanco();
            String query="UPDATE cliente set nome =?, cpf =?, endereco = ?, telefone=?, email= ?, cep=? WHERE cliente.id=?";
            
            ps= con.prepareStatement(query);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getEndereco());
            ps.setString(4,c.getTelefone());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getCep());
            ps.setInt(7, c.getCodigo());
            ps.executeUpdate();
            fecharBanco();
            
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
}
