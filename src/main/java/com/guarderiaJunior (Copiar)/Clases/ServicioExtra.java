package com.guarderiaJunior.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity

public class ServicioExtra {
    private int idServicioExtra;
    private String nombreServicio;
    private double precioServicio;

    public ServicioExtra() {
    }

    public ServicioExtra(int idServicioExtra, String nombreServicio, double precioServicio) {
        this.idServicioExtra = idServicioExtra;
        this.nombreServicio = nombreServicio;
        this.precioServicio = precioServicio;
    }

    public int getIdServicioExtra() {
        return idServicioExtra;
    }

    public void setIdServicioExtra(int idServicioExtra) {
        this.idServicioExtra = idServicioExtra;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public double getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(double precioServicio) {
        this.precioServicio = precioServicio;
    }

    @Override
    public String toString() {
        return "ServicioExtra{" +
                "idServicioExtra=" + idServicioExtra +
                ", nombreServicio='" + nombreServicio + '\'' +
                ", precioServicio=" + precioServicio +
                '}';
    }
}