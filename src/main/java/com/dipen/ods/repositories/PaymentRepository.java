package com.dipen.ods.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dipen.ods.entities.Payment;
import com.dipen.ods.models.Status;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

	List<Payment> findByStatus(Status completed);

}
