package com.ace.springcoredemo.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class KiaCar implements Car {

	@Override
	public String getBrandName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColor(String color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBrandName(String brandName) {
		// TODO Auto-generated method stub

	}

}
