public class Review {

    private int reviewId;
    private int productId;
    private int customerId;
    private int rating;
    private String comment;

    // ✅ Constructor كامل (للتحميل من CSV)
    public Review(int reviewId, int productId, int customerId, int rating, String comment) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.customerId = customerId;
        this.rating = rating;
        this.comment = comment;
    }

    // ✅ Constructor مبسّط (يستخدم في DataManager.loadReviews)
    public Review(int rating, String comment) {
        this.reviewId = 0;
        this.productId = 0;
        this.customerId = 0;
        this.rating = rating;
        this.comment = comment;
    }

    // ======================================================
    // 🟢 Getters
    public int getReviewId() { return reviewId; }
    public int getProductId() { return productId; }
    public int getCustomerId() { return customerId; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }

    // ======================================================
    // 🟢 Setters
    public void setReviewId(int reviewId) { this.reviewId = reviewId; }
    public void setProductId(int productId) { this.productId = productId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public void setRating(int rating) { this.rating = rating; }
    public void setComment(String comment) { this.comment = comment; }

    // ======================================================
    // 🟢 عرض التقييم
    @Override
    public String toString() {
        return "Review { ID=" + reviewId +
               ", ProductID=" + productId +
               ", CustomerID=" + customerId +
               ", Rating=" + rating +
               ", Comment='" + comment + "' }";
    }

    void setReviewDate(String newDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
