package main.java.com.cajero.atm;

import java.util.Map;

public class DispenserDeBilletes implements Dispenser {
    private final int denomination;
    private Dispenser next;

    public DispenserDeBilletes(int denomination) {
        this.denomination = denomination;
    }

    @Override
    public void setNext(Dispenser next) {
        this.next = next;
    }

    @Override
    public void dispense(int amount, Map<Integer, Integer> result) {
        if (amount >= denomination) {
            int numBilletes = amount / denomination;
            int remainder = amount % denomination;
            
            result.put(denomination, numBilletes);
            
            if (remainder > 0 && next != null) {
                next.dispense(remainder, result);
            }
        } else if (next != null) {
            next.dispense(amount, result);
        }
    }
}