package sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Reservation {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int Book_ID;
    private Date Check_in;
    private Date Check_out;
    private int Room_ID;
    private int Guest_ID;
    private int Bill_ID;
    public Reservation(Date Check_in, Date Check_out, int Room_ID, int Guest_ID){
        this.Check_in = Check_in;
        this.Check_out = Check_out;
        Book_ID = count.incrementAndGet();
        this.Room_ID = Room_ID;
        this.Guest_ID = Guest_ID;
    }
    public int getResID(){
        return this.Book_ID;
    }
    public void setBillID(int b){
        this.Bill_ID = b;
    }
    public int getRoom_ID(){
        return this.Room_ID;
    }
    public int getGuest_ID(){
        return this.Guest_ID;
    }
    public Date getCheckIn(){
        return this.Check_in;
    }
    public Date getCheckOut(){
        return this.Check_out;
    }

}
