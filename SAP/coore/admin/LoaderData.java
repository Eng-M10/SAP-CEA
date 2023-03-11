package coore.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoaderData extends JFrame implements ActionListener{
    private JLabel timou,msg;
    private JButton btnback;
    public LoaderData(){
        super("Loader Data");
        setSize(949,720);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        tempElements();
        setVisible(true);
        btnback.addActionListener(this::actionPerformed);
    }
            private void tempElements(){
                timou = new JLabel("TIME OUT");
                msg = new JLabel("Database connection failed!");
                btnback = new JButton("Back");

                //config strings

                timou.setFont(new Font("Arial", Font.PLAIN, 96));
                msg.setFont(new Font("Arial", Font.PLAIN, 20));

                //setBounds
                timou.setBounds(243,221,566,148);
                msg.setBounds(335,391,373,54);
                btnback.setBounds(331,509,300,63);

                //adding
                add(timou);
                add(msg);
                add(btnback);
            }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnback){
            dispose();
        }
    }
}
