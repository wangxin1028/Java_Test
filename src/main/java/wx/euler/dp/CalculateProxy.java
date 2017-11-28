package wx.euler.dp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculateProxy {
	private Calculate calculate; 
	public CalculateProxy(Calculate calculate ) {
		this.calculate = calculate;
	}
	public Calculate getProxy() {
		Calculate newProxyInstance = (Calculate)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] {Calculate.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object result = null;
				if(Arrays.stream(method.getAnnotations()).anyMatch(t -> t.annotationType()==wx.euler.annotation.aop.class)) {
					String name = method.getName();
					System.out.println("Method name :"+name);
					System.out.println("begin calculate,args is :"+Arrays.toString(args));
					result = method.invoke(calculate, args);
					System.out.println("calculate end,result is :"+result);
				}else {
					result = method.invoke(calculate, args);
				}
				return result;
			}
		});
		return newProxyInstance;
	}
}
