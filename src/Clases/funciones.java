package clases;

import java.awt.Color;
import java.awt.Component;
import java.util.function.UnaryOperator;
//import java.awt.event.KeyEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    /*Metodo para darle color a un boton cuando se pasa el mouse sobre el las variables que terminan en uno son para el background 
    y las que terminan en dos son para el color de texto*/
        btn.setStyle("-fx-background-color: rgb(" + r1 + "," + g1 + "," + b1 + ");"
                   + "-fx-text-fill: rgb(" + r2 + "," + g2 + "," + b2 + ");");
    }
    
    public void Msg(String msg){ // metodo para mostrar un mensaje
        JOptionPane.showMessageDialog(null,msg,"Atencion",1);
    }
    
    //metodo para limpiar las cajas de texto en un panel
    public void Clean(Pane pn){ // El Pane es el panel en que se encuentran las cajas de texto
        try{
            for(Node n1 : pn.getChildren()){ //se usa un ciclo foreach y se recorren todos los objetos hijos del panel
                //Node de javafx = Component de java.awt
                if (n1 instanceof TextField) { //si el nodo es un textfield se limpia
                    ((TextField) n1).setText("");
               }
            }
        }catch(Exception e){
            e.printStackTrace();
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
    
    public void formatTD(TextField tf, int bt){ //metodo para validar la caja de texto telefono y DNI
        UnaryOperator<TextFormatter.Change> filter = change -> {
        if (change.isContentChange()) { //si hay cambios en la caja de texto
            handleBackspaceOverSpecialCharacter(change);
            if (change.getText().matches("[0-9]*")) { //si el texto capturado por el textformatter es igual a un valor numerico
                int originalNewTextLength = change.getControlNewText().length();
                change.setText(formatNumber(change.getControlNewText(), bt)); /*se le aplica el formato al texto y se guarda en la variable
                change el nuevo texto en la caja*/
                change.setRange(0, change.getControlText().length());
                int caretOffset = change.getControlNewText().length() - originalNewTextLength;
                change.setCaretPosition(change.getCaretPosition() + caretOffset);
                change.setAnchor(change.getAnchor() + caretOffset);
                /*esto sirve para colocar el puntero en el ultimo digito y no permitir que se vayan arrastrando datos en la caja de
                texto*/
                return change;
            } else {
                return null;
            }
        }
        return change;
        };
        TextFormatter<String> formatter = new TextFormatter<>(filter);
        tf.setTextFormatter(formatter);
    }
    
    public void validaTexto(TextField tf){ //Metodo para validar que solo se ingresen letras y espacios
        UnaryOperator<TextFormatter.Change> filter = change ->{ 
            if (change.getControlNewText().matches("[a-zA-Z ]*")){ /*si el texto que se encuentra en la caja de texto es una letra o 
                un espacio devuelve ese texto*/
                return change; 
            }
            return null; //si no no devuelve nada o sea no permite que se ingrese el valor tecleado
        };
        TextFormatter<String> formatter = new TextFormatter<>(filter);
          tf.setTextFormatter(formatter);
    }
    
   public void validaNumeros(TextField tf){
       UnaryOperator<TextFormatter.Change> filter = change ->{ 
            if (change.getControlNewText().matches("[0-9]*")){ /*si el texto que se encuentra en la caja de texto es un numero*/
                return change; 
            }
            return null; //si no no devuelve nada o sea no permite que se ingrese el valor tecleado
        };
        TextFormatter<String> formatter = new TextFormatter<>(filter);
          tf.setTextFormatter(formatter);
   }
    
    private void handleBackspaceOverSpecialCharacter(TextFormatter.Change change) { /*Este metodo permite borrar todos los valores de
        una caja de texto que use el metodo formatTD(), sin este metodo quedaria un numero y un guion que no se iban a poder eliminar*/
        if (change.isDeleted() && (change.getSelection().getLength() == 0)) {
            if (!Character.isDigit(change.getControlText().charAt(change.getRangeStart()))) {
                if (change.getRangeStart() > 0) {
                    change.setRange(change.getRangeStart() - 1, change.getRangeEnd() - 1);
                }
            }
        }
    }

    private String formatNumber(String numbers, int tb) { //metodo para darle formato a la caja de texto de telefono y DNI
        String nFmt="", fNum="";
        numbers = numbers.replaceAll("[^\\d]", ""); //Reemplaza cualquier valor que no sea un numero por un espacio en blanco
        
        if(tb == 1) fNum = numbers.substring(0, Math.min(8, numbers.length()));
        else fNum = numbers.substring(0, Math.min(13, numbers.length()));;
        //Esto controla la cantidad de numeros que se pueden ingresar
        nFmt = fNum; 
        if (nFmt.length() == 0) return "";
        if(tb == 1){
        if(nFmt.length() < 5) return nFmt + "-";
        nFmt = nFmt.replaceFirst("(\\d{4})(\\d+)", "$1-$2");
        //si no hay coincidencias con los if statement
        //(\\d{4}) = valores que sean digitos y esten agrupados en un grupo de 4
        //(\\d+) = valores que sean digitos y se signa tecleando
        //$1 = el primer grupo definido dentro de los parentesis
        //- = el separador
        //$2 = el segundo grupo definido dentro de parentesis
        } else{
            if(nFmt.length() < 5) return nFmt + "-";
            if(nFmt.length() < 9) return nFmt.replaceFirst("(\\d{4})(\\d+)", "$1-$2");
            nFmt = nFmt.replaceFirst("(\\d{4})(\\d{4})(\\d+)", "$1-$2-$3");
        }
        return nFmt;
    }
}

