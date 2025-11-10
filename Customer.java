public class Customer {

    private int customerId;
    private String name;
    private String email;
    private LinkedList<Integer> orders = new LinkedList<Integer>();

    public Customer() {
        this.customerId = 0;
        this.name = "";
        this.email = "";
    }

    public Customer(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LinkedList<Integer> viewOrders() {
        return orders;
    }

    public void addOrder(Integer orderId) {
        orders.insert(orderId);
    }

    public boolean removeOrder(Integer orderId) {
    if (orders.empty()) return false;
    orders.findFirst();
    while (true) {
        if (orders.retrieve().equals(orderId)) {
            orders.remove();
            return true;
        }
        if (orders.last()) break;
        orders.findNext();
    }
    return false;
}


    @Override
    public String toString() {
    String result = "Customer { ID=" + customerId + ", Name='" + name + "', Email='" + email + "'";
    if (!orders.empty()) {
        result += ", Orders=[";
        orders.findFirst();
        while (true) {
            result += orders.retrieve();
            if (orders.last()) break;
            result += ", ";
            orders.findNext();
        }
        result += "]";
    }
    result += " }";
    return result;
}

}
