import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter client data: ");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Birth Date (DD/MM/YYYY): ");
		Date birthdate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthdate);
		
		
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many items to this order? ");
		int n = sc.nextInt();
		
		for (int i = 0; i <= n; i++) {
			System.out.printf("Enter #%d item data: ", i);
			System.out.println("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.println("Product quantity: ");
			int productQuantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem item = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(item);
			
			
		}
		System.out.println();
		System.out.println(order);
		sc.close();
		
	}
}
