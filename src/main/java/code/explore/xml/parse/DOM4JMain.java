package code.explore.xml.parse;

import java.io.FileWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import code.explore.xml.bean.Student;

public class DOM4JMain {
	public static void main(String[] args) throws Exception {
//		testDOM4J();
//		testDOM4JAddNode();
//		testDOM4JWrite();
		testXPath();
	}
	
	

	public static void testXPath() throws Exception {
		//获取解析器类实例
		SAXReader reader = new SAXReader();
		//解析XML文档
		Document doc = reader.read("conf/stu.xml");
		//查询id为3的学生
		Element stuEle = (Element) doc.selectSingleNode("/students/student[@id='2']");
		//获取学生信息
		String idStr = stuEle.attributeValue("id");
		String name = stuEle.elementText("name");
		String gender = stuEle.elementText("gender");
		String ageStr = stuEle.elementText("age");
		String address = stuEle.elementText("address");
		
		//封装Student对象
		Student student = new Student(Integer.parseInt(idStr), name, Integer.parseInt(ageStr), gender, address);
		
		//输出
		System.out.println(student);
	}



	public static void testDOM4JWrite() throws Exception{
		//创建document对象
		Document document = DocumentHelper.createDocument();
		//创建一个teacher的xml文件
		Element rootEle = document.addElement("teachers");
		//向rootEle中添加teacher
		Element teaEle = rootEle.addElement("teacher");
		//添加名字
		teaEle.addElement("name").addText("孔子");
		//在添加一个
		rootEle.addElement("teacher").addElement("name").addText("孟子");
		//将document对象写入文件中
		XMLWriter writer = new XMLWriter(new FileWriter("teacher.xml"),OutputFormat.createPrettyPrint());
		writer.write(document);
		writer.close();
	}



	public static void testDOM4JAddNode() throws Exception{
		
		//创建解析器类实例
		SAXReader reader = new SAXReader();
		//解析XML文档
		Document doc = reader.read("conf/student.xml");
		//获取根元素
		Element rootEle = doc.getRootElement();
		//向根元素中添加一个student元素
		Element stuEle = rootEle.addElement("student");
		//向stu中添加id属性
		stuEle.addAttribute("id", "5");
		//向stu中添加name元素
		stuEle.addElement("name").addText("白龙马");
		stuEle.addElement("gender").addText("男");
		stuEle.addElement("age").addText("80");
		stuEle.addElement("address").addText("东海");
		
		//创建一个漂亮的格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		
		//获取一个输出流，输出xml文档
		XMLWriter writer = new XMLWriter(new FileWriter("stu.xml"),format);
		//将doc对象输出
		writer.write(doc);
		//关闭流
		writer.close();
	}



	public static void testDOM4J() throws Exception {
		//创建解析器类的实例
		SAXReader reader = new SAXReader();
		//解析XML文档获取Document对象
		Document document = reader.read("conf/student.xml");
		//通过Document对象解析xml文档
		Element root = document.getRootElement();
		//获取所有的student
		@SuppressWarnings("unchecked")
		List<Element> stuEles = root.elements("student");
		
		//System.out.println(stuEles.size());
		//遍历list
		for (Element stuEle : stuEles) {
			
			//获取id
			String idStr = stuEle.attributeValue("id");
			//获取name age gender address
			String name = stuEle.elementText("name");
			String ageStr = stuEle.elementText("age");
			String gender = stuEle.elementText("gender");
			String address = stuEle.elementText("address");
			
			//封装Student对象
			Student student = new Student(Integer.parseInt(idStr), name, Integer.parseInt(ageStr), gender, address);
			//输出
			System.out.println(student);
		}
	}
}
