package book_manager_program;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LibraryManagerConnectorForm extends JFrame{
	
	JPanel buttonPanel = new JPanel();
	JButton registerBtn  =new JButton("회원가입");
	JButton loginBtn  =new JButton("로그인");
	JTextField idTf = new JTextField();
	JTextField pwTf = new JTextField();
	
	public LibraryManagerConnectorForm() {
		super("도서관리 프로그램 접속기");
		
		this.setLayout(new GridLayout(3, 1));
		
		buttonPanel.add(registerBtn);
		buttonPanel.add(loginBtn);
		
		this.add(idTf);
		this.add(pwTf);
		this.add(buttonPanel);
		
		
		this.setSize(400, 200);
		this.setVisible(true);
		registerBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isValidIdPwInserted())
					return;
				
				String id = idTf.getText();
				String pw = idTf.getText();
				
				//회원가입
			}
		});
		
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isValidIdPwInserted())
					return;
				
				String id = idTf.getText();
				String pw = idTf.getText();
				
				JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor((JButton)e.getSource());
				topFrame.dispose();
			}
		});
	}
	
	private boolean isValidIdPwInserted() {
		if (idTf.getText().replaceAll(" ", "").length() <= 0) {
			JOptionPane.showMessageDialog(null, "아이디를 제대로 입력해주세요.");
			return false;
		}
		
		if (pwTf.getText().replaceAll(" ", "").length() <= 0) {
			JOptionPane.showMessageDialog(null, "비밀번호를 제대로 입력해주세요.");
			return false;
		}
		
		if (idTf.getText().contains(" ") || 
			pwTf.getText().contains(" ")) {
			JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호에는 공백이 포함될 수 없습니다.");
			return false;
		}
		
		if (idTf.getText().length() <= 4 || 
			pwTf.getText().length() <= 4  ) {
			JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호는 5자리이상으로 입력해주세요");
			return false;
		}
			
		
		return true;
	}
}
