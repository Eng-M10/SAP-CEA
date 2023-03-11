package coore.admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoaderCourseRegister extends JFrame implements ActionListener {
    private JLabel first,second,third,fourth,fifth;
    private JTextField Textfirst,Textsecond,Textthird,Textfourth;
    private JButton btnADD,btnBack,btnSave;
    public LoaderCourseRegister(){
        super("Register Course");
        setSize(949,720);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        Elements_of_Frame();
        setVisible(true);

        btnADD.addActionListener(this::actionPerformed);
        btnBack.addActionListener(this::actionPerformed);
        btnSave.addActionListener(this::actionPerformed);
    }

    private void Elements_of_Frame(){
        first = new JLabel("Course Designation");
        second = new JLabel("Faculty to which it belongs");
        third = new JLabel("Load curriculum proposal");
        fourth = new JLabel("Admission Exam Subject 1");
        fifth = new JLabel("Admission Exam Subject 2");

        //TextFields
        Textfirst = new JTextField();
        Textsecond = new JTextField();
        Textthird = new JTextField();
        Textfourth = new JTextField();

        //Buttons
        btnADD = new JButton("ADD");
        btnBack = new JButton("BACK");
        btnSave = new JButton("SAVE");


        //Position
        first.setBounds(334,21,278,37);
        second.setBounds(334,126,278,37);
        third.setBounds(334,238,278,37);
        fourth.setBounds(138,420,284,37);
        fifth.setBounds(513,420,284,37);

        Textfirst.setBounds(107,51,732,61);
        Textsecond.setBounds(107,163,732,61);
        Textthird.setBounds(77,469,369,61);
        Textfourth.setBounds(491,469,369,61);

        btnADD.setBounds(107,291,732,61);
        btnBack.setBounds(200,605,160,75);
        btnSave.setBounds(583,606,160,75);

        add(first);
        add(second);
        add(third);
        add(fourth);
        add(fifth);

        add(Textfirst);
        add(Textsecond);
        add(Textthird);
        add(Textfourth);

        add(btnADD);
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
            if(e.getSource()==btnADD) addFile();

            else if (e.getSource()==btnBack) dispose();

            else{
            JOptionPane.showMessageDialog(null,"Course Registed Sucessfully","INFO!!",JOptionPane.PLAIN_MESSAGE);
            dispose();}


    }




}
