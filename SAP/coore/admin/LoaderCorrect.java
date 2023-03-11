package coore.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoaderCorrect extends JFrame implements ActionListener {
        private JLabel textMsg;
        private JButton btnReturn;
        public LoaderCorrect(){
                super("Check - To Correct");
                setSize(949,720);
                setResizable(true);
                setLocationRelativeTo(null);
                setLayout(null);
                setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

                textMsg = new JLabel("Without data to Process");
                btnReturn = new JButton("Return Menu");




                textMsg.setFont(new Font("Arial",Font.PLAIN,24));
                textMsg.setBounds(243,221,800,148);
                btnReturn.setBounds(331,509,300,63);

                add(textMsg);
                add(btnReturn);

                setVisible(true);
                btnReturn.addActionListener(this::actionPerformed);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if (e.getSource()==btnReturn){
                        dispose();
                }
        }
}
