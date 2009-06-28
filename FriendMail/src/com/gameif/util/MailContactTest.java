package com.gameif.util;

import java.util.List;

import com.xdatasystem.user.Contact;

public class MailContactTest {
	
	public static void main(String[] args) {

		List<Contact> contacts = MailContactUtil.getMailContact("splightweb@yahoo.co.jp", "961557");
		
		for(Contact c : contacts) {
			
		  System.out.println("name: "+c.getName()+", email: "+c.getEmailAddress());
		}
	}
}