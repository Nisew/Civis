/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.AyudantesDB;
import Database.UsuariosDB;
import Entities.Ayudante;
import Entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "ServletAyudante", urlPatterns = {"/ayudante"})
public class ServletAyudante extends HttpServlet {

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

        String sa = request.getParameter("sa");
        

        switch (sa) {
            case "inscribir":
                int id_evento_inscribir = Integer.parseInt(request.getParameter("inscribir"));
                
                AyudantesDB ay_inscrito = new AyudantesDB();
                UsuariosDB usToAy = new UsuariosDB();
                Usuario uaux = new Usuario();
                Ayudante ayinscribir = new Ayudante();
                String nombreAy = "";
                try {
                    Cookie cookie[] = request.getCookies();

                    for (Cookie c : cookie) {
                        if (c.getName().equals("uName")) {
                            nombreAy = c.getValue();
                        }

                    }
                    uaux = usToAy.verUsuario(nombreAy);
                    ayinscribir.setId_usuario(uaux.getId_usuario());
                    ayinscribir.setId_evento(id_evento_inscribir);
                    ay_inscrito.inscribirAyudante(ayinscribir);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                request.setAttribute("ayudante", ayinscribir);
                RequestDispatcher rd = request.getRequestDispatcher("misInscripciones.jsp");
                rd.forward(request, response);
                break;
            case "confirmar":
                
                int eventoConfirmado = Integer.parseInt(request.getParameter("confirmar"));
                
                AyudantesDB ayDB = new AyudantesDB();
                Ayudante ayconfirmar = new Ayudante();
                Usuario uaux2 = new Usuario();
                UsuariosDB usToAy2 = new UsuariosDB();
                String nombreAyu = "";
                try {
                    Cookie cookie[] = request.getCookies();

                    for (Cookie c : cookie) {
                        if (c.getName().equals("uName")) {
                            nombreAyu = c.getValue();
                        }
                    }
                    uaux2 = usToAy2.verUsuario(nombreAyu);
                    ayconfirmar.setId_usuario(uaux2.getId_usuario());
                    ayconfirmar.setId_evento(eventoConfirmado);
                    ayconfirmar = ayDB.verAyudante(uaux2.getId_usuario(), eventoConfirmado);
                    ayDB.confirmarAyudante(ayconfirmar);
                } catch(SQLException ex){
                    ex.printStackTrace();
                }
                request.setAttribute("ayudante", ayconfirmar);
                rd = request.getRequestDispatcher("misInscripciones.jsp");
                rd.forward(request, response);
                break;
            case "aceptar":
                int usuarioAaceptar = Integer.parseInt(request.getParameter("aceptar"));
                int eventoAaceptar = 3;
                
                Ayudante ayudAcep = new Ayudante();
                AyudantesDB acepDB = new AyudantesDB();
                
                try{
                ayudAcep = acepDB.verAyudante(usuarioAaceptar, eventoAaceptar);
                acepDB.aceptarAyuda(ayudAcep);
                
                } catch(SQLException ex){
                    ex.printStackTrace();
                }
                request.setAttribute("aceptar", ayudAcep);
                rd = request.getRequestDispatcher("misEventos.jsp");
                rd.forward(request, response);
                break;
            case "rechazar":
                int usuarioArechazar = Integer.parseInt(request.getParameter("rechazar"));
                int eventoArechazar = 3;
                
                Ayudante ayudRec = new Ayudante();
                AyudantesDB recDB = new AyudantesDB();
                
                try{
                ayudRec = recDB.verAyudante(usuarioArechazar, eventoArechazar);
                recDB.rechazarAyudante(ayudRec);
                
                } catch(SQLException ex){
                    ex.printStackTrace();
                }
                request.setAttribute("aceptar", ayudRec);
                rd = request.getRequestDispatcher("misEventos.jsp");
                rd.forward(request, response);
                break;
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
