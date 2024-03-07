package org.eclipse.example.swt.model;

import java.util.ArrayList;
import java.util.List;

public class ContactModel {

	private List<ContactGroup> groups = new ArrayList<ContactGroup>();
	
	public ContactModel() {
		ContactGroup group1 = new ContactGroup(this, "group1");
		group1.addContact("Jane");
		ContactGroup group2 = new ContactGroup(this, "group2");
		group2.addContact("Joe");
		groups.add(group1);
		groups.add(group2);
	}
	
	public List<ContactGroup> getGroups() {
		return groups;
	}
	
	
}
