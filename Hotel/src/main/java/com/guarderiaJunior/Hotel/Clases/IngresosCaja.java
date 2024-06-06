
package com.guarderiaJunior.Hotel.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingresos_caja")
public class IngresosCaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idingresos_caja;

    private double impuestos_iva;

    public Long getId() {
        return idingresos_caja;
    }

    public void setId(Long idingresos_caja) {
        this.idingresos_caja = idingresos_caja;
    }

    public double getImpuestos_IVA() {
        return impuestos_iva;
    }

    public void setImpuestos_IVA(double impuestos_iva) {
        this.impuestos_iva = impuestos_iva;
    }
}
