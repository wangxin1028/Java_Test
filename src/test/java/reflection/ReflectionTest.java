package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

import test.java.entity.ReflectionTestObject;

public class ReflectionTest {
	/**
	 * 目的：获取方法上的注解、异常、修饰符
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@Test
	public void testAnnotation() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> clazz = Class.forName("test.java.entity.Persion");
		Method method = clazz.getDeclaredMethod("setAge", int.class);
		//通过getDeclaredAnnotation获取注解
		NumberCheck annotation = method.getDeclaredAnnotation(NumberCheck.class);
		System.out.println(annotation.min()+","+annotation.max());
		//getExceptionTypes得到异常数组
		Class<?>[] classes = method.getExceptionTypes();
		for (Class<?> class1 : classes) {
			System.out.println(class1);
		}
		//getModifiers获取修饰符
		int modifiers = method.getModifiers();
		boolean final1 = Modifier.isFinal(modifiers);
		System.out.println(final1);
		boolean b = Modifier.isPublic(modifiers);
		System.out.println(b);
	}
	/**
	 * 目的：测试getFields和getDeclaredFields的区别
	 */
	@Test
	public void testGetField() {
		Class<ReflectionTestObject> clazz = ReflectionTestObject.class;
		//只会获取public修饰的属性
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		System.out.println("-------------------------");
		//可以获取当前类中声明的属性，但是不能获取继承得来的属性
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field);
		}
	}
	/**
	 * 目的：获取接口的泛型
	 */
	@Test
	public void testGetSuperClass() {
		Class<ReflectionTestObject> clazz = ReflectionTestObject.class;
		Type[] types = clazz.getGenericInterfaces();
		if(types!=null && types.length>0) {
			Type type = types[0];
			if(type instanceof ParameterizedType) {
				ParameterizedType p = (ParameterizedType)type;
				Type[] typeArguments = p.getActualTypeArguments();
				System.out.println(typeArguments[0]);
			}
		}
	}
}
