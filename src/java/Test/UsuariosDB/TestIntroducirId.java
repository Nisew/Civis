/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test.UsuariosDB;

import Database.UsuariosDB;
import Entities.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class TestIntroducirId {

    public static void main(String[] args) throws SQLException {
        int id = 1;
        Usuario creador = new Usuario();
        UsuariosDB test = new UsuariosDB();
        
        creador = test.verUsuarioId(id);
        //creador.setId_usuario(id);
        System.out.println(creador.getUsuario());
    }
}
