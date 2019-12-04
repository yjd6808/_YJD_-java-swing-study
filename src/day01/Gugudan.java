package day01;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gugudan extends Frame{
	public Gugudan() {
		this.setLayout(new FlowLayout());

		TextField gugudanStringTextField = new TextField(10);
		Button execBtn = new Button("실행");
		TextArea gugudanTextArea = new TextArea(10, 20);
		execBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gugudanTextArea.setText("");
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
		this.add(gugudanTextArea);
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Gugudan();
	}
}
