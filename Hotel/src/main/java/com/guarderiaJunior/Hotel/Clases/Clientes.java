
package com.guarderiaJunior.Hotel.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
 @Table(name="clientes")
public class Clientes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcliente;

    private String nombre_cliente;
    private String dni_cliente;
    private int cantidad_cliente;
    private String fecha_entrada;
    private String fecha_salida;

    public Long getId() {
        return idcliente;
    }

    public void setId(Long id) {
        this.idcliente = id;
    }

 


    @Override
    public String toString(){
        return "Clientes{"+"id="+idcliente+",name="+nombre_cliente+",dniCliente="+dni_cliente+",cantidadClientes="+cantidad_cliente+",fechaEntrada="+fecha_entrada+",fechaSalida"+fecha_salida;
    }

    public Long getIdclientes() {
        return idcliente;
    }

    public void setIdclientes(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getdNI_cliente() {
        return dni_cliente;
    }

    public void setdNI_cliente(String dNI_cliente) {
        this.dni_cliente = dNI_cliente;
    }

    public int getCantidad_cliente() {
        return cantidad_cliente;
    }

    public void setCantidad_cliente(int cantidad_cliente) {
        this.cantidad_cliente = cantidad_cliente;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    
}
