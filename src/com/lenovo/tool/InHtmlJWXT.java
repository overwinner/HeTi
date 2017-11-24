package com.lenovo.tool;

import com.lenovo.tool.InHtmlJWXT_util.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



/**
 * 登录页面跳转后抓取源码
 * @author Administrator
 *
 */
public class InHtmlJWXT {
	/**
	 * 登录页面跳转后抓取源码
	 * @param hm 用户名
	 * @param pwd 密码
	 * @param BtnLogin Login
	 * @param viewstate Fiddler 4抓取隐藏的_VIEWSTATE的值
	 * @return String html
	 */
	public static String isLogin(String hm,String pwd,String BtnLogin,String viewstate){
		HttpResponse responsePost = null;
		String html = null;
		
		//初始化HttpClient为cHttpClient
		CloseableHttpClient cHttpClient = JwUtils.getHttpClient();
		//初始化Post提交为httpPost
		HttpPost httpPost = new HttpPost(JwUtils.BASE_URL+"/mmweb/Login.aspx");
		//初始化表单为params
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("__VIEWSTATE", viewstate));
		params.add(new BasicNameValuePair("ctl00$Cph$TxtName", hm));
		params.add(new BasicNameValuePair("ctl00$Cph$TxtPwd", pwd));
		params.add(new BasicNameValuePair("ctl00$Cph$BtnLogin", BtnLogin));
		
		//开始执行
		try {
			
			//httpPost设置为params
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			//提交Post并获得响应
			responsePost = cHttpClient.execute(httpPost);
			//获得跳转的网址
			Header locationHeader = responsePost.getFirstHeader("Location");
			if(locationHeader != null && "HTTP/1.1 302 Found".equals(responsePost.getStatusLine().toString())){
				String login_success = locationHeader.getValue();//获取登录成功之后跳转链接
				HttpGet httpGet = new HttpGet(JwUtils.BASE_URL+login_success);//初始化Gey提交为httpGet开始跳转
				HttpResponse responsePost2 = cHttpClient.execute(httpGet);//提交Get并获得响应开始跳转
				HttpEntity entity = responsePost2.getEntity();
				System.out.println("Response Line: " + responsePost2.getStatusLine());//打印状态码

				html = EntityUtils.toString(entity,"utf-8");//获得跳转后页面的源码

				EntityUtils.consume(entity);//关闭HttpEntity流
			}else{
				System.out.println("登录不成功，请稍后试试！");
				return null;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return html;
	}
}
