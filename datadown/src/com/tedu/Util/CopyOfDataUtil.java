package com.tedu.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 
 * @author kenyim
 *
 */

public class CopyOfDataUtil {
	//去携程服务器下载他的代码
	/**
	 * 
	 * @param url
	 * @param encoding
	 * @return
	 */
	
	
	public static String getHtmlResourceByUrl(String url,String encoding){
	
		StringBuffer buffer=new StringBuffer();
		InputStreamReader isr=null;
		
		try {
			//建立网络连接
			URL urlObj=new URL(url);
			// 打开网络连接
			URLConnection uc=urlObj.openConnection();
			//建立文件输入流
			isr=new InputStreamReader(uc.getInputStream(),encoding);
			//缓冲
			BufferedReader reader=new BufferedReader(isr);
			
			//建立临时文件
			String line=null;
			
			//开始读取源代码
			while((line=reader.readLine())!=null){
				//将临时文件保存到StringBuffer
				buffer.append(line+"\n");
			}
			
			if(isr!=null)isr.close();
		} catch (Exception e) {
				e.printStackTrace();
			}finally{
					try {
						if(isr!=null)
						isr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				
			}

		return buffer.toString();
	}
	
	public static List<HashMap<String,String>> getHotelInfo(String url,String encoding){
		List<HashMap<String,String>> maps=new ArrayList<HashMap<String,String>>();
		//根据网址获取网页源码
		String html=getHtmlResourceByUrl(url,encoding);
		//解析源码
		Document document=Jsoup.parse(html);
		//获取hotel_list盒子
		Element element=document.getElementById("hotel_list");
		//拿到每一个酒店 ~
		Elements elements=document.getElementsByClass("searchresult_list");
		//拿到每一个酒店的名称 图片 描述
		HashMap<String,String> map =null;
		for(Element el:elements){
			map=new HashMap<String,String> ();
			//获取酒店图片
			String  imgSrc=el.getElementsByTag("img").attr("src");
			//获取酒店的描述
			String content=el.getElementsByClass("searchresult_htladdress").text();
			//获取酒店名称
			String title=el.getElementsByTag("img").attr("alt");
			map.put("imgSrc",imgSrc);
			map.put("content",content);
			map.put("title",title);
			maps.add(map);
		}
		return maps;
	}
	
	public static void main(String[] args) {
		List<HashMap<String,String>> html=getHotelInfo("http://hotels.ctrip.com/hotel/shanghai2#ctm_ref=hod_hp_sb_lst" , "utf-8"); 
		for(HashMap<String,String> hashMap:html){
			String img=hashMap.get("imgSrc");
			String content=hashMap.get("content");
			String title=hashMap.get("title");
			System.out.println("名称:"+title);
			System.out.println("内容:"+content);
			System.out.println("图片:"+img);
			System.out.println("===================");
		}

	}
	
}














