package com.uco.mantenimientoelectrodomesticos.modelo;

public class Electrodomestico {

    private Propietario propietario;

    private String nombreElectrodomestico;
    private String marcaElectrodomestico;

    private String idPropietario;
    private String serial;
    private String descripcion;
    private String observacionTecnica;
    private boolean activo;
    String fechaInicio;

    public Electrodomestico(String nombreElectrodomestico,String marcaElectrodomestico, String idPropietario, String serial,String descripcion, String observacionTecnica, boolean activo, String fechaInicio) {
        this.marcaElectrodomestico = marcaElectrodomestico;
        this.nombreElectrodomestico = nombreElectrodomestico;
        this.idPropietario = idPropietario;
        this.serial = serial;
        this.descripcion = descripcion;
        this.observacionTecnica = observacionTecnica;
        this.activo = activo;
    }

    public String getMarcaElectrodomestico() {
        return marcaElectrodomestico;
    }

    public void setMarcaElectrodomestico(String marcaElectrodomestico) {
        this.marcaElectrodomestico = marcaElectrodomestico;
    }

    public String getNombreElectrodomestico() {
        return nombreElectrodomestico;
    }

    public void setNombreElectrodomestico(String nombreElectrodomestico) {
        this.nombreElectrodomestico = nombreElectrodomestico;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getIdPropietario() {
        return propietario.getIdPropietario();
    }

    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacionTecnica() {
        return observacionTecnica;
    }

    public void setObservacionTecnica(String observacionTecnica) {
        this.observacionTecnica = observacionTecnica;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
