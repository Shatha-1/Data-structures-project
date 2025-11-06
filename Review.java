/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc212;


public class Review {
int reviewId;
int productID;
int customerID;
int rating;
String comment;

public Review(){
    this.reviewId=0;
    this.productID=0;
    this.customerID=0; 
    this.rating=0;
    this.comment="";
}

public Review(int reviewId ,int productID,int customerID, int rating, String comment ){
    this.reviewId=reviewId;
    this.productID=productID;
    this.customerID=customerID; 
    this.rating=rating;
    this.comment=comment;
}
public int getReviewId() { 
    return reviewId ;
}
public int getProduct() { 
    return productID ;
}
public int getCustomer() { 
    return customerID ;
}
public int getRating() { 
    return rating ;
}
public String getComment(){
    return comment;
}

public void setReviewId(int reviewId){
    this.reviewId=reviewId;
}
public void setProduct(int productID){
    this.productID=productID;
}
public void setCustomer(int customerID){
    this.customerID=customerID;
}

public void setRating(int rating){
    this.rating=rating;
}
public void setComment(String comment){
    this.comment=comment;
}
public String toString(){
    return "\n Review{" + " reviewId= "+reviewId + " productID= "+ productID+ " customerID= " + customerID+ " rating= "+ rating+ " comment = " + comment + "}";
}
}
