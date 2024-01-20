package com.curso.ecommerce.model;

import java.util.Date;

public class Order {

	private Integer id;
	private String number;
	private Date createdAt;
	private Date receivedAt;
	private double total;

	public Order() {
	}

	public Order(Integer id, String number, Date createdAt, Date receivedAt, double total) {
		super();
		this.id = id;
		this.number = number;
		this.createdAt = createdAt;
		this.receivedAt = receivedAt;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(Date receivedAt) {
		this.receivedAt = receivedAt;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", createdAt=" + createdAt + ", receivedAt=" + receivedAt
				+ ", total=" + total + "]";
	}

}
