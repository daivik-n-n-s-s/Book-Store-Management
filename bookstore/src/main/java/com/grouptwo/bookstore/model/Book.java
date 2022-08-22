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
@Table(name="bookdetails")
public class Book {
		
	@Id
	@GeneratedValue
	private int bookId;
	private String bookAuthor;
	private String bookTitle;
	private String bookGenre;
	private int bookNumberOfInstances;
	private double bookPrice;
	
	//********************************************BOOKS TO ADMIN****************************************
	@ManyToOne
//	(cascade = CascadeType.ALL)
	@JoinColumn(name="admin_id_foreignkey_book", referencedColumnName = "adminId")
	@JsonIgnore
	private Admin adminForBooks;
	/**
	 * @return the adminForBooks
	 */
	public Admin getAdminForBooks() {
		return adminForBooks;
	}
	/**
	 * @param adminForBooks the adminForBooks to set
	 */
	public void setAdminForBooks(Admin adminForBooks) {
		this.adminForBooks = adminForBooks;
	}
	
	
	//********************************************BOOKS TO USER****************************************
	@ManyToOne
//	(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id_foreginkey_book", referencedColumnName = "userId")
	@JsonIgnore
	private User userForBooks;
	
	
	/**
	 * @return the userForBooks
	 */
	public User getUserForBooks() {
		return userForBooks;
	}
	/**
	 * @param userForBooks the userForBooks to set
	 */
	public void setUserForBooks(User userForBooks) {
		this.userForBooks = userForBooks;
	}
	
	
	
	
	
	//********************************************BOOKS TO ORDERS****************************************
	

	@ManyToOne
//	(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id_foreginkey_book", referencedColumnName = "orderId")
	@JsonIgnore
	private Order ordersForBooks;



	/**
	 * @return the ordersForBooks
	 */
	public Order getOrdersForBooks() {
		return ordersForBooks;
	}
	/**
	 * @param ordersForBooks the ordersForBooks to set
	 */
	public void setOrdersForBooks(Order ordersForBooks) {
		this.ordersForBooks = ordersForBooks;
	}


	//********************************************BOOK TO RATINGS****************************************


	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bookForRatings")
	private Set<Rating> ratingsForBook = new HashSet<Rating>();
	

	/**
	 * @return the ratingsForBook
	 */
	public Set<Rating> getRatingsForBook() {
		return ratingsForBook;
	}
	/**
	 * @param ratingsForBook the ratingsForBook to set
	 */
	public void setRatingsForBook(Set<Rating> ratingsForBook) {
		this.ratingsForBook = ratingsForBook;
	}
	
	public void addRatingsForBook(Rating ratingToBeAdded)
	{
		ratingsForBook.add(ratingToBeAdded);
	}
	
	
	
	////*******************************************************************************************************

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bookId, String bookAuthor, String bookTitle, String bookGenre, int bookNumberOfInstances,
			double bookPrice) {
		super();
		this.bookId = bookId;
		this.bookAuthor = bookAuthor;
		this.bookTitle = bookTitle;
		this.bookGenre = bookGenre;
		this.bookNumberOfInstances = bookNumberOfInstances;
		this.bookPrice = bookPrice;
	}
	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @return the bookAuthor
	 */
	public String getBookAuthor() {
		return bookAuthor;
	}
	/**
	 * @param bookAuthor the bookAuthor to set
	 */
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	/**
	 * @return the bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}
	/**
	 * @param bookTitle the bookTitle to set
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	/**
	 * @return the bookGenre
	 */
	public String getBookGenre() {
		return bookGenre;
	}
	/**
	 * @param bookGenre the bookGenre to set
	 */
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	/**
	 * @return the bookNumberOfInstances
	 */
	public int getBookNumberOfInstances() {
		return bookNumberOfInstances;
	}
	/**
	 * @param bookNumberOfInstances the bookNumberOfInstances to set
	 */
	public void setBookNumberOfInstances(int bookNumberOfInstances) {
		this.bookNumberOfInstances = bookNumberOfInstances;
	}
	/**
	 * @return the bookPrice
	 */
	public double getBookPrice() {
		return bookPrice;
	}
	/**
	 * @param bookPrice the bookPrice to set
	 */
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adminForBooks, bookAuthor, bookGenre, bookId, bookNumberOfInstances, bookPrice, bookTitle,
				ordersForBooks, ratingsForBook, userForBooks);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(adminForBooks, other.adminForBooks) && Objects.equals(bookAuthor, other.bookAuthor)
				&& Objects.equals(bookGenre, other.bookGenre) && bookId == other.bookId
				&& bookNumberOfInstances == other.bookNumberOfInstances
				&& Double.doubleToLongBits(bookPrice) == Double.doubleToLongBits(other.bookPrice)
				&& Objects.equals(bookTitle, other.bookTitle) && Objects.equals(ordersForBooks, other.ordersForBooks)
				&& Objects.equals(ratingsForBook, other.ratingsForBook)
				&& Objects.equals(userForBooks, other.userForBooks);
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookAuthor=" + bookAuthor + ", bookTitle=" + bookTitle + ", bookGenre="
				+ bookGenre + ", bookNumberOfInstances=" + bookNumberOfInstances + ", bookPrice=" + bookPrice
				+ ", adminForBooks=" + adminForBooks + ", userForBooks=" + userForBooks + ", ordersForBooks="
				+ ordersForBooks + ", ratingsForBook=" + ratingsForBook + "]";
	}



	
	

}
