package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus orderStatus;
	private Client client = new Client();
	private List<OrderItem> itens = new ArrayList<>();
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public Order() {
		
	}
	public Order(Date moment, OrderStatus orderStatus, Client Client) {
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus order) {
		this.orderStatus = order;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		itens.add(item);
	}
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	public double total() {
		double total = 0.0;
		for (OrderItem item : itens) {
			total += item.subTotal();
		}
		
		return total;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(orderStatus + "\n" );
		sb.append("Client: " );
		sb.append(client + "\n" );
		sb.append("Order items:\n" );
		for (OrderItem orderItem : itens) {
			sb.append(orderItem + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("2%.f", total()));
		return sb.toString();	}
	
}
