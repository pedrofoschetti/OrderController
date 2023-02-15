package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirth = sdf.parse(sc.next());
		Client cliente = new Client(clientName, clientEmail, clientBirth);
		
		System.out.println("Enter order:");
		System.out.print("Status: (PENDING_PAYMENT | PROCESSING | SHIPPED | DELIVERED) ");
		OrderStatus orderStats = OrderStatus.valueOf(sc.next());
		Order pedido = new Order(new Date(), orderStats, cliente);
		
		System.out.println("How many items in this order: ");
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.println("Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem it = new OrderItem(quantity, productPrice, product);
			
			pedido.addItem(it);
		}
		
		System.out.println();
		System.out.println(pedido);
		
		
		sc.close();
	}

}
