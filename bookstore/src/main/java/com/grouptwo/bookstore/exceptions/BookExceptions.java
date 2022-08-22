/**
 * 
 */
package com.grouptwo.bookstore.exceptions;

/**
 * @author HY1916H
 *
 */
public class BookExceptions extends Exception {

	public void bookNotFoundException() {
		// TODO Auto-generated method stub
		System.out.println("The book you are trying to access is no longer available...!!");
	}
}
