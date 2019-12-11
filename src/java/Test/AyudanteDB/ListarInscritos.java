/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test.AyudanteDB;

import Database.AyudantesDB;
import Database.UsuariosDB;
import Entities.Ayudante;
import Entities.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ListarInscritos {

    public static void main(String[] args) {
        
        AyudantesDB ayudantesDB = new AyudantesDB();
        ArrayList<Ayudante> ayudante = new ArrayList<>();
        Usuario us = new Usuario();
        UsuariosDB udb = new UsuariosDB();
        try {
            ayudante =ayudantesDB.listInscritos(1);
            for (Ayudante ay : ayudante){
                us = udb.verUsuario(ay.getUsuario());
                System.out.println(us.getUsuario());
                System.out.println(ay.getId_usuario());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
