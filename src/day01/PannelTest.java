package day01;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import book_manager_program.ProgramMain;

public class PannelTest extends Frame implements ActionListener
{
	//1. ������Ʈ ����  / Button b1 = new Button("��ư1"); 
	//2. �̺�Ʈ �ڵ鷯 �ۼ�  / ActionListener �������̽��� ��ӹ��� ��ü�� ���� / �������̵� �Լ� �ۼ� / b1.addActionListener(�������̽��� ��ӹ��� ��ü�� ����);
	
	public PannelTest() {
		this.setLayout(new FlowLayout());
		this.setTitle("��ư ����"); // or super("��ư ����");
	
		Button b1 = new Button("��ư1");
		Button b2 = new Button("��ư2");
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b2.addActionListener(this);
		
		this.add(b1);
		this.add(b2);
		
		this.setSize(300, 400);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ư Ŭ��");
	}
	
	public static void main(String[] args) {
		new ProgramMain();
	}
}