package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus order;
	private Client client = new Client();
	private List<OrderItem> itens = new ArrayList<>();
	
	public Order(Date moment, OrderStatus order, Client Client) {
		this.moment = moment;
		this.order = order;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrder() {
		return order;
	}

	public void setOrder(OrderStatus order) {
		this.order = order;
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
}
