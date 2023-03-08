package com;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Admin extends JFrame implements ActionListener{
		Jbutton btnLoadData,btnRegisterAnswers,btnRegisterCourses,btnGenerateRanking,btnCheck;
		JLabel Label1,Label2,Label3,Label4,Label5;


		public Admin(){
			super("Administrator - Dashboard");
			setSize(1366,720);
			setResizable(false);
			setLocationRelativeTo(null);
			setLayout(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);


		}


		private initElementsFrame(){

			//initialize buttons
			btnLoadData=new JButton("Load data");
			btnRegisterAnswers = new JButton("Add matrix");
			btnRegisterCourses = new JButton("Add course");
			btnGenerateRanking = new JButton("Generate ranking");
			btnCheck = new JButton("Correct exams");


			//
			

		}



		@Override
		public void actionPerformed(ActionEvent event){

		}
}

public class PlaceholderTextField extends JTextField {

    private String placeholder;

    public PlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
        setUI(new PlaceholderTextFieldUI());
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        repaint();
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (getText().isEmpty() && ! (FocusListener)super.getListeners(FocusListener.class)[0].equals(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                repaint();
            }
        })) {
            int x = getInsets().left;
            int y = g.getFontMetrics().getAscent() + getInsets().top;
            g.drawString(placeholder, x, y);
        }
    }

    private static class PlaceholderTextFieldUI extends BasicTextFieldUI {}
}
