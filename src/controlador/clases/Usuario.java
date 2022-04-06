package controlador.clases;

import java.io.InputStream;

public class Usuario {
    public String idEmp;
    public String idUsuario;
    public String Nombres;
    public String Apellidos;
    public String Usuario;
    public String DNI;
    public String Genero;
    public String Direccion;
    public String Telefono;
    public String Correo;
    public String Cargo;
    public InputStream entradaFoto;


    public Usuario(String id, String Nombres, String Apellidos, String Usuario, String DNI, String Genero, String Direccion, String Telefono, String Correo, String Cargo, InputStream entradaFoto) {
        this.idEmp = id;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Usuario = Usuario;
        this.DNI = DNI;
        this.Genero = Genero;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Cargo = Cargo;
        this.entradaFoto = entradaFoto;
    }
    
    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public InputStream getEntradaFoto() {
        return entradaFoto;
    }

    public void setEntradaFoto(InputStream entradaFoto) {
        this.entradaFoto = entradaFoto;
    }

    public String getId() {
        return idEmp;
    }

    public void setIdEmp(String id) {
        this.idEmp = id;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}

