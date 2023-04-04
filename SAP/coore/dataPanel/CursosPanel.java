package coore.dataPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;

public class CursosPanel extends JFrame implements ActionListener{
        private JLabel img,l1,l2,l3,l4,l5;
        private JTextField txt1,txt2,txt3,txt4;
        private Choice combobox;
        private JButton btnSave;
        Connection cursoConn;
        public CursosPanel(){
            super();
            setSize(new Dimension(1280,800));
            setExtendedState(JFrame.NORMAL);
            setResizable(false);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            init();
            setBackground(new Color(29,138,186));
            setLayout(null);
            setVisible(true);
            btnSave.addActionListener(this::actionPerformed);
        }

        public void init(){
            img = new JLabel("UP-MAPUTO");
            l1 = new JLabel("Codigo do Curso");
            l2 = new JLabel("Designacao");
            l3 = new JLabel("Regime");
            l4 = new JLabel("Disciplina 1");
            l5 = new JLabel("Disciplina 2");

            txt1 = new JTextField();
            txt2 = new JTextField();
            txt3 = new JTextField();
            txt4 = new JTextField();

            combobox = new Choice();
            combobox.addItem("D");
            combobox.addItem("E");
            combobox.addItem("P");

            btnSave = new JButton("SAVE");

            add(img);
            add(l1);
            add(l2);
            add(l3);
            add(l4);
            add(l5);

            add(txt1);
            add(txt2);
            add(txt3);
            add(txt4);

            add(combobox);

            add(btnSave);

            img.setBounds(546,75,489,94);
            l1.setBounds(546,204,244,22);
            l2.setBounds(546,328,244,22);
            l3.setBounds(546,444,244,22);
            l4.setBounds(496,527,202,22);
            l5.setBounds(593,527,202,22);


            txt1.setBounds(293,234,666,56);
            txt2.setBounds(293,355,666,56);
            txt3.setBounds(293,561,241,49);
            txt4.setBounds(646,561,241,49);

            combobox.setBounds(391,471,385,56);

            btnSave.setBounds(421,648,248,54);
            btnSave.setBorderPainted(false);


        }


    @Override
    public void actionPerformed(ActionEvent e) {
        PreparedStatement query;
        String sql ="INSERT INTO curso (id_cur, designacao, disciplina1, disciplina2, reg) VALUES (?,?,?,?,?);";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cursoConn = DriverManager.getConnection("jdbc:mysql://localhost/sapcea?"+"user=root&password=");


            query = cursoConn.prepareStatement(sql);
            query.setInt(1, Integer.parseInt(txt1.getText()));
            query.setString(2,txt2.getText());
            query.setString(3,txt3.getText());
            query.setString(4,txt4.getText());
            query.setString(5,combobox.getSelectedItem());
            query.executeUpdate();

            JOptionPane.showMessageDialog(null,"Course saved Successfully");
            cursoConn.close();

        }catch(Exception exc){
            JOptionPane.showMessageDialog(null,""+exc.getMessage());
        }

    }
}
