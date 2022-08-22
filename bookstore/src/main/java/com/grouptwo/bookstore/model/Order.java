/**
 * 
 */
package com.grouptwo.bookstore.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author HY1916H
 *
 */
@Entity
@Table(name="orderdetails")
public class Order {
	
	@Id
	@GeneratedValue
	private int orderId;
	private String orderStatus;
	private double orderAmount;
	
	//********************************************ORDERS TO ADMIN****************************************
	//Many to one relationship between the order and the admin
	@ManyToOne
//	(cascade = CascadeType.ALL)
	@JoinColumn(name="admin_id_foreignkey_order", referencedColumnName = "adminId")
	@JsonIgnore
	private Admin adminForOrders;
	/**
	 * @return the adminForOrder
	 */
	public Admin getAdminForOrders() {
		return adminForOrders;
	}
	/**
	 * @param adminForOrder the adminForOrder to set
	 */
	public void setAdminForOrders(Admin adminForOrder) {
		this.adminForOrders = adminForOrder;
	}
	
	//********************************************ORDERS TO USER****************************************
	
	@ManyToOne
//	(cascade = CascadeType.ALL)
	@JoinColumn(name= "user_id_foreignkey_order", referencedColumnName = "userId")	
	@JsonIgnore
	private User userForOrders;
	
	/**
	 * @return the userForOrders
	 */
	public User getUserForOrders() {
		return userForOrders;
	}
	/**
	 * @param userForOrders the userForOrders to set
	 */
	public void setUserForOrders(User userForOrders) {
		this.userForOrders = userForOrders;
	}
	
	
	//********************************************ORDERS TO BOOKS****************************************
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "ordersForBooks")
	private Set<Book> booksForOrders = new HashSet<Book>();
	
	/**
	 * @return the booksForOrders
	 */
	public Set<Book> getBooksForOrders() {
		return booksForOrders;
	}
	/**
	 * @param booksForOrders the booksForOrders to set
	 */
	public void setBooksForOrders(Set<Book> booksForOrders) {
		this.booksForOrders = booksForOrders;
	}
	
	public void addBooksForOrder(Book bookAddedToOrder) {
		// TODO Auto-generated method stub
		booksForOrders.add(bookAddedToOrder);
	}
	//*******************************************************************************************************

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, String orderStatus, double orderAmount) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderAmount = orderAmount;
	}
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the orderAmount
	 */
	public double getOrderAmount() {
		return orderAmount;
	}
	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adminForOrders, booksForOrders, orderAmount, orderId, orderStatus, userForOrders);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(adminForOrders, other.adminForOrders)
				&& Objects.equals(booksForOrders, other.booksForOrders)
				&& Double.doubleToLongBits(orderAmount) == Double.doubleToLongBits(other.orderAmount)
				&& orderId == other.orderId && Objects.equals(orderStatus, other.orderStatus)
				&& Objects.equals(userForOrders, other.userForOrders);
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderAmount=" + orderAmount
				+ ", adminForOrders=" + adminForOrders + ", userForOrders=" + userForOrders + ", booksForOrders="
				+ booksForOrders + "]";
	}
	
	
	

}
