package com.ace.springcoredemo.bean;

//@Component
public class SuzukiCar implements Car {
	private String color;
	private String brandName;
	
	public SuzukiCar() {
		System.out.println("Suzuki Car object is created");
	}

	@Override
	public String getBrandName() {
		return "Suzuki";
	}

	@Override
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

}
