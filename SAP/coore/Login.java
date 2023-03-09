package coore;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener{
	private JLabel l1,l2,l3;
	private JTextField userName;
	private JPasswordField userPassword;
	private JButton btnAccess;
	public Login(){
			super("Home | Login");
			setSize(400,400);
			setResizable(false);
			setLayout(null);
			setLocationRelativeTo(null);
			initFrameElements();
			setVisible (true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			btnAccess.addActionListener(this::actionPerformed);
	}

	//method for init elements and set your position into the frame
	private void initFrameElements(){
		//Labels
		l1 = new JLabel("SAP-CEA");
		l2 = new JLabel("User");
		l3 = new JLabel("Password");

		//Fields

		userName = new JTextField();

		userPassword = new JPasswordField();

		//button		

		btnAccess = new JButton("Access");


		// set position for each element
		l2.setBounds(2,50,100,10);
		l3.setBounds(2,80,100,10);

		userName.setBounds(115,50,200,20);
		userPassword.setBounds(115,80,200,20);
		btnAccess.setBounds(150,150,100,20);


		add(l1);
		add(l2);
		add(l3);
		add(userName);
		add(userPassword);
		add(btnAccess);
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