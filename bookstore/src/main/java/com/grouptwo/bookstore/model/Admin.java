/**
 * 
 */
package com.grouptwo.bookstore.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author HY1916H
 *
 */
@Entity
@Table(name="admindetails")
public class Admin {
	
	@Id
	@GeneratedValue
	private int adminId;
	private String adminName;
	private String adminEmail;
	private String adminPassword;
	//********************************************ADMIN TO ORDERS****************************************
	
	//One admin can look at many orders
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="adminForOrders")
	private Set<Order> ordersForAdmin = new HashSet<Order>();
	
	


	/**
	 * @return the ordersForAdmin
	 */
	public Set<Order> getOrdersForAdmin() {
		return ordersForAdmin;
	}

	/**
	 * @param ordersForAdmin the ordersForAdmin to set
	 */
	public void setOrdersForAdmin(Set<Order> ordersForAdmin) {
		this.ordersForAdmin = ordersForAdmin;
	}
	
	public void addOrdersForAdmin(Order orderToBeAdded)
	{
		ordersForAdmin.add(orderToBeAdded);
	}

	//********************************************ADMIN TO USERS****************************************
	//One admin can have access to multiple users
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "adminForUsers")

	private Set<User> usersForAdmin = new HashSet<User>();
	
	
	/**
	 * @return the usersForAdmin
	 */
	public Set<User> getUsersForAdmin() {
		return usersForAdmin;
	}

	/**
	 * @param usersForAdmin the usersForAdmin to set
	 */
	public void setUsersForAdmin(Set<User> usersForAdmin) {
		this.usersForAdmin = usersForAdmin;
	}

	
	public void addUsersForAdmin(User userToBeAdded)
	{
		usersForAdmin.add(userToBeAdded);
	}
	
	
	//********************************************ADMIN TO RATINGS****************************************
	//One admin can have access to multiple ratings
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "adminForRatings")
	private Set<Rating> ratingsForAdmin = new HashSet<Rating>();



	
	/**
	 * @return the ratingsForAdmin
	 */
	public Set<Rating> getRatingsForAdmin() {
		return ratingsForAdmin;
	}

	/**
	 * @param ratingsForAdmin the ratingsForAdmin to set
	 */
	public void setRatingsForAdmin(Set<Rating> ratingsForAdmin) {
		this.ratingsForAdmin = ratingsForAdmin;
	}

	public void addRatingsForAdmin(Rating ratingViewed)
	{
		ratingsForAdmin.add(ratingViewed);
	}
	//********************************************ADMIN TO BOOKS****************************************
	//One admin can access various books
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "adminForBooks")
	private Set<Book> booksForAdmin = new HashSet<Book>();
	
	
	/**
	 * @return the booksForAdmin
	 */
	public Set<Book> getBooksForAdmin() {
		return booksForAdmin;
	}

	/**
	 * @param booksForAdmin the booksForAdmin to set
	 */
	public void setBooksForAdmin(Set<Book> booksForAdmin) {
		this.booksForAdmin = booksForAdmin;
	}

	public void addBooksForAdmin(Book bookToBeAdded)
	{
		booksForAdmin.add(bookToBeAdded);
	}

	//*******************************************************************************************************

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminId, String adminName, String adminEmail, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adminEmail, adminId, adminName, adminPassword, booksForAdmin, ordersForAdmin,
				ratingsForAdmin, usersForAdmin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(adminEmail, other.adminEmail) && adminId == other.adminId
				&& Objects.equals(adminName, other.adminName) && Objects.equals(adminPassword, other.adminPassword)
				&& Objects.equals(booksForAdmin, other.booksForAdmin)
				&& Objects.equals(ordersForAdmin, other.ordersForAdmin)
				&& Objects.equals(ratingsForAdmin, other.ratingsForAdmin)
				&& Objects.equals(usersForAdmin, other.usersForAdmin);
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail
				+ ", adminPassword=" + adminPassword + ", ordersForAdmin=" + ordersForAdmin + ", usersForAdmin="
				+ usersForAdmin + ", ratingsForAdmin=" + ratingsForAdmin + ", booksForAdmin=" + booksForAdmin + "]";
	}

	
	


}
