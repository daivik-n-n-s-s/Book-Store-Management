/**
 * 
 */
package com.grouptwo.bookstore.exceptions;

/**
 * @author HY1916H
 *
 */
public class RatingExceptions extends Exception{
	
	public void ratingNotFoundException() {
		// TODO Auto-generated method stub
		System.out.println("The Rating you are trying to access is no longer available...!!");
	}
	
}
