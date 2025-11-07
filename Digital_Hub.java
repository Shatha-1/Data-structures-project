package csc212;

import java.util.Scanner;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
        

public class Digital_Hub{
    
private static final Scanner in = new Scanner(System.in);
 
public static void main(String[] args){
ordersData repo = new ordersData("orders.csv") ;

while(true){
    showMenu();
    String choice = in.nextLine().trim();
    
    if (choice.equals("1")){
        LinkedList<Order> all = repo.getOrdersData();
        printOrders(all);
    }
    else if (choice.equals("2")){
        System.out.print("order id: ");
        int inId= readInt();
        Order ord= repo.searchOrderID(inId);
        if(ord != null) System.out.println(ord);
        
    }
    else if (choice.equals("3")){
        System.out.print("order id: ");
        int inId= readInt();
        boolean exists = repo.checkOrderID(inId);
        System.out.println(exists? "exists": "not found");
        
    }
    else if (choice.equals("4")){
        System.out.print("order id: ");
        int inId= readInt();
        int res= repo.cancelOrder(inId);
        if(res == 1) System.out.println("cancelled");
        else if (res== 2) System.out.println("already cancelled");
        else System.out.println("not found");
    }
    else if (choice.equals("5")){
        System.out.print("order id: ");
        int inId= readInt();
        boolean upd= repo.updateOrder(inId);
        System.out.println(upd? "updated" : "failed");
    }
    else if (choice.equals("6")){
        System.out.print("From (dd/mm/yyyy)");
        String d1= in.nextLine().trim();
        System.out.print("To(dd/mm/yyyy): ");
        String d2 = in.nextLine().trim();
        LinkedList<Order> span = repo.BetweenTwoDates(d1, d2);
        printOrders(span);
                
    }
    else if (choice.equals("0")){
        break;
    }
    else{
        System.out.println("invalid");
    }
}

    
    }//end main
   private static void showMenu(){
       System.out.println();
       System.out.println("========Digital Hub========");
       System.out.println ("1- list all orders");
       System.out.println("2- search by ID");
       System.out.println("3- check ID");
       System.out.println("4- cancel the order");
       System.out.println("5- update status");
       System.out.println("6- view orders between two dates ");
       System.out.println("0- Exit");
       System.out.print("enter your choice : ");

   }
   
   private static int readInt(){
       while (true){
           String s = in.nextLine().trim();
           try{
               return Integer.parseInt(s);
           }catch (Exception e){
               System.out.print("enter number: ");
           }
       }
   }
    
   private static void printOrders(LinkedList<Order> list){
       if(list == null || list.empty()){
           System.out.println("no data");
           return;
       }
       list.findFirst();
       while(true){
           System.out.println(list.retrieve());
           if(list.last())
               break; 
           list.findNext();
       }
   }
    
}