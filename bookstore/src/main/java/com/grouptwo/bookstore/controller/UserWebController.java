/**
 * 
 */
package com.grouptwo.bookstore.controller;

import java.util.Collection;
import java.util.List;

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
import com.grouptwo.bookstore.service.UserService;

/**
 * @author HY1916H
 *
 */
@RestController
@RequestMapping("/web")
public class UserWebController {
	
	@Autowired
	UserService userService;
	
	//The resource is admin here: /users/{idOfUser}/ is the resource url along with the id of user
	//***************************WELCOME PAGE*****************************************
	@GetMapping("/users/{idOfUser}/welcome")
	public String sayWelcomeToUser(@PathVariable int idOfUser)
	{
		return "Hello, Welcome User!! Your Id is " + idOfUser ;
	}
	
	//***************************ORDER FUNCTIONALITIES*****************************************
	//******VIEW USER ORDERS*******
	@GetMapping("/users/{idOfUser}/orders")
	public List<Order> getAllOrdersOfUser(@PathVariable int idOfUser)
	{
		return userService.getAllOrdersOfUser(idOfUser);
	}
	
	@GetMapping("/users/{idOfUser}/orders/{idOfOrder}")
	public Order getSpecificOrderByUser(@PathVariable int idOfUser, @PathVariable int idOfOrder)
	{
		return userService.getSpecificOrderByUser(idOfUser, idOfOrder);
	}
	
	//******CREATE USER ORDERS*******	
	@PostMapping("/users/{idOfUser}/orders")
	public Order createOrderByUser(@PathVariable int idOfUser, @RequestBody Order orderCreatedByUser)
	{
		return userService.createOrderByUser(idOfUser, orderCreatedByUser);
	}
	
	//*********ADD BOOKS TO ORDER*******
	@PutMapping("/users/{idOfUser}/orders/{idOfOrder}/books")
	public Order addBooksToOrderByUser(@PathVariable int idOfUser,@PathVariable int idOfOrder, @RequestBody Book bookAddedToOrder)
	{
		return userService.addBooksToOrderByUser(idOfUser, idOfOrder, bookAddedToOrder);
	}
	
	//*********UPDATE USER ORDER***********
	@PutMapping("/users/{idOfUser}/orders")
	public Order updateOrderStatusByUser(@PathVariable int idOfUser, @RequestBody Order orderStatusToBeChanged)
	{
		return userService.updateOrderStatusByUser(idOfUser, orderStatusToBeChanged);
		
		
	}


	//***************************RATING FUNCTIONALITIES*****************************************
		//******VIEW USER RATINGS*******
		@GetMapping("/users/{idOfUser}/ratings")
		public List<Rating> getAllRatingsOfUser(@PathVariable int idOfUser)
		{
			return userService.getAllRatingsOfUser(idOfUser);
		}
		
		
		//******CREATE USER RATINGS*******	
		@PostMapping("/users/{idOfUser}/ratings/{idOfBook}")
		public Rating createRatingByUser(@PathVariable int idOfUser,@PathVariable int idOfBook, @RequestBody Rating ratingCreatedByUser)
		{
			return userService.createRatingByUser(idOfUser, idOfBook, ratingCreatedByUser);
		}
		
		
		//********UPDATE RATINGS*********
		 @PutMapping("/users/{idOfUser}/ratings/{idOfASpecificRating}")
		  public Rating updateRatingByUser(@PathVariable int idOfUser, @PathVariable int idOfASpecificRating, @RequestBody Rating latestRatingDetails) {
		    return userService.updateRatingByUser(idOfUser, idOfASpecificRating, latestRatingDetails);
		  }
		
		
		
		
		
		
		
		//*********DELETE USER RATINGS***********
		 @Transactional
		@DeleteMapping("/users/{idOfUser}/ratings/{idOfASpecificRating}")
		public String deleteRatingByUser(@PathVariable int idOfUser, @PathVariable int idOfASpecificRating)
		{
			userService.deleteRatingByUser(idOfASpecificRating);
			return "Deletion of the rating with id " + idOfASpecificRating +" is successful";
		}
		
		//*********DELETE ALL RATINGS OF A USER**********
		 @Transactional
		@DeleteMapping("/users/{idOfUser}/ratings")
		public String deleteAllRatingsOfAUser(@PathVariable int idOfUser) {

			userService.deleteAllRatingsOfUser(idOfUser);
		    return "Deletion of the all ratings of user with id " + idOfUser +" is successful";
		  }
		
		
		//***************************BOOK FUNCTIONALITIES*****************************************
		//******VIEW ALL BOOKS*******
		@GetMapping("/users/{idOfUser}/books")
		public List<Book> getAllBooks()
		{
			return userService.getAllBooks();
		}
















}
	

