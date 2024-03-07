 
package org.eclipse.example.e4.parts;

import org.eclipse.example.e4.model.provider.SWTExampleHelper;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

public class ContactDetailView {
	private Text text;

	@Inject
	public ContactDetailView() {
		
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		text = SWTExampleHelper.createTextWithLabel(parent);
		
	}
	
	
}