package sample;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Guest {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int Guest_ID;
    private int Title;
    private String First_name;
    private String Last_name;
    private String Address;
    private long Phone;
    private String Email;

    public Guest() {
        Guest_ID = count.incrementAndGet();
        Scanner t = new Scanner(System.in);
        System.out.print("Title: ");
        this.First_name = t.next();
        this.Last_name = t.next();
        Scanner a = new Scanner(System.in);
        System.out.print("Address: ");
        this.Address = a.nextLine();
        Scanner p = new Scanner(System.in);
        System.out.print("Phone: ");
        this.Phone = p.nextLong();
        Scanner e = new Scanner(System.in);
        System.out.print("Email: ");
        this.Email = e.nextLine();
    }
    public int getGuest_ID(){
        return Guest_ID;
    }
    public int getTitle(){
        return Guest_ID;
    }
    public String getFirst_name() {
        return First_name;
    }
    public String getLast_name(){
        return Last_name;
    }
}
