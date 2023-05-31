/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.controle.Funcionario;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Tonilson
 */
public class ManterFuncionario extends DAO{
    
    public void cadastrarFuncionario(Funcionario c){
         try {
             abrirBanco();
             String query = "INSERT INTO funcionarios(id,nome,cpf,endereco,cep,telefone,email,senha) values(null,?,?,?,?,?,?,?) ";
             ps = con.prepareStatement(query);
             ps.setString(1,c.getNome());
             ps.setString(2, c.getCpf());
             ps.setString(3, c.getEndereco());
             ps.setString(4, c.getCep());
             ps.setString(5, c.getTelefone());
             ps.setString(6, c.getEmail());
             ps.setString(7, c.getSenha());
             ps.execute();
             
             fecharBanco();
         } catch (Exception e) {
             System.out.println("Error"+ e.getMessage());
         }
    }
    
    public void deletarFuncioario(Funcionario c){
        try {
            abrirBanco();
            String query = "DELETE FROM funcionarios where id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, c.getCodigo());
            ps.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
    
    public void editaFuncionario(Funcionario c){
        try {
            abrirBanco();
            String query="UPDATE funcionarios set nome =?, cpf =?, endereco = ?,cep = ?, telefone=?, email= ?,senha= ?  where id=?";
            ps= con.prepareStatement(query);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getEndereco());
            ps.setString(4, c.getCep());
            ps.setString(5,c.getTelefone());
            ps.setString(6, c.getEmail());
            ps.setString(7, c.getSenha());
            ps.setInt(8, c.getCodigo());
            ps.executeUpdate();
            fecharBanco();
            
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
    public ArrayList<Funcionario> pesquisaTudoFuncionario(){
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        try {
            abrirBanco();
            String query = "SELECT * FROM funcionarios";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Funcionario func;
            while(rs.next()){
                func = new Funcionario();
               func.setCodigo(rs.getInt("id"));
               func.setNome(rs.getString("nome"));
               func.setCpf(rs.getString("cpf"));
               func.setEndereco(rs.getString("endereco"));
               func.setCep(rs.getString("cep"));
               func.setTelefone(rs.getString("telefone"));
               func.setEmail(rs.getString("email"));
               func.setSenha(rs.getString("senha"));
               lista.add(func);
            }
            fecharBanco();
           
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return lista;
    }
    
    public Funcionario login(String email, String senha) {
        Funcionario ntcben = new Funcionario();
        try {
            abrirBanco();
            String query = "SELECT * FROM funcionarios WHERE email = ? and senha = ?";
            ps= con.prepareStatement(query);
            ps.setString(1,email);
            ps.setString(2,senha);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ntcben.setCodigo(rs.getInt("id"));
                ntcben.setNome(rs.getString("nome"));
                ntcben.setCpf(rs.getString("cpf"));
                ntcben.setEndereco(rs.getString("endereco"));
                ntcben.setTelefone(rs.getString("telefone"));
                ntcben.setCep(rs.getString("cep"));
                ntcben.setEmail(rs.getString("email"));
                ntcben.setSenha(rs.getString("senha"));
                
            }
            fecharBanco();
            return ntcben;
           
        } catch (Exception e) {
            System.out.println("Erro" + e.getMessage());
        }
        return null;
    }
}
