package org.eclipse.example.swt.views;


import org.eclipse.example.swt.model.Contact;
import org.eclipse.example.swt.model.ContactGroup;
import org.eclipse.example.swt.model.ContactModel;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.part.ViewPart;

import jakarta.inject.Inject;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class SampleView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.example.swt.views.SampleView";

	@Inject IWorkbench workbench;
	
	private TreeViewer viewer;
	 

	class ViewContentProvider implements ITreeContentProvider {
		@Override
		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof ContactModel) {
				return ((ContactModel)parentElement).getGroups().toArray();
			} else if(parentElement instanceof ContactGroup) {
				return ((ContactGroup)parentElement).getContacts().toArray();
			}
			return null;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof ContactModel) {
				return ((ContactModel)inputElement).getGroups().toArray();
			} 
			return null;
		}

		@Override
		public Object getParent(Object element) {
			if(element instanceof ContactGroup) {
				return ((ContactGroup)element).getModel();
			} else if(element instanceof Contact) {
				return ((Contact)element).getGroup();
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return false;
		}
		
	}
	
	class ViewLabelProvider extends LabelProvider  {
		
		@Override
		public Image getImage(Object obj) {
			return workbench.getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		ContactModel model = new ContactModel();
		
		viewer = new TreeViewer(parent, SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(model);

		// Create the help context id for the viewer's control
		workbench.getHelpSystem().setHelp(viewer.getControl(), "org.eclipse.example.swt.viewer");
		getSite().setSelectionProvider(viewer);
		
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Sample View",
			message);
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
