package Controller;

import Database.UsuariosDB;
import Entities.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletUsuario", urlPatterns = {"/usuario"})
public class ServletUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String sa = request.getParameter("sa");

        //int idUsuario = Integer.parseInt(id);
        switch (sa) {
            case "newUsuario":
                //CREAR UN NUEVO USUARIO / REGISTRARTE
                
                String usuario = request.getParameter("nombreUsuario");
                String psswrd = request.getParameter("contrasenya");
                String nombre = request.getParameter("nombre");
                String apellidos = request.getParameter("apellidos");
                String telefono = request.getParameter("telefono");
                String fecha_nacimiento = request.getParameter("fechaNacimiento");
                String correo = request.getParameter("correo");

                Usuario u_nuevo = new Usuario(usuario, psswrd, nombre, apellidos, fecha_nacimiento, telefono, correo);

                try {
                    UsuariosDB nuevousuario = new UsuariosDB();
                    nuevousuario.registroUsuario(u_nuevo);
                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                break;
                
            case "borrarCuki":
                Cookie ck = new Cookie("uName","");
                ck.setMaxAge(0);
                response.addCookie(ck);
                response.sendRedirect("index.jsp");
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
