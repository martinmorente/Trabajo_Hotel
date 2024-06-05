using UnityEngine;

public class datosIngresosCaja : MonoBehaviour{

    /*Definir datos*/

    public double impuestos_iva;
    public double pagos_personal;
    public double ingresos_totales;



    /*inicializar los datos */

    void start(){
        impuestos_iva = 25.13;
        pagos_personal = 1200;
        ingresos_totales = 30000;
    }



    /*Método para obtener los datos */

    public string ObtenerDatosJson(){


        var datos = new 
        {
            impuestos_iva = this.impuestos_iva,
            pagos_personal = this.pagos_personal,
            ingresos_totales = this.ingresos_totales
        };

        return JsonUtility.ToJson(datos);
    }
}

/*Realizado por: Ludmila*/