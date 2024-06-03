using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class datosHabitaciones : MonoBehaviour
{
    /*Definimos los datos*/

    public string tipoHabitacion;

    public double precio;

    public Boolean dispobibilidad;

    // Inicializamos
   void start()
    {
        tipoHabitacion = "Simple";
        precio = 30.25;
        dispobibilidad = true;
    }

    // Obtenemos los datos
    public string ObtenerDatosJson(){

        var datos = new 
        {
            tipoHabitacion = this.tipoHabitacion,
            precio = this.precio,
            dispobibilidad = this.dispobibilidad
        };

        return JsonUtility.ToJson(datos);
    }

  
}
