package coore;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import coore.admin.*;
import coore.dataPanel.*;

public class Admin extends JFrame implements ActionListener{
		
		//declarate elements that form the frame layout
		private JButton btnLoadData,btnRegisterAnswers,btnRegisterCourses,btnGenerateRanking,btnCheck;
		private JLabel downLabel,matLabel,checLabel,courLabel,rankLabel;



		public Admin(){
			
			super("Administrator - Dashboard");
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setResizable(true);
			setLocationRelativeTo(null);
			setLayout(null);
			getContentPane().setBackground(new Color(10,115,152));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			initElementsFrame();
			setVisible(true);

			btnLoadData.addActionListener(this::actionPerformed);
			btnRegisterAnswers.addActionListener(this::actionPerformed);
			btnCheck.addActionListener(this::actionPerformed);
			btnRegisterCourses.addActionListener(this::actionPerformed);
			btnGenerateRanking.addActionListener(this::actionPerformed);


		}


		private void initElementsFrame(){



			//initialize buttons
			btnLoadData=new JButton("Load data");
			btnRegisterAnswers = new JButton("Add matrix");
			btnRegisterCourses = new JButton("Add course");
			btnGenerateRanking = new JButton("Generate ranking");
			btnCheck = new JButton("Correct exams");



			ImageIcon downloadImg = new ImageIcon(getClass().getResource("download.png"));
			ImageIcon matrixImg = new ImageIcon(getClass().getResource("form.png"));
			ImageIcon checkImg = new ImageIcon(getClass().getResource("checked.png"));
			ImageIcon courseImg = new ImageIcon(getClass().getResource("books.png"));
			ImageIcon rankingImg = new ImageIcon(getClass().getResource("engine.png"));


			//Atribute images to labels/imagescontainer
			downLabel = new JLabel(downloadImg);
			matLabel = new JLabel(matrixImg);
			checLabel = new JLabel(checkImg);
			courLabel = new JLabel(courseImg);
			rankLabel = new JLabel(rankingImg);

			//position firstly the labels

			downLabel.setBounds(49,73,197,200);
			matLabel.setBounds(511,73,197,200);
			checLabel.setBounds(942,73,197,200);
			courLabel.setBounds(49,411,197,200);
			rankLabel.setBounds(511,411,197,200);

			//position finally the buttons


			btnLoadData.setBounds(32,294,282,66);
			btnRegisterAnswers.setBounds(437,294,282,66);
			btnCheck.setBounds(912,294,282,66);
			btnRegisterCourses.setBounds(32,618,282,66);
			btnGenerateRanking.setBounds(437,618,282,66);

			//adding into the frame

			add(downLabel);
			add(matLabel);
			add(checLabel);
			add(courLabel);
			add(rankLabel);

			add(btnLoadData);
			add(btnRegisterAnswers);
			add(btnCheck);
			add(btnRegisterCourses);
			add(btnGenerateRanking);



		}



		@Override
		public void actionPerformed(ActionEvent event){

			if(event.getSource()==btnLoadData){
				new UserAdmin();

			}
			else if(event.getSource()==btnRegisterAnswers){
				new LoaderMatrix();

			}
			else if(event.getSource()==btnCheck){
				new LoaderCorrect();


			}
			else if(event.getSource()==btnRegisterCourses){
				new LoaderCourseRegister();

			}
			else{
				new LoaderRanking();
			}



		}
}
