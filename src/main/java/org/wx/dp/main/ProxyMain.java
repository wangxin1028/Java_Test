package org.wx.dp.main;

import org.wx.dp.Calculate;
import org.wx.dp.CalculateProxy;
import org.wx.dp.SimpleCalculate;

public class ProxyMain {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Calculate simpleCalculate = new SimpleCalculate();
		CalculateProxy proxy = new CalculateProxy(simpleCalculate);
		Calculate calculate = proxy.getProxy();
		System.out.println(calculate.getClass());
		calculate.add(1, 2);
		System.out.println(calculate);
	}
}
