package com.uco.mantenimientoelectrodomesticos.modelo;


@SuppressWarnings("ALL")
public class Propietario {

    private String idP;
    private String nombre;
    private String correo;
    private String direccion;
    private String telefono;
    private String fechaInicio;

    public Propietario(String idP, String nombre, String correo, String direccion, String telefono, String fechaInicio) {
        this.idP = idP;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
    }

    public String getIdPropietario() {
        return idP;
    }

    public void setIdPropietario(String idPropietario) {
        this.idP = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}