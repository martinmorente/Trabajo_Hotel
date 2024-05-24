
package com.guarderiaJunior.Hotel.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
 @Table(name="Clientes")
public class Clientes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Nombre_Cliente;
    private String DNI_Cliente;
    private int Cantidad_Cliente;
    private String Fecha_Entrada;
    private String Fecha_Salida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public String getDNI_Cliente() {
        return DNI_Cliente;
    }

    public void setDNI_Cliente(String DNI_Cliente) {
        this.DNI_Cliente = DNI_Cliente;
    }

    public int getCantidad_Cliente() {
        return Cantidad_Cliente;
    }

    public void setCantidad_Cliente(int Cantidad_Cliente) {
        this.Cantidad_Cliente = Cantidad_Cliente;
    }

    public String getFecha_Entrada() {
        return Fecha_Entrada;
    }

    public void setFecha_Entrada(String Fecha_Entrada) {
        this.Fecha_Entrada = Fecha_Entrada;
    }

    public String getFecha_Salida() {
        return Fecha_Salida;
    }

    public void setFecha_Salida(String Fecha_Salida) {
        this.Fecha_Salida = Fecha_Salida;
    }


    @Override
    public String toString(){
        return "Clientes{"+"id="+id+",name="+Nombre_Cliente+",dniCliente="+DNI_Cliente+",cantidadClientes="+Cantidad_Cliente+",fechaEntrada="+Fecha_Entrada+",fechaSalida"+Fecha_Salida;
    }
    
}
