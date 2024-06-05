using System.Collections;
using UnityEngine.Networking;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Script_Menu : MonoBehaviour
{
    /*Botones Interfaz*/
    public void AccederHotel(string hotel){
        SceneManager.LoadScene(hotel);
    }

    public void salir()
    {
        Application.Quit();
        Debug.Log("Saliendo el juego illo");
    }
}
/*Coral, Ludmila, Junior, Martín*/