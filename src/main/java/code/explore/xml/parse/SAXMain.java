package code.explore.xml.parse;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import code.explore.xml.bean.Student;

/**
 * Java原生支持
 * @author wangxin
 *
 */
public class SAXMain {
	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse("conf/student.xml", new SAXHandlerTest());
	}
}
class SAXHandlerTest extends DefaultHandler{
	/**
	 * 开始读取文档时调用的方法
	 */
	@Override
	public void startDocument() throws SAXException {
		System.out.println("startDocument...");
	}
	
	/**
	 * 解析文档结束时调用的方法
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("endDocument...");
	}
	
	/**
	 * 解析开始标签时调用
	 * qName 代表标签名
	 * attributes 标签中的属性
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println();
		System.out.println("======================飘逸的分割线=============================");
		System.out.println("uri:"+uri);
		System.out.println("localName:"+localName);
		System.out.println("qName:"+qName);
		System.out.println("attributes:"+attributes.getValue("id"));

	}

	/**
	 * 解析结束标签时调用
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//System.out.println("endElement...");

	}
	
	/**
	 * 解析文本内容时调用
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//System.out.println("characters...");

		String str = new String(ch, start, length);
		
		System.out.println(str);
	}
}
class SAXHandler extends DefaultHandler{
	//定义一个属性接收前一个标签名
	private String preTagName;
	//创建一个Student
	private Student stu;

	/*
	 * qName 标签名
	 * attributes 元素的属性
	 * (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		//设置标签名
		preTagName = qName;
		
		//当当前标签为student标签时，我们获取id属性值
		if("student".equals(qName)){
			//创建student对象
			stu = new Student();
			String idStr = attributes.getValue("id");
			stu.setId(Integer.parseInt(idStr));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		preTagName = "";
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//判断当前id是否为3
		if(stu != null && 3 == stu.getId()){
			if("name".equals(preTagName)){
				String name = new String(ch,start,length);
				//获取学生的name
				stu.setName(name);
				
			}else if("age".equals(preTagName)){
				String ageStr = new String(ch,start,length);
				//获取学生的name
				stu.setAge(Integer.parseInt(ageStr));
				
			}else if("gender".equals(preTagName)){
				String gender = new String(ch,start,length);
				//获取学生的name
				stu.setGender(gender);
				
			}else if("address".equals(preTagName)){
				String address = new String(ch,start,length);
				//获取学生的name
				stu.setAddress(address);
				
				System.out.println(stu);
			}
		}
		
	}
}