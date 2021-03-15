	package presentationLayer;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.awt.Font;

	import javax.swing.*;
	import javax.swing.border.Border;
	
		//This Class represents the environment in which the Chef needs to prepare all the ordered items;
	public class ChefGUI implements Observer{
		
		private JLabel info = new JLabel("Orders added: ");
		private JLabel updateTxt = new JLabel("");
		
		private Subject subject;
		
		private Color defaultColor = new Color(255,255,250);
		private Color panelColor = new Color(255,255,255);
		private Border blackline = BorderFactory.createLineBorder(Color.black);
		
		private JFrame frame = new JFrame("Chef");
		private JPanel defaultPanel = new JPanel();
		private JPanel panel1 = new JPanel();
		private JPanel panel2 = new JPanel();

		
		public ChefGUI(Subject subject) {
			
			this.subject = subject;
			this.subject.attach(this);
			
			frame.setSize(1250, 600);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			defaultPanel.setLayout(new FlowLayout());
			defaultPanel.setBackground(defaultColor);
			panel1.setLayout(new FlowLayout());
			panel1.setBackground(panelColor);
			panel1.setBorder(blackline);
			panel2.setLayout(new FlowLayout());
			panel2.setBackground(panelColor);
			panel2.setBorder(blackline);
			updateTxt.setPreferredSize(new Dimension(1200,40));
			info.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			panel1.add(info);
			panel2.add(updateTxt);
			defaultPanel.add(panel1);
			defaultPanel.add(panel2);
			frame.setContentPane(defaultPanel);
			frame.setVisible(true);
		}
		
		
		//This overridden method implements what the subject's state will be updated to;
		@Override
		public void update() {
		String currentStatus = subject.getState();
		String	text = new String();
		text= updateTxt.getText().concat("" + currentStatus + "  ");	//the spaces between the states are mandatory in order for the Chef to differentiate between orders;
		updateTxt.setText(text);
		}
	}



