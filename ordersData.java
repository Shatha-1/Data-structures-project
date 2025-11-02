import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ordersData {

    public static Scanner input = new Scanner(System.in);
    public static LinkedList<Order> orders = new LinkedList<Order>();

    // ==============================================================
    public LinkedList<Order> getOrdersData() {
        return orders;
    }

    // ==============================================================
    public ordersData(String fileName) {
        try {
            File docsfile = new File(fileName);
            Scanner reader = new Scanner(docsfile);
            String line = reader.nextLine(); // skip header line

            while (reader.hasNext()) {
                line = reader.nextLine();
                String[] data = line.split(",");

                int oid = Integer.parseInt(data[0].trim());
                int cid = Integer.parseInt(data[1].trim());

                String pp = data[2].replaceAll("\"", "");
                String[] p = pp.split(";");
                Integer[] pids = new Integer[p.length];
                for (int i = 0; i < pids.length; i++)
                    pids[i] = Integer.parseInt(p[i].trim());

                double price = Double.parseDouble(data[3].trim());
                String date = data[4].trim();
                String status = data[5].trim();

                Order order = new Order(oid, cid, pids, price, date, status);
                orders.insert(order);
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println("⚠️ Error reading file: " + ex.getMessage());
        }
    }
// ==============================================================
    public int cancelOrder(int oid) {
        if (orders.empty())
            return 0;

        orders.findFirst();
        while (true) {
            if (orders.retrieve().getOrderNumber() == oid) {
                Order currentOrder = orders.retrieve();

                if (currentOrder.getStatusText().equalsIgnoreCase("cancelled")) {
                    System.out.println("Order " + oid + " was cancelled before.");
                    return 2; // cancelled before
                }

                currentOrder.setStatusText("cancelled");
                orders.remove();
                orders.insert(currentOrder);
                return 1; // cancelled successfully
            }

            if (orders.last()) break;
            orders.findNext();
        }

        return 0; // not found
    }

    // ==============================================================
    public boolean updateOrder(int orderID) {
        if (orders.empty()) {
            System.out.println("No orders available.");
            return false;
        }

        orders.findFirst();
        while (true) {
            if (orders.retrieve().getOrderNumber() == orderID) {
                Order obj = orders.retrieve();

                if (obj.getStatusText().equalsIgnoreCase("cancelled")) {
                    System.out.println("Could not change status for a cancelled order.");
                    return false;
                }

                System.out.println("Current status: " + obj.getStatusText());
                System.out.print("Enter new status (pending, shipped, delivered, cancelled): ");
                String newStatus = input.next();

                orders.remove();
                obj.setStatusText(newStatus);
                orders.insert(obj);
                return true;
            }

            if (orders.last()) break;
            orders.findNext();
        }

        System.out.println("No such order found.");
        return false;
    }

    // ==============================================================
    public Order searchOrderID(int orderID) {
        if (orders.empty()) {
            System.out.println("No orders in the system.");
            return null;
        }

        orders.findFirst();
        while (true) {
            if (orders.retrieve().getOrderNumber() == orderID)
                return orders.retrieve();

            if (orders.last()) break;
            orders.findNext();
        }

        System.out.println("No such order.");
        return null;
    }

    // ==============================================================
    public LinkedList<Order> BetweenTwoDates(String date1, String date2) {
        LinkedList<Order> ordersBetweenDates = new LinkedList<Order>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse(date1, formatter);
        LocalDate endDate = LocalDate.parse(date2, formatter);

        if (!orders.empty()) {
            orders.findFirst();
            while (true) {
                LocalDate orderDate = orders.retrieve().getOrderDate();


                if (orderDate.compareTo(startDate) >= 0 && orderDate.compareTo(endDate) <= 0) {
                    ordersBetweenDates.insert(orders.retrieve());
                    System.out.println(orders.retrieve());
                }

                if (orders.last()) break;
                orders.findNext();
            }
        }

        return ordersBetweenDates;
    }

    // ==============================================================
    public boolean checkOrderID(int oid) {
        if (orders.empty())
            return false;

        orders.findFirst();
        while (true) {
            if (orders.retrieve().getOrderNumber() == oid)
                return true;

            if (orders.last()) break;
            orders.findNext();
        }

        return false;
    }
}