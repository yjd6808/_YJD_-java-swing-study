package day01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JGugudan extends JFrame{
	public JGugudan() {
		this.setLayout(new FlowLayout());

		JTextField gugudanStringTextField = new JTextField(10);
		JButton execBtn = new JButton("실행2");
		JTextArea gugudanTextArea = new JTextArea(10, 20);
		JScrollPane jscrollPane = new JScrollPane(gugudanTextArea);
		
		
		execBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer parsed = 0;
				try {
					parsed =  Integer.parseInt(gugudanStringTextField.getText());
				} catch (Exception err) {
					System.out.println("숫자만 입력해주세요");
				} 
				finally {
					for (int i =1; i < 10; i++)
						gugudanTextArea.setText(gugudanTextArea.getText() + parsed + " * " + i + " = " + parsed * i + "\n");
				}
			}
		});
		
		
		
		this.add(gugudanStringTextField);
		this.add(execBtn);
		this.add(jscrollPane);
		
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JGugudan();
	}
}
