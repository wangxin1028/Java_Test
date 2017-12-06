package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class ReflectionTest {
	@Test
	public void testAnnotation() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> clazz = Class.forName("wx.euler.entity.Persion");
		Method method = clazz.getDeclaredMethod("setAge", int.class);
		NumberCheck annotation = method.getDeclaredAnnotation(NumberCheck.class);
		System.out.println(annotation.min()+","+annotation.max());
		
		Class<?>[] classes = method.getExceptionTypes();
		for (Class<?> class1 : classes) {
			System.out.println(class1);
		}
		
		int modifiers = method.getModifiers();
		boolean final1 = Modifier.isFinal(modifiers);
		System.out.println(final1);
	}
}
