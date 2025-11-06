/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc212;

public class Product{
    private int ProductId;
    private String name;
    private double price;
    private int stock;
    private LinkedList <Integer> reviews = new LinkedList <Integer> ();
    
public Product(){
    this.ProductId=0;
    this.name="";
    this.price=0;
    this.stock=0;
}
public Product(int ProductId ,String name , double price , int stock){
    this.ProductId=ProductId;
    this.name=name;
    this.price=price;
    this.stock=stock;
}

public int getProductId() { 
    return ProductId ;
}
public String getName() { 
    return name ;
}
public double getPrice() { 
    return price ;
}
public int getStock() { 
    return stock ;
}

public void setName(String name){ 
    this.name=name ;
}

public void setPrice(double price){ 
    this.price=price ;
}

public void setStock(int stock){ 
    this.stock=stock ;
}

public void addStock(int stock){
    this.stock += stock;
}

public void removeStock (int stock){
    this.stock -= stock;
    if (this.stock < 0) this.stock= 0;
}

public void addReview(Integer Review){
    reviews.insert(Review);
}

public boolean removeReview(Integer Review){
    if (!reviews.empty()){
        reviews.findFirst();
        while (!reviews.last())
        {
            if(reviews.retrieve().equals(Review))
            {
                reviews.remove();
                return true;
            }
            reviews.findNext();
        }
        if(reviews.retrieve().equals(Review))
            {
                reviews.remove();
                return true;
            }
    }
    return false;
}// end removeReview

public String toString(){
    String str = "\n Product ID :" + ProductId + "\n Name :" + name +  "\n price :" + price + "\n stock :" + stock ;
    if (!reviews.empty()){
        str += "\n Review :[";
        reviews.findFirst();
        while (!reviews.last())
        {
            str += reviews.retrieve() + "|" ;
            reviews.findNext();
        }
        str += reviews.retrieve() + "]" ;
    }
    return str;
}
}
