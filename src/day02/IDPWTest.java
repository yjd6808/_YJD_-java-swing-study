package day02;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IDPWTest extends JFrame{
	
	public IDPWTest() {
		super("커넥터 만들기");
		
		this.setLayout(new GridLayout(3, 1));
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(new JButton("회원가입"));
		buttonPanel.add(new JButton("로그인"));
		
		this.add(new JTextField());
		this.add(new JTextField());
		this.add(buttonPanel);
		
		this.setSize(400, 200);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new IDPWTest();

	}

}
