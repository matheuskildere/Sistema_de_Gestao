package TrabalhoII.Graphic_Interface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TrabalhoII.Class.Address;
import TrabalhoII.Class.Client;
import TrabalhoII.Class.Person;

public class Client_Management {

    protected static Color colorGrayButton = new Color(127, 175, 231);
    protected static JButton button_Register;
    protected static JButton button_Consult;
    protected static JButton buttonNext;
    protected static JButton buttonSave;
    protected static JButton buttonSearch;
    protected static JButton buttonEdit;
    protected static JButton buttonRemove;
    protected static int implementLabel;
    protected static int implementTxt;
    protected JPanel panel;
    
    protected static JLabel label_Nome;
    protected static JLabel label_Cpf;
    protected static JLabel label_Rg;
    protected static JLabel label_Logradouro;
    protected static JLabel label_Numero;
    protected static JLabel label_Complemento ;
    protected static JLabel label_Bairro;
    protected static JLabel label_Cep ;
    protected static JLabel label_Cidade;
    protected static JLabel label_Estado;
    protected static JLabel label_Celular;
    protected static JLabel label_Telefone;
    protected static JLabel label_Email;
    protected static JLabel label_Consulta;
    protected static JLabel label_RequiredField;

    protected static JTextField txt_Nome = new JTextField();
    protected static JTextField txt_Cpf = new JTextField();
    protected static JTextField txt_Rg = new JTextField();
    protected static JTextField txt_Logradouro = new JTextField();
    protected static JTextField txt_Numero = new JTextField();
    protected static JTextField txt_Complemento = new JTextField();
    protected static JTextField txt_Bairro = new JTextField();
    protected static JTextField txt_Cep = new JTextField();
    protected static JTextField txt_Cidade = new JTextField();
    protected static JTextField txt_Estado = new JTextField();
    protected static JTextField txt_Celular = new JTextField();
    protected static JTextField txt_Telefone = new JTextField();
    protected static JTextField txt_Email = new JTextField();
    protected static JTextField txt_Consulta = new JTextField();
    protected static JTable table_Info;
    protected static JScrollPane scroll;
    protected static JTable table_InfoAdress;
    protected static JScrollPane scrollAdress;

    protected static Client listClients = new Client();
    
    private static Person client;
    private static Address address;

    public void Menu_Gerenciamento(JPanel panel) {
        this.panel = panel;
        panel.removeAll();
        buttons();
        panel.add(button_Register);
        panel.add(button_Consult);
        panel.repaint();
    }

    /**
     * this method adds a warning message to the panel
     * @param panel
     */
    protected void label_RequiredField(JPanel panel){
        label_RequiredField = new JLabel("'*' Campos Obrigatorios");
        label_RequiredField.setBounds(10, 600, 300, 29);
        label_RequiredField.setFont(new Font("Berbas Neue", Font.ITALIC, 20));
        label_RequiredField.setForeground(Color.RED);
        panel.add(label_RequiredField);
    }

    /**
     * this method get all textfild's text, and creat a new person
     * @return a instance of Person
     */
    protected Person creatPerson() {
        
        String email = txt_Email.getText();
        long cpf = Long.parseLong(txt_Cpf.getText());
        String nome = txt_Nome.getText();
        String log = txt_Logradouro.getText();

        String bai = txt_Bairro.getText();
        long num = Long.parseLong(txt_Numero.getText());
        String cit = txt_Cidade.getText();
        String sta = txt_Estado.getText();
        String com = txt_Complemento.getText();
        try {
            long cep = Long.parseLong(txt_Cep.getText());
            address = new Address(log, com, num, bai, cit, sta, cep);
        } catch (Exception e) {
            address = new Address(log, num, bai, cit, sta);
        }
        try {
            long rg = Long.parseLong(txt_Rg.getText());
            long telefone = Long.parseLong(txt_Telefone.getText());
            long celular = Long.parseLong(txt_Celular.getText());
            client = new Person(nome, cpf, rg, telefone, celular,email , address);
        } catch (Exception e) {
            client = new Person(nome, cpf, address);
        }
        

        return client;
    }

