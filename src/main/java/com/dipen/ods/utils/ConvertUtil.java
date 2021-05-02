package com.dipen.ods.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dipen.ods.entities.Orders;
import com.dipen.ods.models.CustomMessages;
import com.dipen.ods.models.OrderDTO;

@Component
public class ConvertUtil {
	
	public static OrderDTO convertToOrderDto(Orders order) {
		OrderDTO dto = new OrderDTO();
		dto.setId(order.getId());
		dto.setPrice(order.getProduct().getPrice());
		dto.setProductName(order.getProduct().getName());
		dto.setMsg(CustomMessages.BUY_NOW.toString());
		return dto;
	}

	public static List<OrderDTO> convertToListOrderDto(List<Orders> orders){
		List<OrderDTO> dtos = new ArrayList<OrderDTO>();
		for(Orders order: orders) {
			dtos.add(convertToOrderDto(order));
		}
		return dtos;
	}
}
