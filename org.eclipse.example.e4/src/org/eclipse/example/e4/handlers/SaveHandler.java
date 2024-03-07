 
package org.eclipse.example.e4.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import jakarta.inject.Named;

public class SaveHandler {
	@Execute
	public void execute(EPartService partService,
			@Named(IServiceConstants.ACTIVE_PART) MPart mPart) {
		partService.savePart(mPart, false);
	}
	
	
	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_PART) MDirtyable dirtyable) {
		if (dirtyable == null) {
			return false;
		}
		return dirtyable.isDirty();
	}
		
}