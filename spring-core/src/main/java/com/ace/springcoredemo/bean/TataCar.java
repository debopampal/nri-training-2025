package com.ace.springcoredemo.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
//@Primary
@Lazy
public class TataCar implements Car {
	private String brandName;
	private String color;
	
	public TataCar() {
//		this.setBrandName("TATA");
//		this.setColor("GREEN");
		
		System.out.println("Tata car object is created");
	}

	@Override
	public String getBrandName() {
		return this.brandName;
	}

	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	@PostConstruct
	public void initTataCar() {
		this.setBrandName("TATA");
		this.setColor("GREEN");
		
		System.out.println("Tata car object initialization done!");
	}

	@PreDestroy
	public void doCleanupStuff() {
		System.out.println("Cleanup process done!");
	}
}
