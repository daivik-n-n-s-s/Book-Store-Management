/**
 * 
 */
package com.grouptwo.bookstore.model;

import java.util.Objects;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author HY1916H
 *
 */
@Entity
@Table(name="ratingdetails")
public class Rating {
	
	@Id
	@GeneratedValue
	private int ratingId;
	private int ratingValue;
	
	//********************************************RATINGS TO ADMIN****************************************
	//Many ratings relate or can be accessed by one admin
	@ManyToOne
//	(cascade = CascadeType.ALL)
	@JoinColumn(name="admin_id_foreignkey_rating", referencedColumnName = "adminId")
	@JsonIgnore
	private Admin adminForRatings;
	/**
	 * @return the adminForRatings
	 */
	public Admin getAdminForRatings() {
		return adminForRatings;
	}
	
	
	/**
	 * @param adminForRatings the adminForRatings to set
	 */
	public void setAdminForRatings(Admin adminForRatings) {
		this.adminForRatings = adminForRatings;
	}
	//********************************************RATINGS TO USER****************************************
	@ManyToOne
//	(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id_foreignkey_rating", referencedColumnName = "userId")
	@JsonIgnore
	private User userForRatings;
	
	/**
	 * @return the userForRatings
	 */
	public User getUserForRatings() {
		return userForRatings;
	}


	/**
	 * @param userForRatings the userForRatings to set
	 */
	public void setUserForRatings(User userForRatings) {
		this.userForRatings = userForRatings;
	}

	//********************************************RATINGS TO BOOK****************************************
	
	@ManyToOne
//	(cascade = CascadeType.ALL)
	@JoinColumn(name="book_id_foreignkey_rating", referencedColumnName = "bookId")
	@JsonIgnore
	private Book bookForRatings;
	/**
	 * @return the bookForRatings
	 */
	public Book getBookForRatings() {
		return bookForRatings;
	}


	/**
	 * @param bookForRatings the bookForRatings to set
	 */
	public void setBookForRatings(Book bookForRatings) {
		this.bookForRatings = bookForRatings;
	}

	//*******************************************************************************************************
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(int ratingId, int ratingValue) {
		super();
		this.ratingId = ratingId;
		this.ratingValue = ratingValue;
	}
	/**
	 * @return the ratingId
	 */
	public int getRatingId() {
		return ratingId;
	}
	/**
	 * @return the ratingValue
	 */
	public int getRatingValue() {
		return ratingValue;
	}
	/**
	 * @param ratingValue the ratingValue to set
	 */
	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
	}


	@Override
	public int hashCode() {
		return Objects.hash(adminForRatings, bookForRatings, ratingId, ratingValue, userForRatings);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rating other = (Rating) obj;
		return Objects.equals(adminForRatings, other.adminForRatings)
				&& Objects.equals(bookForRatings, other.bookForRatings) && ratingId == other.ratingId
				&& ratingValue == other.ratingValue && Objects.equals(userForRatings, other.userForRatings);
	}


	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", ratingValue=" + ratingValue + ", adminForRatings=" + adminForRatings
				+ ", userForRatings=" + userForRatings + ", bookForRatings=" + bookForRatings + "]";
	}


	
	
	
}
