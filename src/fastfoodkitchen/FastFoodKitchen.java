/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fastfoodkitchen;
import java.util.*;
import java.io.*;

/**
 *
 * @author Mahmood
 */
public class FastFoodKitchen {
        private ArrayList<BurgerOrder> orderList = new ArrayList<BurgerOrder>();
    
        private Scanner scnr = new Scanner(System.in);
    private Scanner fScnr;
    
    
   /* public FastFoodKitchen() {
        
        //creating BurgerOrder objects
        BurgerOrder order1= new BurgerOrder(3, 5, 4, 10, false, 1);
        BurgerOrder order2= new BurgerOrder(0, 0, 3, 2, true, 2);
        BurgerOrder order3= new BurgerOrder(1, 1, 0, 2, false, 3);
        orderList.add(order1);
        incrementNextOrderNum();
        orderList.add(order2);
        incrementNextOrderNum();
        orderList.add(order3);
        incrementNextOrderNum();
        
    }
    */

     // Loop through each line of the file and create a new BurgerOrder object with the line contents
    public void generateOrders(File givenFile) {
    try {
        fScnr = new Scanner(givenFile); // Initialize fScnr with the provided file
        fScnr.nextLine(); // Skip the first heading
        
        while (fScnr.hasNextLine()) {
            String line = fScnr.nextLine();
            String[] lineContents = line.split(",");
            
            // Extract values from the CSV line
            int orderID = Integer.parseInt(lineContents[0]);
            int numHamburgers = Integer.parseInt(lineContents[1]);
            int numCheeseburgers = Integer.parseInt(lineContents[2]);
            int numVeggieburgers = Integer.parseInt(lineContents[3]);
            int numSodas = Integer.parseInt(lineContents[4]);
            boolean toGo = Boolean.parseBoolean(lineContents[5]);
            
            // Create a new BurgerOrder object and add it to the orderList
            orderList.add(new BurgerOrder(numHamburgers, numCheeseburgers, numVeggieburgers, numSodas, toGo, orderID));
        }
        
        fScnr.close(); // Close the Scanner when done
    } catch (FileNotFoundException e) {
        System.out.println("File was not found");
    }
}

    
    private static int nextOrderNum; 
    
    public int getNextOrderNum(){
        return nextOrderNum;
    }
    
