package encodetest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str="李白";
		String str1=URLEncoder.encode(str,"utf-8");//编码
		System.out.println(str1);
		String str2=URLDecoder.decode(str1,"utf-8");//解码
		System.out.println(str2);
	}
}
