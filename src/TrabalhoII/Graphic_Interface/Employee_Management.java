package TrabalhoII.Graphic_Interface;

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
import TrabalhoII.Class.Employee;
import TrabalhoII.Class.Employees;

public class Employee_Management extends Client_Management{

    protected JPanel panel;
    protected JLabel label_ValorTime;
    protected JLabel label_Cargo;
    protected JTextField txt_valorTime = new JTextField();
    protected JTextField txt_Cargo = new JTextField();

    protected static Employees listEmployees = new Employees();
    private Address address;
    private Employee employee;
    
    
    public void Menu_Gerenciamento(JPanel panel) {
        this.panel = panel;
        panel.removeAll();
        buttons();
        panel.repaint();
    }

    @Override
    public void buttons() {
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
        
        panel.add(button_Register);
        panel.add(button_Consult);
    }

    @Override
    protected void painelCLientOne() {
        implementTxt = -50;
        implementLabel = -50;

        labelsStepOne(panel);
        settingsLabels(label_ValorTime, "Valor Hora:*", panel);
        settingsLabels(label_Cargo, "Cargo:*", panel);

        txtStepOne(panel);
        settingsTxt(txt_valorTime, panel); 
        settingsTxt(txt_Cargo, panel);
        
        label_RequiredField(panel);
        buttonNext();
        panel.repaint();
    }

    @Override
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
                button_Register.setEnabled(false);
                painelClientTwo(panel);
                ButtonSave();
            } 
        });
        panel.add(buttonNext);
    }

    @Override
    protected void ButtonSave(){
        buttonSave = new JButton("Salvar");
        buttonSave.setBounds(510 ,200 +implementLabel, 200, 60);
        buttonSave.setFont(new Font("Berbas Neue",Font.BOLD,29));
        buttonSave.setFocusPainted(false);
        buttonSave.setBorderPainted(false);
        buttonSave.setBackground(colorGrayButton);
        buttonSave.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                try {
                    long cpf = Long.parseLong(txt_Cpf.getText());
                    if (listEmployees.get(cpf) != null) {
                        listEmployees.set(cpf, creatPerson());
                    }else{
                        listEmployees.add(creatPerson());
                    }
                    Menu_Gerenciamento(panel);
                    clearData();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Por favor, Digite as informacoes corretamente.", "Error", JOptionPane.ERROR_MESSAGE);
                    panel.removeAll();
                    painelCLientOne();
                }
            } 
        });
        panel.add(buttonSave);
    }

    @Override
    protected void seeInfo(){
        Object[] data= listEmployees.getInfo(Integer.parseInt(txt_Consulta.getText()));
        if (data == null) {
            throw new IllegalArgumentException("FUNCIONARIO NÃO ENCONTRADO");
        }
        String[] nomeCo = new String[]{
            "Nome", "Cpf", "Rg", "Celular", "Telefone", "Email","Cargo", "Valor",
        };
        String[] nomeCol = new String[]{
            "Logradouro", "Numero", "Bairro", "Complemento", "Cep", "Cidade", "Estado"
        };

        table_Info = new JTable((Object[][])data[0], nomeCo);
        table_Info.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_Info.setFont(new Font("Berbas Neue",Font.BOLD,15));
        scroll = new JScrollPane(table_Info);
        scroll.setBounds(50, 290,700, 40);

        table_InfoAdress = new JTable((Object[][]) data[1], nomeCol);
        table_InfoAdress.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_InfoAdress.setFont(new Font("Berbas Neue",Font.BOLD,15));
        scrollAdress = new JScrollPane(table_InfoAdress);
        scrollAdress.setBounds(50, 360,700, 40);

        editAndRemove();
        panel.add(scroll);
        panel.add(scrollAdress);
        panel.repaint();
        
    }

    @Override
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
                
            } 
        });

        buttonRemove.setBounds(181 * 2 + 43, 450, 200, 40);
        buttonRemove.setFont(new Font("Berbas Neue",Font.BOLD,29));
        buttonRemove.setFocusPainted(false);
        buttonRemove.setBorderPainted(false);
        buttonRemove.setBackground(colorGrayButton);
        buttonRemove.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                
            } 
        });

        panel.add(buttonEdit);
        panel.add(buttonRemove);
    }

    @Override
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
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Não encontramos um funcionario com o código digitado.\nPor favor tente novamente com um código valido!", e.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            } 
        });
    }

    @Override
    protected Employee creatPerson() {
        String email = txt_Email.getText();
        long cpf = Long.parseLong(txt_Cpf.getText());
        String nome = txt_Nome.getText();
        String log = txt_Logradouro.getText();

        String bai = txt_Bairro.getText();
        long num = Long.parseLong(txt_Numero.getText());
        String cit = txt_Cidade.getText();
        String sta = txt_Estado.getText();
        String com = txt_Complemento.getText();
        double valorHora = Double.parseDouble(txt_valorTime.getText());
        String cargo =txt_Cargo.getText();
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
            employee = new Employee(nome, cpf, rg, telefone, celular,email , address, cargo, valorHora);
        } catch (Exception e) {
            employee = new Employee(nome, cpf, cargo, valorHora, address);
        }
        

        return employee;
    }
    @Override
    protected void consulta(JPanel panel) {
        super.consulta(panel);
        label_Consulta.setText("Codigo:");
    }
}