package coore.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoaderRanking extends JFrame implements ActionListener {
    private JButton btnGen,btnTRY;
    private JLabel something;
    public LoaderRanking(){
        super("Generate Ranking");
        setSize(949,720);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startingElements();
        setVisible(true);
        btnGen.addActionListener(this::actionPerformed);
        btnTRY.addActionListener(this::actionPerformed);
    }

    private void startingElements(){
        btnGen=new JButton("Generate Table Ranking");
        btnTRY=new JButton("Try Later");

        something=new JLabel(" =( OPS!!! Something went wrong");
        something.setFont(new Font("Aria",Font.BOLD,28));
        something.setBounds(259,360,445,49);
        btnTRY.setVisible(false);
        something.setVisible(false);
        btnGen.setBounds(108,202,732,61);
        add(btnGen);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnGen){
            btnGen.setVisible(false);
            add(something);
            add(btnTRY);


        }
        else{
            dispose();
        }
    }
}
