package Servlets;

import Helpers.conexiondb;
import Helpers.hash;
import Helpers.hash2;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Act extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        String pass= request.getParameter("contrass");
        String pas= request.getParameter("contras");
        hash ha= new hash(pass);
        hash2 as= new hash2(pas);
        conexiondb con = new conexiondb();
        con.DBConnection();
        con.actualizar(request.getParameter("email"),as.getTESTT(),
        request.getParameter("nombre"), request.getParameter("apellido"),
        request.getParameter("emaill"), ha.getTEST());
        con.cerrarconexion();
        request.getRequestDispatcher("PUT.html").forward(request, response);
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
