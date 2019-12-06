package day03;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class SwingFileDialogTest extends JFrame {
	JPanel panel1 = new JPanel();
	
	JButton openFileDialogBtn = new JButton("파일 열기");
	JButton saveFileDialogBtn = new JButton("파일 저장");
	
	JTextArea ta = new JTextArea();
	JScrollPane textAreaScrollPane = new JScrollPane(ta);
	
	private boolean isTextFile(File file) {
		String fileExtension = FilenameUtils.getExtension(file.getAbsolutePath());
		if (fileExtension.toLowerCase().equals("txt"))
			return true;
		
		return false;
	}
	
	
	/***
	 * 파일을 읽어들여서 문자열로 반환해주는 함수
	 * 
	 * @param file java.nio.file.File
	 * @param outText 빈 스트링빌더에 담아서 반환해줌
	 * @return 제대로 읽엇는지 못 읽었는지
	 */
	private boolean readAllText(File file, StringBuilder outText) {
		String content = "";
		boolean isReadFailed = false;
		  try {
			  content = FileUtils.readFileToString(file, "utf-8");
			  outText.append(content);
			
		} catch (IOException e) {
			e.printStackTrace();
			isReadFailed = true;
		}
		
		if (isReadFailed) 
			return false;
		else 
			return true;
	}
	
	/***
	 * 파일을 저장합니다
	 * 
	 * @param path : 저장할 경로
	 * @param content : 내용
	 * @return
	 */
	private boolean writeAllText(String path, String content) {
		try (PrintWriter out = new PrintWriter(path)) {
		    out.println(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	private class OpenFileButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileDialog = new JFileChooser();
			int dialogResult = fileDialog.showOpenDialog(SwingFileDialogTest.this);
			
			
			switch (dialogResult) {
				case JFileChooser.APPROVE_OPTION:{
					
					File file = fileDialog.getSelectedFile();
					if( !isTextFile(file) ) { 
						JOptionPane.showMessageDialog(null, "txt 형식의 파일만 읽어 들일 수 있습니다.", "에러", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					StringBuilder builder = new StringBuilder();
					
					if ( !readAllText(file, builder))
						JOptionPane.showMessageDialog(null, "파일을 읽는데 실패했습니다", "에러", JOptionPane.ERROR_MESSAGE);
					
					String content = builder.toString();
					ta.setText("");
					ta.setText(content);
				}
			}
		}
	}
	
	private class SaveFileButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileDialog = new JFileChooser();
			int dialogResult = fileDialog.showSaveDialog(SwingFileDialogTest.this);
			switch (dialogResult) {
				case JFileChooser.APPROVE_OPTION:{
					if (!writeAllText(fileDialog.getSelectedFile().getAbsolutePath(), ta.getText()))
						JOptionPane.showMessageDialog(null, "파일을 저장하는데 실패했습니다", "에러", JOptionPane.ERROR_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "파일을 저장하는데 성공했습니다");
					break;
				}
			}
		}
	}
	
	
	public SwingFileDialogTest() {
		super("Json 파일 열기와 저장");
		
		openFileDialogBtn.addActionListener(new OpenFileButtonActionListener());
		saveFileDialogBtn.addActionListener(new SaveFileButtonActionListener());
		
		panel1.setLayout(new GridLayout(1, 2));
		
		panel1.add(openFileDialogBtn);
		panel1.add(saveFileDialogBtn);
		
		this.add(BorderLayout.NORTH, panel1);
		this.add(BorderLayout.CENTER, textAreaScrollPane);
		this.setSize(300, 400);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingFileDialogTest();
		
	}
}
