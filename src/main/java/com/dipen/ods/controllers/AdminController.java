package com.dipen.ods.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dipen.ods.models.AdminDTO;
import com.dipen.ods.services.UserService;

@RestController
public class AdminController {

	@Autowired
	private UserService userService;

	@GetMapping("/dashboard")
	public List<AdminDTO> getAllRecords() {
		return userService.getTotalRecords();
	}
}