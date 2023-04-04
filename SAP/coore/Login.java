package coore;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	private JLabel l1,l2,l3,msg2;
	private JTextField userName;
	private JPasswordField userPassword;
	private JButton btnAccess,btnSignup;
	public boolean n = false;
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
			btnSignup.addActionListener(this::actionPerformed);
	}

	//method for init elements and set your position into the frame
	private void initFrameElements(){
		//Labels
		l1 = new JLabel(new javax.swing.ImageIcon(getClass().getResource("logo.png")));
		l2 = new JLabel("USERNAME");
		l3 = new JLabel("PASSWORD");
        JLabel msg1 = new JLabel("Sistema de Apuramento - Comissão de exames ");
		msg2 = new JLabel("@CiUp - 2023");

		//Fields

		userName = new JTextField();
		userPassword = new JPasswordField();

		//button
		btnAccess = new JButton("ENTER");
		btnSignup = new JButton("Create new user");
		//setColors
		userName.setBackground(new Color(62,174,237));
		userPassword.setBackground(new Color(62,174,237));

		btnAccess.setBackground(Color.BLACK);
		btnSignup.setBackground(new Color(12,21,33));
		// set position for each element
		l1.setBounds(27,53,539,101);
		l2.setBounds(258,185,246,24);
		l3.setBounds(258,328,280,32);
		msg1.setBounds(153,623,664,37);
		msg2.setBounds(258,650,431,36);



		userName.setBounds(30,240,555,65);
		userPassword.setBounds(30,383,555,65);
		btnAccess.setBounds(148,487,296,84);
		btnSignup.setBounds(148,580,296,20);

		add(l1);
		add(l2);
		add(l3);
		add(userName);
		add(userPassword);
		add(btnAccess);
		add(btnSignup);
		add(msg1);
		add(msg2);
	}

	//Validation
			private boolean login(){
			DBconnection dbconn = new DBconnection();
			Connection dbcon = dbconn.conn;
			PreparedStatement stm;
			ResultSet Res = null;

			String sql = "SELECT * FROM logindata WHERE name=? and passcode=?";
			String pss = new String(userPassword.getPassword());
			boolean resu = true;

			try{

				stm = dbcon.prepareStatement(sql);
				stm.setString(1,userName.getText());
				stm.setString(2,pss);

				Res = stm.executeQuery();

				if(Res.next()){

					resu = true;

					if (userName.getText().equals("admin")&& pss.equals("admin")) n = true;

				}
					else{
					resu=false;
					}

			}
			catch (Exception exxc){
				JOptionPane.showMessageDialog(null,"Login :"+exxc.getMessage());
			}
		return resu;
			}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnAccess){
			
			if(login()){

				if(n){
							dispose();
							new IUfirst();
						}
				else{
					dispose();
					new Admin();
				}

			}
			else{
				  JOptionPane.showMessageDialog(null,"Wrong Password. try Again!","Alert",JOptionPane.WARNING_MESSAGE);
			}

		}

		if(e.getSource()==btnSignup){
			new SignUP();
		}
	}


}

