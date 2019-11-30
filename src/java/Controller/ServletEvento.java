package Controller;

import Database.EventosDB;
import Entities.Evento;
import Entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(urlPatterns = {"/evento"})
public class ServletEvento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String sa = request.getParameter("sa");
        String id= request.getParameter("idUsuario");
        int idUsuario = Integer.parseInt(id);
        EventosDB eventoDB = new EventosDB();

        switch (sa) {
            case "newEvent":
                // obtengo los datos introducidos por el usuario

                String tituloEvento = request.getParameter("titulo");
                String ubicacion = request.getParameter("localidad");
                String hora_evento = request.getParameter("hora");
                String fecha_evento = request.getParameter("fecha");
                String numPersonas = request.getParameter("numPersonas");
                String descripcion = request.getParameter("descripcion");
                hora_evento += ":00";
                int np = Integer.parseInt(numPersonas);

                //CREO UN OBJETO EVENTO Y EJECUTO EL METODO
                Evento evento1 = new Evento(tituloEvento, ubicacion, hora_evento, fecha_evento, descripcion, np);
                try {

                    eventoDB.crearEvento(evento1);

                } catch (SQLException ex) {
                    Logger.getLogger(ServletEvento.class.getName()).log(Level.SEVERE, null, ex);
                }

                //ENVIAMOS LA INFORMACION A LA SIGUIENTE PAGINA
                request.setAttribute("user", tituloEvento);
                RequestDispatcher rd = request.getRequestDispatcher("jspok.jsp"); //
                rd.forward(request, response);
                break;

            case "listEvent":
                //LISTAMOS LOS EVENTOS
                Usuario u = new Usuario();
                u.setId_usuario(idUsuario);

                try {
                    eventoDB.mostrarEventosInscritos(u);
                } catch (SQLException ex) {
                    Logger.getLogger(ServletEvento.class.getName()).log(Level.SEVERE, null, ex);
                }
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
