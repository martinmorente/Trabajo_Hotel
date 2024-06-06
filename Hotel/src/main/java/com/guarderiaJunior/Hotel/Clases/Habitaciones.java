
package com.guarderiaJunior.Hotel.Clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Habitaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idhabitacion;
    private String tipohab;

    @Column(name = "precio")
    private double precio;
    private boolean disponibilidad;

    // GETTERS & SETTERS
    // IdHabitacion
    public Long getIdHabitacion() {
        return idhabitacion;
    }

    public void setIdHabitacion(Long idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    // Name
    public String getName() {
        return tipohab;
    }

    public void setName(String tipohab) {
        this.tipohab = tipohab;
    }

    // Precio
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Disponibilidad
    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }


    @Override
    public String toString(){
        return "Habitaciones{"+"id="+idhabitacion+",tipo habitacion="+tipohab+",precio="+precio+",disponibilidad="+disponibilidad;
    }

}