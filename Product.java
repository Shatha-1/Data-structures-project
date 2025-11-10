public class Product {
    private int productId;
    private String name;
    private double price;
    private int stock;
    private LinkedList<Review> reviews = new LinkedList<>();

    // Constructor
    public Product(int productId, String name, double price, int stock) {
        this.productId = productId;
        setName(name);
        setPrice(price);
        setStock(stock);
    }

    // Getters
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public LinkedList<Review> getReviews() { return reviews; }

    // Setters
    public void setName(String name) {
        this.name = (name == null) ? "" : name.trim();
    }
    public void setPrice(double price) {
        this.price = Math.max(0, price);
    }
    public void setStock(int stock) {
        this.stock = Math.max(0, stock);
    }

    // 🟢 Add review — O(1)
    public void addReview(Review r) {
        if (r != null) reviews.insert(r);
    }

    // 🟢 Edit review (by index) — O(n)
    public boolean editReview(int index, int newRating, String newComment, String newDate) {
        if (reviews.empty()) return false;
        int i = 0;
        reviews.findFirst();
        while (true) {
            if (i == index) {
                Review rev = reviews.retrieve();
                rev.setRating(newRating);
                rev.setComment(newComment);
                rev.setReviewDate(newDate);
                return true;
            }
            if (reviews.last()) break;
            reviews.findNext();
            i++;
        }
        return false;
    }

    // 🟢 Get average rating — O(n)
    public double getAverageRating() {
        if (reviews.empty()) return 0.0;
        double sum = 0;
        int count = 0;
        reviews.findFirst();
        while (true) {
            sum += reviews.retrieve().getRating();
            count++;
            if (reviews.last()) break;
            reviews.findNext();
        }
        return sum / count;
    }

    // 🟢 Increase/decrease stock — O(1)
    public void addStock(int qty) { if (qty > 0) stock += qty; }
    public void removeStock(int qty) { if (qty > 0) stock = Math.max(0, stock - qty); }

    @Override
    public String toString() {
        String s = "Product{id=" + productId + ", name='" + name + "', price=" + price + ", stock=" + stock + "}";
        if (!reviews.empty()) {
            s += " Reviews=[";
            reviews.findFirst();
            while (true) {
                s += reviews.retrieve();
                if (reviews.last()) break;
                s += ", ";
                reviews.findNext();
            }
            s += "]";
        }
        return s;
    }
}