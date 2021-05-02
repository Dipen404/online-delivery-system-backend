package com.dipen.ods.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
	private Long productId;
	private String productName;
	private String customerName;
	private String orderedDate;
	private String paymentDate;
	private int price;

}
