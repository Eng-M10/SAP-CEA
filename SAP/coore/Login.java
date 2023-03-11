package coore;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics.*;


public class Login extends JFrame implements ActionListener{
	private JLabel l1,l2,l3,msg1,msg2;
	private JTextField userName;
	private JPasswordField userPassword;
	private JButton btnAccess;
	public Login(){
			super("SAP-CEA | Login");
			setSize(616,735);
			setResizable(false);
			setLayout(null);
			setLocationRelativeTo(null);
			initFrameElements();
			setVisible (true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			btnAccess.addActionListener(this::actionPerformed);
	}
	protected void paintComponent(Graphics g){
		super.paintComponents(g);
		g.drawRect(0,610,744,0);
	}

	//method for init elements and set your position into the frame
	private void initFrameElements(){
		//Labels
		l1 = new JLabel(new javax.swing.ImageIcon(getClass().getResource("logo.png")));
		l2 = new JLabel("USERNAME");
		l3 = new JLabel("PASSWORD");
		msg1 = new JLabel("Sistema de Apuramento - Comissão de exames ");
		msg2 = new JLabel("@CiUp - 2023");

		//Fields

		userName = new JTextField();
		userPassword = new JPasswordField();

		//button
		btnAccess = new JButton("ENTER");
		//setColors
		userName.setBackground(new Color(62,174,237));
		userPassword.setBackground(new Color(62,174,237));
		repaint();
		btnAccess.setBackground(Color.BLACK);
		// set position for each element
		l1.setBounds(27,53,539,101);
		l2.setBounds(258,185,246,24);
		l3.setBounds(258,328,280,32);
		msg1.setBounds(153,623,664,37);
		msg2.setBounds(258,650,431,36);



		userName.setBounds(30,240,555,65);
		userPassword.setBounds(30,383,555,65);
		btnAccess.setBounds(148,487,296,84);

		add(l1);
		add(l2);
		add(l3);
		add(userName);
		add(userPassword);
		add(btnAccess);
		add(msg1);
		add(msg2);
	}

	//Validation
	private boolean verify(){
		final String user ="admin";
		final String pass ="admin";
		String frameUser = userName.getText();
		String framePass = String.valueOf(userPassword.getPassword());

		if((user.equals(frameUser))&&(pass.equals(framePass))) return true ; else return false;
			} 

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnAccess){
			
			if(verify()){
					dispose();
					new Admin();
			}
			else{
				  JOptionPane.showMessageDialog(null,"Wrong Password. try Again!","Alert",JOptionPane.WARNING_MESSAGE);
			}

		}
	}
}