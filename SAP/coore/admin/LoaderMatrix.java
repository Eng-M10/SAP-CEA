package coore.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class LoaderMatrix extends JFrame implements ActionListener{
        private JLabel filesubject,Year;
        private JTextField subjectField,subjectYearField;
        private JButton btnBack,btnSave,btnADD;

        public LoaderMatrix(){
            super("Register Matrix");
            setSize(949,720);
            setResizable(false);
            setLocationRelativeTo(null);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            init();
            setVisible(true);
        }

        protected void init(){
            filesubject = new JLabel("Subject");
            Year = new JLabel("Year");
            subjectYearField = new JTextField();
            subjectField = new JTextField();
            btnBack = new JButton("BACK");
            btnSave = new JButton("SAVE");
            btnADD = new JButton("Load File");
            filesubject.setBounds(25,64,166,30);
            Year.setBounds(25,157,108,37);
            subjectYearField.setBounds(222,157,557,20);
            subjectField.setBounds(222,64,560,20);
            btnBack.setBounds(64,627,300,25);
            btnSave.setBounds(587,627,300,25);


            add(filesubject);
            add(Year);
            add(subjectYearField);
            add(subjectField);
            add(btnBack);
            add(btnSave);
        }
    private void addFile(){
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
        }
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBack){
            dispose();
        }
        else if(e.getSource()==btnSave){
            JOptionPane.showMessageDialog(null,"Matrix Loaded Sucessfully","INFO!!",JOptionPane.PLAIN_MESSAGE);
            dispose();
        }
        else if(e.getSource()==btnADD){
            addFile();
        }
    }
}
