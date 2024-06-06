package com.guarderiaJunior.Hotel.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicios_extras")
public class ServicioExtra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idservicios_extra;
    private String tipo;
    private double precio;

    public ServicioExtra() {
    }

    public ServicioExtra(Long idservicios_extra, String tipo, double precio) {
        this.idservicios_extra = idservicios_extra;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Long getIdServicioExtra() {
        return idservicios_extra;
    }

    public void setIdservicio_extra(Long idservicios_extra) {
        this.idservicios_extra = idservicios_extra;
    }

    public String getNombreServicio() {
        return tipo;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }

    public double getprecio() {
        return precio;
    }

    public void setpr(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ServicioExtra{" +
                "idServicios_extra=" + idservicios_extra +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
}