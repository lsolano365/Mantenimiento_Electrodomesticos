package com.uco.mantenimientoelectrodomesticos;

public class Electrodomestico {

    private int idElectrodomestico;
    private String nombreElectrodomestico;
    private String serial;
    private boolean activo;

    public Electrodomestico(int idElectrodomestico, String nombreElectrodomestico, String serial, boolean activo) {
        this.idElectrodomestico = idElectrodomestico;
        this.nombreElectrodomestico = nombreElectrodomestico;
        this.serial = serial;
        this.activo = activo;
    }

    public int getIdElectrodomestico() {
        return idElectrodomestico;
    }

    public void setIdElectrodomestico(int idElectrodomestico) {
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
}
