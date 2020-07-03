package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;



public class Login {
    private String Login_id;
    private String Login_psd;
    public Login() {
        boolean access = false;
            Scanner id = new Scanner(System.in);  // Create a Scanner object
            Scanner pass = new Scanner(System.in);  // Create a Scanner object
            System.out.print("Please enter account ID>");
            String sid = id.next();  // Read user input
            System.out.print("Please enter a password>");
            String spass = pass.next();  // Read user input
                this.Login_id = sid;
                this.Login_psd = spass;
    }
    public Login(String id, String psd) {
        if (id != null && psd != null) {
            Login_id = id;
            Login_psd = psd;
        } else {
            System.out.println("Cant be null");
        }
    }
//    public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append(String.format("%-20s", "Name"));
//        sb.append(": " + this.fullName + '\n');
//        sb.append(String.format("%-20s", "Number"));
//        sb.append(": " + this.accountNumber + '\n');
//        sb.append(String.format("%-20s", "Current Balance"));
//        sb.append(": " + this.balance + '\n');
//        String s = sb.toString();
//        return s;
//    }


    public String getLoginId() {
        return this.Login_id;
    }
    public String getPass() {
        return this.Login_psd;
    }

//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        } else if (obj != null && this.getClass() == obj.getClass()) {
//            Login other = (Login)obj;
//            if (this.Login_id == null) {
//                if (other.Login_id != null) {
//                    return false;
//                }
//            } else if (!this.Login_id.equals(other.Login_id)) {
//                return false;
//            }
//
//            if (!this.Login_id.equals(other.Login_id)) {
//                return false;
//            } else {
//                if (this.Login_id == null) {
//                    if (other.Login_id != null) {
//                        return false;
//                    }
//                } else if (!this.Login_id.equals(other.Login_id)) {
//                    return false;
//                }
//
//                return true;
//            }
//        } else {
//            return false;
//        }
//    }
}
