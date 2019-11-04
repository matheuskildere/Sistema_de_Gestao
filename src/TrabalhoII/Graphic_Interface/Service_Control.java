package TrabalhoII.Graphic_Interface;

import static TrabalhoII.Graphic_Interface.Employee_Management.listEmployees;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import TrabalhoII.Class.Employee;
import TrabalhoII.Class.Service;
import TrabalhoII.Class.Services;

public class Service_Control extends Client_Management {
    private JPanel panel;
    private JLabel label_Descricao;
    private JLabel label_Valor;
    private JLabel label_Funcionario;

    private JTextField txt_Descricao =  new JTextField();
    private JTextField txt_Valor =  new JTextField();

    protected static Services listsServices = new Services();
    private JComboBox<Employee> jcb_Employee = new JComboBox<>();
    private ArrayList<Employee> listEmplo;

    @Override
    public void Menu_Gerenciamento(JPanel panel) {
        this.panel = panel;
        panel.removeAll();
        buttons();
        panel.repaint();
    }

    protected void jComboBox() {
        jcb_Employee.setBounds(220,implementTxt + 200, 350, 40);
        implementTxt += 50;

        jcb_Employee.removeAll();
        ArrayList<Employee> aEmployees = listEmployees.getEmployeesList();
        for (Employee emp : aEmployees) {
            jcb_Employee.addItem(emp);
        }

        panel.add(jcb_Employee);
    }

    @Override
    protected void consulta(JPanel panel) {
        buttonSearch();
        txt_Consulta = new JTextField();
        txt_Consulta.setBounds(150, 200, 400, 40);
        txt_Consulta.setFont(new Font("Berbas Neue", Font.BOLD, 20));

        label_Consulta = new JLabel("Codigo:");
        label_Consulta.setBounds(10, 200, 210, 29);
        label_Consulta.setFont(new Font("Berbas Neue", Font.BOLD, 29));

        panel.add(buttonSearch);
        panel.add(txt_Consulta);
        panel.add(label_Consulta);
        panel.repaint();
    }

    @Override
    protected void seeInfo() {
        Object[][] data= listsServices.getInfo(Integer.parseInt(txt_Consulta.getText()));
        if (data == null) {
            throw new IllegalArgumentException("SERVICO NÃO ENCONTRADO");
        }
        String[] nomeCo = new String[]{
            "Cod", "Nome", "Descricao", "Valor", "Funcionarios"
        };
        
        table_Info = new JTable(data, nomeCo);
        table_Info.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_Info.setFont(new Font("Berbas Neue",Font.BOLD,15));
        table_Info.setRowHeight(0, 25);
        table_Info.setShowHorizontalLines(true);
        scroll = new JScrollPane(table_Info);
        scroll.setBounds(50, 290,700, 45);

        editAndRemove();
        panel.add(scroll);
        panel.repaint();
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
                    listsServices.add(creatService());
                    Menu_Gerenciamento(panel);
                    clearData();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Por favor, Digite as informações corretamente.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } 
        });

        JButton buttonAdd = new JButton("Add");
        buttonAdd.setBounds(590 ,implementLabel + 145, 90, 50);
        buttonAdd.setFont(new Font("Berbas Neue",Font.BOLD,29));
        buttonAdd.setFocusPainted(false);
        buttonAdd.setBorderPainted(false);
        buttonAdd.setBackground(colorGrayButton);
        buttonAdd.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                listEmplo = new ArrayList<>();
                for (Employee employee : listEmplo) {
                    if(employee.equals((Employee)jcb_Employee.getSelectedItem())){
                        JOptionPane.showMessageDialog(null,"Este funcionario ja foi adicionado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                listEmplo.add((Employee)jcb_Employee.getSelectedItem());
            } 
        });

        panel.add(buttonAdd);
        panel.add(buttonSave);
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
                jComboBox();
                button_Register.setEnabled(false);        
            } 
        });
        
        panel.add(button_Register);
        panel.add(button_Consult);
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
                    getData(Integer.parseInt(txt_Consulta.getText()));
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
                    listsServices.remove(Integer.parseInt(txt_Consulta.getText()));
                    JOptionPane.showMessageDialog(null, "Servico excluido com sucesso!");
                    Menu_Gerenciamento(panel);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Tente novamente com um codigo valido", "ERRO DO SISTEMA", JOptionPane.ERROR_MESSAGE);
                }
            } 
        });

        panel.add(buttonEdit);
        panel.add(buttonRemove);
    }

    @Override
    protected void painelCLientOne() {
        implementTxt = 0;
        implementLabel = 0;

        settingsLabels(label_Nome, "Nome", panel);
        settingsLabels(label_Descricao, "Descricao", panel);
        settingsLabels(label_Valor, "Valor", panel);
        settingsLabels(label_Funcionario, "Funcionario", panel);
        
        
        settingsTxt(txt_Nome, panel);
        settingsTxt(txt_Descricao, panel);
        settingsTxt(txt_Valor, panel);
        ButtonSave();
        panel.repaint();
    }

    /**
    * This method get all dice of service and adds on the JTextfields 
    * @param cod
    */
    protected void getData(int cod) {
        Service pro = listsServices.get(cod);
        txt_Nome.setText(pro.getName());
        txt_Descricao.setText(pro.getDescription());
        txt_Valor.setText(""+pro.getValue());
    }

    @Override
    protected void clearData() {
        txt_Nome.setText("");
        txt_Descricao.setText("");
        txt_Valor.setText("");
    }


    protected Service creatService(){
        String nam = txt_Nome.getText();
        double val = Double.parseDouble(txt_Valor.getText());

        Service newService;
        try {
            String des = txt_Descricao.getText();
            newService = new Service(nam, des, val ,listEmplo);
        } catch (Exception e) {
            newService = new Service(nam, val, listEmplo);
        }

        return newService;
    }


    @Override
    protected void buttonSearch() {
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
                    JOptionPane.showMessageDialog(null,"Servico não encontrado, tente com um codigo diferente!", e.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            } 
        });
    }

}
