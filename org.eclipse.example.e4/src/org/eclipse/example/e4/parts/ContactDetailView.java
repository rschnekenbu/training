 
package org.eclipse.example.e4.parts;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.example.e4.model.Contact;
import org.eclipse.example.e4.model.provider.SWTExampleHelper;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;

public class ContactDetailView {
	private Text text;

	@Inject
	public ContactDetailView() {
		
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		text = SWTExampleHelper.createTextWithLabel(parent);
		
	}


	@Inject
	public void setInput(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Contact contact) {
		if(text == null || text.isDisposed()) {
			return;
		}
		if(contact !=null && contact.getName() !=null) {
			text.setText(contact.getName());			
		} else {
			text.setText("");
		}
	} 
	
}