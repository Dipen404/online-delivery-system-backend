package com.dipen.ods.services;

import com.dipen.ods.entities.Payment;

public interface PaymentService {

	Payment createPayment(Long order_id);
}
