package coore;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class SignUP extends JFrame implements ActionListener {
    JLabel nameLabel,maillabel,passcodelabel;
    JTextField nameTxt,mailTxt,passcodeTxt;
    JButton btnLoad;

    public SignUP(){
        super("Sign-Up");
        setSize(616,735);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        init_();
        setVisible (true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        btnLoad.addActionListener(this::actionPerformed);
    }

    public void init_(){
        nameLabel = new JLabel("Name");
        maillabel  = new JLabel("E-mail");
        passcodelabel  = new JLabel("Password");

        nameTxt = new JTextField(20);
        mailTxt = new JTextField(20);
        passcodeTxt = new JTextField(20);

        btnLoad = new JButton("SAVE");
        //pOS

     /*   nameLabel.setBounds();
        maillabel.setBounds();
        passcodelabel.setBounds();



        nameTxt.setBounds();
        mailTxt.setBounds();
        passcodeTxt.setBounds();

        btnLoad.setBounds();*/


        //adding
        add(nameLabel);
        add(maillabel);
        add(passcodelabel);

        add(nameTxt);
        add(mailTxt);
        add(passcodeTxt);

        add(btnLoad);
    }



    @Override
    public void actionPerformed(ActionEvent ev){
        DBconnection connect = new DBconnection();
        PreparedStatement query = null;
        if(ev.getSource()== btnLoad){
            try{
            Connection connector = connect.conn;
            String sql = "INSERT INTO logindata (name,email,passcode) VALUES (?,?,?)";
            query=connector.prepareStatement(sql);
            query.setString(1,nameTxt.getText());
            query.setString(2,mailTxt.getText());
            query.setString(3,passcodeTxt.getText());

            query.executeUpdate();
            JOptionPane.showMessageDialog(null,"DATA SAVED");

            connector.close();
            } catch(Exception op ){
                System.out.println("Error: "+ op.getMessage());

            }

        }

    }
}





/*
*       import java.sql.*;

public class RetrieveData {
    public static void main(String[] args) {
        try {
            // Conectar à base de dados
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Criar uma instrução SQL
            String sql = "SELECT * FROM mytable";

            // Executar a instrução SQL
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Obter os resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Fechar a conexão
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar à base de dados: " + e.getMessage());
        }
    }
}

*
* */