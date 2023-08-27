/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.challenge.oraclesprint01conversordivisas;

import com.challenge.oraclesprint01conversordivisas.conversorMonedas.Pesos;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author cesar
 */
public class OracleSprint01ConversorDivisas extends JFrame{

    private JPanel contenedor;
    private JPanel conversorMoneda;
    private JPanel homeMenu;
    private JButton backMoneda;
    private JPanel conversorTemp;
    private JButton backTemp;
    private JPanel panelN;
    private JButton buttonOkMoneda;
    private JLabel resultado;
    private JButton buttonOkTemp;
    private JPanel panelS;
    private JLabel signo;
    private JLabel signo2;
    private JTextField tFieldDivisa;
    private JTextField tFieldDivisa2;
    private JComboBox<String> options;
    private JComboBox<String> divisas;
    private JComboBox<String> divisas2;
    private String[] opciones = {"De pesos a dolares", "De pesos a euros", "De dolar a pesos", "De euros a pesos"};
    private String[] menuOptions = {"---", "Conversor de Divisas", "Conversor de Temperatura"};
    
    public OracleSprint01ConversorDivisas(){
        setTitle("Conversor ");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        initComponents();
        initListeners();
        
        setVisible(true);
    }
    
    private void initComponents(){
        contenedor =  new JPanel(new CardLayout());
        
        //Menu
        homeMenu = new JPanel();
        homeMenu.add(new JLabel("Selecciona una opcion"));
        options = new JComboBox(menuOptions);
        homeMenu.add(options);
        
        //Conversor moneda
        conversorMoneda = new JPanel();
        conversorMoneda.setLayout(new BoxLayout(conversorMoneda, BoxLayout.Y_AXIS));
        //conversorMoneda.add(new JLabel("Conversor de moneda"));
        
        conversorMoneda.add(new JLabel("Ingresa la cantidad de dinero que deseas convertir"));
        panelN = new JPanel();
        //panelN.setPreferredSize(new Dimension(400, 50));
        conversorMoneda.add(panelN);
        signo = new JLabel("$");
        signo.setFont(new Font("Arial", Font.PLAIN, 24));
        panelN.add(signo);
        tFieldDivisa = new JTextField(10);
        tFieldDivisa.setFont(new Font("Arial", Font.PLAIN, 24));
        tFieldDivisa.setHorizontalAlignment(JTextField.LEFT);
        tFieldDivisa.setEditable(true);
        //tFieldDivisa.setPreferredSize(new Dimension(300, 50));
        panelN.add(tFieldDivisa);
        divisas = new JComboBox<>(opciones);
        //divisas.setPreferredSize(new Dimension(100, 50));
        panelN.add(divisas);
        buttonOkMoneda = new JButton("Convertir");
        conversorMoneda.add(buttonOkMoneda);
        resultado = new JLabel();
        resultado.setFont(new Font("Arial", Font.PLAIN, 24));
        conversorMoneda.add(resultado);
        
        backMoneda = new JButton("Regresar");
        conversorMoneda.add(backMoneda);
        
        //Conversor temperatura
        conversorTemp = new JPanel();
        conversorTemp.add(new JLabel("Conversor de temperatura"));
        backTemp = new JButton("Regresar");
        conversorTemp.add(backTemp);
        
        contenedor.add(homeMenu, "homeMenu");
        contenedor.add(conversorMoneda, "ventanaMoneda");
        contenedor.add(conversorTemp, "ventanaTemp");
        
        add(contenedor);
        
    }
    
    private void initListeners() {
        
        options.addActionListener((e) -> {
            String selected = options.getSelectedItem().toString();
            if(selected.equals("Conversor de Divisas")){
                CardLayout cardLayout = (CardLayout) contenedor.getLayout();
                cardLayout.show(contenedor, "ventanaMoneda");
            }else {
                CardLayout cardLayout = (CardLayout) contenedor.getLayout();
                cardLayout.show(contenedor, "ventanaTemp");
            }
        });
        
        tFieldDivisa.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (!Character.isDigit(caracter) &&
                        caracter != KeyEvent.VK_BACK_SPACE && 
                        caracter != KeyEvent.VK_DELETE) {
                    e.consume(); 
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {               
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        buttonOkMoneda.addActionListener((e) -> {
            Pesos pesos = new Pesos();
            String selected = divisas.getSelectedItem().toString();
            switch (selected) {
                case "De pesos a dolares" -> showResult(pesos.pesosADolares(Double.parseDouble(tFieldDivisa.getText())));
                case "De pesos a euros" -> showResult(pesos.pesosAEuros(Double.parseDouble(tFieldDivisa.getText())));
                default -> showResult(0);
            }
        });
        
        backMoneda.addActionListener((e) -> {
            CardLayout cardLayout = (CardLayout) contenedor.getLayout();
            cardLayout.show(contenedor, "homeMenu");
        });
        
        backTemp.addActionListener((e) -> {
            CardLayout cardLayout = (CardLayout) contenedor.getLayout();
            cardLayout.show(contenedor, "homeMenu");
        });
    }
    
    public void showResult(double result){
        resultado.setText("Coversion: " + result);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new OracleSprint01ConversorDivisas();
        });
    }
}
