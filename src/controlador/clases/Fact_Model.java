package controlador.clases;

public class Fact_Model {
    
    private String _id, descr, cant, price, isv, desc, lote;
    
    public Fact_Model(String id, String _descr, String _cant, String _price, String _isv, String _desc, String _lote){
         _id = id;
         descr = _descr;
         cant = _cant;
         price = _price;
         isv = _isv;
         desc = _desc;
         lote = _lote;
    }
    
    public String get_id(){
        return _id;
    }
    
    public String getLote(){
        return lote;
    }
    
    public String getDescr(){
        return  descr;
    }
    
    public String getCant(){
        return cant;
    }
    
    public String getPrice(){
        return price;
    }
    
    public String getIsv(){
        return isv;
    }
    
    public String getDesc(){
        return desc;
    }
    
    public void setIdProd(String _idProd){
        _id = _idProd;
    }
    
    public void setLote(String _lote){
        lote = _lote;
    }
    
    public void setDescr(String _descr){
        descr  = _descr;
    }
    
    public void setCant(String _cant){
        cant = _cant;
    }
    
    public void setPrice(String _price){
        price = _price;
    }
    
    public void setIsv(String  _isv){
        isv = _isv;
    }
    
    public void setDesc(String _desc){
        desc = _desc;
    }
}
