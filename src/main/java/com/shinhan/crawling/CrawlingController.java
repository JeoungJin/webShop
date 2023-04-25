package com.shinhan.crawling;

import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.shinhan.frontcontrollerpattern.CommonControllerInterface;

public class CrawlingController implements CommonControllerInterface{

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		String url = "https://www.choongang.co.kr/html/sub07_01_n.php?page=1&mod=&idx=";

		// 1~11 웹페이지 소스 가져오기
		for(int p=1; p<=11; p++) {
		    String params = "?page=" + p + "&mod=&idx=";
		    //System.out.println(params);
		    Document doc = Jsoup.connect(url+params).get();
		    System.out.println(doc);
		    
		    Elements elements = doc.select(".default_title");
		    for( Element element : elements ) {
		        System.out.println(element.text());
		    } // for end
		    
		} // for end
		
		return null;
	}
	public static void main(String[] args) {
		try {
			new CrawlingController().execute(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
