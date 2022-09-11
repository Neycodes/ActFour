/*
Activity 5
CADA, GIANNA ALYANNA
CLOMA, PRANZ ANGELO
ESCOBAL, YVONNE
LLOSA, EDUARDO DOMINICO
QUINONEZ, DIANA RYNE
CSCC 20 B - OBJECT-ORIENTED PROGRAMMING
*/
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

        Seller seller = new Seller();

        seller.isAvailable();
        seller.available();
        seller.sPrice();

        System.out.println("How may I address you?: " );
        buyer.name();
        buyer.buy();
        seller.invoice();
        buyer.pay();
    }

    static class Buyer extends Seller{
        String myName;
        String isThere;
        void asking(){
            isThere = read.nextLine();
        }

        void buy(){
            System.out.println();
            System.out.println("Buying...");
        }
        void pay(){
            System.out.println("Payment sent ");
        }
        void name(){
            myName = read.nextLine();
        }
    }

    static class Seller extends Billing{
        boolean isAvail;
        void isAvailable() {
            isAvail = setShoeList().contains(buyer.isThere.toUpperCase());
        }
        void available(){
            if (isAvail) {
                System.out.println( "Yes "+buyer.isThere+" is available");
            }else{
                System.out.println("Sorry, "+ buyer.isThere + " is not available yet");
                System.exit(0);
            }
        }
    }

    static class ShoeShelves  {
        ArrayList<String> shoeList = new ArrayList<>();
        ArrayList<String> setShoeList() {
            shoeList.add("NIKE AIRFORCE");
            shoeList.add("NIKE AIR MAX");
            shoeList.add("NIKE REVOLUTION");
            shoeList.add("NIKE QUEST");
            shoeList.add("NIKE AIR JORDAN");
            shoeList.add("VANS OLD SKOOL");
            shoeList.add("ONITSUKA TIGER MEXICO");
            shoeList.add("ONITSUKA TIGER ACROMOUNT");
            shoeList.add("ADIDAS FORUM");
            shoeList.add("ADIDAS STAN SMITH");
            shoeList.add("ADIDAS CONTINENTAL");


            return shoeList;
        }
    }

    static class PriceList extends ShoeShelves {
        int[] shoePrice = new int[]{3999, 4599, 3599, 4999, 5999, 3799, 3800, 4900, 3499,5599,4399};
         void sPrice(){
             System.out.println(    );
             System.out.println("The price of "+ buyer.isThere +" is P"+shoePrice[(setShoeList().indexOf(buyer.isThere.toUpperCase(Locale.ROOT)))]);
         }
    }

        static class Billing extends PriceList{
        void invoice(){
            String[] inv = new String[]{" ", "NAME                           " + buyer.myName.toUpperCase(Locale.ROOT) , " ", "ITEM                           "+ buyer.isThere.toUpperCase(Locale.ROOT)," ",  " "," ", "TOTAL                           P    "+ (shoePrice[setShoeList().indexOf(buyer.isThere.toUpperCase(Locale.ROOT))]), " ", " "};
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









