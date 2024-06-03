using UnityEngine;
using UnityEngine.Networking;
using System.Collections;

public class Conexion : MonoBehaviour
{
    private string apiUrl = "http://127.0.0.1:8080";
    private string urlFinal;


	public void SelectData(string url){
		urlFinal = apiUrl + url;
		StartCoroutine(GetDataFromApi());
	}

    IEnumerator GetDataFromApi()
    {
        using (UnityWebRequest webRequest = UnityWebRequest.Get(urlFinal))
        {
            Debug.Log("Cargando....");
            yield return webRequest.SendWebRequest();
            
            if (webRequest.result != UnityWebRequest.Result.Success)
            {
                Debug.Log(webRequest.error);
            }
            else
            {
                string responseData = webRequest.downloadHandler.text;
                Debug.Log(responseData);
            }
        }
    }

    public void InsertData(string url, string jsonData)
    {
        urlFinal = apiUrl + url;
        StartCoroutine(PostDataToApi(jsonData));
    }

    IEnumerator PostDataToApi(string jsonData)
    {
        using (UnityWebRequest webRequest = UnityWebRequest.PostWwwForm(urlFinal, jsonData))
        {
            webRequest.SetRequestHeader("Content-Type", "application/json");

            byte[] bodyRaw = System.Text.Encoding.UTF8.GetBytes(jsonData);
            webRequest.uploadHandler = new UploadHandlerRaw(bodyRaw);
            webRequest.downloadHandler = new DownloadHandlerBuffer();

            Debug.Log("Enviando datos...");
            yield return webRequest.SendWebRequest();

            if (webRequest.result != UnityWebRequest.Result.Success)
            {
                Debug.Log(webRequest.error);
            }
            else
            {
                string responseData = webRequest.downloadHandler.text;
                Debug.Log("Datos insertados: " + responseData);
            }
        }
    }

    public void DeleteData(string url)
    {
        urlFinal = apiUrl + url;
        StartCoroutine(DeleteDataFromApi());
    }

    IEnumerator DeleteDataFromApi()
    {
        using (UnityWebRequest webRequest = UnityWebRequest.Delete(urlFinal))
        {
            Debug.Log("Eliminando datos...");
            yield return webRequest.SendWebRequest();

            if (webRequest.result != UnityWebRequest.Result.Success)
            {
                Debug.Log(webRequest.error);
            }
            else
            {
                Debug.Log("Datos eliminados correctamente.");
            }
        }
    }
}
/*Realizado por Martín*/