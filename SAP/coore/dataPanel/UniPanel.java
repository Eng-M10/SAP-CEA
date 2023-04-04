package coore.dataPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Objects;

public class UniPanel extends JFrame implements ActionListener {

    private JTextField txtID,Design;
    private JLabel l1,l2,img;
    private JButton btnSave;
    public UniPanel(){
        super();
        setSize(new Dimension(1280,800));
        setExtendedState(JFrame.NORMAL);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        init_Elements();
        setBackground(new Color(17,89,65));
        setLayout(null);
        setVisible(true);
        btnSave.addActionListener(this::actionPerformed);

    }


    private void init_Elements() {
        txtID = new JTextField();
        Design = new JTextField();
        img = new JLabel("UP-Maputo");
        l1 = new JLabel("Codigo da Universidade");
        l2 = new JLabel("Designacao");

        btnSave = new JButton("SAVE");

        img.setBounds(429,60,489,94);
        l1.setBounds(552,203,244,22);
        l2.setBounds(587,321,244,22);

        txtID.setBounds(341,249,666,56);
        Design.setBounds(341,355,666,56);

        btnSave.setBounds(550,464,248,54);


        add(img);
        add(l1);
        add(txtID);
        add(l2);
        add(Design);
        add(btnSave);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Connection con;
        PreparedStatement query;
        String sql = "INSERT INTO universidade (id_uni,dedsignacao) VALUES (?,?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/sapcea?"+"user=root&password=");

            query = con.prepareStatement(sql);
            query.setInt(1,Integer.parseInt(txtID.getText()));
            query.setString(2,Design.getText());

            query.executeUpdate();
            JOptionPane.showMessageDialog(null,"Universidade saved Successfully");
            query.close();
        }
        catch (Exception et){
            JOptionPane.showMessageDialog(null,"UniPanel: "+et.getMessage());
        }
    }
}
