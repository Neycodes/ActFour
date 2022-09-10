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
            isAvail = setShoeList().contains(buyer.isThere);
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
             System.out.println(    );
             System.out.println("The price of "+ buyer.isThere +" is P"+shoePrice[(setShoeList().indexOf(buyer.isThere))]);
         }
    }

        static class Billing extends PriceList{

        void invoice(){
            String[] inv = new String[]{" ","NAME                           " + buyer.myName.toUpperCase(Locale.ROOT) , " ", "ITEM                           "+ buyer.isThere.toUpperCase(Locale.ROOT)," ",  " "," ", "TOTAL                           P    "+ (shoePrice[setShoeList().indexOf(buyer.isThere)]), " ", " "};
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









