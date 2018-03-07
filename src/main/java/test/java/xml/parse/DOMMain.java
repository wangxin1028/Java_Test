package test.java.xml.parse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import test.java.xml.bean.Student;
/**
 * Java原生支持
 * @author wangxin
 *
 */
public class DOMMain {
	public static void main(String[] args) throws Exception {
		DomParse();
	}
	public static void DomParse() throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse("conf/student.xml");
		NodeList nodeList = document.getElementsByTagName("student");
		for(int i = 0 ; i < nodeList.getLength() ; i++) {
			Element ele = (Element) nodeList.item(i);
			String id = ele.getAttribute("id");
			
			String name = ele.getElementsByTagName("name").item(0).getTextContent();
			String gender = ele.getElementsByTagName("gender").item(0).getTextContent();
			String age = ele.getElementsByTagName("age").item(0).getTextContent();
			String address = ele.getElementsByTagName("address").item(0).getTextContent();
			
			System.out.println(new Student(Integer.parseInt(id), name, Integer.parseInt(age), gender, address));
		}
	}
}
