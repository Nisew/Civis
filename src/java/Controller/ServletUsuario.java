/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.UsuariosDB;
import Entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/usuario"})
public class ServletUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Registro de usuario nuevo        
        /* String usuario = request.getParameter("nombreUsuario");
        String psswrd = request.getParameter("contrasenya");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String fecha_nacimiento = request.getParameter("fechaNacimiento");
        String correo = request.getParameter("correo");

        Usuario u_nuevo = new Usuario(usuario, psswrd, nombre, apellidos, fecha_nacimiento, telefono, correo);

        try {
            UsuariosDB nuevousuario = new UsuariosDB();
            nuevousuario.crearUsuario(u_nuevo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        Cookie ck = new Cookie("user", "sonoo jaiswal");//creating cookie object  
        response.addCookie(ck);//adding cookie in the response  

        request.setAttribute("user", u_nuevo);
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp"); //
        rd.forward(request, response);
         */
        //Login
        String usuario = request.getParameter("nombreUsuario");
        String contrasenya = request.getParameter("contrasenya");

        boolean logueado = false;
        Usuario u_login = new Usuario(usuario, contrasenya);
        UsuariosDB userlogin = new UsuariosDB();
        try {

            logueado = userlogin.iniciarSesion(u_login);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (logueado) {
            request.setAttribute("user", u_login);
            RequestDispatcher rd = request.getRequestDispatcher("logok.jsp"); //
            rd.forward(request, response);
        } else {
            request.setAttribute("user", u_login);
            RequestDispatcher rd = request.getRequestDispatcher("logok.jsp"); //
            rd.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
