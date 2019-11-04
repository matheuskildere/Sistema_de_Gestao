package TrabalhoII.Graphic_Interface;

import static TrabalhoII.Graphic_Interface.Employee_Management.listEmployees;
import static TrabalhoII.Graphic_Interface.Product_Management.listProducts;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TrabalhoII.Class.Employee;
import TrabalhoII.Class.GeranceService;
import TrabalhoII.Class.Person;
import TrabalhoII.Class.Product;
import TrabalhoII.Class.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Service_Management extends Client_Management {
    private JPanel panel;
    private JLabel label_Date;
    private JLabel label_TimeInitial;
    private JLabel label_TimeEnd;
    private JLabel label_Service;
    private JLabel label_Employee;
    private JLabel label_Client;
    private JLabel label_Product;
    private JTextField txt_Date = new JTextField();
    private JTextField txt_TimeInitial = new JTextField();
    private JTextField txt_TimeEnd = new JTextField();
    private JComboBox<Service> jcb_Service = new JComboBox<>();
    private JComboBox<Employee> jcb_Employee = new JComboBox<>();
    private JComboBox<Person> jcb_Client = new JComboBox<>();
    private JComboBox<Product> jcb_Product = new JComboBox<>();
    private ArrayList<Product> productsList = new ArrayList<>();

    public void service_Management(JPanel panel) {
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
        button_Consult.setFont(new Font("Berbas Neue", Font.BOLD, 29));
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
        button_Register.setFont(new Font("Berbas Neue", Font.BOLD, 29));
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
        implementTxt = -30;
        implementLabel = -30;
        labelsStepOne(panel);
        jComboBox();
        txtStepOne(panel);

        label_RequiredField(panel);
        ButtonSave();
        panel.repaint();
    }

    /**
     * This method adds a JComboBox at panel of service register
     */
    protected void jComboBox() {
        jcb_Service.setBounds(220, 200 + implementTxt, 490, 40);
        implementTxt += 50;
        jcb_Client.setBounds(220, 200 + implementTxt, 490, 40);
        implementTxt += 50;
        jcb_Employee.setBounds(220, 200 + implementTxt, 490, 40);
        implementTxt += 50;
        jcb_Product.setBounds(220, 200 + implementTxt, 200, 40);
        implementTxt += 50;

        jcb_Client.removeAllItems();
        for (Person cli : listClients.getList()) {
            jcb_Client.addItem(cli);
        }

        jcb_Service.removeAllItems();
        ArrayList<Service> serArrayList = Service_Control.listsServices.getServicesList();
        for (Service ser : serArrayList) {
            jcb_Service.addItem(ser);
        }

        jcb_Employee.removeAll();
        ArrayList<Employee> eArrayList = listEmployees.getEmployeesList();
        for (Employee emp : eArrayList) {
            jcb_Employee.addItem(emp);
        }

        jcb_Product.removeAll();
        ArrayList<Product> sArrayList = listProducts.getProductsList();
        for (Product emp : sArrayList) {
            jcb_Product.addItem(emp);
        }

        panel.add(jcb_Product);
        panel.add(jcb_Employee);
        panel.add(jcb_Client);
        panel.add(jcb_Service);
    }

    protected GeranceService creatService(){
        String dat = txt_Date.getText();
        int timI = Integer.parseInt(txt_TimeInitial.getText());
        int timF = Integer.parseInt(txt_TimeEnd.getText());
        Service ser =(Service) jcb_Service.getSelectedItem();
        Person cli = (Person)jcb_Client.getSelectedItem();
        Employee emp = (Employee) jcb_Employee.getSelectedItem();

        GeranceService geranceService;
        try {
            geranceService = new GeranceService(ser, cli, emp,productsList, dat, timI, timF);
        } catch (Exception e) {
            geranceService = new GeranceService(ser, cli, emp, dat, timI, timF);
        }
        return geranceService;
    }

    @Override
    protected void ButtonSave() {
        buttonSave = new JButton("Salvar");
        buttonSave.setBounds(510 ,200 +implementLabel, 200, 60);
        buttonSave.setFont(new Font("Berbas Neue",Font.BOLD,29));
        buttonSave.setFocusPainted(false);
        buttonSave.setBorderPainted(false);
        buttonSave.setBackground(colorGrayButton);
        buttonSave.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                try {
                    creatService();
                    Menu_Gerenciamento(panel);
                    clearData();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Preencha as informacoes corretamente", "ERRO DO SISTEMA", JOptionPane.ERROR_MESSAGE);
                }
                clearData();
                Menu_Gerenciamento(panel);
            } 
        });

        JButton buttonAdd = new JButton("Add");
        buttonAdd.setBounds(570 ,implementLabel  , 90, 40);
        buttonAdd.setFont(new Font("Berbas Neue",Font.BOLD,29));
        buttonAdd.setFocusPainted(false);
        buttonAdd.setBorderPainted(false);
        buttonAdd.setBackground(colorGrayButton);
        buttonAdd.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                for (Product product : productsList) {
                    if(product.equals((Product)jcb_Product.getSelectedItem())){
                        JOptionPane.showMessageDialog(null,"Este funcionario ja foi adicionado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                productsList.add((Product)jcb_Product.getSelectedItem());
            } 
        });

        panel.add(buttonAdd);
        panel.add(buttonSave);
    }

    @Override
    protected void labelsStepOne(JPanel panel) {
        settingsLabels(label_Service, "Servico:*", panel);
        settingsLabels(label_Client, "Cliente:*", panel);
        settingsLabels(label_Employee, "Funcionario:*", panel);
        settingsLabels(label_Product, "Produtos:", panel);
        settingsLabels(label_Date, "Data:*", panel);
        settingsLabels(label_TimeInitial, "Hora Inicial:*", panel);
        settingsLabels(label_TimeEnd, "Hora Final:*", panel);
    }
    @Override
    protected void txtStepOne(JPanel panel) {
        settingsTxt(txt_Date, panel);
        settingsTxt(txt_TimeInitial, panel);
        settingsTxt(txt_TimeEnd, panel);
    }
    
    @Override
    protected void clearData() {
        txt_Date.setText("");
        txt_TimeInitial.setText("");
        txt_TimeEnd.setText("");
    }

    @Override
    protected void consulta(JPanel panel) {
        super.consulta(panel);
        label_Consulta.setText("Codigo");
    }
}
