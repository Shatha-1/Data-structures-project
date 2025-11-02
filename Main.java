import java.util.Scanner;

public class Main{

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        ordersData repo = new ordersData("orders.csv");

        while (true) {
            showMenu();
            String choice = in.nextLine().trim();

            if (choice.equals("1")) {
                LinkedList<Order> all = repo.getOrdersData();
                printOrders(all);

            } else if (choice.equals("2")) {
                System.out.print("Order ID: ");
                int oid = readInt();
                Order o = repo.searchOrderID(oid);
                if (o != null) System.out.println(o);

            } else if (choice.equals("3")) {
                System.out.print("Order ID: ");
                int oid = readInt();
                boolean exists = repo.checkOrderID(oid);
                System.out.println(exists ? "Exists" : "Not found");

            } else if (choice.equals("4")) {
                System.out.print("Order ID: ");
                int oid = readInt();
                int res = repo.cancelOrder(oid);
                if (res == 1) System.out.println("Cancelled");
                else if (res == 2) System.out.println("Already cancelled");
                else System.out.println("Not found");

            } else if (choice.equals("5")) {
                System.out.print("Order ID: ");
                int oid = readInt();
                boolean ok = repo.updateOrder(oid);
                System.out.println(ok ? "Updated" : "Failed");

            } else if (choice.equals("6")) {
                System.out.print("From (dd/MM/yyyy): ");
                String d1 = in.nextLine().trim();
                System.out.print("To (dd/MM/yyyy): ");
                String d2 = in.nextLine().trim();
                LinkedList<Order> span = repo.BetweenTwoDates(d1, d2);
                printOrders(span);

            } else if (choice.equals("0")) {
                break;

            } else {
                System.out.println("Invalid");
            }

            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("1) List orders");
        System.out.println("2) Search by ID");
        System.out.println("3) Check ID");
        System.out.println("4) Cancel order");
        System.out.println("5) Update status");
        System.out.println("6) Orders by date range");
        System.out.println("0) Exit");
        System.out.print("Choose: ");
    }

    private static int readInt() {
        while (true) {
            String s = in.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.print("Enter number: ");
            }
        }
    }

    private static void printOrders(LinkedList<Order> list) {
        if (list == null || list.empty()) {
            System.out.println("No data");
            return;
        }
        list.findFirst();
        while (true) {
            System.out.println(list.retrieve());
            if (list.last()) break;
            list.findNext();
        }
    }
}