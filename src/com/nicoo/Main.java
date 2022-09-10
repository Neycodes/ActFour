package com.nicoo;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner read = new Scanner(System.in);
    static Buyer buyer = new Buyer();
    public static void main(String[] args) {
        System.out.println("Is this shoe available?: " + buyer.isThere);
        Billing billing = new Billing();
        Seller seller = new Seller();
        PriceList priceList = new PriceList();
        seller.yesItIs();
        priceList.check();
        buyer.buy();
        billing.invoice();
        buyer.pay();

    }

    static class Buyer {

        String asking = read.nextLine();
        String isThere = asking;
        void buy(){
            System.out.println();
            System.out.println("Buying...");
        }
        void pay(){
            System.out.println("Payment sent ");
        }
    }

    static class Seller extends Billing{
        ShoeShelves shoeShelves = new ShoeShelves();

        void yesItIs() {
            if (shoeShelves.setShoeList().contains(buyer.isThere)) {
                System.out.println(buyer.isThere+" is available");
            } else
                System.out.println("Sorry, " + buyer.isThere + " is not available");

        }
    }

    static class ShoeShelves {
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

        void check() {
            System.out.println("The price of "+ buyer.isThere +" is P"+shoePrice[(setShoeList().indexOf(buyer.isThere))]);
        }
    }

        static class Billing extends PriceList{
        String[] inv = new String[]{" ", "ITEM",buyer.isThere.toUpperCase(Locale.ROOT)," ", " "," ", " ", "TOTAL", String.valueOf(shoePrice[setShoeList().indexOf(buyer.isThere)])," "};
        void invoice(){
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









