package day01;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JPannelTest extends JFrame implements ActionListener
{
	public JPannelTest() {
		this.setLayout(new FlowLayout());
		this.setTitle("버튼 예제"); // or super("버튼 예제");
	
		JButton b1 = new JButton("버튼1");
		JButton b2 = new JButton("버튼2");
		JButton b3 = new JButton("버튼3");
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1이 클릭되었습니다.");
			}
		});
		b2.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		
		this.setSize(300, 400);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("버튼2")) {
			System.out.println("버튼2가 클릭되었습니다.");
			this.getContentPane().setBackground(Color.BLACK);
			//직접적으로 색깔은 못바꿈			
			//getContentPane으로 컨테이너를 가져와서 바꿔줘야함
		}
		else if (e.getActionCommand().equals("버튼3")) {
			System.out.println("버튼3이 클릭되었습니다.");
		}
	}
	
	public static void main(String[] args) {
		new JPannelTest();
	}
}