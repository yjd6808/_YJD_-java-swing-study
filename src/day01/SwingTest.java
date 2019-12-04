package day01;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingTest extends JFrame {
	private JPanel p1, p2;
	private JButton b1, b2, b3, b4;
	
	public SwingTest() {
		super("SwingTest");
		
		this.setLayout(new FlowLayout());
		
		p1 = new JPanel();
		p2 = new JPanel();
		
		b1 = new JButton("패널2 보이기");
		b2 = new JButton("패널2 안보이기");
		b3 = new JButton("패널1 보이기");
		b4 = new JButton("패널1 안보이기");
		
		p1.add(b1);
		p1.add(b2);
		
		p2.add(b3);
		p2.add(b4);
		
		p1.setBackground(Color.blue);
		p2.setBackground(Color.yellow);
		
		this.add(p1);
		this.add(p2);
		
		this.setSize(400, 400);
		this.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p2.setVisible(true);
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p2.setVisible(false);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p1.setVisible(true);
			}
		});
		
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p1.setVisible(false);
			}
		});
	}
	
	public static void main(String[] args) {
		new SwingTest();
	}
}
