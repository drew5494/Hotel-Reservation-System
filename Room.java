package sample;

import java.util.concurrent.atomic.AtomicInteger;

public class Room {
    private static final AtomicInteger count = new AtomicInteger(100);
    private final int id;
    boolean taken = false;
    Double rate = 0.0;
    int max_guests = 0;
    public Room(){
        id = count.incrementAndGet();
    }
//        Scanner ng = new Scanner(System.in);  // Create a Scanner object
//        System.out.print("No of guests:");
//        max_guests = ng.nextInt();  // Read user input
//        if (max_guests == 1) {
//
//        }
//        Scanner ra = new Scanner(System.in);  // Create a Scanner object
//        System.out.print("Show the room available for the guests: ");
//        String rooms = ra.next();  // Read user input
//        Scanner rt = new Scanner(System.in);  // Create a Scanner object
//        System.out.print("Choose the room type:");
//        String srt = rt.next();  // Read user input
//        Scanner nd = new Scanner(System.in);  // Create a Scanner object
//        System.out.print("No of days to be booked for:");
//        String snd = nd.next();  // Read user input
//        Scanner r = new Scanner(System.in);  // Create a Scanner object
//        System.out.print("Rate to be offered /day:");
//        String rate = r.next();  // Read user input
    public int getRoomId() {
        return this.id;
    }
    public boolean isTaken() {
        return this.taken;
    }

    public void setTaken(boolean t) {
        this.taken = t;
    }

    public int getMax_guests() {
        return max_guests;
    }
    public String getType() {
        String className = this.getClass().getSimpleName();
        return className;
    }
    public void setRate(Double r) {
        this.rate = r;
    }
    public Double getRate() {
        return this.rate;
    }
}
    class Single_room extends Room {
        int max_guests = 2;
        @Override
        public int getMax_guests() {
            return max_guests;
        }
        // the MountainBike subclass adds one field
    }

    class Double_room extends Room {
        int max_guests = 4;
        @Override
        public int getMax_guests() {
            return max_guests;
        }
    }

    class Delux_room extends Room {
        String type = "Deluxe";
        int max_guests = 4;
        @Override
        public int getMax_guests() {
            return max_guests;
        }
    }

    class Pent_house extends Room {
        String type = "Penthouse";
        int max_guests = 4;
        @Override
        public int getMax_guests() {
            return max_guests;
        }
    }