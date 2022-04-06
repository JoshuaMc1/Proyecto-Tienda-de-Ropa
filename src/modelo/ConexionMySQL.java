
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ConexionMySQL {
    public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;
    
    public void ConectarBasedeDatos(String db){
        try {
            final String Controlador = "com.mysql.cj.jdbc.Driver";
            Class.forName(Controlador);
            final String url_bd = "jdbc:mysql://localhost:3306/"+db;
            conexion = DriverManager.getConnection(url_bd,"root","");
            sentencia = conexion.createStatement();
        }catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void DesconectarBasedeDatos() {
        try {
            if (conexion != null ) {
                if(sentencia != null) {
                    sentencia.close();
                }
                conexion.close();
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public Connection getConnection(){
        return conexion;
    }
}
