
package com.guarderiaJunior.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Habitaciones")
public class Habitaciones {

        @Id
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
            this.idHabitacion = IdHabitacion;
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