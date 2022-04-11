    package controlador;

import controlador.clases.Fact_Model;
import controlador.clases.Usuario;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import modelo.ConexionMySQL;
import modelo.funciones.funciones;

public class SalesController implements Initializable {

    private static String uID="";  
    private boolean suma = false, sumado=false;
    //para verificar si ya se sumo en precio en el metodo calcant, sumado es para validar si el usuario ya sumo una cantidad antes
    //de agregar el producto a la factura
    
    private funciones fun = new funciones();
    private Usuario usuario = new Usuario();
    private ConexionMySQL con = new ConexionMySQL(); //Variable que referencia a la clase que realiza la conexion a la bd
    private ResultSet rs = null; //ResultSet para varios usos
    private String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    private ObservableList<Fact_Model> ol = FXCollections.observableArrayList(); //lista de tipo Fact_Model(clase) para llenar y manejar la tabla
    private ArrayList<Integer> _exists =  new ArrayList<Integer>();
    private double imp=0.0,tot=0.0,s_TotG=0.0, totG =0.0, impG=0.0, vImp=0.0, txt_price=0.0, st=0.0,
                   vDesc=0.0, desc = 0.0, descg=0.0, precioG=0.0, totB=0.0, stB=0.0, isvB=0.0, descB=0.0;
    private int idF, cantG=0, fmIndex=0, exisB=0;
    private Fact_Model fm;
    
    @FXML
    private Button btnAgProd;
    @FXML 
    private TextField txtIDProd, txtUser, txtDniCli, txtProdName, txtPrice, txtCant;
    @FXML
    private Label lblSTot, lblDesc, lblTotal, lblCant, lblFact;
    @FXML
    private AnchorPane pnlPrinc;
    @FXML
    private ComboBox cmbCli; 
    @FXML
    private TableView<Fact_Model> tblDet;
    @FXML
    private TableColumn<Fact_Model, String> col_IDProd;
    @FXML
    private TableColumn<Fact_Model, String> colDescr;
    @FXML
    private TableColumn<Fact_Model, String> colCant;
    @FXML
    private TableColumn<Fact_Model, String> colPrice;
    @FXML
    private TableColumn<Fact_Model, String> colImp;
    @FXML
    private TableColumn<Fact_Model, String> colDesc;
    @FXML
    private TableColumn<Fact_Model, String> colLote;
    
