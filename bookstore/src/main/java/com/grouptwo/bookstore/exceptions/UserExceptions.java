/**
 * 
 */
package com.grouptwo.bookstore.exceptions;

/**
 * @author HY1916H
 *
 */
public class UserExceptions extends Exception {

	public void userNotFoundException() {
		// TODO Auto-generated method stub
		System.out.println("The user you are trying to access is no longer available...!!");
	}
}
