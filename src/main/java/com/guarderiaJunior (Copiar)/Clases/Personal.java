
package com.guarderiaJunior.Clases;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Personal")

public class Personal{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idPersonal;

private String Cocina;
private String Limpieza;
private String Reparacion;

private Long idServicios_Extra;

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public void setCocina(String Cocina) {
        this.Cocina = Cocina;
    }

    public void setLimpieza(String Limpieza) {
        this.Limpieza = Limpieza;
    }

    public void setReparacion(String Reparacion) {
        this.Reparacion = Reparacion;
    }

    public void setIdServicios_Extra(Long idServicios_Extra) {
        this.idServicios_Extra = idServicios_Extra;
    }

    public Long getIdPersonal() {
        return idPersonal;
    }

    public String getCocina() {
        return Cocina;
    }

    public String getLimpieza() {
        return Limpieza;
    }

    public String getReparacion() {
        return Reparacion;
    }

    public Long getIdServicios_Extra() {
        return idServicios_Extra;
    }

}
