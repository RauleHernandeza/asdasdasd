package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class conexiondb {
    boolean error;
    Connection conexion = null;
    PreparedStatement st=null;
    ResultSet rs=null;
    String todo=null;
    String ee=null;
 ////////////////////////////////////////////////////////////////////////////////////   
     public Connection DBConnection() {
		 try {
            //Establecer datos de conexion
            Class.forName("org.postgresql.Driver");
            String  url="jdbc:postgresql://localhost:5432/conexion";
            conexion = DriverManager.getConnection(url,"Raul","Raul");
		}
		 catch (SQLException e) {
			System.out.println("Ha ocurrido el siguiente error con la BD:" + e.getMessage());
			error = true;
		}catch(ClassNotFoundException ex) {
            System.out.print("Ocurri� un error con los drivers.");
            error = true;
            }
	 return conexion;
   	 }   
////////////////////////////////////////////////////////////////////////////////////
      public Connection cerrarconexion() { 
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
      return conexion;
      }

    ////////////////////////////////////////////////////////////////////////////////////  
      public void crear(String c, String d, String e, String b){
          
        try {
            st = conexion.prepareCall("INSERT INTO usuario VALUES(?, ?, ?, ?)");
            st.setString(1, c);
            st.setString(2, d);
            st.setString(3, e);
            st.setString(4, b);
            rs = st.executeQuery();
            
        } catch (SQLException ex ) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
      }
      //////////////////////////////////////////////////////////////////////////////////////
      
      public void borrar (String j, String m){
          
        try {
            st = conexion.prepareCall("DELETE FROM usuario WHERE email= ? and contras = ?");
            st.setString(1, j);
            st.setString(2, m);
            rs = st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      ////////////////////////////////////////////////////////////////////////////////////////
      
      public void actualizar(String c, String d, String e, String b, String o, String p){
      try {
            st = conexion.prepareCall("UPDATE usuario SET email=?, contras=?, nombre=?, apellido=? WHERE contras=? AND email=?");
            st.setString(1, c);
            st.setString(2, d);
            st.setString(3, e);
            st.setString(4, b);
            st.setString(5, o);
            st.setString(6, p);
            rs = st.executeQuery();
            
        } catch (SQLException ex ) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
      //////////////////////////////////////////////////////////////////////////////////////
      public void verificacion(String c, String d){
        try {
            st = conexion.prepareCall("SELECT * FROM usuario WHERE email=? AND contras=?");
            st.setString(1, c);
            st.setString(2, d);
            rs = st.executeQuery();
            if(rs.next()==!false){
            ee="Bienvenido";
            }
            else{
            ee="correo o contraseña invalida vuelva a intentar";
            }
        } catch (SQLException ex ) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }  
      }
      //////////////////////////////////////////////////////////////////////////////////////
      public String respuesta(){
      return ee;
      }
}