    /**
     * This method configures the fist panel of register
     */
    protected  void painelCLientOne(){
        implementTxt = 0;
        implementLabel = 0;
        labelsStepOne(panel);
        txtStepOne(panel);
        label_RequiredField(panel);
        buttonNext();
        panel.repaint();
      }

      /**
     * This method configures the second panel of register
     * @param JPanel panel
     */
    protected void painelClientTwo(JPanel panel){
        implementTxt = -20;
        implementLabel = -20;

        Menu_Gerenciamento(panel);
        labelsStepTwo(panel);
        txtStepTwo(panel);
        label_RequiredField(panel);
        panel.repaint();
    }

    /**
     * The method creat two tables with client's informations
     */
    protected void seeInfo(){
        Object[] data= listClients.getInfo(Long.parseLong(txt_Consulta.getText()));
        if (data == null) {
            throw new IllegalArgumentException("CLIENTE N√ÉO ENCONTRADO");
        }
        String[] nomeCo = new String[]{
            "Nome", "Cpf", "Rg", "Celular", "Telefone", "Email", 
        };
        String[] nomeCol = new String[]{
            "Logradouro", "Numero", "Bairro", "Complemento", "Cep", "Cidade", "Estado"
        };
        
        table_Info = new JTable((Object[][]) data[0], nomeCo);
        table_Info.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_Info.setFont(new Font("Berbas Neue",Font.BOLD,15));
        table_Info.setRowHeight(0, 25);
        table_Info.setShowHorizontalLines(true);
        scroll = new JScrollPane(table_Info);
        scroll.setBounds(50, 290,700, 45);

        table_InfoAdress = new JTable((Object[][]) data[1], nomeCol);
        table_InfoAdress.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_InfoAdress.setRowHeight(0, 25);
        table_InfoAdress.setFont(new Font("Berbas Neue",Font.BOLD,15));
        scrollAdress = new JScrollPane(table_InfoAdress);
        scrollAdress.setBounds(50, 360,700, 45);

        editAndRemove();
        panel.add(scroll);
        panel.add(scrollAdress);
        panel.repaint();
        
    }
    /**
     * This method configures the panel of consult
     * @param panel
     */
    protected void consulta(JPanel panel){
        buttonSearch();
        txt_Consulta = new JTextField();
        txt_Consulta.setBounds(150, 200, 400, 40);
        txt_Consulta.setFont(new Font("Berbas Neue", Font.BOLD, 20));

        label_Consulta = new JLabel("Cpf:");
        label_Consulta.setBounds(10, 200, 210, 29);
        label_Consulta.setFont(new Font("Berbas Neue", Font.BOLD, 29));

        panel.add(buttonSearch);
        panel.add(txt_Consulta);
        panel.add(label_Consulta);
        panel.repaint();
    }
    
