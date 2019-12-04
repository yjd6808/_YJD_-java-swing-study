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
		this.setTitle("��ư ����"); // or super("��ư ����");
	
		JButton b1 = new JButton("��ư1");
		JButton b2 = new JButton("��ư2");
		JButton b3 = new JButton("��ư3");
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ư1�� Ŭ���Ǿ����ϴ�.");
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
		if (e.getActionCommand().equals("��ư2")) {
			System.out.println("��ư2�� Ŭ���Ǿ����ϴ�.");
			this.getContentPane().setBackground(Color.BLACK);
			//���������� ������ ���ٲ�			
			//getContentPane���� �����̳ʸ� �����ͼ� �ٲ������
		}
		else if (e.getActionCommand().equals("��ư3")) {
			System.out.println("��ư3�� Ŭ���Ǿ����ϴ�.");
		}
	}
	
	public static void main(String[] args) {
		new JPannelTest();
	}
}