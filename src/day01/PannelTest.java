package day01;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import book_manager_program.ProgramMain;

public class PannelTest extends Frame implements ActionListener
{
	//1. 컴포넌트 생성  / Button b1 = new Button("버튼1"); 
	//2. 이벤트 핸들러 작성  / ActionListener 인터페이스를 상속받은 객체를 만듬 / 오버라이드 함수 작성 / b1.addActionListener(인터페이스를 상속받은 객체를 연결);
	
	public PannelTest() {
		this.setLayout(new FlowLayout());
		this.setTitle("버튼 예제"); // or super("버튼 예제");
	
		Button b1 = new Button("버튼1");
		Button b2 = new Button("버튼2");
		
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
		System.out.println("버튼 클릭");
	}
	
	public static void main(String[] args) {
		new ProgramMain();
	}
}