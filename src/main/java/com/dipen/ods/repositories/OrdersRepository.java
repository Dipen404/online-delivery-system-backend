package com.dipen.ods.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dipen.ods.entities.Orders;
import com.dipen.ods.models.PaymentStatus;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

	List<Orders> findByPayment(PaymentStatus incomplete);

	List<Orders> findByUserId(Long id);

}
