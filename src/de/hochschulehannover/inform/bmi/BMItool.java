package de.hochschulehannover.inform.bmi;



import org.apache.log4j.BasicConfigurator;

import de.hochschulehannover.inform.bmi.gui.GUIcontrol;
import de.hochschulehannover.inform.bmi.gui.MainView;

public class BMItool {

	static GUIcontrol _guiControl;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		// Set up a simple log4j configuration that logs on the console.
		
		
	     BasicConfigurator.configure();
//	     try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		//_guiControl = GUIcontrol.getInstance();
		MainView mv = new MainView();
		mv.run();
		
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BMItool window = new BMItool();
//					window.frmStart.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

}
