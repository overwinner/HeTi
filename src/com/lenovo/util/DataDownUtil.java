package com.lenovo.util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
 * HeTi1内第一个功能
 * @author Administrator
 * DownHtml
 */
public class DataDownUtil {
/**
 * @Title:getHtmlResourceByUrl
 * @Discription:get html5 code
 * @param @return
 * @param encoding utf-8 gbk
 * @return String
 * @see <a href="http://www.baidu.com">test</a>
 * @throws Exception
 */
	//use url catch information
	public static String getHtmlResourceByUrl(String url,String encoding){
		URL urlObject = null;
		URLConnection uc = null;
		InputStreamReader isr = null;
		BufferedReader reader = null;
		StringBuffer buffer = new StringBuffer();
				try {
					//建立网络连接
					urlObject = new URL(url);
					//打开网络连接
					uc = urlObject.openConnection();
					//建立文件输入流
					isr = new InputStreamReader(uc.getInputStream(),encoding);
					//建立缓存写入
					reader = new BufferedReader(isr);
					//临时
					String temp = null;
					//test
					File writename = new File("C:\\New Text Document.txt");
					writename.createNewFile();
					BufferedWriter out = new BufferedWriter(new FileWriter(writename));
					//先判断是否为空，再循环读取
					while((temp=reader.readLine())!=null){
						//保存到buffer
						buffer.append(temp+"\n");
						//test
						
						out.write(temp+"\n");
						out.flush();
					}
					out.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					//关闭流
					if(isr!=null){
						try {
							isr.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		return buffer.toString();
	}
	
	/**
	 * @Title getJobInfo
	 * @Description papa
	 * @param 设定文件
	 * @return void 返回类型
	 * 
	 */
	public static List<HashMap<String, Object>> getJobInfo(String url,String encoding){
		//登录页面并跳转到指定页面
//		User user = new User();
//		String html = InHtmlJWXT.isLogin(user.getName(), user.getPasswd(), user.getBtnLogin(), user.getviewstate());
		//拿到源代码
		String html = getHtmlResourceByUrl(url, encoding);
		//解析源代码
		Document document = Jsoup.parse(html);
		//
		Element element = document.getElementById("ctl00_Cph_VP_GvMaterial");
		//
		Elements elements1 = document.getElementsByClass("row");
		//
		Elements elements2 = document.getElementsByClass("alternatingRow");
		
		List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map1 = null;
		HashMap<String, Object> map2 = null;
		
		int endNumber = (elements1.size()-3)*2;
		for(int i=1;i<endNumber;i++){
			ok:
			for(Element e1 : elements1){
				map1 = new HashMap<String, Object>();
				//
				String No1 = e1.getElementsByClass("listNo").text();
				
				String PN1 = e1.getElementsByClass("lc").text();

				String Description1 = e1.getElementsByClass("title").text();
				
				String BorrowDate1 = e1.getElementsByClass("lenddate").text();
				
				if(No1 == null || No1.length() == 0){
					continue;
				}else {
					if(Integer.parseInt(No1)==i){
						map1.put("No", No1);
						map1.put("PN", PN1);
						map1.put("Description", Description1);
						map1.put("BorrowDate", BorrowDate1);
						maps.add(map1);
						break;
						}
					else {
							for(Element e2: elements2){
								map2 = new HashMap<String, Object>();
								//
								String No2 = e2.getElementsByClass("listNo").text();
									
								String PN2 = e2.getElementsByClass("lc").text();

								String Description2 = e2.getElementsByClass("title").text();
									
								String BorrowDate2 = e2.getElementsByClass("lenddate").text();
									
								if(Integer.parseInt(No2)==i){
								map2.put("No", No2);
								map2.put("PN", PN2);
								map2.put("Description", Description2);
								map2.put("BorrowDate", BorrowDate2);
								maps.add(map2);
								break ok;
								}
							}
							
						}
					}
			}
		}
		
		return maps;
	}
	/**
	 * use main test class
	 * @param args
	 */
//	public static void main(String[] args) {
//		 TODO Auto-generated method stub
//		List<HashMap<String, Object>> list = getJobInfo("file:///F:/Noname1--ANSI.html","gbk");
//		System.out.println(list);
//	}

}
