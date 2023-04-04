package coore.dataPanel;

import org.apache.poi.ss.usermodel.*;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;


public class Carregar extends JFrame implements ActionListener {
  private JButton btnenterDb,btnLoaerXls;
  private JFileChooser fileXls;
  private JLabel lablechoose;
  private String path = null;
  private JTable table;
  private JPanel tablePane,elePane;

    public Carregar() {
        super("Loading data");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initJFrame_Elements();
        setVisible(true);
        btnLoaerXls.addActionListener(this::actionPerformed);
    }

    private void initJFrame_Elements(){
        btnenterDb = new JButton("Save");
        btnLoaerXls = new JButton("Load");


        fileXls = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int r =fileXls.showDialog(null,"Save");
        if(r== JFileChooser.APPROVE_OPTION) path = fileXls.getSelectedFile().getAbsolutePath();

        lablechoose = new JLabel("Carregar Arquivo");

        tablePane = new JPanel();
        add(tablePane,BorderLayout.SOUTH);

        elePane =  new JPanel();
        add(elePane,BorderLayout.NORTH);

        //Adding to JPanel the atomic elements

        elePane.setLayout(new FlowLayout());
        elePane.add(lablechoose);
        elePane.add(fileXls);
        elePane.add(btnenterDb);
        elePane.add(btnLoaerXls);

        //Adding "table to Panel"


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(btnLoaerXls==e.getSource()){
            try {
                File ficheiro = new File(path);
                FileInputStream FileS =new FileInputStream(ficheiro);

                Workbook livro = WorkbookFactory.create(FileS);
                Sheet folha = livro.getSheetAt(0);
                DefaultTableModel modelo = new DefaultTableModel();

                modelo.addColumn("Nomes");
                modelo.addColumn("Apelido");
                modelo.addColumn("ID Provincia");
                modelo.addColumn("ID Universidade");
                modelo.addColumn("ID Curso");
                modelo.addColumn("iD Candidato");

                Iterator<Row>  linhaIterator = folha.iterator();

                while (linhaIterator.hasNext()){
                    Row linha = linhaIterator.next();
                    Object [] DadosReg = new Object[folha.getRow(0).getLastCellNum()];
                    for (int i=0;i<folha.getRow(0).getLastCellNum();i++){
                        Cell celula = linha.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                        switch (celula.getCellType()){

                            case STRING :
                                DadosReg [i] = celula.getStringCellValue();
                                break;
                            case NUMERIC:
                                DadosReg [i] = celula.getNumericCellValue();
                                break;
                            case BOOLEAN:
                                DadosReg [i] = celula.getBooleanCellValue();
                                break;
                            case FORMULA:
                                DadosReg [i] = celula.getCellFormula();
                                break;
                            default:
                                DadosReg [i] = "";
                        }

                    }
                    modelo.addRow(DadosReg);
                }
                table = new JTable(modelo);

                int i =0;
                while (i<modelo.getColumnCount()) {
                    table.getColumnModel().getColumn(i).setPreferredWidth(500);
                    i++;
                }
             JScrollPane scrool = new JScrollPane(table);
                //tablePane.add(table);
                tablePane.add(scrool);
                livro.close();
                FileS.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
