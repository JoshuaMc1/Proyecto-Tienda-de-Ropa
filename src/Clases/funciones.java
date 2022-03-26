package clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class funciones {
    
    //metodo para navegar a traves de los paneles
    public void GroupController(StackPane skp, String paneName){ // El stackpane es un panel que agrupa todos los paneles del sistema
        try{
        for(Node n1 : skp.getChildren()){ //nodos son el equivalente a los componentes de swing, getchildren es para obtener todos los objetos hijos del stackpane
            if (n1 instanceof Pane) { //si el nodo es un panel
                if(((Pane)n1).isVisible()) //si el panel es visible
                    ((Pane)n1).setVisible(false); //se vuelve invisible
                if(((Pane)n1).getId().equals(paneName)) //si el id del panel es igual al string 
                    ((Pane)n1).setVisible(true); //ese panel se vuelve visible
           }
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void Hover(Button btn, int r1, int g1, int b1, int r2, int g2, int b2){
        btn.setStyle("-fx-background-color: rgb(" + r1 + "," + g1 + "," + b1 + ");"
                   + "-fx-text-fill: rgb(" + r2 + "," + g2 + "," + b2 + ");");
    }
    
    public void Msg(String msg){ // metodo para mostrar un mensaje
        JOptionPane.showMessageDialog(null,msg,"Atencion",1);
    }
    
    //metodo para limpiar las cajas de texto en un jpanel
    public void Clean(JPanel pnl){ // El jpanel es el panel en que se encuentran las cajas de texto
        for(Component jl : pnl.getComponents()){
            if (jl instanceof JTextField) {
                ((JTextField) jl).setText("");
           }
        }
    }
    
    //metodo para limpiar una tabla
    public void CleanTable(JTable jtbl, DefaultTableModel model){// jpanel en que se encuentra la tabla y el defaulttablemodel que usa
        int fila = jtbl.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
    //metodo para verificar que todas las cajas de texto en un jpanel esten vacias
    public boolean Vacio(JPanel panel,JTextField jtfN){// jpanel en que se encuentran las cajas de texto y opcional una caja de texto que no se quiera
        boolean vacio = false;                         // verificar si esta vacia o no, en propiedades ponerle un valor al atributo name
        for(Component jt : panel.getComponents()){ //foreach, recorre todos los componentes en el jpanel
            if(jt instanceof JTextField){ //if un componente es un textfield
                if(((JTextField) jt).getText().equals("") && jt.getName() != jtfN.getName()){ //if la caja de texto esta vacia o su nombre es similar al nombre de la caja de texto que no se quiere verificar
                    vacio=true;
                    break; 
                }
            }
        }
        return vacio;
    }
    
    //metodo para verificar que solo se ingresen numeros y ciertos digitos
    public void keyTyped(KeyEvent e, int type){ // metodo para verificar que solo se ingresen numeros
        int key = e.getKeyChar(); // se almacena el valor tecleado
        if(key==e.VK_0||key==e.VK_1||key==e.VK_2||key==e.VK_3||key==e.VK_4||key==e.VK_5||key==e.VK_6||
           key==e.VK_7||key==e.VK_8||key==e.VK_9 || key==e.VK_BACK_SPACE || key==e.VK_PERIOD || key==e.VK_TAB ||
           key==e.VK_ENTER || key==e.VK_MINUS || key==e.VK_CONTROL){ // si el valor tecleado es igual a cualquier valor numerico
            if(type == 2) e.consume();
        } else { // si no es igual a los valores de arriba
            //JOptionPane.showMessageDialog(null,"Solo se permiten numeros en este campo");
            if(type==1)e.consume(); // para que no se muestre el texto en la caja de texto
        }
    } 
}

