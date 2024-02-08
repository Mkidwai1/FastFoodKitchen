/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fastfoodkitchen;

import java.util.ArrayList;

/**
 *
 * @author Mahmood
 */
public class BurgerOrder {
     private int numHamburgers = 0;
    private int numCheeseburgers = 0;
    private int numVeggieburgers = 0;
    private int numSodas = 0;
    private boolean orderToGo = false;
    private int orderNum = 23;
    
    public BurgerOrder(int newHamburgers, int newCheeseburgers, int newVeggieburgers, int newSodas, boolean newOrderToGo, int newOrderNum){
    numHamburgers = newHamburgers;
    numCheeseburgers = newCheeseburgers;
    numVeggieburgers = newVeggieburgers;
    numSodas = newSodas;
    orderToGo = newOrderToGo;
    orderNum = newOrderNum;
    
    }
   
    public int getNumHamburger(){
    return numHamburgers;
    }

    public void setNumHamburger(int newHamburger){
        if(newHamburger < 0){
            System.out.println("Error");}
        else if(newHamburger > 0){
            numHamburgers = newHamburger;
        }
    }
    
    public int getNumCheeseburger(){
    return numCheeseburgers;
    }
    public void setNumCheeseburger(int newCheeseburger){
    if(newCheeseburger < 0){
    System.out.println("Error");}
    else if(newCheeseburger > 0){
            numCheeseburgers = newCheeseburger;
        }
    }
    
    public int getNumVeggieburger(){
    return numVeggieburgers;
    }
    public void setNumVeggieburger(int newVeggieburger){
    if(newVeggieburger < 0){
    System.out.println("Error");}
    else if(newVeggieburger > 0){
            numVeggieburgers = newVeggieburger;
        }
    }
    
    public int getNumSoda(){
    return numSodas;
    }
    public void setNumSoda(int newSodas){
    if(newSodas < 0){
    System.out.println("Error");}
    else if(newSodas > 0){
            numSodas = newSodas;
        }
    }
    
    public boolean isOrderToGo(){
    return orderToGo ;
    }
    
    public void setOrderToGo(boolean newOrderToGo){
    orderToGo = newOrderToGo;
    }
    
    public int getOrderNum(){
    return orderNum;
    }
    public void setOrderNum(int newOrderNum){
        orderNum = newOrderNum;
    }
    public int getTotalBurgerOrders() { 
        return (this.numCheeseburgers + this.numHamburgers + this.numVeggieburgers); 
    }

    int compareTo(BurgerOrder current) {
        int comp = 0;
        if (this.getTotalBurgerOrders() < current.getTotalBurgerOrders()){
            comp = -1;
        }
        if (current.getTotalBurgerOrders() > this.getTotalBurgerOrders()){
            comp = 1;
        }
        return comp;
    }
@Override
    public String toString(){
        return numHamburgers + " " + numCheeseburgers + " " + numVeggieburgers + " " + numSodas + " " + orderToGo + " " + orderNum;
    }
    public String toTXTString(){
        return numHamburgers + "," + numCheeseburgers + "," + numVeggieburgers + "," + numSodas + "," + orderToGo + "," + orderNum;
    }
}
