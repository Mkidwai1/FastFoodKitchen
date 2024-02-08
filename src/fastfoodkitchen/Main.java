/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fastfoodkitchen;

import java.io.*;
import java.util.*;


/**
 *
 * @author Mahmood
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
     
                FastFoodKitchen kitchen = new FastFoodKitchen();
                ArrayList<BurgerOrder> orderList = new ArrayList();
                File inventory = new File("burgerOrders.csv");
                kitchen.generateOrders(inventory);
                Scanner sc = new Scanner(System.in);
                boolean open = true;
                
                while (open) {
                        
                        System.out.println("Please select from the following menu of options, by typing a number:");
                        System.out.println("\t 1. Order food");
                        System.out.println("\t 2. Cancel last order");
                        System.out.println("\t 3. Show number of orders currently pending.");
                        System.out.println("\t 4. Is Order Done?");
                        System.out.println("\t 5. Cancel Order");
                        System.out.println("\t 6. Complete Order");
                        System.out.println("\t 7. Exit");
                        /** add options to test new feature **/
                
                        int num = -1;
                        while (true) { //Keep asking for input until one is given within the items rangle
                                try{
                                num = sc.nextInt();
                                } catch(InputMismatchException e){
                                sc.next();
                                System.out.println("Please enter an integer!");
                                }
                                switch (num) {
                                case 1:
                                try{
                                        System.out.println("How many hamburgers do you want?");
                                        int ham = sc.nextInt();
                                        System.out.println("How many cheeseburgers do you want?");
                                        int cheese = sc.nextInt();
                                        System.out.println("How many veggieburgers do you want?");
                                        int veggie = sc.nextInt();
                                        System.out.println("How many sodas do you want?");
                                        int sodas = sc.nextInt();
                                        System.out.println("Is your order to go? (Y/N)");
                                        char letter = sc.next().charAt(0);
                                        boolean TOGO = false;
                                        if (letter == 'Y' || letter == 'y') {
                                                TOGO = true;
                                        }
                                        int orderNum = kitchen.addOrder(ham, cheese, veggie, sodas, TOGO);
                                        BurgerOrder purchase = new BurgerOrder(ham, cheese, veggie, sodas, TOGO, orderNum);
                                        System.out.println("Thank-you. Your order number is " + orderNum);
                                        System.out.println();
                                        orderList.add(purchase);
                                        for(int i = 0; i< orderList.size(); i++){
                                                if(Math.random() < .33){
                                                kitchen.completeSpecificOrder(orderNum);
                                                }      
                                        }
                                } catch(InputMismatchException e){
                                        
                                }
                                        break;
                                case 2:
                                        boolean ready = kitchen.cancelLastOrder();
                                        if (ready) {
                                                System.out.println("Thank you. The last order has been canceled");
                                        } else {
                                                System.out.println("Sorry. There are no orders to cancel.");

                                                        }               
                                        System.out.println();
                                        break;
                                case 3:
                                        System.out.println("There are " + kitchen.getNumOrdersPending() + " pending orders");
                                        break;
                                case 4:
                                        System.out.println("What is your Order Number?");
                                        int order = sc.nextInt();
                                        boolean OrderNum = kitchen.isOrderDone(order);
                                        if (OrderNum ) {
                                                System.out.println("Your Order has been Completed");
                                        } else {
                                                System.out.println("Your Order is being Prepared");
                                        }
                                        break;
                                case 5:
                                try{
                                        System.out.println("What is your Order Number?");
                                        int orderID = sc.nextInt();
                                        boolean OrderNumCancel = kitchen.cancelOrder(orderID);
                                        if (OrderNumCancel) {
                                                System.out.println("Your order has been successfully cancelled");
                                        } else {
                                                System.out.println("Sorry, we can’t find your order number in the system");
                                        }
                                }catch(InputMismatchException e){

                                }
                                        break;
                                case 6:
                                System.out.println("Enter order number to complete?");
                                int orderNum = sc.nextInt();
                                kitchen.completeSpecificOrder(orderNum);
                                System.out.println("Your order is ready. Thank you!");
                                        break;
                                case 7:
                                        kitchen.endOfDay();
                                        open = false;
                                
                                        break;

                                default:
                                        System.out.println("Sorry, but you need to enter a 1, 2, 3, 4, 5, or a 6");
                                }// end switch
                                if (num != -1) {
                                        break; // Exit the inner loop to print the menu again
                                }

                        }// end while loop excpetion handling
                }// end while loop
        } // end main
}// end class

    
    

