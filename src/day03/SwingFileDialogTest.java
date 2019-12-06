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
	
	JButton openFileDialogBtn = new JButton("���� ����");
	JButton saveFileDialogBtn = new JButton("���� ����");
	
	JTextArea ta = new JTextArea();
	JScrollPane textAreaScrollPane = new JScrollPane(ta);
	
	private boolean isTextFile(File file) {
		String fileExtension = FilenameUtils.getExtension(file.getAbsolutePath());
		if (fileExtension.toLowerCase().equals("txt"))
			return true;
		
		return false;
	}
	
	
	/***
	 * ������ �о�鿩�� ���ڿ��� ��ȯ���ִ� �Լ�
	 * 
	 * @param file java.nio.file.File
	 * @param outText �� ��Ʈ�������� ��Ƽ� ��ȯ����
	 * @return ����� �о����� �� �о�����
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
	 * ������ �����մϴ�
	 * 
	 * @param path : ������ ���
	 * @param content : ����
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
						JOptionPane.showMessageDialog(null, "txt ������ ���ϸ� �о� ���� �� �ֽ��ϴ�.", "����", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					StringBuilder builder = new StringBuilder();
					
					if ( !readAllText(file, builder))
						JOptionPane.showMessageDialog(null, "������ �дµ� �����߽��ϴ�", "����", JOptionPane.ERROR_MESSAGE);
					
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
						JOptionPane.showMessageDialog(null, "������ �����ϴµ� �����߽��ϴ�", "����", JOptionPane.ERROR_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "������ �����ϴµ� �����߽��ϴ�");
					break;
				}
			}
		}
	}
	
	
	public SwingFileDialogTest() {
		super("Json ���� ����� ����");
		
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
