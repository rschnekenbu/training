package org.eclipse.example.swt.model;

public class Contact extends NamedEntry {

	private ContactGroup group;

	public Contact(ContactGroup group, String name) {
		super(name);
		this.group = group;
	}

	public ContactGroup getGroup() {
		return group;
	}
}