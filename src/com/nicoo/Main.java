package com.nicoo;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner read = new Scanner(System.in);
    static Buyer buyer = new Buyer();
    public static void main(String[] args) {
        System.out.println("Is this shoe available?: " );
        buyer.asking();
        System.out.println("How may I address you?: " );

        Seller seller = new Seller();
        buyer.name();
        seller.isAvailable();
        seller.available();
        seller.sPrice();
        buyer.buy();
        seller.invoice();
        buyer.pay();
    }

    static class Buyer extends Seller{
        String myName;
        String isThere;
        String asking(){
            String asking = read.nextLine();
            return isThere = asking;
        }

        void buy(){
            System.out.println();
            System.out.println("Buying...");
        }
        void pay(){
            System.out.println("Payment sent ");
        }
        String name(){
            String name = read.nextLine();
            return myName = name;
        }


    }

    static class Seller extends Billing{

        boolean isAvail;
        boolean isAvailable() {
            return isAvail = setShoeList().contains(buyer.isThere);
        }
        void available(){
            if (isAvail) {
                System.out.println(buyer.isThere+" is available");
            }else{
                System.out.println("Sorry, " + buyer.myName+" "+ buyer.isThere + " is not available yet");
                System.exit(0);
            }
        }

    }

    static class ShoeShelves  {
        ArrayList<String> shoeList = new ArrayList<>();
        ArrayList<String> setShoeList() {
            shoeList.add("Airforce 1");
            shoeList.add("Airforce 2");
            shoeList.add("Airforce 3");
            shoeList.add("Airforce 4");
            shoeList.add("Airforce 5");
            shoeList.add("Airforce 6");
            shoeList.add("Airforce 7");
            shoeList.add("Airforce 8");
            shoeList.add("Airforce 9");

            return shoeList;
        }
    }

    static class PriceList extends ShoeShelves {
        int[] shoePrice = new int[]{1100, 2100, 1300, 4100, 5100, 1600, 1700, 1800, 1900, 9011};
         void sPrice(){
             System.out.println("The price of "+ buyer.isThere +" is P"+shoePrice[(setShoeList().indexOf(buyer.isThere))]);
         }
    }

        static class Billing extends PriceList{

        void invoice(){
            String[] inv = new String[]{" ","NAME                               " + buyer.myName , " ", "ITEM                           "+ buyer.isThere.toUpperCase(Locale.ROOT)," ",  " ", "TOTAL                             "+ (shoePrice[setShoeList().indexOf(buyer.isThere)])," ", " ", " "};
            System.out.println();
            System.out.println(" ============================================");
            System.out.println("                    Invoice");
            for (int i = 0; i < 10; i++) {
                System.out.println("|"+inv[i]  );
            }
            System.out.println(" ============================================");
        }

    }
}









