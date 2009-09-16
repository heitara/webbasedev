package com.gameif.portal.businesslogic.titleif;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


public class APITest {

	public static void main(String[] args) {
	
		try {

			/*
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet("http://localhost/test.html");
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
				String line;

				while ((line = reader.readLine()) != null) {
				    System.out.println(line);
				}
				reader.close();
			}
			/*
			if (entity != null) {
			    InputStream instream = entity.getContent();
			    int l;
			    byte[] tmp = new byte[2048];
			    while ((l = instream.read(tmp)) != -1) {
			    	
			    }
			}
			*/
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet("http://localhost/test.html");
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				SAXReader sxreader = new SAXReader();
				Document document = sxreader.read(entity.getContent());
				Node resultNode = document.selectSingleNode("//response/result");
				Node tradeNumNode = document.selectSingleNode("//response/tradeNum");
				
				System.out.println("resultNode.getStringValue(): " + resultNode.getStringValue());
				System.out.println("resultNode.getText(): " + resultNode.getText());
				
				System.out.println("tradeNumNode.getStringValue(): " + tradeNumNode.getStringValue());
				System.out.println("tradeNumNode.getText(): " + tradeNumNode.getText());
			}
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
	}
}
