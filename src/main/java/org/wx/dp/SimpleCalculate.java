package org.wx.dp;

public class SimpleCalculate implements Calculate {

	@Override
	public double add(double num1, double num2) {
		return num1+num2;
	}

	@Override
	public double minus(double num1, double num2) {
		return num1-num2;
	}

}
