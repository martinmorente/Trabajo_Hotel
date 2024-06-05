package com.guarderiaJunior.Hotel.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ServicioExtra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicios_extra;
    private String tipo;
    private double precio;

    public ServicioExtra() {
    }

    public ServicioExtra(Long idServicioExtra, String nombreServicio, double precioServicio) {
        this.idServicios_extra = idServicioExtra;
        this.tipo = nombreServicio;
        this.precio = precioServicio;
    }

    public Long getIdServicioExtra() {
        return idServicios_extra;
    }

    public void setIdServicioExtra(Long idServicioExtra) {
        this.idServicios_extra = idServicioExtra;
    }

    public String getNombreServicio() {
        return tipo;
    }

    public void setNombreServicio(String nombreServicio) {
        this.tipo = nombreServicio;
    }

    public double getPrecioServicio() {
        return precio;
    }

    public void setPrecioServicio(double precioServicio) {
        this.precio = precioServicio;
    }

    @Override
    public String toString() {
        return "ServicioExtra{" +
                "idServicioExtra=" + idServicios_extra +
                ", nombreServicio='" + tipo + '\'' +
                ", precioServicio=" + precio +
                '}';
    }
}