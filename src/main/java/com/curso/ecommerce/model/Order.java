package com.curso.ecommerce.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String number;
	private Date createdAt;
	private Date receivedAt;
	private double total;

	@ManyToOne
	private Usuario usuario;

	@OneToOne(mappedBy = "order")
	private OrderDetail detail;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public OrderDetail getDetail() {
		return detail;
	}

	public void setDetail(OrderDetail detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", createdAt=" + createdAt + ", receivedAt=" + receivedAt
				+ ", total=" + total + "]";
	}

}
