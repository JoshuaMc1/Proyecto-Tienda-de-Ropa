
package modelo.funciones;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ConexionMySQL;

/**
 *
 * @author Joshua Mc
 */
public class funciones {
    //Objetos
    ConexionMySQL con = new ConexionMySQL();
    
    public int validarInicio(String usuario, String clave){
        int dato = 0;
        try{
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT * FROM usuarios WHERE usuario='"+usuario+"' AND clave=SHA('"+clave+"') AND status='1'");
            if(con.resultado.next()){
                dato = con.resultado.getInt("id_user");
            }
            con.DesconectarBasedeDatos();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return dato;
    }
    
    public ArrayList datosUser(int idUser){
        ArrayList datos = new ArrayList();
        try{
            con.ConectarBasedeDatos();
            con.resultado = con.sentencia.executeQuery("SELECT * FROM empleado WHERE id_user='"+idUser+"' AND status='1'");
            if(con.resultado.next()){
                
            }
            con.DesconectarBasedeDatos();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return datos;
    }
}
