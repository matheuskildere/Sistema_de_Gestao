package TrabalhoII.Graphic_Interface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * main_Screen
 */
public class Main_Screen {

    protected static JFrame windowFrame;
    private static JPanel panel;
    
    private static JButton buttonEmployee;
    private static JButton buttonClient;
    private static JButton buttonService;
    private static JButton buttonServiceControl;
    private static JButton buttonProduct;
    private static JButton button1Menu;
    private static JButton button2Menu;
    private static JButton button3Menu;
    private static JButton button4Menu;
    private static JLabel logo;
    private static Color colorDarkBlue = new Color(127, 175, 231);
    private static Color colorLightBlue = new Color(147, 192, 243);
    private static Color colorGrayButton = new Color(135, 160, 211);
    private static Client_Management geren = new Client_Management();
    private static Employee_Management gerenEmp = new Employee_Management();
    private static Product_Management gerenPro = new Product_Management();
    private static Service_Management manageService = new Service_Management();
    private static Service_Control controlService = new Service_Control();
    // variaveis para auxiliar a definicao do tamanho das labels
    private static int x = 70;
    private static int y = 40;
    private static int dimX = 300;

    
    /**
     * Class builder, this one, runs the program with all
     * the initial settings required
     */
    public Main_Screen() {
        settingsWindow();
        settingsLogo();
        settingsPanel();
        settingsButtons();
        windowFrame.setVisible(true);
        windowFrame.setLocationRelativeTo(null);
    }

    /**
     * Method in which you configure frame settings
     */
    public static void settingsWindow() {
        windowFrame = new JFrame("ESERV SISTEMA");
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setResizable(false);
        windowFrame.setSize(1280, 720);
        windowFrame.getContentPane().setBackground(colorDarkBlue);
        windowFrame.setLayout(null);

    }

    /**
     * Method for setting up the system logo
     */
    public static void settingsLogo() {
        logo = new JLabel("ESERV");
        logo.setBounds(x + 30, y, dimX, 70);
        logo.setFont(new Font("Berbas Neue", Font.BOLD, 80));
        windowFrame.getContentPane().add(logo);
    }

    /**
     *Method for configuring the panel settings used
ÿÿÿÿÿ* in the menu options.
     */
    public static void settingsPanel() {
        panel = new JPanel();
        panel.setBounds(475, y + 8, 805, 640);
        panel.setBackground(colorLightBlue);
        panel.getComponentPopupMenu();
        panel.setLayout(null);

        JLabel welcome = new JLabel("BEM VINDO");
        welcome.setBounds(240, 190, 550, 210);
        welcome.setFont(new Font("Berbas Neue", Font.BOLD, 60));
        panel.add(welcome);

        windowFrame.getContentPane().add(panel);
        panel.repaint();
    }

