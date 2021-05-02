package com.dipen.ods.serviceImpl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dipen.ods.entities.Orders;
import com.dipen.ods.entities.Payment;
import com.dipen.ods.entities.User;
import com.dipen.ods.entities.UserRole;
import com.dipen.ods.models.AdminDTO;
import com.dipen.ods.models.PaymentStatus;
import com.dipen.ods.models.Status;
import com.dipen.ods.repositories.OrdersRepository;
import com.dipen.ods.repositories.PaymentRepository;
import com.dipen.ods.repositories.UserRepository;
import com.dipen.ods.repositories.UserRoleRepository;
import com.dipen.ods.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public void createUser(User user, Set<UserRole> userRoles) throws IOException {
		log.debug("Creating new user {}", user.getEmail());

		if (userRepository.findByEmail(user.getEmail()) != null) {
			log.error("Duplicate Email: {}", user.getEmail());
		} else {
			user = userRepository.save(user);
			for (UserRole userRole : userRoles)
				userRole.setUser(user);
			userRoleRepository.saveAll(userRoles);
		}

		return;
	}

	@Override
	public User findUserByUserName(String uname) {
		return userRepository.findByEmail(uname);
	}

	@Override
	public List<AdminDTO> getTotalRecords() {
		List<AdminDTO> dtos = new ArrayList<AdminDTO>();
		// List<Orders> orders =
		// ordersRepository.findByPayment(PaymentStatus.INCOMPLETE);
		List<Orders> orders = ordersRepository.findAll();
		List<Payment> payments = paymentRepository.findByStatus(Status.COMPLETED);
		for (Orders order : orders) {
			AdminDTO dto = new AdminDTO();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd");
			dto.setProductId(order.getProduct().getId());
			dto.setCustomerName(order.getUser().getFirstName());
			dto.setPrice(order.getProduct().getPrice());
			dto.setOrderedDate(dateFormat.format(order.getDate()));
			dto.setProductName(order.getProduct().getName());

			for (Payment payment : payments) {

				if (payment.getOrder().getId() == order.getId()) {
					dto.setPaymentDate(dateFormat.format(payment.getDate()));
					break;
				} else {
					dto.setPaymentDate("");
				}

			}
			dtos.add(dto);

		}
		return dtos;
	}
}