 
package org.eclipse.example.e4.parts;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.example.e4.model.ContactEntry;
import org.eclipse.example.e4.model.provider.SWTExampleHelper;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;

public class ContactDetailView {
	private Text text;

	@Inject
	MDirtyable part;
	
	private ContactEntry entry;
	
	@Inject
	public ContactDetailView() {
		
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		text = SWTExampleHelper.createTextWithLabel(parent);
		text.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if(entry !=null && entry.getName()!=null && !entry.getName().equals(text.getText())) {
					setDirty(true);
				} else {
					setDirty(false);
				}
 			}
		});
	}
	
	private void setDirty(boolean newValue) {
		if (part != null)
			part.setDirty(newValue);
	}

	@Focus
	public void setFocus() {
		if(text !=null && !text.isDisposed()) {
			text.setFocus();
		}
	}
	
	@Inject
	public void setInput(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) ContactEntry contactEntry) {
		if(text == null || text.isDisposed()) {
			return;
		}
		this.entry = contactEntry;
		if(contactEntry !=null && contactEntry.getName() !=null) {
			text.setText(contactEntry.getName());			
		} else {
			text.setText("");
		}
	} 
	
	@Persist
	public void save() {
		entry.setName(text.getText());
		part.setDirty(false);
	}
}