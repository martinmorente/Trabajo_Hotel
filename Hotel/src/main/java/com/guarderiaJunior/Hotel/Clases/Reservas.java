
package com.guarderiaJunior.Hotel.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idreservas;

    public Long getId() {
        return idreservas;
    }

    public void setId(Long idreservas) {
        this.idreservas = idreservas;
    }

}
