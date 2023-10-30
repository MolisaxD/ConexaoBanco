/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobanco;

import classes.Pessoa;
import dao.DBConnection;
import java.util.ArrayList;
import telas.TelaListagem;

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
        
        TelaListagem telaInicial = new TelaListagem();
        telaInicial.setVisible(true);
        
        DBConnection db = new DBConnection();
        
        //Pessoa pessoa = new Pessoa("El Wiwi", 15, "168");
        //db.create(pessoa);
        
        //db.update(pessoa, 4);
        
        //db.delete(4);
        
        
        ArrayList<Pessoa> pessoasCadastradas = new ArrayList();
        pessoasCadastradas = db.readAll();
        
        for(int i = 0; i < pessoasCadastradas.size(); i++) {
            System.out.println(pessoasCadastradas.get(i).mostrarDados());
        }
    }
}
