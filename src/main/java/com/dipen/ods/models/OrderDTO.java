package com.dipen.ods.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
	private Long id;
	private String productName;
	private int price;
	private String msg;

}
