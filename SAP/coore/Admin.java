package coore;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import coore.admin.*;

public class Admin extends JFrame implements ActionListener{
		
		//declarate elements that form the frame layout
		private JButton btnLoadData,btnRegisterAnswers,btnRegisterCourses,btnGenerateRanking,btnCheck;
		private JLabel downLabel,matLabel,checLabel,courLabel,rankLabel;

		//new javax.swing.ImageIcon("C:\\Users\\Muvi\\Desktop\\F  E  T\\2 ANO\\2nd Semestre\\Lab.Inf -II\\Trabalhos\\Zara-eStore\\ui\\zara_logo.png")importing images
		/*private	ImageIcon downloadImg = new ImageIcon("C:\\Users\\Muvi\\Desktop\\F  E  T\\3 ANO\\1st Semestre\\PAJ\\SAP-CEA\\SAP\\com\\imgAdmin\\books.png");
	private	ImageIcon matrixImg = new ImageIcon("C:\\Users\\Muvi\\Desktop\\F  E  T\\3 ANO\\1st Semestre\\PAJ\\SAP-CEA\\SAP\\com\\imgAdmin\\books.png");
	private	ImageIcon checkImg = new ImageIcon("C:\\Users\\Muvi\\Desktop\\F  E  T\\3 ANO\\1st Semestre\\PAJ\\SAP-CEA\\SAP\\com\\imgAdmin\\books.png");
	private ImageIcon courseImg = new ImageIcon("C:\\Users\\Muvi\\Desktop\\F  E  T\\3 ANO\\1st Semestre\\PAJ\\SAP-CEA\\SAP\\com\\imgAdmin\\books.png");
	private	ImageIcon rankingImg = new ImageIcon("C:\\Users\\Muvi\\Desktop\\F  E  T\\3 ANO\\1st Semestre\\PAJ\\SAP-CEA\\SAP\\com\\imgAdmin\\books.png");
	ImageIcon downloadImg = new ImageIcon("C:\Users/MuviDesktop/'F  E  T'/'3 ANO'/'1st Semestre'/PAJ/SAP-CEA/SAP/com/imgAdmin/download.png");
		ImageIcon matrixImg = new ImageIcon("C:/Users/MuviDesktop/'F  E  T'/'3 ANO'/'1st Semestre'/PAJ/SAP-CEA/SAP/com/imgAdmin/contact-form.png"); 
		ImageIcon checkImg = new ImageIcon("C:/Users/MuviDesktop/'F  E  T'/'3 ANO'/'1st Semestre'/PAJ/SAP-CEA/SAP/com/imgAdmin/checked.png"); 
		ImageIcon courseImg = new ImageIcon("C:/Users/MuviDesktop/'F  E  T'/'3 ANO'/'1st Semestre'/PAJ/SAP-CEA/SAP/com/imgAdmin/books-stack-of-three.png"); 
		ImageIcon rankingImg = new ImageIcon("C:/Users/MuviDesktop/'F  E  T'/'3 ANO'/'1st Semestre'/PAJ/SAP-CEA/SAP/com/imgAdmin/search-engine.png"); */


		public Admin(){
			
			super("Administrator - Dashboard");
			setSize(1280,800);
			setResizable(true);
			setLocationRelativeTo(null);
			setLayout(null);
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

			//atribute images to labels/imagescontainer
			downLabel = new JLabel("CARREGAR DADOS");
			matLabel = new JLabel("Registrar Matriz");
			checLabel = new JLabel("CORRIGIR EXAMES");
			courLabel = new JLabel("REGISTRAR CURSO");
			rankLabel = new JLabel("GERAR RANKING");


			downLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Muvi\\Desktop\\F  E  T\\3 ANO\\1st Semestre\\PAJ\\SAP-CEA\\SAP\\com\\download.png"));
			matLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Muvi\\Desktop\\F  E  T\\3 ANO\\1st Semestre\\PAJ\\SAP-CEA\\SAP\\com\\form.png"));
			checLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Muvi\\Desktop\\F  E  T\\3 ANO\\1st Semestre\\PAJ\\SAP-CEA\\SAP\\com\\checked.png"));
			courLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Muvi\\Desktop\\F  E  T\\3 ANO\\1st Semestre\\PAJ\\SAP-CEA\\SAP\\com\\books.png"));
			rankLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Muvi\\Desktop\\F  E  T\\3 ANO\\1st Semestre\\PAJ\\SAP-CEA\\SAP\\com\\engine.png"));
			

			//position firstly the labels

			downLabel.setBounds(49,73,197,200);
			matLabel.setBounds(511,73,197,200);
			checLabel.setBounds(942,73,197,200);
			courLabel.setBounds(49,411,197,200);
			rankLabel.setBounds(511,411,197,200);

			//position finaly the buttons


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
				new LoaderData();

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

/*public class PlaceholderTextField extends JTextField {

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

    private static class PlaceholderTextFieldUI extends BasicTextFieldUI {

    }
}
*/