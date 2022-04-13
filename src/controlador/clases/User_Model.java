package controlador.clases;

public class User_Model {

    String id_user,u_Name,rol;
    
    public User_Model(String _id_user, String _u_Name, String _rol){
        id_user = _id_user;
        u_Name = _u_Name;
        rol = _rol;
    }

    public void setId_user(String _id_user) {
        id_user = _id_user;
    }

    public void setU_Name(String _u_Name) {
        u_Name = _u_Name;
    }

    public void setRol(String _rol) {
        rol = _rol;
    }

    public String getId_user() {
        return id_user;
    }

    public String getU_Name() {
        return u_Name;
    }

    public String getRol() {
        return rol;
    }
}
