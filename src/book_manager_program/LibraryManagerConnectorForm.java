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
	JButton registerBtn  =new JButton("ȸ������");
	JButton loginBtn  =new JButton("�α���");
	JTextField idTf = new JTextField();
	JTextField pwTf = new JTextField();
	
	public LibraryManagerConnectorForm() {
		super("�������� ���α׷� ���ӱ�");
		
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
				
				//ȸ������
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
			JOptionPane.showMessageDialog(null, "���̵� ����� �Է����ּ���.");
			return false;
		}
		
		if (pwTf.getText().replaceAll(" ", "").length() <= 0) {
			JOptionPane.showMessageDialog(null, "��й�ȣ�� ����� �Է����ּ���.");
			return false;
		}
		
		if (idTf.getText().contains(" ") || 
			pwTf.getText().contains(" ")) {
			JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ���� ������ ���Ե� �� �����ϴ�.");
			return false;
		}
		
		if (idTf.getText().length() <= 4 || 
			pwTf.getText().length() <= 4  ) {
			JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� 5�ڸ��̻����� �Է����ּ���");
			return false;
		}
			
		
		return true;
	}
}
