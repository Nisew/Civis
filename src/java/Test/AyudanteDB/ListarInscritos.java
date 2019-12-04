/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test.AyudanteDB;

import Database.AyudantesDB;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ListarInscritos {

    public static void main(String[] args) {
        
        AyudantesDB ayudantesDB = new AyudantesDB();
        try {
            System.out.println(ayudantesDB.listInscritos(4));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
