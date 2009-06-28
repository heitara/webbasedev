package com.gameif.util;

import java.util.List;
import com.xdatasystem.contactsimporter.*;
import com.xdatasystem.user.Contact;

public class MailContactUtil {

	public static List<Contact> getMailContact(String mailAddr, String passwd) {	

		ContactListImporter importer=ContactListImporterFactory.guess(mailAddr, passwd);
		List<Contact> contacts = null;
		try {
			contacts = importer.getContactList();
		} catch (ContactListImporterException e) {
			e.printStackTrace();
		}
		return contacts;
	}
}
