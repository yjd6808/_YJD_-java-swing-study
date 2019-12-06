package day03;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class SwingJMenuBarTest extends JFrame {
	
	public SwingJMenuBarTest() {
		super("�޴��� ���");
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("����");
		JMenuItem openLibraryFile = new JMenuItem("������� ���� ����");
		openLibraryFile.addActionListener(e -> JOptionPane.showMessageDialog(null, "���� �ƹ��� ����� ����.", "����", JOptionPane.ERROR_MESSAGE));
		fileMenu.add(openLibraryFile);
		fileMenu.add("���� ������ ����");
		fileMenu.add("�ٸ� �̸����� ���� ������ ����");
		
		
		JMenu helpMenu = new JMenu("����");
		helpMenu.add("������ ����");
		helpMenu.add("���α׷� ����");
		
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);
		this.setSize(300,300);
	}

	public static void main(String[] args) {
		new SwingJMenuBarTest();
	}
}
