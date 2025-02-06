package com.ace.springcoredemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ace.springcoredemo.bean.Car;

@RestController
public class ScopeDemoController {
	private Car kiaSeltos;
	private Car kiaSonet;

	@Autowired
	public ScopeDemoController(
			@Qualifier("kiaCar") Car kiaSeltos,
			@Qualifier("kiaCar") Car kiaSonet
	) {
		this.kiaSeltos = kiaSeltos;
		this.kiaSonet = kiaSonet;
	}
	
	@GetMapping("/checkKia")
	public String check() {
		return String.format("Comparing between kiaSeltos & kiaSonet: %s", kiaSeltos == kiaSonet); 
	}
}