    private void fillCBox(){
        try{
            //String arr[] = {"1","2","3","4","5"};
            cmbCli.getItems().removeAll(cmbCli.getItems());
            //cmbCli.getItems().addAll(arr);
            cmbCli.getItems().addAll("Cliente Normal","Cliente Temporal");
            //cmbCli.getSelectionModel().select("1");
            cmbCli.getSelectionModel().select("Cliente Normal");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public double giveFormat(double val){ //dar formato a double para que solo tenga dos digitos
        String formt = String.format("%.2f", val);
        double finalD = Double.parseDouble(formt);
        return finalD;
    }
    
    private void verifyEnter(KeyEvent evt){ //metodo para verificar que se presiono la tecla enter en la caja de texto del id del producto
        if(evt.getCode() == KeyCode.ENTER){
            int n = 0;
            buscartxt(n);
        } 
    }
    
    private void calCant(KeyEvent evt){ //metodo para sumar el precio total de un producto
        precioG = Double.parseDouble(txtPrice.getText());
        if(precioG > 0){
            if(evt.getCode() == KeyCode.ENTER){
                cantG += Integer.parseInt(txtCant.getText());
                if(suma)  precioG += txt_price * Double.parseDouble(txtCant.getText());
                if(!suma){
                    precioG += txt_price * Double.parseDouble(txtCant.getText()) - precioG;
                    suma = true;
                }
                txtPrice.setText(Double.toString(precioG));
                txtCant.setText("");
                lblCant.setText(Integer.toString(cantG));
            } 
        }
    }
    
    private void request(KeyEvent evt, Node n1){
       if(evt.getCode() == KeyCode.ENTER){
            if(n1 instanceof TextField) n1.requestFocus();
            if(n1 instanceof Button) n1.requestFocus();
        } 
    }
    
    //metodo para limpiar las cajas de texto en un panel
    private void cleanTxt(AnchorPane ap, String txtName, String txtName2){ // El Pane es el panel en que se encuentran las cajas de texto
        //System.out.println(txtIDProd.getParent().toString());
        try{
            for(Node n1 : ap.getChildren()){ //se usa un ciclo foreach y se recorren todos los objetos hijos del panel
                //Node de javafx = Component de java.awt
                if (n1 instanceof TextField) { //si el nodo es un textfield se limpia
                    if(!n1.getId().equals(txtName) && !n1.getId().equals(txtName2)) //El unico txtfld que no se limpiara es el que muestra el id del usuario
                        ((TextField) n1).setText("");
               }
            }
        }catch(Exception e){   fun.msg("Ha ocurrido un error: \n Por Favor contacte a soporte");}
    }    
    
    private void setCellValue(){
        col_IDProd.setCellValueFactory(new PropertyValueFactory<>("_id"));
        colDescr.setCellValueFactory(new PropertyValueFactory<>("descr"));
        colCant.setCellValueFactory(new PropertyValueFactory<>("cant"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colImp.setCellValueFactory(new PropertyValueFactory<>("isv"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));
        colLote.setCellValueFactory(new PropertyValueFactory<>("lote"));
    }
    
    private void agrProd(String sql){
        int cant = cantG, rc = tblDet.getItems().size(), exists = 0, rsSize=0, agr=0;
        try{
            if(!txtIDProd.getText().isEmpty() && !txtProdName.getText().isEmpty() && !txtDniCli.getText().isEmpty()){
                rs = buscar(sql, con);
                while(rs.next() && agr == 0){
                    if(rs.getInt("existencias") > cant && cant > 0){
                        agr=1;
                        sum(rs.getDouble("porcentaje"), precioG);
                        if(rc > 0){
                            for(int i=0;i<rc;i++){
                                if(txtIDProd.getText().equals(tblDet.getItems().get(i).get_id())){
                                    _exists.add(rs.getInt("existencias"));
                                    exists = 1;
                                    int ct = Integer.parseInt(tblDet.getItems().get(i).getCant()) + cantG;
                                    tblDet.getItems().get(i).setCant(Integer.toString(ct));
                                    tblDet.getItems().set(i, tblDet.getItems().get(i));
                                } else if(exists == 0){
                                    _exists.add(rs.getInt("existencias"));
                                    exists = 1;
                                    ol.add(new Fact_Model(txtIDProd.getText(), rs.getString("descripcion"), Integer.toString(cantG),
                                    Double.toString(rs.getDouble("Precio")), "0.15", Double.toString(rs.getDouble("porcentaje")),
                                    Integer.toString(rs.getInt("n_lote"))));
                                    setCellValue();
                                    tblDet.setItems(ol);
                                }
                            }
                        }else if(exists == 0){
                            _exists.add(rs.getInt("existencias"));
                            ol.add(new Fact_Model(txtIDProd.getText(), rs.getString("descripcion"), Integer.toString(cantG),
                            Double.toString(rs.getDouble("Precio")), "0.15", Double.toString(rs.getDouble("porcentaje")),
                            Integer.toString(rs.getInt("n_lote"))));
                            setCellValue();
                            tblDet.setItems(ol);
                            exists=1;
                        }
                        exists = 0;
                        cleanTxt(pnlPrinc, "txtUser", "txtDniCli");
                        lblCant.setText("");
                    } else{
                        fun.msg("La cantidad de producto a facturar supera la existencia actual del lote # " + rs.getInt("n_lote") + "  o su valor es 0");
                    }
                }
                agr=0;
                rs = null;
                con.DesconectarBasedeDatos();
            }
        }catch(Exception e){
            e.printStackTrace();
            fun.msg("Hubo un error¡¡¡ " + e + "\n favor contactar al administrador ");}
    }
    
    private void facturar(){
        String fact_a="", fact_b="", upExis="";
        //string para hacer el query para guardar el header de la factura junto con el cuerpo y actualizar la existencia de productos
        int rc = tblDet.getItems().size();
        //el numero de filas que tiene la tabla
        //se verifica que la tabla este llena y que se haya especificado el DNI del cliente
        if(rc > 0 && !txtDniCli.getText().isEmpty()){ 
            //si se escribio el DNI de manera correcta
            if(txtDniCli.getText().length() == 15){
                fact_a = "insert into fcatura_a (id_factura, dni_cliente, t_desc, id_user, t_imp, sub_total, total, fechaVenta, status) "+
                             "values ('"+idF+"','"+txtDniCli.getText()+"','"+descg+"','"+txtUser.getText()+"','"+impG+"','"+s_TotG+"','"+totG+"','"+date+"','1')";
                fun.guardar(fact_a);
                for(int i=0; i<rc; i++){
                    stB = Double.parseDouble(tblDet.getItems().get(i).getCant()) * Double.parseDouble(tblDet.getItems().get(i).getPrice());
                    isvB = Double.parseDouble(tblDet.getItems().get(i).getIsv()) * stB;
                    descB = Double.parseDouble(tblDet.getItems().get(i).getDesc()) * stB;
                    totB = stB + isvB - descB;
                    exisB = _exists.get(i) - Integer.parseInt(tblDet.getItems().get(i).getCant());
                    frmtB();
                    fact_b = "insert into fcatura_b (id_factura, id_pdt, isv, descuento, sub_total, total, status) "+
                             "values ('"+idF+"','"+tblDet.getItems().get(i).get_id()+"','"+isvB+"','"+descB+"','"+stB+"','"+totB+"','1')";
                    upExis = "update inventario set existencias = '" + exisB + "' where id_pdt='"+tblDet.getItems().get(i).get_id()+"' and n_lote='"+tblDet.getItems().get(i).getLote()+"'";
                    fun.guardar(fact_b);
                    fun.guardar(upExis);
                    exisB = 0;
                }
                cleanTxt(pnlPrinc, "txtUser", "");
                resetD();
                CargarIdFact();
                resetLbl();
                tblDet.getItems().clear();
                con.DesconectarBasedeDatos();
                fun.msg("Facturacion Exitosa");
            }
        } else{
            fun.msg("NO hay productos para facturar o no hay cliente ");
        }
    }
    
    private void quitarProd(){
        if(fm!=null){
            String opc []={"Eliminar la fila completa", "Quitar una cantidad x de producto"};// arreglo de opciones
            int dec = JOptionPane.showOptionDialog(null,"Que deseas realizar?","Opciones",JOptionPane.YES_OPTION,JOptionPane.WARNING_MESSAGE,null,opc,opc[0]);
            switch(dec){
                case 0:{
                    restar(fmIndex, Double.parseDouble(tblDet.getItems().get(fmIndex).getCant()));
                    tblDet.getItems().remove(fmIndex);
                    fm = null;
                }break;
                case 1:{
                    int ndec = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad que desea eliminar"));
                    if(ndec < Integer.parseInt(tblDet.getItems().get(fmIndex).getCant())){
                        int cant = Integer.parseInt(tblDet.getItems().get(fmIndex).getCant()) - ndec;
                        double n = (double)ndec;
                        restar(fmIndex, n);
                        tblDet.getItems().get(fmIndex).setCant(Integer.toString(cant));
                        tblDet.getItems().set(fmIndex, tblDet.getItems().get(fmIndex));
                    } else fun.msg("La cantidad introducida excede la cantidad que se encuentra en la tabla");
                }break;
            }
        }
    }
    
    //Metodo para darle formato a los valores decimales que se le agregan al cuerpo de la factura
    private void frmtB(){
        stB = giveFormat(stB);
        isvB = giveFormat(isvB);
        totB = giveFormat(totB);
        descB = giveFormat(descB);
    }
    
    //
    private void resetD(){
        st=0.0;
        vDesc=0.0;
        vImp=0.0;
        imp=0.0;
        tot=0.0;
        s_TotG=0.0;
        totG=0.0;
        impG=0.0;
        descg=0.0;
    }
    
    private void resetLbl(){
        lblDesc.setText("L.");
        lblSTot.setText("L.");
        lblTotal.setText("L.");
    }
    
    private void selRow(){
        if(tblDet.getItems().size() > 0)
            if(tblDet.getSelectionModel().getSelectedItem() != null){
                fm = tblDet.getSelectionModel().getSelectedItem();
                fmIndex = tblDet.getSelectionModel().getSelectedIndex();
                System.out.println(fmIndex + " index");
            }
    }
    
    private void restar(int index, double cantidad){
        double rprecio = Double.parseDouble(tblDet.getItems().get(index).getPrice()); //precio del producto que se va a quitar
        double risv = Double.parseDouble(tblDet.getItems().get(index).getIsv()); //isv del producto que se va a quitar
        double rdesc = Double.parseDouble(tblDet.getItems().get(index).getDesc());
        double rcant = cantidad;
        double rst = rprecio * rcant;
        rst = giveFormat(rst);
        double risvg = rst * risv;
        risvg = giveFormat(risvg);
        double rdescg = rst * rdesc;
        rdescg = giveFormat(rdescg);
        double rtotal = rst + risvg - rdescg;
        rtotal = giveFormat(rtotal);
        impG = impG - risvg;
        s_TotG = s_TotG - rst;
        descg = descg - rdescg;
        totG = totG - rtotal;
        updtLbl();
    }
    
    private void updtLbl(){
        if(descg < 0) descg = 0.0;
        if(s_TotG < 0) s_TotG = 0.0;
        if(totG < 0) totG = 0.0;
        lblDesc.setText("L. " + String.format("%.2f",descg));
        lblSTot.setText("L. " + String.format("%.2f",s_TotG));
        lblTotal.setText("L. " + String.format("%.2f",totG));
    }
    
    private void sum(double _desc, double s_tt){ //metodo para realizar la sumatoria del total ,sTotal,isv y decuento
        try{
            double stt = s_tt; //recibe el valor del subtotal
            st = giveFormat(stt); //Se le da formato al sTotal, se le dejan solamente 2 ceros
            vDesc = _desc; //recibe el valor del descuento
            double desct = st * vDesc; //se calcula el descuento
            desc = giveFormat(desct);
            vImp = 0.15;
            double impte = st * vImp; //se calcula el valor del impuesto
            imp = giveFormat(impte);
            double tott = st + imp - desc;
            tot = giveFormat(tott);
            s_TotG += st;//se asignan los valores oficiales de total, sTotal, descuento e isv
            totG+=tot;
            impG+=imp;
            descg+=desc;
            updtLbl();
        }catch(Exception e){fun.msg("ERROR"+e);}
    }
    
    public void recibirId(int id) {
        cargarObjeto(id);
    }

    public void CargarIdFact(){
        try{
            String sql = "select * from fcatura_a";
            rs = buscar(sql, con);
            if(rs.next()){
                do{
                    if(rs.isLast()){
                        idF = rs.getInt("id_factura") + 1;
                        lblFact.setText("FACTURA                                      " + idF);
                    } 
                }while((rs.next()));
            } else{ 
                idF=1;
                lblFact.setText("#FACTURA                                      " + idF);
            }
            con.DesconectarBasedeDatos();
        }catch(Exception e){fun.msg("Error!!");}
    }
    
    private void cargarObjeto(int id) {
        try {
            usuario = fun.llenarObejto(id);
            txtUser.setText(usuario.getIdUsuario());
        }catch(Exception ex) {
            fun.msg(ex.getMessage());
        }
    }
    
    public void buscartxt(int _id){ //metodo para buscar un producto
        _id = Integer.parseInt(txtIDProd.getText());  //se captura el id del prodcuto a buscar en la caja de texto idProducto
        String sql = "select p.descripcion, p.precio from producto p where p.id_pdt = '" + _id + "' && status = 1";
        try{
            rs = buscar(sql, con);
            if(rs.next()){
                txtProdName.setText(rs.getString("descripcion"));//se carga el nombre del producto en el txtFLD nombreProducto
                txtPrice.setText(Double.toString(rs.getDouble("precio")));//se carga el precio del producto en el txtFLD precio
                txt_price = Double.parseDouble(txtPrice.getText());//se guarda el precio en una variable para poder usarlo luego
                cantG = 0;
                precioG=0.0;
                suma = false;
            }
        }catch(Exception e){fun.msg("Hubo un error¡¡¡ " + e + "\n favor contactar al administrador ");}
        con.DesconectarBasedeDatos();
    }
    
    public ResultSet buscar(String sql, ConexionMySQL con){ //Metodo para realizar una consulta devuelve un ResultSet
        try{
            //con = new ConexionMySQL();
            con.ConectarBasedeDatos();
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    @FXML
    private void AgrProd(ActionEvent evt){
        int idp = Integer.parseInt(txtIDProd.getText());
        String sql = "SELECT pr.descripcion, pr.precio, de.porcentaje, iv.n_lote, iv.existencias from producto pr " +
                         " INNER JOIN inventario iv on pr.id_pdt = iv.id_pdt " +
                         " INNER JOIN descuentos de on pr.id_desc = de.id_desc "
                        +" where pr.id_pdt = " + idp;
        if(!txtIDProd.getText().isEmpty() && !txtPrice.getText().isEmpty()) agrProd(sql);
        else fun.msg("¡¡¡No hay productos para facturar!!");
        idp = 0;
    }
    
    @FXML
    private void SaveBill(ActionEvent evt){
        facturar();
    }
    
    @FXML
    private void RemProd(ActionEvent evt){
        quitarProd();
    }
    
    @FXML
    private void clean(ActionEvent evt){
        cleanTxt(pnlPrinc, "txtUser","");
        lblCant.setText("");
    }
    
    @FXML
    private void busc(ActionEvent evt){
        int id=0;
        if(!txtIDProd.getText().isEmpty()){
            buscartxt(id);
        }
    }
    
    @FXML
    private void IDProdkpr(KeyEvent evt){
        fun.validaNumeros(txtIDProd, 100);
        verifyEnter(evt);
        request(evt, txtDniCli);
    }
    
    @FXML
    private void Cantkpr(KeyEvent evt){
        fun.validaNumeros(txtCant, 20);
        sumado=false;
        if(!txtCant.getText().isEmpty() && !txtPrice.getText().isEmpty()) calCant(evt);
        System.out.println(sumado); 
   }
    
    @FXML
    private void dniCkpr(KeyEvent evt){
        fun.formatTD(txtDniCli, 2);
    }
    
    @FXML
    private void tblMC(MouseEvent evt){
        selRow();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillCBox();
        CargarIdFact();
    }    
}
