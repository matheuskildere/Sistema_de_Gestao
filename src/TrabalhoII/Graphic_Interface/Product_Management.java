package TrabalhoII.Graphic_Interface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import TrabalhoII.Class.Product;
import TrabalhoII.Class.Products;

public class Product_Management extends Client_Management {
    private JPanel panel;
    private JLabel label_Nome;
    private JLabel label_Tipo;
    private JLabel label_Descricao;
    private JLabel label_Quantidade;
    private JLabel label_Valor;
    
    private JTextField txt_Nome =  new JTextField();
    private JTextField txt_Tipo =  new JTextField();
    private JTextField txt_Descricao =  new JTextField();
    private JTextField txt_Quantidade =  new JTextField();
    private JTextField txt_Valor =  new JTextField();
    
    protected static Products listProducts = new Products();
        
        
    public void Menu_Gerenciamento(JPanel panel) {
        this.panel = panel;
        panel.removeAll();
        buttons();
        panel.repaint();
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
        Object[][] data= listProducts.getInfo(Integer.parseInt(txt_Consulta.getText()));
        if (data == null) {
            throw new IllegalArgumentException("PRODUTO NÃO ENCONTRADO");
        }
        String[] nomeCo = new String[]{
            "Cod", "Nome", "Descricao", "Tipo", "Valor"
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
                ButtonSave();
                button_Register.setEnabled(false);        
            } 
        });
            
        panel.add(button_Register);
        panel.add(button_Consult);
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
                    JOptionPane.showMessageDialog(null,"Produto não encontrado, tente com um codigo diferente!", e.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            } 
        });
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
                    listProducts.add(creatProduct());
                    Menu_Gerenciamento(panel);
                    clearData();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Por favor, Digite as informações corretamente.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } 
        });
        panel.add(buttonSave);
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
                    panel.removeAll();
                    painelCLientOne();
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
                    listProducts.remove(Integer.parseInt(txt_Consulta.getText()));
                    JOptionPane.showMessageDialog(null, "Estoque excluido com sucesso!");
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
        settingsLabels(label_Tipo, "Tipo", panel);
        settingsLabels(label_Descricao, "Descricao", panel);
        settingsLabels(label_Quantidade, "Quantidade", panel);
        settingsLabels(label_Valor, "Valor", panel);
        
        
        settingsTxt(txt_Nome, panel);
        settingsTxt(txt_Tipo, panel);
        settingsTxt(txt_Descricao, panel);
        settingsTxt(txt_Quantidade, panel);
        settingsTxt(txt_Valor, panel);

        panel.repaint();
    }

   /**
    * This method get all dice of product and adds on the JTextfields 
    * @param cod
    */
    protected void getData(int cod) {
        Product pro = listProducts.get(cod);
        txt_Nome.setText(pro.getName());
        txt_Tipo.setText(pro.getType());
        txt_Descricao.setText(pro.getDescription());
        txt_Quantidade.setText(""+pro.getQuantidade());
        txt_Valor.setText(""+pro.getValueUnit());
    }

    @Override
    protected void clearData() {
        txt_Nome.setText("");
        txt_Tipo.setText("");
        txt_Descricao.setText("");
        txt_Quantidade.setText("");
        txt_Valor.setText("");
    }

    /**
     * This method get all dice of textFields and creat a new product
     * @return Product
     */
    protected Product creatProduct(){
        String nam = txt_Nome.getText();
        int qua = Integer.parseInt(txt_Quantidade.getText());
        double val = Double.parseDouble(txt_Valor.getText());

        Product newProduct;
        try {
            String typ = txt_Tipo.getText();
            String des = txt_Descricao.getText();
            newProduct = new Product(nam, typ, des, qua, val);
        } catch (Exception e) {
            newProduct = new Product(nam, qua, val);
        }

        return newProduct;
    }

}