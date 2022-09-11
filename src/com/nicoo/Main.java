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
    // static objects, so that other classes can access them.
    static Scanner read = new Scanner(System.in);
    static Buyer buyer = new Buyer();
    public static void main(String[] args) {
        System.out.println("Is this shoe available?: " );
        buyer.asking();
        // seller object
        Seller seller = new Seller();
        // The transaction process between the Buyer and the Seller, and also the Seller and the other classes functions.
        seller.isAvailable();
        seller.available();
        seller.sPrice();

        System.out.println("How may I address you?: " );
        buyer.name();

        buyer.buy(buyer.isThere);
        seller.invoice(buyer.isThere);
        buyer.pay();
    }
// All of these static classes are connected to each other by inheritance.
    // Buyer CLass consists of String variables, and methods/functions
    static class Buyer{
        String myName;
        String isThere;
        void asking(){
            isThere = read.nextLine();
        }

        void buy(String s){
            System.out.println();
            System.out.println("Buying " + s.toUpperCase(Locale.ROOT));
        }
        void pay(){
            System.out.println("Payment sent ");
        }
        void name(){
            myName = read.nextLine();
        }
    }
    // Seller class consists of methods/ functions for checking the shoe shelf, and return a response if the shoe is available.
    static class Seller extends Billing{
        boolean isAvail;
        // isAvailable method is used to setting the isAvail boolean to true or false.
        void isAvailable() {
            isAvail = setShoeList().contains(buyer.isThere.toUpperCase());
        }
        void available(){
            if (isAvail) {
                System.out.println( "Yes "+buyer.isThere.toUpperCase(Locale.ROOT)+" is available");
            }else{
                System.out.println("Sorry, "+ buyer.isThere.toUpperCase(Locale.ROOT) + " is not available yet");
                System.exit(0);
            }
        }
    }
    // Shoe shelf Class contains an array list for the shoe items.
    static class ShoeShelf  {
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
    // Pricelist Class, contains an Integer array for the shoe prices in the shoeshelf. Index 0 in the shoePrice is the price of the shoeList index 0.
    static class PriceList extends ShoeShelf {
        int[] shoePrice = new int[]{3999, 4599, 3599, 4999, 5999, 3799, 3800, 4900, 3499,5599,4399};
        // This method prints out the price of a shoe,
         void sPrice(){
             System.out.println(    );
             System.out.println("The price of "+ buyer.isThere.toUpperCase(Locale.ROOT) +" is P"+shoePrice[(setShoeList().indexOf(buyer.isThere.toUpperCase(Locale.ROOT)))]);
         }
    }
    // Billing class, contains a method that prints out the invoice with the billing info.
        static class Billing extends PriceList{
        void invoice(String item){
            String[] inv = new String[]{" ", "NAME                           " + buyer.myName.toUpperCase(Locale.ROOT) , " ", "ITEM                           "+ item.toUpperCase(Locale.ROOT)," ",  " "," ", "TOTAL                          P    "+ (shoePrice[setShoeList().indexOf(item.toUpperCase(Locale.ROOT))]), " ", " "};
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









