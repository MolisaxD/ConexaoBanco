/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobanco;

import classes.Pessoa;
import dao.DBConnection;

/**
 *
 * @author mborges
 */
public class ConexaoBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBConnection con = new DBConnection();
        con.getConnection();
        
        Pessoa pessoa = new Pessoa("Criatura", 24, "166");
        con.create(pessoa);
    }
}
