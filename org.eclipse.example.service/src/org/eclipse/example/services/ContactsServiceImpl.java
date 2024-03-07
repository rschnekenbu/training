package org.eclipse.example.services;

import org.eclipse.example.e4.model.ContactEntry;
import org.eclipse.example.e4.model.ContactGroup;
import org.eclipse.example.e4.model.ContactService;
import org.eclipse.example.e4.model.ModelFactory;

public class ContactsServiceImpl implements ContactService {
	
	private ContactGroup model;

	public ContactsServiceImpl() {
		this.model = initModel();
	}

	private ContactGroup initModel() {
		ContactGroup model = ModelFactory.eINSTANCE.createExampleModel();
		return model;
		
	}

	@Override
	public ContactGroup getInput() {
		return model;
	}

	@Override
	public void addContact(ContactEntry contactEntry) {
		getInput().getContacts().add(contactEntry);
		
	}
}
