using UnityEngine;

public class datosCliente : MonoBehaviour{

    /*Definir datos*/

    public string nombre;
    public string dni;
    
    public string fechaEntrada;

    public string fechaSalida;



    /*inicializar los datos */

    void start(){
        nombre = "Marco Perez";
        dni = "5748483N";
        fechaEntrada = "12/05/2024";
        fechaSalida = "30/06/2024";
    }



    /*Método para obtener los datos */

    public string ObtenerDatosJson(){


        var datos = new 
        {
            nombre = this.nombre,
            dni = this.dni,
            fechaEntrada = this.fechaEntrada,
            fechaSalida = this.fechaSalida
        };

        return JsonUtility.ToJson(datos);
    }
}
/*Realizado por Martín*/
