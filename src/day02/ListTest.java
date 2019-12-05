package day02;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListTest extends JFrame{
	private List list = new List();
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	private class AddButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField inputTf = ((JTextField)p1.getComponent(0));
			
			if (inputTf.getText().isEmpty())
				return;
			
			list.add(inputTf.getText());
		}
	}
	
	private class MultypleAllowCheckBoxItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox checkBox = (JCheckBox)e.getSource();
			if (checkBox.isSelected())
				list.setMultipleMode(true);
			else
				list.setMultipleMode(false);
		}
	}
	
	private class ListSelectionItenListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			List list = (List)e.getSource();
			String[] selectedItems = list.getSelectedItems();
			JTextArea area = (JTextArea)p2.getComponent(1);
			if (selectedItems.length > 0) {
				area.setText("");
				
				for (int i =0; i < selectedItems.length; i++)
					area.setText(area.getText() + selectedItems[i] + "\n");
			}
			else
				area.setText("");
		}
	}
	
	public ListTest() {
		super("리스트 테스트");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1.add(new JTextField(15));
		p1.add(new JButton("추가"));
		p1.add(new JCheckBox("다중 선택"));
		
		p2.setLayout(new GridLayout(1, 2));
		p2.add(list);
		p2.add(new JTextArea());
		
		
		((JButton)p1.getComponent(1)).addActionListener(new AddButtonActionListener());
		((JCheckBox)p1.getComponent(2)).addItemListener(new MultypleAllowCheckBoxItemListener());
		list.addItemListener(new ListSelectionItenListener());
		this.add(BorderLayout.NORTH, p1);
		this.add(BorderLayout.CENTER, p2);
		
		this.setSize(400, 400);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListTest();
	}

}
