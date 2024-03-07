package org.eclipse.example.swt.model;

public abstract class NamedEntry {
	
	
	public NamedEntry(String name) {
		this.name = name;
	}
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
