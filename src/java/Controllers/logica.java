package Controllers;
/*
import Helpers.conexiondb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class logica {
    String todo;
    
            
            
     //debo crea 4 paginas diferentes para cada uno de los botones, asi que primero comenzare por el de crear usuario
    public logica() throws IOException{
		crear();
	}
    
    public void crear() throws IOException{
	FileReader fileReader = null;
        try
    {
        fileReader = new FileReader("C:\\Users\\Maria Alejandra\\Documents\\NetBeansProjects\\WebApplication1\\src\\java\\Helpers\\properties.properties");
        Properties p = new Properties();
        p.load(fileReader);
        todo = p.getProperty("crear");
    }
    finally
    {
        if (fileReader != null)
                   {
            fileReader.close();
                   }
               }
           
           for(int i = 0; i < 30; ++i){
           todo = todo.replaceFirst("_",request.getParameter(“nombre”)); 
	   conexiondb.query = todo;
	}
     }
}

	*/