using UnityEngine;
using System.Collections.Generic;

public class DatabaseTest : MonoBehaviour
{
     public Conexion conexion;
 
    void Start()
    {

        conexion = FindObjectOfType<Conexion>();
        
    } 

      public void OnSeleccionarDatosClientes()
    {
        conexion.SelectData("/api/Clientes");
    }

    public void OnSeleccionarDatosHabitaciones()
    {
        conexion.SelectData("/api/Habitaciones");
    }

    public void OnSeleccionarIngresosCaja()
    {
        conexion.SelectData("/api/IngresosCaja");
    }
    public void OnSeleccionarDatosServicioExtra()
    {
        conexion.SelectData("/api/ServicioExtra");
    }
}
/*Realizado por: Coral*/