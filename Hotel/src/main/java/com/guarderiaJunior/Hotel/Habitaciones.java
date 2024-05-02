/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.guarderiaJunior.Hotel;

/**
 *
 * @author Jose Antonio
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Habitaciones {

        @idHabitacion
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        
        private Long idHabitacion;
        private String name;
        private double precio;
        private boolean disponibilidad;
        
        //GETTERS & SETTERS
        //IdHabitacion
        public Long getIdHabitacion(){
            return idHabitacion;
        }
        
        public void setIdHabitacion(Long IdHabitacion){
            this.idHabitacion =idHabitacion;
        }
        
        //Name
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        
        //Precio
        public double getPrecio(){
            return precio;
        }
        public void setPrecio(double precio){
            this.precio = precio;
        }
        
        //Disponibilidad
        public boolean getDisponibilidad(){
            return disponibilidad;
        }
        public void setDisponibilidad(boolean disponibilidad){
            this.disponibilidad = disponibilidad;
        }
    
}
