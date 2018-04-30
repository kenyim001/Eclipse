package json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Stock;

public class JsonTest {
	/**
	 * 使用jackson api将java对象转换成json字符串
	 * @throws JsonProcessingException 
	 */

	public static void test1() throws JsonProcessingException{
		Stock s=new Stock();
		s.setCode("600877");
		s.setName("中国加零");
		s.setPrice(8);
		
		//jackson api
		ObjectMapper om=new ObjectMapper();
		String jsonStr=om.writeValueAsString(s);
		System.out.println(jsonStr);
	}
	
	public static void test2() throws JsonProcessingException{
		List<Stock> stocks=new ArrayList<Stock>();
		for (int i = 0; i < 3; i++) {
			Stock s=new Stock();
			s.setCode("600877"+i);
			s.setName("中国加零"+i);
			s.setPrice(8+i);
			stocks.add(s);
		}
		ObjectMapper om=new ObjectMapper();
		String jsonStr=om.writeValueAsString(stocks);
		System.out.println(jsonStr);
	}
	
	public static void main(String[] args) throws JsonProcessingException{
		test1();
		test2();
	}
	
}