    private static void incrementNextOrderNum(){
        nextOrderNum++;
    }
    private static void decrementNextOrderNum(){
        nextOrderNum--;
    }
     /**
         * addOrder adds a new order to the orderList
         * It also sets the orderID to the nextOrderNum and increments the nextOrderNum
         */
        public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo) {
            int orderNum = getNextOrderNum();
            orderList.add(new BurgerOrder(ham, cheese, veggie, soda, toGo, orderNum));
            incrementNextOrderNum();
            orderCallOut(orderList.get(orderList.size() - 1));
            return orderNum;
    
        }

        private void orderCallOut(BurgerOrder order) {
            if (order.getNumHamburger() > 0) {
                System.out.println("You have " + order.getNumHamburger() + " hamburgers");
            }
            if (order.getNumCheeseburger() > 0) {
                System.out.println("You have " + order.getNumCheeseburger() + " cheeseburgers");
            }
            if (order.getNumVeggieburger() > 0) {
                System.out.println("You have " + order.getNumVeggieburger() + " veggieburgers");
            }
            if (order.getNumSoda() > 0) {
                System.out.println("You have " + order.getNumSoda() + " sodas");
            }
    
        }

        public void completeSpecificOrder(int orderID) {
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i).getOrderNum() == orderID) {
                    System.out.println("Order number " + orderID + " is done!");
                    if (orderList.get(i).isOrderToGo()) {
                        orderCallOut(orderList.get(i));
                    }
                    orderList.remove(i);
                }
            }
    
        }
      public boolean cancelLastOrder(){
          /**
           * checks if orderList is greater than zero if it is it removes the last order and -1 to the orderNum
           * if it is not greater than zero it returns false
           */
          if(orderList.size()>=1){
              orderList.remove(orderList.size()-1);
              decrementNextOrderNum();  
              return true;
          }
          else return false;
      }
    public int getNumOrdersPending(){
          /**
           *  returns orderList size
           */
         
          return orderList.size();
          
          
      }
    public boolean isOrderDone (int orderID){
        for (int i = 0; i < orderList.size(); i++){
            if (orderList.get(i).getOrderNum()== orderID) 
                return false;
   
        }
        return true;
    }
        
    public boolean cancelOrder (int orderID){
        for (int i = 0; i < orderList.size(); i++){
            if (orderList.get(i).getOrderNum()== orderID) 
                orderList.remove(orderList.get(i));
                    return true;
        }
            return false;
    
    }
    public int findOrderSeq(int OrderID){
        for(int i = 0; i< orderList.size();i++){
            if (orderList.get(i).getOrderNum() == OrderID){
                return i;
                 }          
             }
             return -1;
         }
         
         
         public void selectionSort(){
             for(int i = 0; i< orderList.size(); i++){
                 int min = i;
                 for(int j =0; j < orderList.size(); j++){
                     if(orderList.get(min).getTotalBurgerOrders() < orderList.get(j).getTotalBurgerOrders() ){
                         min = j;
                     }
                     BurgerOrder temp = orderList.get(min);
                     orderList.set(min,orderList.get(i));
                     orderList.set(i,temp);
                 }
               }    
             }
         public void insetionSort(){
             for (int i = 1; i < orderList.size(); i++){
                 BurgerOrder current = orderList.get(i); 
                 int j = i - 1;  			
                 while ((j > -1) && ((orderList.get(j).compareTo(current)) == 1)){
                     orderList.set(j + 1, orderList.get(j));
                     j--; 			
                 }
                 orderList.set(j + 1, current);
         }
         }
         public int findOrderBin(int OrderID){
             int left = 0;
             int right = orderList.size()-1;
             int mid = (left+right)/2;
             int end = 0;
             for(int i = 0; i<orderList.size(); i++){
                 if(orderList.get(OrderID).getOrderNum() > orderList.get(mid).getOrderNum()){
                     left = mid+1;
                 }  
                 if(orderList.get(OrderID).getOrderNum() < orderList.get(mid).getOrderNum()){
                     right = mid+1;
                 }
             }
             if(orderList.get(OrderID).getOrderNum() == orderList.get(mid).getOrderNum()){
                 end = mid;
             
             
         }
             return end;
         }
             
           public ArrayList<BurgerOrder> getOrderList(){
                     return orderList;
         }

          /*
    An end of day report should be generated as a .txt file. 
This file should include what orders were placed and whether they were completed or not.
 The file should also include totals for each item sold (number of hamburgers, number of cheeseburgers,...).  You can include any other information you think is relevant.
It is up to you to figure out the proper formatting to this file. It should be clear, readable, and make sense.
An updated orders file. This file should follow the same format of the input file , but have any orders that remain to be completed. 
This file should have a slightly different name, such as burgerOrders2.csv. 
    */
         public void endOfDay() {
        
        
        
            try{
                
                //PART A: to create the .txt End of Day Report.txt
                
                  // Create a file object for End of Day Report.txt
            File endOfDayReport = new File("End of Day Report.txt");
            
             // Create a file output stream for the End of Day Report.txt file
            FileOutputStream endOfDayFOS = new FileOutputStream(endOfDayReport);
            
            // Create a PrintWriter object for the End of Day Report.txt file
            PrintWriter endOfDayPF = new PrintWriter(endOfDayFOS);
            
             // Write a header to the file
            endOfDayPF.println("The following products were sold today: \n");
            
             // Loop through each burger order in the orderList and write it to the file
            for(BurgerOrder burgerOrder: orderList){
                endOfDayPF.println(burgerOrder.toTXTString() + "," + isOrderDone(burgerOrder.getOrderNum()));
            }
            //Initilizes a variable to hold the total amount of each item
            int hamTotal = 0;
            int cheeseTotal = 0;
            int veggieTotal = 0;
            int sodaTotal = 0;

             // Loop through each burger order in the orderList and count the total number of hamburgers sold
            for(BurgerOrder burgerOrder: orderList){
                hamTotal +=burgerOrder.getNumHamburger();
             }

             // Write the total number of hamburgers sold to the file
             endOfDayPF.println("Hamburgers Total: " + hamTotal);

             // Loop through each burger order in the orderList and count the total number of cheeseburgers sold
             for(BurgerOrder burgerOrder: orderList){
                cheeseTotal +=burgerOrder.getNumCheeseburger();
             }

            // Write the total number of cheeseburgers sold to the file
             endOfDayPF.println("Cheeseburger Total: " + cheeseTotal);

            // Loop through each burger order in the orderList and count the total number of veggieburgers sold
             for(BurgerOrder burgerOrder: orderList){
                veggieTotal +=burgerOrder.getNumVeggieburger();
             }

             // Write the total number of veggieburgers sold to the file
             endOfDayPF.println("Veggieburger Total: " + veggieTotal);

             // Loop through each burger order in the orderList and count the total number of sodas sold
             for(BurgerOrder burgerOrder: orderList){
                sodaTotal +=burgerOrder.getNumSoda();
             }
            // Write the total number of sodas sold to the file
            endOfDayPF.println("Soda Total: " + sodaTotal);

            // Flush the PrintWriter and close the file output stream and PrintWriter objects
            endOfDayPF.flush();
            endOfDayFOS.close();
            endOfDayPF.close();
            
            // Catch FileNotFoundException and print an error message
             } catch(FileNotFoundException e){
                System.out.println("File was not found");

            // Catch IOException and print an error message
            }catch(IOException e){
                System.out.println("IOException Occured");
            }

            // PART B

            // This writes the data of BurgerOrder objects to a CSV file named "End of Day Orders.csv"
            try{

                // Create a file object for End of Day Orders.csv
                File updatedOrdersReport = new File("End of Day Orders.csv");
                
                // Create a file output stream for the End of Day Orders.csv file
                FileOutputStream updatedOrdersReportFOS = new FileOutputStream(updatedOrdersReport);
                
                // Create a PrintWriter object to write data to the file
                PrintWriter updatedOrdersReportPF = new PrintWriter(updatedOrdersReportFOS);

                // Write the header row for the CSV file
                updatedOrdersReportPF.println("orderID,numHamburgers,numCheeseburgers,numVeggieburgers,numSodas,toGo");

                // Iterate through the BurgerOrder objects in the list and write their data to the CSV file
                for(BurgerOrder i: orderList){
                   updatedOrdersReportPF.println(i.getOrderNum() + "," + i.getNumCheeseburger() + "," + i.getNumCheeseburger()  + "," + i.getNumVeggieburger() + "," +i.getNumSoda() + "," + i.isOrderToGo());
                }
                // Flush the PrintWriter and close the file output stream and PrintWriter objects
                updatedOrdersReportPF.flush();
                updatedOrdersReportFOS.close();
                updatedOrdersReportPF.close();
                
                // Catch FileNotFoundException and print an error message
                } catch(FileNotFoundException e){
                    System.out.println("File was not found");
                
                // Catch IOException and print an error message
                }catch(IOException e){
                    System.out.println("IOException Occured");
                }
    }
}




