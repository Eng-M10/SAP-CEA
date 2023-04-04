package coore;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IUfirst extends JFrame implements ActionListener {
   private  JButton btnAccessData, btnGetAdmin;

    public IUfirst(){
        super("SteP");
        setSize(600,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        btnAccessData = new JButton(" User Data");
        btnGetAdmin = new JButton("Go Admin ");
        btnGetAdmin.setBorderPainted(false);
        btnAccessData.setBorderPainted(false);
        add(btnAccessData);
        add(btnGetAdmin);
        btnAccessData.addActionListener(this::actionPerformed);
        btnGetAdmin.addActionListener(this::actionPerformed);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event){

        if(event.getSource() == btnGetAdmin){

                    new Admin();
                }

        else if(event.getSource() == btnAccessData){
                    new ListData();
        }

    }

}
