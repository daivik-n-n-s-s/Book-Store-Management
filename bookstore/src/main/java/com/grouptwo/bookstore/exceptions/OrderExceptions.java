/**
 * 
 */
package com.grouptwo.bookstore.exceptions;

/**
 * @author HY1916H
 *
 */
public class OrderExceptions extends Exception{
	
	public void userDoNotHaveAcess()
	{
		System.out.println("User does not have access to this order...");
	}

	public void orderNotFoundException() {
		// TODO Auto-generated method stub
		System.out.println("The book you are trying to access is no longer available...!!");
	}

}
