/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author mborges
 */
public class DBConnection {
    private static final String URL = ("jdbc:mysql://localhost:3308/crud_pessoa");
    private static final String USER = ("root");
    private static final String PASS = ("");
    
    public static Connection getConnection() {
        try {
            System.out.println("Conexão realizada com êxito.");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch(SQLException e) {
            System.err.println("Houve um erro ao fazer a conexão.");
            throw new RuntimeException(e);
        }
    }
}


