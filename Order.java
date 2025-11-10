public class Order {

    private int orderId;
    private int customerId;
    private Integer[] productIds;
    private double totalPrice;
    private String orderDate;
    private String status;

    // ✅ Constructor بسيط حسب ما في ملف Data
    public Order(int orderId, int customerId, Integer[] productIds, double totalPrice, String orderDate, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productIds = productIds;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.status = status;
    }

    // ✅ Constructor مختصر (لما نستخدم null في DataManager)
    public Order(int orderId, Object unused, String orderDate) {
        this.orderId = orderId;
        this.customerId = 0;
        this.orderDate = orderDate;
        this.status = "pending";
        this.productIds = new Integer[0];
        this.totalPrice = 0.0;
    }

    // ======================================================
    // 🟢 Getters
    public int getOrderId() { return orderId; }
    public int getCustomerId() { return customerId; }
    public Integer[] getProductIds() { return productIds; }
    public double getTotalPrice() { return totalPrice; }
    public String getOrderDate() { return orderDate; }
    public String getStatus() { return status; }

    // ======================================================
    // 🟢 Setters
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public void setProductIds(Integer[] productIds) { this.productIds = productIds; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }
    public void setStatus(String status) { this.status = status; }

    // ======================================================
    // 🟢 تحديث حالة الطلب
    public void updateStatus(String newStatus) {
        if (newStatus != null && !newStatus.isEmpty())
            this.status = newStatus;
    }

    // ======================================================
    // 🟢 عرض الطلب
    @Override
    public String toString() {
        String result = "Order { ID=" + orderId +
                        ", CustomerID=" + customerId +
                        ", Date=" + orderDate +
                        ", Status=" + status +
                        ", Total=" + totalPrice +
                        ", Products=[";
        if (productIds != null && productIds.length > 0) {
            for (int i = 0; i < productIds.length; i++) {
                result += productIds[i];
                if (i < productIds.length - 1)
                    result += ", ";
            }
        }
        result += "] }";
        return result;
    }
}
