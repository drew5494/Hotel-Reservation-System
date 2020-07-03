package sample;

//ANDREW TASSONE
//149242166

import java.util.*;

public class Hotel {
    private String b_name;
    private ArrayList<Login> bankacnts;
    private ArrayList<Room> rooms;
    private ArrayList<Guest> guests;
    private ArrayList<Reservation> reservations;
    private ArrayList<Bill> bills;

    public Hotel() {
        b_name = "Seneca@York";
        bankacnts = new ArrayList<Login>();
        rooms = new ArrayList<Room>();
        reservations = new ArrayList<Reservation>();
        guests = new ArrayList<Guest>();
        bills = new ArrayList<Bill>();
    }
    public Hotel(String a) {
        b_name = a;
        bankacnts = new ArrayList<Login>();
        rooms = new ArrayList<Room>();
        reservations = new ArrayList<Reservation>();
        guests = new ArrayList<Guest>();
        bills = new ArrayList<Bill>();
    }
    public String toString() {//overriding the toString() method
        int counter = 1;
        StringBuilder str = new StringBuilder();
        str.append("*** Welcome to the Hotel of " + b_name + " ***" + "\n It has " + bankacnts.size() + " accounts.\n");
        for(Login el:bankacnts){
//            str.append(counter++ + , name: " + el.getFullName() + ", balance: $" + el.getAccountBalance() + "\n");
        }
        return str.toString();
    }
    public boolean equals(Hotel b) {//overriding the toString() method
        return this.b_name == b.b_name && this.bankacnts.equals(b.bankacnts);
    }
    public boolean addAccount( Login newAccount ){
        if (newAccount == null  ){
            System.out.println("Account couldn't be added.");
            return false;
        }
        for (Login a : bankacnts) {
            if (a.getLoginId() == newAccount.getLoginId()) {
                System.out.println("Account couldn't be added.");
                return false;
            }
        }
        bankacnts.add(newAccount);
        System.out.println("Account " + newAccount.getLoginId() + " has been added successfully.");
        return true;
    }
    public boolean addRoom( Room room ){
        if (room == null  ){
            System.out.println("Room couldn't be added.");
            return false;
        }
        for (Room a : rooms) {
            if (a.getRoomId() == room.getRoomId()) {
                System.out.println("Room couldn't be added.");
                return false;
            }
        }
        rooms.add(room);
        System.out.println("Room " + room.getRoomId() + " has been added successfully.");
        return true;
    }
    public boolean addRes( Reservation res ){
        if (res == null){
            System.out.println("Reservation couldn't be added.");
            return false;
        }
        for (Reservation a : reservations) {
            if (a.getResID() == res.getResID()) {
                System.out.println("Reservation couldn't be added.");
                return false;
            }
        }
        reservations.add(res);
        System.out.println("Reservation ID " + res.getResID() + " at room number " + res.getRoom_ID() + " on " + res.getCheckIn() + " to " + res.getCheckOut() + " has been added successfully.");
        return true;
    }
    public boolean addGuest( Guest g ){
        if (g == null){
            System.out.println("Guest couldn't be added.");
            return false;
        }
        for (Guest a : guests) {
            if (a.getGuest_ID() == g.getGuest_ID()) {
                System.out.println("Guest couldn't be added.");
                return false;
            }
        }
        guests.add(g);
        System.out.println("Guest " + g.getFirst_name() + " " + g.getLast_name() + " has been added successfully.");
        return true;
    }
    public boolean addBill( Bill b ){
        if (b == null){
            System.out.println("Bill couldn't be added.");
            return false;
        }
        bills.add(b);
        System.out.println("Bill added successfully.");
        return true;
    }
    public String getName(){
        return b_name;
    }
    public boolean verify( Login newAccount ) {
            for (Login a : bankacnts) {
                if (a.getLoginId().equals(newAccount.getLoginId()) && a.getPass().equals(newAccount.getPass())) {
                    System.out.println("Login successful.");
                    return true;
                }
            }
            System.out.println("Login failed.");
            return false;
    }
    public ArrayList<Guest> getGuests(){
        return guests;
    }
    public ArrayList<Room> getRooms(){
        return rooms;
    }
    public ArrayList<Reservation> getReservations(){
        return reservations;
    }

}
