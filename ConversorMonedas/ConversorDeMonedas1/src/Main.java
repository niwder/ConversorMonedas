import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Definir la clave de la API para acceder al servicio de conversión de moneda
        String apiKey = "819327f5989b2c83f3840935";

        // Crear una instancia de ApiClient pasando la clave de la API como argumento
        ApiClient apiClient = new ApiClient(apiKey);

        // Crear una instancia de CurrencyConverter pasando el cliente de la API como argumento
        CurrencyConverter currencyConverter = new CurrencyConverter(apiClient);

        // Mostrar un mensaje de bienvenida al usuario
        System.out.println("*****************************************************");
        System.out.println("¡Bienvenid/a al Conversor de Monedas :D!");

        // Loop principal para mostrar el menú y procesar las opciones del usuario
        while (true) {
            // Mostrar el menú de opciones al usuario
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Convertir Dolar a Peso Argentino");
            System.out.println("2. Convertir Peso Argentino a Dolar");
            System.out.println("3. Convertir Dolar a Real Brasileño");
            System.out.println("4. Convertir Real Brasileño a Dolar");
            System.out.println("5. Convertir Dolar a Peso Colombiano");
            System.out.println("6. Convertir Peso Colombiano a Dolar");
            System.out.println("7. Convertir Dolar a Peso Dominicano");
            System.out.println("8. Convertir Peso Dominicano a Dolar");
            System.out.println("9. Salir");

            // Leer la opción seleccionada por el usuario
            int opcion = scanner.nextInt();

            // Si el usuario selecciona la opción 9, salir del bucle
            if (opcion == 9) {
                System.out.println("*****************************************************");
                System.out.println("¡Gracias por usar nuestro convertidor de Monedas :D!");
                break;
            }

            try {
                double cantidad;
                // Procesar la opción seleccionada por el usuario
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la cantidad en dólares:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " dólares corresponden a " + currencyConverter.convert("USD", "ARS", cantidad) + " pesos argentinos.");
                        break;
                    case 2:
                        System.out.println("Ingrese la cantidad en pesos argentinos:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " pesos argentinos corresponden a " + currencyConverter.convert("ARS", "USD", cantidad) + " dólares.");
                        break;
                    case 3:
                        System.out.println("Ingrese la cantidad en dólares:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " dólares corresponden a " + currencyConverter.convert("USD", "BRL", cantidad) + " reales brasileños.");
                        break;
                    case 4:
                        System.out.println("Ingrese la cantidad en reales brasileños:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " reales brasileños corresponden a " + currencyConverter.convert("BRL", "USD", cantidad) + " dólares.");
                        break;
                    case 5:
                        System.out.println("Ingrese la cantidad en dólares:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " dólares corresponden a " + currencyConverter.convert("USD", "COP", cantidad) + " pesos colombianos.");
                        break;
                    case 6:
                        System.out.println("Ingrese la cantidad en pesos colombianos:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " pesos colombianos corresponden a " + currencyConverter.convert("COP", "USD", cantidad) + " dólares.");
                        break;
                    case 7:
                        System.out.println("Ingrese la cantidad en Dolares:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " dolares corresponden a " + currencyConverter.convert("USD", "DOP", cantidad) + " pesos dominicanos.");
                        break;
                    case 8:
                        System.out.println("Ingrese la cantidad en pesos dominicanos:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " pesos dominicanos corresponden a " + currencyConverter.convert("DOP", "USD", cantidad) + " dólares.");
                        break;

                    default:
                        System.out.println("Opción no válida, por favor seleccione una opción válida.");
                        break;
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        // Cerrar el Scanner para liberar los recursos
        scanner.close();
    }
}