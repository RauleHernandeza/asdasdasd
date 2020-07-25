package Servlets;

import Helpers.conexiondb;
import Helpers.hash;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mirar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        String pass= request.getParameter("contras");
        hash ha= new hash(pass);
        conexiondb con = new conexiondb();
        con.DBConnection();
        con.borrar(request.getParameter("email"),
        ha.getTEST());
        con.cerrarconexion();
          
      } catch (NoSuchAlgorithmException ex) {
          Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
      }
        processRequest(request, response);
        request.getRequestDispatcher("exit.html").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
