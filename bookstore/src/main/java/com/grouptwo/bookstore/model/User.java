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
import javax.persistence.ManyToOne;
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
@Table(name="userdetails")
public class User {
	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userAddress;
	private long userContact;
	
	
	//********************************************USERS TO ADMIN****************************************
	//Multiple users have only one admin
	@ManyToOne
//	(cascade = CascadeType.ALL)
	@JoinColumn(name="admin_id_foreignkey_user", referencedColumnName = "adminId")
	@JsonIgnore
	private Admin adminForUsers;
	/**
	 * @return the adminForUser
	 */
	public Admin getAdminForUsers() {
		return adminForUsers;
	}


	/**
	 * @param adminForUser the adminForUser to set
	 */
	public void setAdminForUsers(Admin adminForUser) {
		this.adminForUsers = adminForUser;
	}

	
	//********************************************USER TO ORDERS****************************************
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userForOrders")
	private Set<Order> ordersForUser = new HashSet<Order>();
	


	/**
	 * @return the ordersForUser
	 */
	public Set<Order> getOrdersForUser() {
		return ordersForUser;
	}


	/**
	 * @param ordersForUser the ordersForUser to set
	 */
	public void setOrdersForUser(Set<Order> ordersForUser) {
		this.ordersForUser = ordersForUser;
	}

	public void addOrdersForUser(Order orderToBeAdded)
	{
		ordersForUser.add(orderToBeAdded);
	}



	//********************************************USER TO RATINGS****************************************
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="userForRatings")
	private Set<Rating> ratingsForUser = new HashSet<Rating>();


	/**
	 * @return the ratingsForUser
	 */
	public Set<Rating> getRatingsForUser() {
		return ratingsForUser;
	}


	/**
	 * @param ratingsForUser the ratingsForUser to set
	 */
	public void setRatingsForUser(Set<Rating> ratingsForUser) {
		this.ratingsForUser = ratingsForUser;
	}

	public void addRatingsForUser(Rating ratingToBeAdded)
	{
		ratingsForUser.add(ratingToBeAdded);
	}

	//********************************************USER TO BOOKS****************************************
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userForBooks")
	private Set<Book> booksForUser = new HashSet<Book>();


	/**
	 * @return the booksForUser
	 */
	public Set<Book> getBooksForUser() {
		return booksForUser;
	}


	/**
	 * @param booksForUser the booksForUser to set
	 */
	public void setBooksForUser(Set<Book> booksForUser) {
		this.booksForUser = booksForUser;
	}
	
	

	//*******************************************************************************************************


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int userId, String userName, String userEmail, String userPassword, String userAddress,
			long userContact) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userContact = userContact;
	}


	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}


	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}


	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}


	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}


	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	/**
	 * @return the userContact
	 */
	public long getUserContact() {
		return userContact;
	}


	/**
	 * @param userContact the userContact to set
	 */
	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}


	@Override
	public int hashCode() {
		return Objects.hash(adminForUsers, booksForUser, ordersForUser, ratingsForUser, userAddress, userContact,
				userEmail, userId, userName, userPassword);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(adminForUsers, other.adminForUsers) && Objects.equals(booksForUser, other.booksForUser)
				&& Objects.equals(ordersForUser, other.ordersForUser)
				&& Objects.equals(ratingsForUser, other.ratingsForUser)
				&& Objects.equals(userAddress, other.userAddress) && userContact == other.userContact
				&& Objects.equals(userEmail, other.userEmail) && userId == other.userId
				&& Objects.equals(userName, other.userName) && Objects.equals(userPassword, other.userPassword);
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userAddress=" + userAddress + ", userContact=" + userContact + ", adminForUsers="
				+ adminForUsers + ", ordersForUser=" + ordersForUser + ", ratingsForUser=" + ratingsForUser
				+ ", booksForUser=" + booksForUser + "]";
	}



	
	

}
