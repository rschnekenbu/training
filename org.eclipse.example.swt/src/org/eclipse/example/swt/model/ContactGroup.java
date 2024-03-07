package org.eclipse.example.swt.model;

import java.util.ArrayList;
import java.util.List;

public class ContactGroup extends NamedEntry {
	
	List<Contact> contacts = new ArrayList<Contact>();
	private ContactModel model;
	
	
	public ContactGroup(ContactModel model, String name) {
		super(name);
		this.model = model;
	}
	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	public Contact addContact(String name) {
		Contact contact = new Contact(this, name);
		return contact;
	}

	public ContactModel getModel() {
		return model;
	}
	
}
