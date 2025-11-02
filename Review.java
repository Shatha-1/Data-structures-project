
public class Review {
    private int reviewId;
    private int productId;
    private int customerId;
    private int rating;
    private String comment;

    public Review() {    
    this.reviewId = 0;    
    this.productId = 0;    
    this.customerId = 0;    
    this.rating = 0;    
    this.comment = "";    
}
    public Review(int reviewId, int productId, int customerId, int rating, String comment) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.customerId = customerId;
        setRating(rating); //   
        this.comment = (comment == null) ? "" : comment;
    }

    public int getReviewId() { return reviewId; }
    public int getProductId() { return productId; }
    public int getCustomerId() { return customerId; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }

    public void setRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be 1..5");
        }
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = (comment == null) ? "" : comment;
    }

    @Override
    public String toString() {
        return "Review{id=" + reviewId +
                ", product=" + productId +
                ", customer=" + customerId +
                ", rating=" + rating +
                ", comment='" + comment + "'}";
    }
}