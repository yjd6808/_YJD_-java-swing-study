package day02;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridLayoutTest extends JFrame{
	
	public GridLayoutTest() {
		super("그리드 레이아웃 테스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel gridLayoutPanel = new JPanel();
		gridLayoutPanel.setLayout(new GridLayout(4, 2));
		
		gridLayoutPanel.add(new JLabel("이름"));
		gridLayoutPanel.add(new JTextField());
		gridLayoutPanel.add(new JLabel("나이"));
		gridLayoutPanel.add(new JTextField());
		gridLayoutPanel.add(new JLabel("주소"));
		gridLayoutPanel.add(new JTextField());
		gridLayoutPanel.add(new JButton("확인"));
		gridLayoutPanel.add(new JTextField());
		
		this.add(gridLayoutPanel);
		
		//JRootPane을 가져옴
		//this.getContentPane()
		
		//JRootPane에 포함된 컴포넌트들을 가져옴 (현재 JPanel을 추가했으니 패널 한개만 들어가있을 것이다.)
		//this.getContentPane().getComponents[i];
		
		
		JPanel panel =  (JPanel)this.getContentPane().getComponents()[0];
		for(int i =0; i < 8; i++) {
			if (panel.getComponent(i).getClass().getName().equals("javax.swing.JLabel"))
				((JLabel)panel.getComponent(i)).setHorizontalAlignment(JLabel.CENTER);
		}
			
		this.setSize(400, 200);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutTest();

	}

}