    /**
     * This method configures the button next
     */
    protected void buttonNext(){
        buttonNext = new JButton("Next");
        buttonNext.setBounds(510 ,200 + implementLabel, 200, 60);
        buttonNext.setFont(new Font("Berbas Neue",Font.BOLD,29));
        buttonNext.setFocusPainted(false);
        buttonNext.setBorderPainted(false);
        buttonNext.setBackground(colorGrayButton);
        buttonNext.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                panel.removeAll();
                painelClientTwo(panel);
                button_Register.setEnabled(false);
                ButtonSave();
            } 
        });
        panel.add(buttonNext);
    }

    /**
     * this method configures the search button
     */
    protected void buttonSearch(){
        buttonSearch = new JButton("Consultar");
        buttonSearch.setBounds(560, 200, 180, 40);
        buttonSearch.setFont(new Font("Berbas Neue",Font.BOLD,29));
        buttonSearch.setFocusPainted(false);
        buttonSearch.setBorderPainted(false);
        buttonSearch.setBackground(colorGrayButton);
        buttonSearch.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                try {
                    seeInfo();
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null,"N„o encontramos um cliente com o CPF digitado.\nPor favor tente novamente com um CPF valido!", e.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            } 
        });
    }
    
    /**
     * this method configures the buttons(register and Consult).
     */
    public void buttons(){
        int btX = 181;
        int btY = 36;
        int btDimX = 200;
        int btDimY = 60;       
        button_Register = new JButton("Cadastro");
        button_Consult = new JButton("Consulta");

        button_Consult.setBounds(btX, btY, btDimX, btDimY);
        button_Consult.setFont(new Font("Berbas Neue",Font.BOLD,29));
        button_Consult.setFocusPainted(false);
        button_Consult.setBorderPainted(false);
        button_Consult.setBackground(colorGrayButton);
        button_Consult.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                Menu_Gerenciamento(panel);
                consulta(panel);
                button_Consult.setEnabled(false);
            } 
        });

        button_Register.setBounds(btX * 2 + 43, btY, btDimX, btDimY);
        button_Register.setFont(new Font("Berbas Neue",Font.BOLD,29));
        button_Register.setFocusPainted(false);
        button_Register.setBorderPainted(false);
        button_Register.setBackground(colorGrayButton);
        button_Register.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                Menu_Gerenciamento(panel);
                painelCLientOne();
                button_Register.setEnabled(false);        
            } 
        });
    }
    
    /**
     * This method configures the buttons edit and remove
     */
    protected void editAndRemove(){
        buttonEdit = new JButton("Editar");
        buttonRemove = new JButton("Remover");
    
        buttonEdit.setBounds(181, 450, 200, 40);
        buttonEdit.setFont(new Font("Berbas Neue",Font.BOLD,29));
        buttonEdit.setFocusPainted(false);
        buttonEdit.setBorderPainted(false);
        buttonEdit.setBackground(colorGrayButton);
        buttonEdit.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                try {
                    getData(Long.parseLong(txt_Consulta.getText()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Houve algum erro inesperado, tente novamente", "ERRO DO SISTEMA", JOptionPane.ERROR_MESSAGE);
                }
            } 
        });

        buttonRemove.setBounds(181 * 2 + 43, 450, 200, 40);
        buttonRemove.setFont(new Font("Berbas Neue",Font.BOLD,29));
        buttonRemove.setFocusPainted(false);
        buttonRemove.setBorderPainted(false);
        buttonRemove.setBackground(colorGrayButton);
        buttonRemove.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                try {
                    listClients.remove(Long.parseLong(txt_Consulta.getText()));
                    JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
                    Menu_Gerenciamento(panel);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Houve algum erro inesperado, tente novamente", "ERRO DO SISTEMA", JOptionPane.ERROR_MESSAGE);
                }
            } 
        });

        panel.add(buttonEdit);
        panel.add(buttonRemove);
    }

    
    /**
     * This method configures the button next and
     * define your actions
     */
    protected void ButtonSave(){
        buttonSave = new JButton("Salvar");
        buttonSave.setBounds(510 ,200 +implementLabel, 200, 60);
        buttonSave.setFont(new Font("Berbas Neue",Font.BOLD,29));
        buttonSave.setFocusPainted(false);
        buttonSave.setBorderPainted(false);
        buttonSave.setBackground(colorGrayButton);
        buttonSave.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                long cpf = Long.parseLong(txt_Cpf.getText());
                if (listClients.get(cpf) != null) {
                    listClients.set(cpf, creatPerson());
                }else{
                    System.out.println("3");
                    listClients.add(creatPerson());
                    System.out.println("4");
                }
                Menu_Gerenciamento(panel);
                clearData();
            } 
        });
        panel.add(buttonSave);
    }


    /**
     * Method of settings of labels
     * @param label
     * @param name
     * @param panel
     */
    protected void settingsLabels(JLabel label, String name,JPanel panel){ // string
        label = new JLabel(name);
        label.setBounds(10, 200 + implementLabel, 210, 29);
        label.setFont(new Font("Berbas Neue", Font.BOLD, 29));
        panel.add(label);
        implementLabel += 50;
    }

    
    /**
     * This method configures all labels of the fist panel
     */
    protected void labelsStepOne(JPanel panel){
        settingsLabels(label_Nome, "Nome:*", panel);
        settingsLabels(label_Cpf, "Cpf:*", panel);
        settingsLabels(label_Rg, "Rg:", panel);
        settingsLabels(label_Telefone, "Telefone:", panel);
        settingsLabels(label_Celular, "Celular:", panel);
        settingsLabels(label_Email, "E-mail:", panel);
    }

    /**
     * This method configures all labels of the second panel
     */
    protected void labelsStepTwo(JPanel panel){
        settingsLabels(label_Logradouro, "Logradouro:*", panel);
        settingsLabels(label_Numero, "Numero:*", panel);
        settingsLabels(label_Complemento, "Complemento:", panel);
        settingsLabels(label_Bairro, "Bairro:*", panel);
        settingsLabels(label_Cep, "Cep:", panel);
        settingsLabels(label_Cidade, "Cidade:*", panel);
        settingsLabels(label_Estado, "Estado:*", panel);
    }

    /**
     * This method configures all txtfields of the fist panel
     */
    protected void txtStepOne(JPanel panel){
        settingsTxt(txt_Nome, panel);
        settingsTxt(txt_Cpf, panel);
        settingsTxt(txt_Rg, panel);
        settingsTxt(txt_Celular, panel);
        settingsTxt(txt_Telefone, panel);
        settingsTxt(txt_Email, panel);
    }

    /**
     * This method configures all labels of the second panel
     */
    protected void txtStepTwo(JPanel panel){
        settingsTxt(txt_Logradouro, panel);
        settingsTxt(txt_Numero, panel);
        settingsTxt(txt_Complemento, panel);
        settingsTxt(txt_Bairro, panel);
        settingsTxt(txt_Cep, panel);
        settingsTxt(txt_Cidade, panel);
        settingsTxt(txt_Estado, panel);
    }


    /**
     * This method get all dice of client and adds on the JTextfields 
     * @param cpf
     */
    protected void getData(long cpf){
        Person client = listClients.get(cpf);
        txt_Nome.setText(client.getName());
        txt_Bairro.setText(client.getAddress().getBairro());
        txt_Celular.setText(""+client.getFoneC());
        txt_Cep.setText("" + client.getAddress().getCep());
        txt_Cidade.setText(client.getAddress().getCity());
        txt_Complemento.setText(client.getAddress().getComplement());
        txt_Cpf.setText("" + client.getCpf());
        txt_Email.setText(client.getEmail());
        txt_Estado.setText(client.getAddress().getState());
        txt_Logradouro.setText(client.getAddress().getLogradoro());
        txt_Numero.setText(""+client.getAddress().getNumber());
        txt_Rg.setText("" + client.getRg());
        txt_Telefone.setText(""+ client.getFoneR());
        Menu_Gerenciamento(panel);
        painelCLientOne();
    }

    /**
     * this method clear any data of jtextfields
     */
    protected void clearData(){
        txt_Nome.setText("");
        txt_Bairro.setText("");
        txt_Celular.setText("");
        txt_Cep.setText("");
        txt_Cidade.setText("");
        txt_Complemento.setText("");
        txt_Cpf.setText("");
        txt_Email.setText("");
        txt_Estado.setText("");
        txt_Logradouro.setText("");
        txt_Numero.setText("");
        txt_Rg.setText("");
        txt_Telefone.setText("");
    }
    

    /**
     * Method of settings of JTextFields
     * @param txt
     * @param panel
     */
    protected void settingsTxt(JTextField txt,JPanel panel){
        txt.setBounds(220, 200 + implementTxt, 490, 40);
        txt.setFont(new Font("Berbas Neue", Font.BOLD, 20));
        panel.add(txt);
        implementTxt += 50;
    }      
}