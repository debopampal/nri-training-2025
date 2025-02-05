package com.ace.springcoredemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ace.springcoredemo.bean.Car;

@RestController
public class DemoController {
//	@Autowired
//	@Qualifier("tataCar")
	private Car car;
	
	@Autowired
	public DemoController(@Qualifier("tataCar") Car c) {
		this.car = c;
	}
	
	
//	@Autowired
//	public void setCar(Car car) {
//		this.car = car;
//	}

	@GetMapping("/brandname")
	public String getCarBrand() {
		return this.car.getBrandName();
	}
	
	@GetMapping("/carcolor")
	public String getColor() {
		return this.car.getColor();
	}
}
