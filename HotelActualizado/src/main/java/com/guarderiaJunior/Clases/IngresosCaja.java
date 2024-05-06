
package com.guarderiaJunior.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Ingresos_Caja")
public class IngresosCaja {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private double impuestos_IVA;
    private int pagos_personal;
    private double ingresos_totales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getImpuestos_IVA() {
        return impuestos_IVA;
    }

    public void setImpuestos_IVA(double impuestos_IVA) {
        this.impuestos_IVA = impuestos_IVA;
    }

    public int getPagos_personal() {
        return pagos_personal;
    }

    public void setPagos_personal(int pagos_personal) {
        this.pagos_personal = pagos_personal;
    }

    public double getIngresos_totales() {
        return ingresos_totales;
    }

    public void setIngresos_totales(double ingresos_totales) {
        this.ingresos_totales = ingresos_totales;
    }
    
}
