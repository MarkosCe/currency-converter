/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.challenge.oraclesprint01conversordivisas;

import com.challenge.oraclesprint01conversordivisas.conversorMonedas.CaracterInvalidoException;
import com.challenge.oraclesprint01conversordivisas.conversorMonedas.CurrencyConverterException;
import com.challenge.oraclesprint01conversordivisas.conversorMonedas.Moneda;
import com.challenge.oraclesprint01conversordivisas.conversorMonedas.Pesos;
import com.challenge.oraclesprint01conversordivisas.conversorTemperatura.Temperatura;
import java.awt.CardLayout;
import java.awt.Color;
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
public class OracleSprint01ConversorDivisas extends JFrame {

    private JPanel contenedor;
    private JPanel conversorMoneda;
    private JPanel homeMenu;
    private JButton backMoneda;
    private JPanel conversorTemp;
    private JButton backTemp;
    private JPanel panelN;
    private JLabel labelErrorCurrency;
    private JButton buttonOkMoneda;
    private JLabel resultado;
    private JLabel resultadoTemp;
    private JButton buttonOkTemp;
    private JPanel panelS;
    private JLabel labelErrorTemp;
    private JLabel signo;
    private JTextField tFieldDivisa;
    private JTextField tFieldTemp;
    private JComboBox<String> options;
    private JComboBox<String> divisas;
    private JComboBox<String> grados;
    private final String[] opciones = {"De Pesos a Dolar",
        "De Pesos a Euro", "De Pesos a Libras",
        "De Pesos a Yen", "De Pesos a Won Coreano",
        "De Dolar a Pesos", "De Euro a Pesos",
        "De Libras a Pesos", "De Yen a Pesos",
        "De Won Coreano a Pesos"};

    private final String[] opcionesTemp = {"De grados Celsius a Fahrenheit",
        "De grados Celsius a Kelvin", "De grados Fahrenheit a Celsius",
        "De grados Fahrenheit a Kelvin", "De Kelvin a grados Fahrenheit",
        "De Kelvin a grados Celsius"};

    private final String[] menuOptions = {"---", "Conversor de Divisas", "Conversor de Temperatura"};

    public OracleSprint01ConversorDivisas() {
        setTitle("Conversor ");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        initComponents();
        initListeners();

        setVisible(true);
    }

    private void initComponents() {
        contenedor = new JPanel(new CardLayout());

        //Menu
        componentsMenu();

        //Conversor moneda
        componentsCurrencyConverter();

        //Conversor temperatura
        componentsTempConverter();

        contenedor.add(homeMenu, "homeMenu");
        contenedor.add(conversorMoneda, "ventanaMoneda");
        contenedor.add(conversorTemp, "ventanaTemp");

        add(contenedor);
    }

