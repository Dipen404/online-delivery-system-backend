package com.dipen.ods.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dipen.ods.entities.Orders;
import com.dipen.ods.entities.Product;
import com.dipen.ods.entities.User;
import com.dipen.ods.models.OrderDTO;
import com.dipen.ods.models.PaymentStatus;
import com.dipen.ods.models.Status;
import com.dipen.ods.repositories.OrdersRepository;
import com.dipen.ods.repositories.ProductRepository;
import com.dipen.ods.services.OrderService;
import com.dipen.ods.services.ProductService;
import com.dipen.ods.utils.ConvertUtil;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Orders createOrder(Long product_id, User user) {
		Product product= productRepository.getOne(product_id);
		if(product==null) {
			Orders newOrder = new Orders();
			newOrder.setProduct(productService.getProductById(product_id));
			Date date = new Date();
			newOrder.setDate(date);
			newOrder.setStatus(Status.COMPLETED);
			newOrder.setUser(user);
			newOrder.setPayment(PaymentStatus.INCOMPLETE);
			return ordersRepository.save(newOrder);
		}
		return null;
		
	}

	@Override
	public List<OrderDTO> getUpaidOrders(User user) {
		List<Orders> orders = ordersRepository.findByUserId(user.getId());
		List<Orders> unpaidOrders = new ArrayList<Orders>();
		for(Orders order:orders) {
			if(order.getPayment().equals(PaymentStatus.INCOMPLETE)) {
				unpaidOrders.add(order);
			}
		}
		return ConvertUtil.convertToListOrderDto(unpaidOrders);
	}

	@Override
	public List<Orders> getOrdersByUser(User user) {
		
		return ordersRepository.findByUserId(user.getId());
	}

	@Override
	public User findUserFromOrderId(Long order_id) {
		Orders order = ordersRepository.findById(order_id).orElse(null);
		return order.getUser();
	}

}
