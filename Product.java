package csc212;

/**
 *
 * @author Manal Alhihi
 */
public class Product {
    private int productId;
    private String name;
    private double price;
    private int stock;
    private LinkedList <Integer> reviews = new LinkedList <Integer> ();

    public Product() {
        this.productId = 0;
        this.name = "";
        this.price = 0;
        this.stock = 0;
    }

    public Product(int productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // ===== Getters and Setters =====
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }

    public void addStock ( int stock)
    {
        this.stock += stock;
    }
    
    public void removeStock ( int stock)
    {
        this.stock -= stock;
        if (this.stock < 0) this.stock = 0;
    }
    
    
    public void addReview( Integer R)
    {
        reviews.insert(R);
    }
    
    public boolean removeReview( Integer R)
    {
        if ( ! reviews.empty())
        {
            reviews.findFirst();
            while(!reviews.last())
            {
                if (reviews.retrieve().equals(R))
                {
                    reviews.remove();
                    return true;
                }
                
                    reviews.findNext();
            }
            if (reviews.retrieve().equals(R))
            {
                reviews.remove();
                return true;
            }
        }
        return false;
    }
    
    public LinkedList<Integer> getReviews ()
    {
        return reviews;
    }
    
    @Override
    public String toString() {
        String str =  "\nProduct ID:" + productId + "\nName: " + name + "\nPrice: " + price + "\nStock: " + stock ;
        if ( ! reviews.empty())
        {
            str += "\nReviews: [ " ;
            reviews.findFirst();
            while(! reviews.last())
            {
                str += reviews.retrieve() + " | ";
                reviews.findNext();
            }
            str += reviews.retrieve() + " ]";
        }
        return str;        
    }
    
}
