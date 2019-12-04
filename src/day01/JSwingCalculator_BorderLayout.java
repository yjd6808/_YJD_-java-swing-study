package day01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JSwingCalculator_BorderLayout extends JFrame{

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
	
	//JFrame 기본 레이아웃 : BorderLayout
	//JPanel 기본 레이아웃 : FlowLayout
	
	public JSwingCalculator_BorderLayout() {
		super("BorderLayoutTest");
		
		this.setLayout(new BorderLayout());
		
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
		
		JPanel topPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel bottomLayout = new JPanel();
		
		
		topPanel.add(leftOperandLb);
		topPanel.add(leftOperandTf);
		topPanel.add(rightOperandLb);
		topPanel.add(rightOperandTf);
		
		centerPanel.add(opSumBtn);
		centerPanel.add(opSubBtn);
		centerPanel.add(opMulBtn);
		centerPanel.add(opDivBtn);
		
		bottomLayout.add(resultLb);
		bottomLayout.add(resultTextField);
		
		this.add(BorderLayout.NORTH, topPanel);
		this.add(BorderLayout.CENTER, centerPanel);
		this.add(BorderLayout.SOUTH, bottomLayout);
		
		this.setSize(300, 150);
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		new JSwingCalculator_BorderLayout();
	}

}
