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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



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
    
    public ArrayList<Pessoa> readAll() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        String query = "SELECT * FROM pessoa";
        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            )
        {
            while (rs.next()) {
                pessoas.add(new Pessoa(rs.getInt("id_pessoa"), rs.getString("nome"), rs.getInt("idade"), rs.getString("cpf")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pessoas;
    }
     
    public void update(Pessoa pessoa, int id) {
        String query = "UPDATE pessoa SET nome = ?, idade = ?, cpf = ? WHERE id_pessoa = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
            ) 
        {
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setString(3, pessoa.getCpf());
            stmt.setInt(4, id);
            stmt.execute();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int id) {
        String query = "DELETE FROM pessoa WHERE id_pessoa = ?";
        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
            )
        {
            stmt.setInt(1, id);
            stmt.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


