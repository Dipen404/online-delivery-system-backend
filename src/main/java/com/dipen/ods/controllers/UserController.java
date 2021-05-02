package com.dipen.ods.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dipen.ods.entities.Orders;
import com.dipen.ods.entities.User;
import com.dipen.ods.services.OrderService;
import com.dipen.ods.services.UserService;
import com.dipen.ods.utils.AuthenticationUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	
	/*@GetMapping("/profile")
	public String getUserHomePage(Model model) {
		String username = AuthenticationUtil.getLoggedInUser();
		model.addAttribute("user", username);
		return "user/home";
	}*/

	/*@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveOrder")
	public Orders saveOrder(@PathVariable Long product_id) {
		
		String userName = AuthenticationUtil.getLoggedInUser();
		User user =userService.findUserByUserName(userName);
		return orderService.createOrder(product_id, user);
	}
	@GetMapping("/hello")
	public String getUserHomePages(Model model) {
		String username = AuthenticationUtil.getLoggedInUser();
		model.addAttribute("user", username);
		return "user/hello";
	}*/
}
