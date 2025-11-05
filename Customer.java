/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jalot
 */
public class Customer {
    
    private int customerId ;
    private String name ;
    private String email ;
    private LinkedList<Integer> orders = new LinkedList<Integer>() ;
    
    public Customer(){
        this.customerId = 0 ;
        this.name = "" ;
        this.email = "" ;
    }
    
    public Customer(int customerId , String name , String email){
        this.customerId = customerId ;
        this.name = name ;
        this.email = email ;
    }
    
    public int getCustomerId(){
        return customerId ;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId ;
    }
    
    
    public String getName(){
        return name ;
    }
     
     public void setName(String name) {
        this.email = email ;
     }
     
     
    public String getEmail(){
        return email ;
    }
    public void setEmail(String email) {
        this.email = email ;
     }
    
    public LinkedList<Integer> getOrders(){
        return orders ;
    }
    public void addOrder (Integer order){
        orders.insert(order);
    }
    public boolean removeOrder(Integer R){
        if(!orders.empty()){
            orders.findFirst();
            while(orders.last())
            {
                if (orders.retrieve() == R){
                    orders.remove();
                    return true ;
                }
                else
                    orders.findNext();
                   
            }
            if (orders.retrieve() == R){
                    orders.remove();
                    return true ;
            }
        }
        return false ;
    }
    
    public String toString() {
        String str = "\n Customers { " + "customer ID : " +customerId + " , name : " + name + " , email : " + email ;
        if (! orders.empty()){
            str += "(order List" ;
            orders.findFirst();
            while(orders.last()){
                str += orders.retrieve() + " " ;
                orders.findNext();
            }
            str += orders.retrieve() + " )" ;
        }
        str += " }" ;
        return str ;
    }
    
}
