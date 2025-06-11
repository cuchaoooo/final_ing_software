package main.java.com.cajero.atm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private Dispenser chain;

    public ATM() {
        // 1. Construir la cadena de responsabilidad
        this.chain = new DispenserDeBilletes(100000);
        Dispenser d50k = new DispenserDeBilletes(50000);
        Dispenser d20k = new DispenserDeBilletes(20000);
        Dispenser d10k = new DispenserDeBilletes(10000);
        Dispenser d5k = new DispenserDeBilletes(5000);

        // 2. Definir el orden de la cadena
        chain.setNext(d50k);
        d50k.setNext(d20k);
        d20k.setNext(d10k);
        d10k.setNext(d5k);
    }

    public Map<Integer, Integer> retirar(int amount) {
        // 3. Validar que la cantidad es múltiplo de 5.000
        if (amount % 5000 != 0) {
            System.out.println("Error: La cantidad debe ser un múltiplo de 5.000.");
            return null;
        }

        // 4. Iniciar el proceso en la cadena y devolver el resultado
        Map<Integer, Integer> result = new LinkedHashMap<>(); // Para mantener el orden
        chain.dispense(amount, result);
        return result;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad a retirar: ");
        int amount = scanner.nextInt();

        Map<Integer, Integer> dispensed = atm.retirar(amount);

        if (dispensed != null) {
            System.out.println("Dispensando billetes:");
            for (Map.Entry<Integer, Integer> entry : dispensed.entrySet()) {
                System.out.println(entry.getValue() + " billete(s) de $" + String.format("%,d", entry.getKey()));
            }
        }
        scanner.close();
    }
}