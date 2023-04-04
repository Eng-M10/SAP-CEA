package coore;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import coore.dataPanel.*;

public class UserAdmin extends JFrame implements ActionListener {
    JPanel sidebar;
    JButton btnCurso,btnProvincia,btnRegime,btnUniversidade,btnCarregar;
    JButton btnViewCurso,btnViewProvincia,btnViewUniversidade,btnViewRegime;

        public UserAdmin(){
            super("Data for Table");
            setExtendedState(JFrame.MAXIMIZED_BOTH);
             init();

            setLocationRelativeTo(null);

            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setLayout(null);
            setVisible(true);
            btnCurso.addActionListener(this::actionPerformed);
            btnProvincia.addActionListener(this::actionPerformed);
            btnUniversidade.addActionListener(this::actionPerformed);
            btnCarregar.addActionListener(this::actionPerformed);

            btnViewRegime.addActionListener(this::actionPerformed);
            btnViewCurso.addActionListener(this::actionPerformed);
            btnViewProvincia.addActionListener(this::actionPerformed);
            btnViewUniversidade.addActionListener(this::actionPerformed);

        }

        public void init(){
            btnCurso= new JButton("Cursos");
            btnProvincia = new JButton("Provincias");
            btnRegime = new JButton("Regime");
            btnUniversidade = new JButton("Universidades");
            btnCarregar = new JButton("Carregar");

            btnViewCurso = new JButton("Mostrar Cursos");
            btnViewProvincia = new JButton("Mostrar Provincias");
            btnViewRegime = new JButton("Mostrar Regimes");
            btnViewUniversidade = new JButton("Mostrar Universidade");

            btnCurso.setBounds(0,236,209,51);
            btnRegime.setBounds(0,360,209,51);
            btnProvincia.setBounds(0,501,209,51);
            btnUniversidade.setBounds(0,634,209,51);
            btnCarregar.setBounds(580,236,209,51);


            btnViewCurso.setBounds(300,236,209,51);
            btnViewRegime.setBounds(300,360,209,51);
            btnViewProvincia.setBounds(300,501,209,51);
            btnViewUniversidade.setBounds(300,634,209,51);


            add(btnCurso);
            add(btnRegime);
            add(btnProvincia);
            add(btnUniversidade);
            add(btnCarregar);
            add(btnViewProvincia);
            add(btnViewRegime);
            add(btnViewCurso);
            add(btnViewUniversidade);
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnCurso){
                new CursosPanel();


        }

        if (e.getSource()==btnProvincia){
           new ProvPanel();

        }

        if(e.getSource()==btnUniversidade){
            new UniPanel();
        }

        if(e.getSource()==btnCarregar){
            new Carregar();
        }

        if(e.getSource()==btnViewCurso){
            new ListCur();
        }
        if(e.getSource()==btnViewProvincia){
            new ListPro();
        }
        if(e.getSource()==btnViewRegime){
            new ListReg();
        }
        if(e.getSource()==btnViewUniversidade){
            new ListUni();
        }
    }
}
