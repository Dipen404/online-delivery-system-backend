package com.dipen.ods.services;

import java.util.List;

import com.dipen.ods.entities.Orders;
import com.dipen.ods.entities.User;
import com.dipen.ods.models.OrderDTO;

public interface OrderService {
	
	Orders createOrder(Long product_id, User user);
	List<OrderDTO> getUpaidOrders(User user);
	List<Orders> getOrdersByUser(User user);
	User findUserFromOrderId(Long order_id);

}
