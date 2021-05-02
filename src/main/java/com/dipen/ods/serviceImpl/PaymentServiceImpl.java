package com.dipen.ods.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dipen.ods.entities.Orders;
import com.dipen.ods.entities.Payment;
import com.dipen.ods.models.PaymentStatus;
import com.dipen.ods.models.Status;
import com.dipen.ods.repositories.OrdersRepository;
import com.dipen.ods.repositories.PaymentRepository;
import com.dipen.ods.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private OrdersRepository ordersRepository; 
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment createPayment(Long order_id) {
		Orders order =ordersRepository.getOne(order_id);
		if(order.getPayment().equals(PaymentStatus.INCOMPLETE)) {
			Payment payment = new Payment();
			payment.setOrder(ordersRepository.getOne(order_id));
			Date date = new Date();
			payment.setDate(date);
			payment.setStatus(Status.COMPLETED);
			order.setPayment(PaymentStatus.COMPLETE);
			ordersRepository.save(order);
			return paymentRepository.save(payment);
		}
		return null;
		
	}

}
