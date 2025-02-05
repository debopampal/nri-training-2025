package com.ace.springcoredemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ace.springcoredemo.bean.Car;
import com.ace.springcoredemo.bean.SuzukiCar;

@Configuration
public class CarConfig {
	
	@Bean
	public Car suzukiCar() {
		SuzukiCar suzukiCar = new SuzukiCar();
		suzukiCar.setColor("Red");
		return suzukiCar;
	}
}
