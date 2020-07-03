package sample;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;  // Import the Scanner class

import static java.time.temporal.ChronoUnit.DAYS;

class FinancialApp<bankName> {

    private static Hotel bnk;
    private static int choice = 0;
    static void loadHotel(){
        bnk = new Hotel("Hotel Transylvania");
        boolean access = false;
        bnk.addAccount(new Login("drew", "password"));
        bnk.addAccount(new Login("Mahboob", "1234"));
        for (int i = 0; i < 50; i++) {
            if (i >= 40) {
                bnk.addRoom(new Pent_house());
            } else {
                bnk.addRoom(new Delux_room());
            }
            bnk.addRoom(new Double_room());
            bnk.addRoom(new Double_room());
            bnk.addRoom(new Single_room());
            bnk.addRoom(new Single_room());
        }
        do {
            Login three = new Login();
            if(bnk.verify(three))
                access = true;
        } while (!access);
    }
    static void displayMenu() {
        System.out.println("Welcome to " + bnk.getName() + " Bank!");
        System.out.println("1. Book a room.\n2. Bill service.");
        System.out.println("3. Current booking.\n4. Available rooms.");
        System.out.println("5. Exit.");
    }
//    static boolean bookRoom(String type){
//            }
//        System.out.println("No rooms found.");
//            return false;
//    }

    static void menuChoice(){
        Scanner s1 = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Please enter your choice>");
        choice = s1.nextInt();  // Read user input
    }

    public static void main(String[] args) {
        loadHotel();
        do {
            displayMenu();
            menuChoice();
            if (choice == 1) {
                Scanner ng = new Scanner(System.in);
                System.out.print("No of guests: ");
                int num = ng.nextInt();
                int count = 0;
                int s = 0;
                int d = 0;
                int de = 0;
                int p = 0;
                for (Room obj : bnk.getRooms()) {
                    if (!obj.isTaken() && obj.getMax_guests() >= num) {
                        count++;
                        if (obj.getType().equals("Single_room")) {
                            s++;
                        }
                        if (obj.getType().equals("Double_room")) {
                            d++;
                        }
                        if (obj.getType().equals("Delux_room")) {
                            de++;
                        }
                        if (obj.getType().equals("Pent_house")) {
                            p++;
                        }
                    }
                }
                System.out.println(count + " rooms are available:\n" + s + " Single Rooms\n" + d + " Double Rooms\n" + de + " Deluxe Rooms\n" + p + " Penthouse Rooms");
                Scanner t = new Scanner(System.in);
                System.out.print("Choose the room type: ");
                String type = t.next();
                for (Room obj : bnk.getRooms()) {
                    if (obj.getType().equals(type) && !obj.isTaken()) {
                        int rid = obj.getRoomId();
                        obj.setTaken(true);
                        Scanner nd = new Scanner(System.in);
                        System.out.print("No of days to be booked for: ");
                        int num_days = nd.nextInt();
                        Date start = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
                        Date end = Date.from(LocalDate.now().plusDays(num_days).atStartOfDay(ZoneId.systemDefault()).toInstant());
                        Scanner rt = new Scanner(System.in);
                        System.out.print("Rate to be offered /day: ");
                        Double rate = rt.nextDouble();
                        obj.setRate(rate);
                        Guest g = new Guest();
                        bnk.addGuest(g);
                        bnk.addRes(new Reservation(start, end, rid, g.getGuest_ID()));
                        break;
                    }
                }
            }
            if (choice == 2){
                Scanner bid = new Scanner(System.in);
                System.out.println("Enter booking ID: ");
                int id = bid.nextInt();
                for (Reservation obj : bnk.getReservations()) {
                    if (obj.getResID() == id){
                       System.out.println("Booking ID: " + obj.getResID());
                       for (Guest obj2 : bnk.getGuests()) {
                           if(obj2.getGuest_ID() == obj.getResID()){
                               System.out.println("Guest Name:" + obj2.getFirst_name() + " " + obj2.getLast_name());
                           }
                       }
                        for (Room obj3 : bnk.getRooms()) {
                            if(obj3.getRoomId() == obj.getRoom_ID()){
//                                System.out.println("No of rooms booked: " + obj.get() + " " + obj2.getLast_name());
                                System.out.println("Type of rooms: " + obj3.getClass().getSimpleName());
                                System.out.println("Rate per night: " + obj3.getRate());
                                Scanner d = new Scanner(System.in);
                                System.out.print("Discounts: %");
                                int discount = d.nextInt();
                                while (discount > 25){
                                    System.out.print("Discount is not acceptable. Please try again: ");
                                    discount = d.nextInt();
                                }
                                LocalDate date1 = obj.getCheckIn().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                                LocalDate date2 = obj.getCheckOut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                                long daysBetween = DAYS.between(date1, date2);
                                double prediscount = obj3.getRate()*daysBetween;
                                double total = prediscount - prediscount*(double)discount/100.00;
                                Bill b = new Bill(total);
                                bnk.addBill(b);
                                obj.setBillID(b.getBill_ID());
                                System.out.println("Total Amount: " + total);
                            }
                        }
                       }
                    }
                }
            if (choice == 3){
                System.out.println("Booking #         Customer Name       Room Type        No of Rooms      No of Days");
                for (Reservation res : bnk.getReservations()) {
                    for (Room room : bnk.getRooms()){
                    for (Guest guest : bnk.getGuests()){
                            if (room.getRoomId() == res.getRoom_ID()){
                                if (guest.getGuest_ID() == res.getGuest_ID()){
                                    String rtype = room.getClass().getSimpleName();
                                    LocalDate date1 = res.getCheckIn().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                                    LocalDate date2 = res.getCheckOut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                                    long daysBetween = DAYS.between(date1, date2);
                                    System.out.println(res.getResID() + "   " + guest.getFirst_name() + "   " + guest.getLast_name() + "  " + rtype + " " + daysBetween);
                            }
                        }
                    }
                    }
                }
            }
            if (choice == 4){
                System.out.println("Room ID       Room Type");
                for (Room room : bnk.getRooms()) {
                    if (!room.isTaken()) {
                        System.out.println(room.getRoomId() + "   " + room.getType());
                    }
                }
            }
            }
        while (choice != 5);
        System.out.println("Thank you!");
    }
}