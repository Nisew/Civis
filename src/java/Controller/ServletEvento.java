package Controller;

import Database.EventosDB;
import Database.UsuariosDB;
import Entities.Evento;
import Entities.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
@WebServlet(urlPatterns = {"/evento"})
public class ServletEvento extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String sa = request.getParameter("sa");

        EventosDB eventoDB = new EventosDB();

        switch (sa) {
            case "newEvent":
                //CREAR UN NUEVO EVENTO

                String tituloEvento = request.getParameter("titulo");
                String ubicacion = request.getParameter("localidad");
                String hora_evento = request.getParameter("hora");
                String fecha_evento = request.getParameter("fecha");
                String numPersonas = request.getParameter("numPersonas");
                String descripcion = request.getParameter("descripcion");
                hora_evento += ":00";

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                SimpleDateFormat sdf_f = new SimpleDateFormat("YYYY-MM-dd");
                String hora_registro = sdf.format(cal.getTime());
                String fecha_registro = sdf_f.format(cal.getTime());

                int np = Integer.parseInt(numPersonas);
                Cookie ck[] = request.getCookies();
                String nomUsuario = "";
                for (Cookie c : ck) {
                    if (c.getName().equals("uName")) {
                        nomUsuario = c.getValue();
                    }
                }

                UsuariosDB udbId = new UsuariosDB();

                //CREO UN OBJETO EVENTO Y EJECUTO EL METODO
                try {
                    Usuario userCookie = udbId.verUsuario(nomUsuario);
                    
                    Evento evento1 = new Evento(tituloEvento, ubicacion, hora_registro, fecha_registro, hora_evento, fecha_evento, descripcion, np, userCookie.getId_usuario());

                    eventoDB.crearEvento(evento1);

                } catch (SQLException ex) {
                    Logger.getLogger(ServletEvento.class.getName()).log(Level.SEVERE, null, ex);
                }

                //ENVIAMOS LA INFORMACION A LA SIGUIENTE PAGINA
                request.setAttribute("user", tituloEvento);
                RequestDispatcher rd = request.getRequestDispatcher("jspok.jsp"); //
                rd.forward(request, response);
                break;

            case "listEvents":
                //VISUALIZAR TODOS LOS EVENTOS
                
                EventosDB listareventos = new EventosDB();
                ArrayList<Evento> listaEventos = new ArrayList<>();

                try {
                    listaEventos = listareventos.mostrarEventos();
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                request.setAttribute("listaEventos", listaEventos);
                rd = request.getRequestDispatcher("index.jsp"); 
                rd.forward(request, response);
                break;

            case "showOwnEvents":
                //VISUALIZAR LOS EVENTOS LOS CUALES HAS CREADO
                
                EventosDB edbeventos = new EventosDB();

                try {
                    Cookie cookie[] = request.getCookies();
                    String nombreUsuario = "";
                    for (Cookie c : cookie) {
                        if (c.getName().equals("uName")) {
                            nombreUsuario = c.getValue();
                        }
                    }
                    
                    Usuario userEventosPropios = new Usuario(nombreUsuario);
                    edbeventos.listarEventosPropios(userEventosPropios);
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                break;
                
            case "listJoinedEvents":
                //VISUALIZAR LOS EVENTOS A LOS CUALES ESTAS INSCRITOS
                
                EventosDB eventosInscritos = new EventosDB();
                
                try {
                    Cookie cookie[] = request.getCookies();
                    String nombreUsuario = "";
                    for (Cookie c : cookie) {
                        if (c.getName().equals("uName")) {
                            nombreUsuario = c.getValue();
                        }
                    }
                    
                    Usuario userEventsInscritos = new Usuario(nombreUsuario);
                    eventosInscritos.verEstadoInscripcion(userEventsInscritos);
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
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
