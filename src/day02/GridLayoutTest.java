package day02;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridLayoutTest extends JFrame{
	
	public GridLayoutTest() {
		super("�׸��� ���̾ƿ� �׽�Ʈ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel gridLayoutPanel = new JPanel();
		gridLayoutPanel.setLayout(new GridLayout(4, 2));
		
		gridLayoutPanel.add(new JLabel("�̸�"));
		gridLayoutPanel.add(new JTextField());
		gridLayoutPanel.add(new JLabel("����"));
		gridLayoutPanel.add(new JTextField());
		gridLayoutPanel.add(new JLabel("�ּ�"));
		gridLayoutPanel.add(new JTextField());
		gridLayoutPanel.add(new JButton("Ȯ��"));
		gridLayoutPanel.add(new JTextField());
		
		this.add(gridLayoutPanel);
		
		//JRootPane�� ������
		//this.getContentPane()
		
		//JRootPane�� ���Ե� ������Ʈ���� ������ (���� JPanel�� �߰������� �г� �Ѱ��� ������ ���̴�.)
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
