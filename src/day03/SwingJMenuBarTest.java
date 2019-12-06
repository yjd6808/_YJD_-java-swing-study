package day03;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class SwingJMenuBarTest extends JFrame {
	
	public SwingJMenuBarTest() {
		super("메뉴바 사용");
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("파일");
		JMenuItem openLibraryFile = new JMenuItem("도서목록 파일 열기");
		openLibraryFile.addActionListener(e -> JOptionPane.showMessageDialog(null, "현재 아무런 기능이 없다.", "에러", JOptionPane.ERROR_MESSAGE));
		fileMenu.add(openLibraryFile);
		fileMenu.add("현재 페이지 저장");
		fileMenu.add("다른 이름으로 현재 페이지 저장");
		
		
		JMenu helpMenu = new JMenu("도움말");
		helpMenu.add("개발자 정보");
		helpMenu.add("프로그램 정보");
		
		
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
