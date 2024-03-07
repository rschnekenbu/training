package org.eclipse.example.e4.model;

public interface ContactService {

	ContactGroup getInput();
	
	void addContact(ContactEntry contactEntry);

}
