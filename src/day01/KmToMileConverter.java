package day01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KmToMileConverter extends JFrame{
	JPanel kmPanel = new JPanel();
	JPanel ConverterPanel = new JPanel();
	JPanel milePanel = new JPanel();
	
	public KmToMileConverter() {
		super("KmToMileConverter");

		kmPanel.add(new JLabel("Km"));
		kmPanel.add(new JTextField(10));
		
		ConverterPanel.setLayout(new BorderLayout());
		ConverterPanel.add(new JButton("º¯È¯"));
		
		milePanel.add(new JLabel("Mile"));
		milePanel.add(new JTextField(10));
		
		this.add(BorderLayout.NORTH, kmPanel);
		this.add(BorderLayout.CENTER, ConverterPanel);
		this.add(BorderLayout.SOUTH, milePanel);
		
		((JButton)ConverterPanel.getComponents()[0]).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField kmTextField = (JTextField)kmPanel.getComponents()[1];
				JTextField mileTextField = (JTextField)milePanel.getComponents()[1];
				
				float km = Float.parseFloat(kmTextField.getText());
				float mile = km * 0.62137f;
				
				mileTextField.setText(new Float(mile).toString());
			}
		});
		
		
		this.setSize(300, 150);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new KmToMileConverter();
	}

}
