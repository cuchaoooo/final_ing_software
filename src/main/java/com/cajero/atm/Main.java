package main.java.com.cajero.atm;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Cajero Automático - Patrón Chain of Responsibility ");
        System.out.println("----------------------------------------------------");
        System.out.print("Ingrese la cantidad a retirar: ");

        // Validar que la entrada sea un número entero
        if (!scanner.hasNextInt()) {
            System.out.println("Error: Por favor, ingrese un número válido.");
            scanner.close();
            return;
        }

        int amount = scanner.nextInt();

        // Utilizar la clase ATM para procesar el retiro
        Map<Integer, Integer> dispensed = atm.retirar(amount);

        // Si el retiro fue exitoso (no nulo), imprimir el resultado
        if (dispensed != null) {
            if (dispensed.isEmpty()) {
                System.out.println("No se dispensó ningún billete para el monto solicitado.");
            } else {
                System.out.println("Dispensando billetes:");
                // Iterar sobre el mapa de resultados para mostrar el desglose
                for (Map.Entry<Integer, Integer> entry : dispensed.entrySet()) {
                    System.out.println(entry.getValue() + " billete(s) de $" + String.format("%,d", entry.getKey()));
                }
            }
        }

        // Siempre cerrar el scanner para liberar recursos
        scanner.close();
    }
}
