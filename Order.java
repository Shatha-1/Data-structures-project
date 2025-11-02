import java.time.LocalDate;

public class Order {

    private int OrderId;
    private int customerId;
    private LinkedList<Integer> productList = new LinkedList<>();
    private double totalCost;
    private LocalDate orderDate;
    String statusText; // "pending", "shipped", "delivered", "cancelled"

    public Order() {
        OrderId = 0;
        customerId = 0;
        totalCost = 0;
        orderDate = LocalDate.now();
        statusText = "pending";
    }

    public Order(int orderNumber, int customerId, Integer[] products, double totalCost, String dateText, String statusText) {
        this.OrderId = orderNumber;
        this.customerId = customerId;
        this.totalCost = Math.max(0, totalCost);
        this.orderDate = LocalDate.parse(dateText);
        this.statusText = (statusText == null) ? "pending" : statusText.toLowerCase();

        if (products != null) {
            for (int i = 0; i < products.length; i++) {
                productList.insert(products[i]);
            }
        }
    }

    public int getOrderNumber() {
        return OrderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LinkedList<Integer> getProductList() {
        return productList;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setOrderId(int orderNumber) {
        this.OrderId = orderNumber;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = Math.max(0, totalCost);
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = (orderDate == null) ? LocalDate.now() : orderDate;
    }

    public void setStatusText(String statusText) {
        this.statusText = (statusText == null) ? "pending" : statusText.toLowerCase();
    }

    public void addProduct(int pid) {
        productList.insert(pid);
    }

    public boolean removeProduct(int pid) {
        if (!productList.empty()) {
            productList.findFirst();
            while (true) {
                if (productList.retrieve().equals(pid)) {
                    productList.remove();
                    return true;
                }
                if (productList.last()) break;
                productList.findNext();
            }
        }
        return false;
    }

    public boolean isInRange(LocalDate start, LocalDate end) {
        boolean after = (start == null) || !orderDate.isBefore(start);
        boolean before = (end == null) || !orderDate.isAfter(end);
        return after && before;
    }

    @Override
    public String toString() {
        String result = "Order#" + OrderId +
                " | Customer=" + customerId +
                " | Date=" + orderDate +
                " | Status=" + statusText +
                " | Total=" + totalCost;

        if (!productList.empty()) {
            result += " | Products: [";
            productList.findFirst();
            while (true) {
                result += productList.retrieve();
                if (productList.last()) break;
                result += ", ";
                productList.findNext();
            }
            result += "]";
        }
        return result;
    }

    int getOrderId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setCustomerRefrence(int cid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setTotal_price(int total_price) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setDate(LocalDate Ldate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setStatus(String next) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    int getCustomerRefrence() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}