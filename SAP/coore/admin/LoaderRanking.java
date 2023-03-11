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
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        startingElements();
        setVisible(true);


        btnTRY.addActionListener(this::actionPerformed);
    }

    private void startingElements(){

        btnTRY=new JButton("Try Later");
        something=new JLabel(" =( OPS!!! Something went wrong");


        something.setFont(new Font("Aria",Font.BOLD,28));
        something.setBounds(259,360,445,49);
        something.setVisible(false);

        add(btnTRY);
        add(something);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnGen){

        }
        else{
            dispose();
        }
    }
}