    private void initListeners() {
        options.addActionListener((e) -> {
            String selected = options.getSelectedItem().toString();
            if (selected.equals("Conversor de Divisas")) {
                showCard("ventanaMoneda");
            } else if (selected.equals("Conversor de Temperatura")) {
                showCard("ventanaTemp");
            }
        });

        //conversor moneda
        tFieldDivisa.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    onlyNumbers(e);
                    labelErrorCurrency.setText("");
                    resultado.setText("");
                } catch (CaracterInvalidoException ex) {
                    labelErrorCurrency.setText(ex.getMessage());
                    resultado.setText("");
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
            if (tFieldDivisa.getText().isEmpty()) {
                labelErrorCurrency.setText("Ingresa una cantidad");
                return;
            }
            try {
                goSwitchCurrency();
            } catch (CurrencyConverterException ex) {
                labelErrorCurrency.setText(ex.getMessage());
                resultado.setText("");
            }
        });

        backMoneda.addActionListener((e) -> {
            showCard("homeMenu");
        });

        //conversor temperatura
        tFieldTemp.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    onlyNumbers(e);
                    labelErrorTemp.setText("");
                    resultadoTemp.setText("");
                } catch (CaracterInvalidoException ex) {
                    labelErrorTemp.setText(ex.getMessage());
                    resultadoTemp.setText("");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        buttonOkTemp.addActionListener((e) -> {
            if (tFieldTemp.getText().isEmpty()) {
                labelErrorTemp.setText("Ingresa los grados");
                return;
            }
            
            goSwitchTemp();
            
        });

        backTemp.addActionListener((e) -> {
            showCard("homeMenu");
        });
    }
    
    private void componentsMenu() {
        homeMenu = new JPanel();
        homeMenu.add(new JLabel("Selecciona una opcion"));
        options = new JComboBox(menuOptions);
        homeMenu.add(options);
    }

    private void componentsCurrencyConverter() {
        conversorMoneda = new JPanel();
        conversorMoneda.setLayout(new BoxLayout(conversorMoneda, BoxLayout.Y_AXIS));
        conversorMoneda.add(new JLabel("Ingresa la cantidad de dinero que deseas convertir"));

        panelN = new JPanel();
        conversorMoneda.add(panelN);

        signo = new JLabel("$");
        signo.setFont(new Font("Arial", Font.PLAIN, 24));
        panelN.add(signo);

        tFieldDivisa = new JTextField(10);
        tFieldDivisa.setFont(new Font("Arial", Font.PLAIN, 24));
        tFieldDivisa.setHorizontalAlignment(JTextField.LEFT);
        tFieldDivisa.setEditable(true);
        panelN.add(tFieldDivisa);

        divisas = new JComboBox<>(opciones);
        panelN.add(divisas);

        labelErrorCurrency = new JLabel();
        labelErrorCurrency.setFont(new Font("Arial", Font.PLAIN, 12));
        labelErrorCurrency.setForeground(Color.red);
        conversorMoneda.add(labelErrorCurrency);

        buttonOkMoneda = new JButton("Convertir");
        conversorMoneda.add(buttonOkMoneda);

        resultado = new JLabel();
        resultado.setFont(new Font("Arial", Font.PLAIN, 24));
        conversorMoneda.add(resultado);

        backMoneda = new JButton("Regresar");
        conversorMoneda.add(backMoneda);
    }

    private void componentsTempConverter() {
        conversorTemp = new JPanel();
        conversorTemp.setLayout(new BoxLayout(conversorTemp, BoxLayout.Y_AXIS));
        conversorTemp.add(new JLabel("Conversor de temperatura"));

        panelS = new JPanel();
        conversorTemp.add(panelS);

        tFieldTemp = new JTextField(6);
        tFieldTemp.setFont(new Font("Arial", Font.PLAIN, 24));
        tFieldTemp.setHorizontalAlignment(JTextField.LEFT);
        tFieldTemp.setEditable(true);
        panelS.add(tFieldTemp);

        grados = new JComboBox<>(opcionesTemp);
        panelS.add(grados);

        labelErrorTemp = new JLabel();
        labelErrorTemp.setFont(new Font("Arial", Font.PLAIN, 12));
        labelErrorTemp.setForeground(Color.red);
        conversorTemp.add(labelErrorTemp);

        buttonOkTemp = new JButton("Convertir");
        conversorTemp.add(buttonOkTemp);

        resultadoTemp = new JLabel();
        resultadoTemp.setFont(new Font("Arial", Font.PLAIN, 24));
        conversorTemp.add(resultadoTemp);

        backTemp = new JButton("Regresar");
        conversorTemp.add(backTemp);
    }

    public void showResult(double result, String currency) {
        resultado.setText("" + result + " " + currency);
    }

    public void showCard(String cardName) {
        CardLayout cardLayout = (CardLayout) contenedor.getLayout();
        cardLayout.show(contenedor, cardName);
    }

    public void onlyNumbers(KeyEvent e) throws CaracterInvalidoException {
        char caracter = e.getKeyChar();
        if (!Character.isDigit(caracter)
                && caracter != KeyEvent.VK_BACK_SPACE
                && caracter != KeyEvent.VK_DELETE) {
            e.consume();
            throw new CaracterInvalidoException("Simbolo no permitido, solo inserte numeros");
        }
    }
    
    private void goSwitchCurrency() throws CurrencyConverterException {
        double amount = Double.parseDouble(tFieldDivisa.getText());
        Pesos pesos = new Pesos(amount);
        Moneda moneda = new Moneda();
        labelErrorCurrency.setText("");
        String selected = divisas.getSelectedItem().toString();
        switch (selected) {
            case "De Pesos a Dolar" ->
                showResult(pesos.pesosADolar(), "Dolares");
            case "De Pesos a Euro" ->
                showResult(pesos.pesosAEuro(), "Euros");
            case "De Pesos a Libras" ->
                showResult(pesos.pesosALibras(), "Libras");
            case "De Pesos a Yen" ->
                showResult(pesos.pesosAYen(), "Yenes");
            case "De Pesos a Won Coreano" ->
                showResult(pesos.pesosAWonCoreano(), "Wones");
            case "De Dolar a Pesos" ->
                showResult(moneda.dolarAPesos(amount), "Pesos");
            case "De Euro a Pesos" ->
                showResult(moneda.euroAPesos(amount), "Pesos");
            case "De Libras a Pesos" ->
                showResult(moneda.librasAPesos(amount), "Pesos");
            case "De Yen a Pesos" ->
                showResult(moneda.yenAPesos(amount), "Pesos");
            case "De Won Coreano a Pesos" ->
                showResult(moneda.wonCoreanoAPesos(amount), "Pesos");
            default ->
                showResult(0, "");
        }
    }
    
    private void goSwitchTemp() {
        double amount = Double.parseDouble(tFieldTemp.getText());
        Temperatura temperatura = new Temperatura();
        labelErrorTemp.setText("");
        String selected = grados.getSelectedItem().toString();
        switch (selected) {
            case "De grados Celsius a Fahrenheit" ->
                resultadoTemp.setText("" + temperatura.celsiusToFahrenheit(amount) + " grados Fahrenheit");
            case "De grados Celsius a Kelvin" ->
                resultadoTemp.setText("" + temperatura.celsiusToKelvin(amount) + " Kelvin");
            case "De grados Fahrenheit a Celsius" ->
                resultadoTemp.setText("" + temperatura.fahrenheitToCelsius(amount) + " grados Celsius");
            case "De grados Fahrenheit a Kelvin" ->
                resultadoTemp.setText("" + temperatura.farenheitToKelvin(amount) + " Kelvin");
            case "De Kelvin a grados Fahrenheit" ->
                resultadoTemp.setText("" + temperatura.kelvinToFahrenheit(amount) + " grados Fahrenheit");
            case "De Kelvin a grados Celsius" ->
                resultadoTemp.setText("" + temperatura.kelvinToCelsius(amount) + " grados Celsius");
            default ->
                showResult(0, "");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new OracleSprint01ConversorDivisas();
        });
    }
}
