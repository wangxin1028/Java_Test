package org.wx.dp;

import org.wx.annotation.aop;

public interface Calculate {
	@aop
	public double add(double num1,double num2);
	@aop
	public double minus(double num1,double num2);
}
