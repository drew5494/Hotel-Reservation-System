package sample;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Bill {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int Bill_ID;
    private double Amount_toPay;
    public Bill(double Amount_toPay){
        Bill_ID = count.incrementAndGet();
        this.Amount_toPay = Amount_toPay;
    }

    public int getBill_ID() {
        return Bill_ID;
    }
}
