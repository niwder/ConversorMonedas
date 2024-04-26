import org.json.JSONObject; // Importar la clase JSONObject de la biblioteca JSON
import java.io.IOException;

public class CurrencyConverter {

    private ApiClient apiClient; // Declarar una variable para almacenar el cliente de la API

    // Constructor que recibe un objeto ApiClient como argumento
    public CurrencyConverter(ApiClient apiClient) {
        this.apiClient = apiClient; // Asignar el cliente de la API recibido al campo apiClient
    }

    // Método para convertir una cantidad de una moneda a otra
    public double convert(String fromCurrency, String toCurrency, double amount) throws IOException {
        // Obtener los datos de cambio de la moneda de origen utilizando el cliente de la API
        String exchangeData = apiClient.getExchangeRate(fromCurrency);

        // Crear un objeto JSONObject para analizar los datos de cambio
        JSONObject jsonObject = new JSONObject(exchangeData);

        // Obtener el objeto JSON que contiene las tasas de conversión
        JSONObject rates = jsonObject.getJSONObject("conversion_rates");

        // Obtener la tasa de cambio de la moneda de origen a la moneda de destino
        double exchangeRate = rates.getDouble(toCurrency);

        // Calcular el monto convertido multiplicando la cantidad por la tasa de cambio
        return exchangeRate * amount;
    }
}