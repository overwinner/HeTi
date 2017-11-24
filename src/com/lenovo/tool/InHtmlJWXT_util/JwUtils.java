package com.lenovo.tool.InHtmlJWXT_util;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
/**
 * 储存HttpClient
 * @Discription httpClient = null;BASE_URL="mmweb/";httpClient==null==HttpClients.createDefault
 * @author Administrator
 *
 */
public class JwUtils {
	private static CloseableHttpClient httpClient = null;
	public final static String BASE_URL = "http://10.96.25.243";
	
	public static CloseableHttpClient getHttpClient(){
		if(httpClient == null){
			httpClient = HttpClients.createDefault();
			return httpClient;
		}
		return httpClient;
	}

}
