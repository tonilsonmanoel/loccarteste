/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.controle.Contador;
import br.com.controle.Locacoes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tonilson
 */
public class ManterLocacoes extends DAO{
    public ArrayList<Locacoes> pesquisaTudoLocacoes(){
        ArrayList<Locacoes> lista = new ArrayList<Locacoes>();
        try {
            abrirBanco();
            String query = "SELECT L.*,DATE_FORMAT(data_inicio, '%d/%m/%Y') AS dataInicioFormat,DATE_FORMAT(data_termino, '%d/%m/%Y') AS dataTerminoFormat,C.nome as Cliente, V.placa as Placa,CR.nome as Cor, M.nome as Modelo, M.id as ModeloID\n" +
                            "FROM locacoes as L\n" +
                            "inner join veiculos as V ON L.veiculos_id = V.id\n" +
                            "inner join cliente as C ON L.clientes_id = C.id\n" +
                            "inner join cores as CR ON V.cores_id = CR.id\n" +
                            "inner join modelos as M ON V.modelos_id = M.id ORDER BY id";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Locacoes vei;
            while(rs.next()){
                vei = new Locacoes();
                vei.setCodigo(rs.getInt("id"));
                vei.setData_inicio(rs.getString("data_inicio"));
                vei.setData_termino(rs.getString("data_termino"));
                vei.setData_inicioFormat(rs.getString("dataInicioFormat"));
                vei.setData_terminoFormat(rs.getString("dataTerminoFormat"));
                vei.setValor_diaria(rs.getDouble("valor_diaria"));
                vei.setValor_locacao(rs.getDouble("valor_locacao"));
                vei.setValor_pago(rs.getDouble("valor_pago"));
                vei.setStatusLocacoes(rs.getString("status_locacao"));
                vei.setPlaca_id(rs.getInt("veiculos_id"));
                vei.setCliente_id(rs.getInt("clientes_id"));
                vei.setCliente(rs.getString("Cliente"));
                vei.setCor(rs.getString("Cor"));
                vei.setPlaca(rs.getString("Placa"));
                vei.setModelo(rs.getString("Modelo"));
                vei.setModelo_id(rs.getInt("ModeloID"));
                lista.add(vei);
            }
            fecharBanco();
             
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return lista;
    }
    
    
    public ArrayList<Locacoes> pesquisaTudoLocacoesTabela(int start, int total){
        ArrayList<Locacoes> lista = new ArrayList<Locacoes>();
        try {
            abrirBanco();
            String query = "SELECT L.*,DATE_FORMAT(data_inicio, '%d/%m/%Y') AS dataInicioFormat,DATE_FORMAT(data_termino, '%d/%m/%Y') AS dataTerminoFormat,C.nome as Cliente, V.placa as Placa,CR.nome as Cor, M.nome as Modelo\n" +
                            "FROM locacoes as L\n" +
                            "inner join veiculos as V ON L.veiculos_id = V.id\n" +
                            "inner join cliente as C ON L.clientes_id = C.id\n" +
                            "inner join cores as CR ON V.cores_id = CR.id\n" +
                            "inner join modelos as M ON V.modelos_id = M.id ORDER BY id limit "+(start)+","+(total);
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Locacoes vei;
            while(rs.next()){
                vei = new Locacoes();
                vei.setCodigo(rs.getInt("id"));
                vei.setData_inicio(rs.getString("data_inicio"));
                vei.setData_termino(rs.getString("data_termino"));
                vei.setData_inicioFormat(rs.getString("dataInicioFormat"));
                vei.setData_terminoFormat(rs.getString("dataTerminoFormat"));
                vei.setValor_diaria(rs.getDouble("valor_diaria"));
                vei.setValor_locacao(rs.getDouble("valor_locacao"));
                vei.setValor_pago(rs.getDouble("valor_pago"));
                vei.setStatusLocacoes(rs.getString("status_locacao"));
                vei.setPlaca_id(rs.getInt("veiculos_id"));
                vei.setCliente_id(rs.getInt("clientes_id"));
                vei.setCliente(rs.getString("Cliente"));
                vei.setCor(rs.getString("Cor"));
                vei.setPlaca(rs.getString("Placa"));
                vei.setModelo(rs.getString("Modelo"));
                lista.add(vei);
            }
            fecharBanco();
             
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return lista;
    }
    
    public ArrayList<Locacoes> pesquisaLocacoesAtivaTabela(int start, int total){
        ArrayList<Locacoes> lista = new ArrayList<Locacoes>();
        try {
            abrirBanco();
            String query = "SELECT L.*,DATE_FORMAT(data_inicio, '%d/%m/%Y') AS dataInicioFormat,DATE_FORMAT(data_termino, '%d/%m/%Y') AS dataTerminoFormat,C.nome as Cliente, V.placa as Placa,CR.nome as Cor, M.nome as Modelo\n" +
                            "FROM locacoes as L\n" +
                            "inner join veiculos as V ON L.veiculos_id = V.id\n" +
                            "inner join cliente as C ON L.clientes_id = C.id\n" +
                            "inner join cores as CR ON V.cores_id = CR.id\n" +
                            "inner join modelos as M ON V.modelos_id = M.id where status_locacao='ALUGADO' ORDER BY id limit "+(start)+","+(total);
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Locacoes vei;
            while(rs.next()){
                vei = new Locacoes();
                vei.setCodigo(rs.getInt("id"));
                vei.setData_inicio(rs.getString("data_inicio"));
                vei.setData_termino(rs.getString("data_termino"));
                vei.setData_inicioFormat(rs.getString("dataInicioFormat"));
                vei.setData_terminoFormat(rs.getString("dataTerminoFormat"));
                vei.setValor_diaria(rs.getDouble("valor_diaria"));
                vei.setValor_locacao(rs.getDouble("valor_locacao"));
                vei.setValor_pago(rs.getDouble("valor_pago"));
                vei.setStatusLocacoes(rs.getString("status_locacao"));
                vei.setPlaca_id(rs.getInt("veiculos_id"));
                vei.setCliente_id(rs.getInt("clientes_id"));
                vei.setCliente(rs.getString("Cliente"));
                vei.setCor(rs.getString("Cor"));
                vei.setPlaca(rs.getString("Placa"));
                vei.setModelo(rs.getString("Modelo"));
                lista.add(vei);
            }
            fecharBanco();
             
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
       return lista;
    }
    
    public void deletarLocacao(Locacoes c){
        try {
            abrirBanco();
            String query = "DELETE FROM locacoes where id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, c.getCodigo());
            ps.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
    
    public void cadastrarLocacao(Locacoes c){
         try {
             abrirBanco();
             String query = "INSERT INTO locacoes(id,data_inicio,data_termino,valor_diaria,valor_locacao ,valor_pago ,status_locacao,veiculos_id,clientes_id) values(null,?,?,?,?,?,?,?,?) ";
             ps = con.prepareStatement(query);
             ps.setString(1,c.getData_inicio());
             ps.setString(2, c.getData_termino());
             ps.setDouble(3, c.getValor_diaria());
             ps.setDouble(4, c.getValor_locacao());
             ps.setDouble(5, c.getValor_pago());
             ps.setString(6, c.getStatusLocacoes());
             ps.setInt(7, c.getPlaca_id());
             ps.setInt(8,c.getCliente_id());
             ps.execute();
             fecharBanco();
         } catch (Exception e) {
             System.out.println("Error"+ e.getMessage());
         }
    }
    
    public void editarLocacoes(Locacoes c){
        try {
            abrirBanco();
            String query="UPDATE locacoes set data_inicio =?, data_termino = ?,valor_diaria = ?, valor_locacao=?, valor_pago= ?,status_locacao= ?,veiculos_id= ?,clientes_id= ?  where id=?";
            ps= con.prepareStatement(query);
            ps.setString(1, c.getData_inicio());
            ps.setString(2, c.getData_termino());
            ps.setDouble(3, c.getValor_diaria());
            ps.setDouble(4, c.getValor_locacao());
            ps.setDouble(5, c.getValor_pago());
            ps.setString(6, c.getStatusLocacoes());
            ps.setInt(7, c.getPlaca_id());
            ps.setInt(8, c.getCliente_id());
            ps.setInt(9, c.getCodigo());
            ps.executeUpdate();
            fecharBanco();
            
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
    
    public void pagamentoLocacao(Locacoes c){
        try {
            abrirBanco();
            String query="UPDATE locacoes set valor_pago= ? where id=?";
            ps= con.prepareStatement(query);
            ps.setDouble(1, c.getValor_pago());
            ps.setInt(2, c.getCodigo());
            ps.executeUpdate();
            fecharBanco();
            
        } catch (Exception e) {
            System.out.println("Erro"+ e.getMessage());
        }
    }
    
    public double valorPagoLocacao(int codigo) throws SQLException, Exception{
            double valor = 0;
            abrirBanco();
            String query = "SELECT valor_pago FROM locacoes where id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                valor = rs.getDouble("valor_pago");
            }
            fecharBanco();
            return valor;
    }
    
    public Locacoes totalLocacao(){
        Locacoes func = new Locacoes();
        try {
            abrirBanco();
            String query = "select count(*) as totalId from locacoes;";
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
    
    public Locacoes totalLocacaoAtiva(){
        Locacoes func = new Locacoes();
        try {
            abrirBanco();
            String query = "select count(*) as totalId from locacoes WHERE status_locacao=\"ALUGADO\"";
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
    public ArrayList<Locacoes> buscarDataLocacoes(String dataInicio, String dataFinal){
        String buscar="SELECT L.*,DATE_FORMAT(data_inicio, '%d/%m/%Y') AS dataInicioFormat,DATE_FORMAT(data_termino, '%d/%m/%Y') AS dataTerminoFormat,C.nome as Cliente, V.placa as Placa,CR.nome as Cor, M.nome as Modelo\n" +
                    "FROM locacoes as L \n" +
                    "inner join veiculos as V ON L.veiculos_id = V.id\n" +
                    "inner join cliente as C ON L.clientes_id = C.id\n" +
                    "inner join cores as CR ON V.cores_id = CR.id\n" +
                    "inner join modelos as M ON V.modelos_id = M.id ";
        System.out.println(dataInicio);
        System.out.println(dataFinal);
        if(dataInicio != null && dataFinal != null){
            buscar +="WHERE (L.data_inicio >= '"+dataInicio+"' && L.data_inicio <= '"+dataFinal+"') ORDER BY id";
            
        } 
        if(dataInicio != null && (dataFinal == null || dataFinal.equals(""))){System.out.println("estou if Data inicio");
           buscar="SELECT L.*,DATE_FORMAT(data_inicio, '%d/%m/%Y') AS dataInicioFormat,DATE_FORMAT(data_termino, '%d/%m/%Y') AS dataTerminoFormat,C.nome as Cliente, V.placa as Placa,CR.nome as Cor, M.nome as Modelo\n" +
                    "FROM locacoes as L \n" +
                    "inner join veiculos as V ON L.veiculos_id = V.id\n" +
                    "inner join cliente as C ON L.clientes_id = C.id\n" +
                    "inner join cores as CR ON V.cores_id = CR.id\n" +
                    "inner join modelos as M ON V.modelos_id = M.id WHERE L.data_inicio >= '"+dataInicio+ "' ORDER BY id";   
            
        }
        if(dataInicio == null && dataFinal != null) {
            buscar +="WHERE L.data_inicio <= '"+dataFinal+ "' ORDER BY id";
        }
        
        ArrayList<Locacoes> lista = new ArrayList<Locacoes>();
        try {
            abrirBanco();
            String query =buscar;
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Locacoes loc;
            
             while(rs.next()){
                loc = new Locacoes();
                loc.setCodigo(rs.getInt("id"));
                loc.setData_inicio(rs.getString("data_inicio"));
                loc.setData_termino(rs.getString("data_termino"));
                loc.setData_inicioFormat(rs.getString("dataInicioFormat"));
                loc.setData_terminoFormat(rs.getString("dataTerminoFormat"));
                loc.setValor_diaria(rs.getDouble("valor_diaria"));
                loc.setValor_locacao(rs.getDouble("valor_locacao"));
                loc.setValor_pago(rs.getDouble("valor_pago"));
                loc.setStatusLocacoes(rs.getString("status_locacao"));
                loc.setPlaca_id(rs.getInt("veiculos_id"));
                loc.setCliente_id(rs.getInt("clientes_id"));
                loc.setCliente(rs.getString("Cliente"));
                loc.setCor(rs.getString("Cor"));
                loc.setPlaca(rs.getString("Placa"));
                loc.setModelo(rs.getString("Modelo"));
                lista.add(loc);
                
            }
            fecharBanco();
        } catch(Exception e){
            System.out.println("Erro:" + e.getMessage());
        }
        return lista;
    }
}
