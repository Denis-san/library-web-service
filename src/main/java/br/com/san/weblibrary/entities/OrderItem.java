package br.com.san.weblibrary.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.san.weblibrary.entities.pk.OrderItemPK;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	
	private Integer quantity;
	private Date devolutionDate;
	
	public OrderItem() {
		
	}
	
	public OrderItem(Order order, Book book, Integer quantity, Date devolutionDate) {
		super();
		id.setBook(book);
		id.setOrder(order);
		this.quantity = quantity;
		this.devolutionDate = devolutionDate;
	}

	public Book getBook() {
		return id.getBook();
	}
	
	public void setBook(Book book) {
		id.setBook(book);
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
