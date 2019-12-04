package day01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JSwingCalculator_FlowLayout extends JFrame{
	private JButton opSumBtn;
	private JButton opSubBtn;
	private JButton opDivBtn;
	private JButton opMulBtn;
	
	private JLabel leftOperandLb;
	private JTextField leftOperandTf;
	private JLabel rightOperandLb;
	private JTextField rightOperandTf;
	
	private JLabel resultLb;
	private JTextField resultTextField;
	
	private class OperatorButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			String op = e.getActionCommand();
			Integer leftOperand = Integer.parseInt(leftOperandTf.getText());
			Integer rightOperand = Integer.parseInt(rightOperandTf.getText());
			
			
			switch(op) {
			case "+": {
				Integer ret = leftOperand + rightOperand;
				resultTextField.setText( ret.toString());
				break;
			}
			case "-": {
				Integer ret = leftOperand - rightOperand;
				resultTextField.setText( ret.toString());
				break;
			}
			case "*": {
				Integer ret = leftOperand * rightOperand;
				resultTextField.setText( ret.toString());
				break;
			}
			case "/": {
				Integer ret = leftOperand / rightOperand;
				resultTextField.setText( ret.toString());
				break;
			}
			}
		}
	}
	
	
	public JSwingCalculator_FlowLayout() {
		super("나의 계산기");
		this.setLayout(new FlowLayout());
		
		this.opSumBtn = new JButton("+");
		this.opSubBtn = new JButton("-");
		this.opMulBtn = new JButton("*");
		this.opDivBtn = new JButton("/");
		
		this.leftOperandLb = new JLabel("숫자1");
		this.leftOperandTf = new JTextField(5);
		this.rightOperandLb = new JLabel("숫자2");
		this.rightOperandTf = new JTextField(5);
		
		this.resultLb = new JLabel("결과");
		this.resultTextField = new JTextField(20);
		
		this.add(leftOperandLb);
		this.add(leftOperandTf);
		this.add(rightOperandLb);
		this.add(rightOperandTf);
		
		this.add(opSumBtn);
		this.add(opSubBtn);
		this.add(opMulBtn);
		this.add(opDivBtn);
		
		this.add(resultLb);
		this.add(resultTextField);
		
		this.setSize(250, 300);
		this.setVisible(true);
		
		opSumBtn.addActionListener(new OperatorButtonActionListener());
		opSubBtn.addActionListener(new OperatorButtonActionListener());
		opMulBtn.addActionListener(new OperatorButtonActionListener());
		opDivBtn.addActionListener(new OperatorButtonActionListener());
	}
	
	public static void main(String[] args) {
		new JSwingCalculator_FlowLayout();
	}
	
}
