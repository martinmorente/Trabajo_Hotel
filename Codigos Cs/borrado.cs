using UnityEngine;
 
public class Borrado : MonoBehaviour
{
    public Conexion conexion;

    void Start()
    {
       
        conexion = FindObjectOfType<Conexion>();
        
    } 
    
    public void OnBorrarDatosClientes()
    {
        conexion.DeleteData("/api/Clientes");
    }

    public void OnBorrarDatosHabitaciones()
    {
        conexion.DeleteData("/api/Habitaciones");
    }

    public void OnBorrarDatosIngresosCaja()
    {
        conexion.DeleteData("/api/IngresosCaja");
    }

    public void OnBorrarDatosServicioExtra()
    {
        conexion.DeleteData("/api/ServicioExtra"); 
    }

}
/*Realizado por: Junior*/