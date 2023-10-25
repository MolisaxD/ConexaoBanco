/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 *
 * @author mborges
 */
public class DBConnection {
    private static final String URL = ("jdbc:mysql://192.168.10.130:3306/crud_pessoa");
    private static final String USER = ("mborges");
    private static final String PASS = ("root");
    
    public static Connection getConnection() {
        try {
            System.out.println("Conexão realizada com êxito.");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch(SQLException e) {
            System.err.println("Houve um erro ao fazer a conexão.");
            throw new RuntimeException(e);
        }
    }
    
    public void create(Pessoa pessoa) {
        String query = "INSERT INTO pessoa (cpf, nome, idade) VALUES (?, ?, ?)";
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, pessoa.getCpf());
            stmt.setString(2, pessoa.getNome());
            stmt.setInt(3, pessoa.getIdade());
            
            stmt.execute();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}


