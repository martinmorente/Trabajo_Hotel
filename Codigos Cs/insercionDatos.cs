using UnityEngine;

public class Insercion : MonoBehaviour
{
    private Conexion conexion;
    private datosCliente datosC;
    private datosHabitaciones datosH;
    private datosIngresosCaja datosIngresos;
    private DatosServiciosExtras datosServicios;

    void Start()
    {
        conexion = FindObjectOfType<Conexion>(); 
        datosC = FindObjectOfType<datosCliente>();
        datosH = FindObjectOfType<datosHabitaciones>();
        datosIngresos = FindObjectOfType<datosIngresosCaja>();
        datosServicios = FindObjectOfType<DatosServiciosExtras>();

    }

    public void insercionCliente()
    {
        string jsonData = datosC.ObtenerDatosJson();
        conexion.InsertData("/api/Clientes", jsonData);
    }

    public void inserccionHabitaciones()
    {
        string jsonData = datosH.ObtenerDatosJson();
        conexion.InsertData("/api/Habitaciones", jsonData);
    }

    public void inserccionIngresosCaja()
    {
        string jsonData = datosIngresos.ObtenerDatosJson();
        conexion.InsertData("/api/IngresosCaja", jsonData);
    }

    public void inserccionServiciosExtra()
    {
        string jsonData = datosServicios.ObtenerDatosServicioExtraJson();
        conexion.InsertData("/api/ServiciosExtra", jsonData);
    }
}
