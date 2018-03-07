package test.java.xml.parse;

import java.io.FileReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import test.java.xml.bean.Student;

public class PullMain {
	public static void main(String[] args) {
		
	}

	public static void testPULL2() throws Exception{
		//创建工厂类实例
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		//创建解析器类实例
		XmlPullParser parser = factory.newPullParser();
		//解析XML文档
		parser.setInput(new FileReader("student.xml"));
		
		//创建一个student对象
		Student stu = new Student();
		
		//通过解析器对象读取文档内容
		//当当前事件类型不为END_DOCUMENT,进行循环
		while(parser.next() != XmlPullParser.END_DOCUMENT){
			
			//获取标签名
			String tagName = parser.getName();
			//获取当前的事件类型
			int eventType = parser.getEventType();
			//先判断当前标签是否为开始标签
			if(eventType == XmlPullParser.START_TAG){
				
				//获取id属性值
				if("student".equals(tagName)){
					//创建一个新的学生对象
					stu = new Student();
					String idStr = parser.getAttributeValue(null, "id");
					
					stu.setId(Integer.parseInt(idStr));
					
				}else if("name".equals(tagName)){
					//读取name标签的文本值
					String name = parser.nextText();
					
					stu.setName(name);
					
				}else if("gender".equals(tagName)){
					String gender = parser.nextText();
					
					stu.setGender(gender);
					
				}else if("age".equals(tagName)){
					String ageStr = parser.nextText();
					
					stu.setAge(Integer.parseInt(ageStr));
					
				}else if("address".equals(tagName)){
					String address = parser.nextText();
					
					stu.setAddress(address);
					
					if(stu.getId() == 2){
						System.out.println(stu);
						break;
					}
					
				}
				
			}
			
			
			
		}
	}
	

	
	public static void testPULL() throws Exception {
		
		//创建工厂类实例
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		//创建解析器类实例
		//pull解析一切操作都是通过解析器对象来完成，需要将文件的流通过setInput()设置进解析器对象
		XmlPullParser parser = factory.newPullParser();
		//解析xml文档
		//获取文件输入流
		FileReader in = new FileReader("stu.xml");
		parser.setInput(in);
		
		//获取当前的事件类型
		int type = parser.getEventType();
		System.out.println(type);
		//控制解析器向下解析文档
		type = parser.next();
		System.out.println(type);
		type = parser.next();
		System.out.println(type);
		type = parser.next();
		System.out.println(type);
		
		//获取标签名
		String tagName = parser.getName();
		
		//获取id属性值
		//String idStr = parser.getAttributeValue(0);
		//getAttributeValue(命名空间,属性名) 命名空间没有 直接传null
		String idStr = parser.getAttributeValue(null, "id");
		
		System.out.println(idStr);
		
		System.out.println(tagName);
		
	}
}

