package com.heima.util;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class JaxpUtils {

	public static Document getDocument(){
		
		try {
			DocumentBuilder db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document=db.parse("src/exam.xml");
			return document;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public static void write2xml(Document document){
		try {
			Transformer tf=TransformerFactory.newInstance().newTransformer();
			tf.transform(new DOMSource(document), new StreamResult("src/exam.xml"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