    /**
     * This method configures the system menu buttons and the
ÿÿÿÿÿ* add to JFrame
     */
    public static void settingsButtons() {
        int btX = 53;
        int btY = 200;
        int btDimX = 377;
        int btDimY = 69;
        button1Menu = new JButton("GERENCIAMENTO");
        button2Menu = new JButton("CONTROLE");
        button3Menu = new JButton("FOLHA DE PAGAMENTO");
        button4Menu = new JButton("RELATORIOS");

        button1Menu.setBounds(btX, btY, btDimX, btDimY);
        button1Menu.setFont(new Font("Berbas Neue", Font.BOLD, 29));
        button1Menu.setFocusPainted(false);
        button1Menu.setBorderPainted(false);
        button1Menu.setBackground(colorGrayButton);
        button1Menu.setActionCommand("GERENCIAMENTO");
        windowFrame.getContentPane().add(button1Menu);
        button1Menu.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) { 
                panel.removeAll();
                buttonsSup();
                button1Menu.setEnabled(false);
                button2Menu.setEnabled(true);
            } 
        });

        button2Menu.setBounds(btX, btY + 107, btDimX, btDimY);
        button2Menu.setFont(new Font("Berbas Neue", Font.BOLD, 29));
        button2Menu.setBorderPainted(false);
        button2Menu.setFocusPainted(false);
        button2Menu.setActionCommand("CONTROLE");
        button2Menu.setBackground(colorGrayButton);
        windowFrame.getContentPane().add(button2Menu);
        button2Menu.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) { 
                panel.removeAll();
                buttonsSupControl();
                button1Menu.setEnabled(true);
                button2Menu.setEnabled(false);
            }
        });

        button3Menu.setBounds(btX, btY + 214, btDimX, btDimY);
        button3Menu.setFont(new Font("Berbas Neue", Font.BOLD, 29));
        button3Menu.setBorderPainted(false);
        button3Menu.setFocusPainted(false);
        button3Menu.setActionCommand("FOLHA DE PAGAMENTO");
        button3Menu.setBackground(colorGrayButton);
        windowFrame.getContentPane().add(button3Menu);

        button4Menu.setBounds(btX, btY + 321, btDimX, btDimY);
        button4Menu.setFont(new Font("Berbas Neue", Font.BOLD, 29));
        button4Menu.setFocusPainted(false);
        button4Menu.setBorderPainted(false);
        button4Menu.setActionCommand("RELATORIOS");
        button4Menu.setBackground(colorGrayButton);
        windowFrame.getContentPane().add(button4Menu);
    }

    /**
     * This method adds the top management option buttons.
     */
    private static void buttonsSup() {
        int x = 520;
        int dimX = 250;
        buttonEmployee = new JButton("Funcionarios");
        buttonService = new JButton("Servicos");
        buttonClient = new JButton("Clientes");
        buttonClient.setBounds(x, 0, dimX, 50);
        buttonClient.setFont(new Font("Berbas Neue", Font.BOLD, 29));
        buttonClient.setFocusPainted(false);
        buttonClient.setContentAreaFilled(false);
        buttonClient.setBorderPainted(false);
        buttonClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                buttonClient.setEnabled(false);
                buttonEmployee.setEnabled(true);
                buttonService.setEnabled(true);
                geren.Menu_Gerenciamento(panel);
            }
        });

        windowFrame.getContentPane().add(buttonClient);

        buttonEmployee.setBounds(x + dimX - 30, 0, dimX, 50);
        buttonEmployee.setFont(new Font("Berbas Neue", Font.BOLD, 29));
        buttonEmployee.setFocusPainted(false);
        buttonEmployee.setContentAreaFilled(false);
        buttonEmployee.setBorderPainted(false);
        buttonEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                gerenEmp.Menu_Gerenciamento(panel);
                buttonEmployee.setEnabled(false);
                buttonClient.setEnabled(true);
                buttonService.setEnabled(true);
            }
        });
        windowFrame.getContentPane().add(buttonEmployee);

        buttonService.setBounds(x - 60 + dimX * 2, 0, dimX, 50);
        buttonService.setFont(new Font("Berbas Neue", Font.BOLD, 29));
        buttonService.setFocusPainted(false);
        buttonService.setContentAreaFilled(false);
        buttonService.setBorderPainted(false);
        buttonService.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                manageService.service_Management(panel);
                buttonService.setEnabled(false);
                buttonEmployee.setEnabled(true);
                buttonClient.setEnabled(true);

            }
        });
        windowFrame.getContentPane().add(buttonService);
        if (buttonProduct != null){
            windowFrame.remove(buttonProduct);
            windowFrame.remove(buttonServiceControl);
        }
        windowFrame.repaint();
    }

    /**
     * This method adds the top Control option buttons.
     */
    private static void buttonsSupControl() {
        int x = 400;
        int dimX = 250;
        buttonProduct = new JButton("Estoque");
        buttonProduct.setBounds(x + dimX , 0, dimX, 50);
        buttonProduct.setFont(new Font("Berbas Neue",Font.BOLD,29));
        buttonProduct.setFocusPainted(false);
        buttonProduct.setContentAreaFilled(false);
        buttonProduct.setBorderPainted(false);
        buttonProduct.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                gerenPro.Menu_Gerenciamento(panel);
                buttonProduct.setEnabled(false);
                    
            } 
        });
        windowFrame.getContentPane().add(buttonProduct);

        buttonServiceControl = new JButton("Servico");
        buttonServiceControl.setBounds(x + dimX + dimX, 0, dimX, 50);
        buttonServiceControl.setFont(new Font("Berbas Neue",Font.BOLD,29));
        buttonServiceControl.setFocusPainted(false);
        buttonServiceControl.setContentAreaFilled(false);
        buttonServiceControl.setBorderPainted(false);
        buttonServiceControl.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                controlService.Menu_Gerenciamento(panel);
                buttonServiceControl.setEnabled(false);
                buttonProduct.setEnabled(true);
                    
            } 
        });
        if (buttonClient != null) {
            windowFrame.remove(buttonService);
            windowFrame.remove(buttonClient);
            windowFrame.remove(buttonEmployee);
        }
        windowFrame.getContentPane().add(buttonServiceControl);
        windowFrame.repaint();
    }
    /**
     * run the system
     * @param args
     */
    public static void main(String[] args) {
        new Main_Screen();
    }

}
