/**
 * @author Andres
 */
package proy_sena;

//importar la libria
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Proy_sena {


    public static void main(String[] args) {
        
        // Variables
        
        String usuario="root";
        String password="root";
        String url="jdbc:mysql://localhost:3307/tecnostore";
        
        // Objetos
        
        Connection conexion;
        Statement st;
        ResultSet rs;
        
        
        // Inicializar el driver
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Proy_sena.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // Conexion DB 
            conexion=DriverManager.getConnection(url, usuario, password);
            
            st=conexion.createStatement();
            
            //Sentencia para imprimir los datos
            
            rs=st.executeQuery("SELECT * From usuarios");
            System.out.println("Imprimir");//Separador
            rs.next();
            do{
                
                System.out.println("id:" +rs.getInt("id_usuario") +" nombre: "+rs.getString("nombre"));
            } while (rs.next());
            
          
            //Sentencia para insertar datos
            
            st.executeUpdate("INSERT INTO usuarios VALUES(3,'Andres Felipe','andres.felipe@mail.com','claveSegura123')");
            System.out.println("Insertar");//Separador
            rs=st.executeQuery("SELECT * FROM usuarios");
            rs.next();
            do{
                System.out.println("id:" +rs.getInt("id_usuario") +" nombre: "+rs.getString("nombre"));
            }while(rs.next());
            
           
            //Sentencia para actualizar datos
            
            st.executeUpdate("UPDATE usuarios SET nombre='Jesús Ernesto' WHERE id_usuario=3");
            System.out.println("Actualizar");//Separador
            rs=st.executeQuery("SELECT * FROM usuarios");
            rs.next();
            do{
                System.out.println("id:" +rs.getInt("id_usuario") +" nombre: "+rs.getString("nombre"));
            }while(rs.next());
            
            
            //Sentencia de eliminación de datos
            
            st.executeUpdate("DELETE FROM usuarios WHERE id_usuario=3");
            System.out.println("Eliminar");//Separador
            rs=st.executeQuery("SELECT * FROM usuarios");
            rs.next();
            do{
                System.out.println("id:" +rs.getInt("id_usuario") +" nombre: "+rs.getString("nombre"));
            }while(rs.next());
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Proy_sena.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
       
    }
    
}
