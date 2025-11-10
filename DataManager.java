import java.io.File;
import java.util.Scanner;

public class DataManager {

    // Scanner عام
    public static Scanner input = new Scanner(System.in);

    // كل القوائم في مكان واحد
    public static LinkedList<Customer> customers = new LinkedList<>();
    public static LinkedList<Product> products = new LinkedList<>();
    public static LinkedList<Order> orders = new LinkedList<>();
    public static LinkedList<Review> reviews = new LinkedList<>();

    // =========================================================
    // تحميل بيانات العملاء
    public void loadCustomers(String fileName) {
        try {
            File file = new File("customers.csv");
            Scanner reader = new Scanner(file);
            reader.nextLine(); // تخطي العنوان
            while (reader.hasNext()) {
                String[] data = reader.nextLine().split(",");
                Customer c = new Customer(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2]
                );
                customers.insert(c);
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println("Error loading customers: " + ex.getMessage());
        }
    }

    // =========================================================
    // تحميل بيانات المنتجات
    public void loadProducts(String fileName) {
        try {
            File file = new File("prodcuts.csv");
            Scanner reader = new Scanner(file);
            reader.nextLine();
            while (reader.hasNext()) {
                String[] data = reader.nextLine().split(",");
                Product p = new Product(
                        Integer.parseInt(data[0]),
                        data[1],
                        Double.parseDouble(data[2]),
                        Integer.parseInt(data[3])
                );
                products.insert(p);
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println("Error loading products: " + ex.getMessage());
        }
    }

    // =========================================================
    // تحميل بيانات الطلبات
    public void loadOrders(String fileName) {
        try {
            File file = new File("orders.csv");
            Scanner reader = new Scanner(file);
            reader.nextLine();
            while (reader.hasNext()) {
                String[] data = reader.nextLine().split(",");
                int orderId = Integer.parseInt(data[0]);
                int customerId = Integer.parseInt(data[1]);
                double totalPrice = Double.parseDouble(data[3]);
                String date = data[4];
                String status = data[5];

                // إنشاء الطلب
                Order o = new Order(orderId, null, date);
                o.updateStatus(status);
                orders.insert(o);
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println("Error loading orders: " + ex.getMessage());
        }
    }

    // =========================================================
    // تحميل بيانات المراجعات
    public void loadReviews(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner("reviews.csv");
            reader.nextLine();
            while (reader.hasNext()) {
                String[] data = reader.nextLine().split(",");
                int rating = Integer.parseInt(data[3]);
                String comment = data[4];
                Review r = new Review(rating, comment);
                reviews.insert(r);
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println("Error loading reviews: " + ex.getMessage());
        }
    }

    // =========================================================
    // عرض كل البيانات للتجربة
    public void printAllData() {
        System.out.println("\n📋 Customers:");
        if (!customers.empty()) {
            customers.findFirst();
            while (true) {
                System.out.println(customers.retrieve());
                if (customers.last()) break;
                customers.findNext();
            }
        }

        System.out.println("\n📦 Products:");
        if (!products.empty()) {
            products.findFirst();
            while (true) {
                System.out.println(products.retrieve());
                if (products.last()) break;
                products.findNext();
            }
        }

        System.out.println("\n🧾 Orders:");
        if (!orders.empty()) {
            orders.findFirst();
            while (true) {
                System.out.println(orders.retrieve());
                if (orders.last()) break;
                orders.findNext();
            }
        }

        System.out.println("\n⭐ Reviews:");
        if (!reviews.empty()) {
            reviews.findFirst();
            while (true) {
                System.out.println(reviews.retrieve());
                if (reviews.last()) break;
                reviews.findNext();
            }
        }
    }
}
