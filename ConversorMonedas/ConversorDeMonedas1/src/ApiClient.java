import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiClient {

    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/"; // URL base de la API
    private String apiKey; // Clave de API

    // Constructor que recibe la clave de API como argumento
    public ApiClient(String apiKey) {
        this.apiKey = apiKey; // Asignar la clave de API recibida al campo apiKey
    }

    // Método para obtener los datos de cambio de una moneda específica
    public String getExchangeRate(String baseCurrency) throws IOException {
        // Construir la URL completa para la solicitud de la API
        URL url = new URL(API_BASE_URL + apiKey + "/latest/"+ baseCurrency);

        // Abrir una conexión HTTP con la URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET"); // Establecer el método de solicitud como GET

        // Obtener el código de respuesta de la conexión
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // Si la solicitud es exitosa
            // Crear un Scanner para leer la respuesta de la conexión
            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder(); // StringBuilder para almacenar la respuesta

            // Leer la respuesta línea por línea y agregarla al StringBuilder
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }

            scanner.close(); // Cerrar el Scanner
            return response.toString(); // Devolver la respuesta como una cadena
        } else {
            // Si la solicitud no es exitosa, lanzar una excepción con un mensaje de error
            throw new IOException("Failed to fetch data from API: " + responseCode);
        }
    }
}