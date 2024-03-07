package org.eclipse.swt.example;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HelloWorld {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell( display );
		
	
		Text helloText = new Text(shell, SWT.CENTER);
	    helloText.setText("Hello SWT!");
	    helloText.setBounds(47, 20, 100, 20);
		shell.setSize( 200, 200 );
		
		shell.open();
		shell.setText( "Hello World!" );
		
		while( !shell.isDisposed() ) {
			if( !display.readAndDispatch() ) {
				display.sleep();
			}
		}
		display.dispose();

	}

}
