package com.dipen.ods.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dipen.ods.entities.Orders;
import com.dipen.ods.entities.Payment;
import com.dipen.ods.entities.User;
import com.dipen.ods.models.OrderDTO;
import com.dipen.ods.services.OrderService;
import com.dipen.ods.services.PaymentService;
import com.dipen.ods.services.UserService;
import com.dipen.ods.utils.AuthenticationUtil;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/saveorder/{product_id}")
	public void saveOrder(@PathVariable Long product_id) {
		
		String userName = AuthenticationUtil.getLoggedInUser();
		User user =userService.findUserByUserName(userName);
		orderService.createOrder(product_id, user);
	}
	@GetMapping("/getorders")
	public List<OrderDTO> getUnPaidOrders(){
		String userName = AuthenticationUtil.getLoggedInUser();
		User user =userService.findUserByUserName(userName);
		return orderService.getUpaidOrders(user);
	}
	
	/*@GetMapping("/getOrdersByUser")
	public List<Orders> getUnPaidOrdersByUser(){
		String userName = AuthenticationUtil.getLoggedInUser();
		User user =userService.findUserByUserName(userName);
		return orderService.getOrdersByUser(user);
	}*/
	@GetMapping("/savepayment/{order_id}")
	public Payment savePayment(@PathVariable Long order_id) {
		String userName = AuthenticationUtil.getLoggedInUser();
		User user =userService.findUserByUserName(userName);
		if(user.equals(orderService.findUserFromOrderId(order_id))) {
			return paymentService.createPayment(order_id);
		}
		return null;
	}

}
