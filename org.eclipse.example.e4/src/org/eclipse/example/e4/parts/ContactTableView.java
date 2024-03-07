 
package org.eclipse.example.e4.parts;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.example.e4.model.ContactService;
import org.eclipse.example.e4.model.provider.SWTExampleHelper;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;

public class ContactTableView {
	
	@Inject
	public ContactService contactService;

	private TreeViewer viewer;
	
	@Inject
	public ContactTableView() {
		
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		viewer = SWTExampleHelper.createTreeViewer(parent);
		viewer.setInput(contactService.getInput());
	}
	
	
	@PreDestroy
	public void preDestroy() {
		SWTExampleHelper.dispose(viewer);
	}
	
	
	@Focus
	public void onFocus() {
		
	}
	
	
	@Persist
	public void save() {
		
	}
	
}