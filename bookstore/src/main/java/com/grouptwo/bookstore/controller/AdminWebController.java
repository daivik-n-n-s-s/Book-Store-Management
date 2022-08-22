/**
 * 
 */
package com.grouptwo.bookstore.controller;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grouptwo.bookstore.model.Book;
import com.grouptwo.bookstore.model.Order;
import com.grouptwo.bookstore.model.Rating;
import com.grouptwo.bookstore.model.User;
import com.grouptwo.bookstore.service.AdminService;

/**
 * @author HY1916H
 *
 */
@RestController
@RequestMapping("/web")
public class AdminWebController {
	
	@Autowired
	AdminService adminService;
	
	//The resource is admin here: /admins/{idOfAdmin}/ is the resource url along with the id of admin
	//***************************WELCOME PAGE*****************************************
	@GetMapping("/admins/{idOfAdmin}/welcome")
	public String sayWelcomeToAdmin(@PathVariable int idOfAdmin)
	{
		return "Hello, Welcome Admin!! Your Id is " + idOfAdmin ;
	}
		
	
	//***************************USER FUNCTIONALITIES*****************************************
	//*****CREATE USER*********
	@PostMapping("/admins/{idOfAdmin}/users")
	public User createUserByAdmin(@PathVariable int idOfAdmin, @RequestBody User userCreatedByAdmin)
	{	
		
		return adminService.createUserByAdmin(idOfAdmin, userCreatedByAdmin);
	}
	
	//******READ ALL USERS*******
	@GetMapping("/admins/{idOfAdmin}/users")
	public Collection<User> getAllUsersByAdmin()
	{
		return adminService.getAllUsersByAdmin();
	}
	
	//********READ A SPECIFIC USER******
	@GetMapping("/admins/{idOfAdmin}/users/{idOfASpecificUser}")
	public User getUserByUserId(@PathVariable int idOfAdmin, @PathVariable int idOfASpecificUser)
	{
		return adminService.getUserByUserId(idOfASpecificUser);
	}
	
	//*********UPDATE A SPECIFIC USER*******
	@PutMapping("/admins/{idOfAdmin}/users")
	public User updateUserByAdmin(@RequestBody User latestUserDetails)
	{
		return adminService.updateUserByAdmin(latestUserDetails);
	}
	

	
	//*********DELETING A SPECIFIC USER*****
	@Transactional
	@DeleteMapping("/admins/{idOfAdmin}/users/{idOfASpecificUser}")
	public String deleteUserByAdmin(@PathVariable int idOfAdmin, @PathVariable int idOfASpecificUser)
	{
		adminService.deleteUserByAdmin(idOfASpecificUser);
		return "Deletion of the user with id " + idOfASpecificUser +" is successful";
	}
	
	

	//***************************BOOK FUNCTIONALITIES*****************************************
	//*****CREATE BOOK*********
	@PostMapping("/admins/{idOfAdmin}/books")
	public Book createBookByAdmin(@PathVariable int idOfAdmin,@RequestBody Book bookCreatedByAdmin)
	{
		return adminService.createBookByAdmin(idOfAdmin, bookCreatedByAdmin);
	}
	
	//******READ ALL BOOKS*******
	@GetMapping("/admins/{idOfAdmin}/books")
	public Collection<Book> getAllBooksByAdmin()
	{
		return adminService.getAllBooksByAdmin();
	}
	
	//********READ A SPECIFIC BOOK******
	@GetMapping("/admins/{idOfAdmin}/books/{idOfASpecificBook}")
	public Book getBookByBookId(@PathVariable int idOfAdmin, @PathVariable int idOfASpecificBook)
	{
		return adminService.getBookByBookId(idOfASpecificBook);
	}
	
	
	//**********SEARCH A BOOK************
	@GetMapping("/admins/{idOfAdmin}/books/search/{titleOfASpecificBook}")
	public Book getBookByBookTitle(@PathVariable int idOfAdmin, @PathVariable String titleOfASpecificBook)
	{
		return adminService.getBookByBookTitle(titleOfASpecificBook);
	}
	//*********UPDATE A SPECIFIC BOOK*******
	@PutMapping("/admins/{idOfAdmin}/books")
	public Book updateBookByAdmin(@RequestBody Book latestBookDetails)
	{
		return adminService.updateBookByAdmin(latestBookDetails);
	}
	
	
	//*********DELETING A SPECIFIC BOOK*****
	@Transactional
	@DeleteMapping("/admins/{idOfAdmin}/books/{idOfASpecificBook}")
	public String deleteBookByAdmin(@PathVariable int idOfAdmin, @PathVariable int idOfASpecificBook)
	{
		adminService.deleteBookByAdmin(idOfASpecificBook);
		return "Deletion of the book with id " + idOfASpecificBook +" is successful";
	}
	
	//***************************RATING FUNCTIONALITIES*****************************************
	//*****VIEW ALL RATINGS******
	@GetMapping("/admins/{idOfAdmin}/ratings")
	public Collection<Rating> getAllRatingssByAdmin()
	{
		return adminService.getAllRatingsByAdmin();
	}
	
	//***************************ORDER FUNCTIONALITIES*****************************************
	//******READ ALL ORDERS*******
	@GetMapping("/admins/{idOfAdmin}/orders")
	public Collection<Order> getAllOrdersByAdmin()
	{
		return adminService.getAllOrdersByAdmin();
	}
	
	//********READ A SPECIFIC ORDER******
	@GetMapping("/admins/{idOfAdmin}/orders/{idOfASpecificOrder}")
	public Order getOrderByOrderId(@PathVariable int idOfAdmin, @PathVariable int idOfASpecificOrder)
	{
		return adminService.getOrderByOrderId(idOfAdmin, idOfASpecificOrder);
	}
	
	//*********UPDATE A SPECIFIC ORDER*******
	@PutMapping("/admins/{idOfAdmin}/orders")
	public Order updateOrderByAdmin(@PathVariable int idOfAdmin,@RequestBody Order latestOrderDetails)
	{
		return adminService.updateOrderByAdmin(idOfAdmin, latestOrderDetails);
	}

	
//	//*********DELETING A SPECIFIC ORDER*****
//	@Transactional
//	@DeleteMapping("/admins/{idOfAdmin}/orders/{idOfASpecificOrder}")
//		public String deleteOrderByAdmin(@PathVariable int idOfAdmin, @PathVariable int idOfASpecificOrder)
//		{
//			adminService.deleteOrderByAdmin(idOfASpecificOrder);
//			return "Deletion of the order with id " + idOfASpecificOrder +" is successful";
//		}

}
