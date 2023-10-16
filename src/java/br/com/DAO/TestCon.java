/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import java.sql.SQLException;

/**
 *
 * @author User
 */
public class TestCon {
    public static void main(String[] args) throws SQLException, Exception {
        DAO dao = new DAO();
        dao.abrirBanco();
        dao.fecharBanco();
    }
}
