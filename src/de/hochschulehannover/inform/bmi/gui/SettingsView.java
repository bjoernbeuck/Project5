package de.hochschulehannover.inform.bmi.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.apache.log4j.Logger;

public class SettingsView extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -435133579435952106L;
	
static GUIcontrol _guiControl;
	
	public SettingsView(){
		_guiControl = GUIcontrol.getInstance();
	}
	
	/**
	 * Logger!
	 */
	private static Logger _LOGGER = Logger.getLogger(SettingsView.class);
	
	public void run(){
		
		initComponents();
	
		this.setMinimumSize(new Dimension(172, 113));
		this.setSize(new Dimension(
				Integer.parseInt(_guiControl.getSetting("settingswidth", String.valueOf(1))),
				Integer.parseInt(_guiControl.getSetting("settingsheight", String.valueOf(1)))));
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle(_guiControl.getLocalizedString("gui.settings"));
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				JFrame jf = (JFrame) e.getSource();
				if (jf.getExtendedState() != Frame.MAXIMIZED_BOTH){
					_guiControl.setSetting("settingsx", jf.getLocation().x + "");
					_guiControl.setSetting("settingswidth", jf.getBounds().width + "");

					_guiControl.setSetting("settingsy", jf.getLocation().y + "");
					_guiControl.setSetting("settingsheight", jf.getBounds().height + "");
				}
				jf.removeAll();
				//_guiControl.setSetting("settingsstate", jf.getExtendedState() + "");
			}
		});
		
		try{
			this.setLocation(Integer.parseInt(_guiControl.getSettings("settingsx")),
					Integer.parseInt(_guiControl.getSettings("settingsy")));
		} catch (java.lang.NumberFormatException e){
			_LOGGER.info("No location information for settings view, putting it to the centre.");
			this.setLocationRelativeTo(rootPane);
		}
		//			try{
		//				this.setExtendedState(Integer.parseInt(_guiControl.getSettings("settingsstate")));
		//			} catch (java.lang.NumberFormatException e){
		//				_LOGGER.info("No state information for settings view, using default");
		//			}
		
		

		this.setVisible(true);
	}
	
	
	JLabel labUser;
	JLabel labPasswd;
	
	JTextField txtUser;
	JPasswordField txtPasswd;
	
	JButton buttCancel;
	JButton buttOK;
	
	JPanel pControls;
	JPanel pContent;
	
	private void initComponents(){
		this.setLayout(new BorderLayout());
		
		pContent = new JPanel();
		{
			pContent.setLayout(new GridLayout(2, 2));
			labUser = new JLabel(_guiControl.getLocalizedString("gui.user_name"));{
				pContent.add(labUser);
			}
			txtUser = new JTextField();{
				txtUser.setText(_guiControl.getSettings("user"));
				pContent.add(txtUser);
			}
			labPasswd = new JLabel(_guiControl.getLocalizedString("gui.password"));{
				pContent.add(labPasswd);
			}
			txtPasswd = new JPasswordField();{
				txtPasswd.setText(_guiControl.getSettings("password"));
				txtPasswd.setActionCommand("ok");
				txtPasswd.addActionListener(this);
				pContent.add(txtPasswd);
			}
			this.add(pContent, BorderLayout.CENTER);
		}
		pControls = new JPanel();{
			pControls.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttOK = new JButton(_guiControl.getLocalizedString("gui.ok"));{
				buttOK.setActionCommand("ok");
				buttOK.addActionListener(this);
				pControls.add(buttOK);
			}
			buttCancel = new JButton(_guiControl.getLocalizedString("gui.cancel"));{
				buttCancel.setActionCommand("cancel");
				buttCancel.addActionListener(this);
				pControls.add(buttCancel);
			}
			this.add(pControls, BorderLayout.SOUTH);
		}
		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("ok".equals(e.getActionCommand())) {
			_guiControl.setSetting("user", txtUser.getText());
			_guiControl.setPassword("password", txtPasswd.getPassword());
		}
		// I do not know if this is actually necessary.
		txtPasswd.setText("*********************************************");
		this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
