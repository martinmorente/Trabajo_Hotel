 
using UnityEngine;
 
public class DatosServiciosExtras : MonoBehaviour{
 
    /*Definir datos*/
    public string tipo;
    public double precio;
 
    /*inicializar los datos */
    void start(){
        tipo = "Fontaneria";
        precio = 30;
    }
 
    /*Método para obtener los datos */
    public string ObtenerDatosServicioExtraJson(){
 
 
        var datosServicioExtra = new 
        {
            tipo = this.tipo,
            precio = this.precio,
        };
 
        return JsonUtility.ToJson(datosServicioExtra);
    }
}

/*Realizado por Junior*/