package main.java.com.cajero.atm;

import java.util.Map;

public interface Dispenser {
    void setNext(Dispenser next);

    /**
     * Procesa la solicitud para dispensar una cantidad.
     * @param amount 
     * @param result 
     */
    void dispense(int amount, Map<Integer, Integer> result);
}