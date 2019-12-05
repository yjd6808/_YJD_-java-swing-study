package day01;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CheckBoxTest extends JFrame{
	JPanel checkBoxPanel = new JPanel();
	JCheckBox checkBoxApple = new JCheckBox("�籫");
	JCheckBox checkBoxBanana = new JCheckBox("�ٳ���");
	JScrollPane textArea = new JScrollPane(new JTextArea(10, 20)); 
	
	public CheckBoxTest() {
		 super("CheckBoxTest");
		 
		 checkBoxPanel.add(checkBoxApple);
		 checkBoxPanel.add(checkBoxBanana);
		 
		 this.add(BorderLayout.NORTH, checkBoxPanel);
		 this.add(textArea);
		 
		 checkBoxApple.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox box =  (JCheckBox)e.getSource();
				if (box.isSelected()) {
					((JTextArea)textArea.getViewport().getView()).append("���\n");
				}
			}
		});
		 
		 checkBoxBanana.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					JCheckBox box =  (JCheckBox)e.getSource();
					if (box.isSelected()) {
						((JTextArea)textArea.getViewport().getView()).append("�ٳ���\n");
					}
				}
			});
		 
		 this.setSize(300, 300);
		 this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckBoxTest();
	}

}
