package com.uco.mantenimientoelectrodomesticos.modelo;

public class Electrodomestico {

    private Propietario propietario;

    private String idElectrodomestico;
    private String nombreElectrodomestico;
    private String idPropietario;
    private String serial;
    private boolean activo;

    public Electrodomestico(String idElectrodomestico, String nombreElectrodomestico,String idPropietario, String serial, boolean activo) {
        this.idElectrodomestico = idElectrodomestico;
        this.nombreElectrodomestico = nombreElectrodomestico;
        this.idPropietario = idPropietario;
        this.serial = serial;
        this.activo = activo;
    }

    public String getIdElectrodomestico() {
        return idElectrodomestico;
    }

    public void setIdElectrodomestico(String idElectrodomestico) {
        this.idElectrodomestico = idElectrodomestico;
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
}
