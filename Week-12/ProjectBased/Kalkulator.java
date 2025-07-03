package ProjectBased;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] buttons = new JButton[20];
    private String[] buttonLabels = {
        "1", "2", "3", "4", "5", "6",
        "7", "8", "9", "0", "+", "-",
        "*", "/", "=", ".", "Mod", "Exit", "Clear", "Del"
    };
    
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;
    private boolean operatorPressed = false;
    
    public Kalkulator() {
        setTitle("Kalkulator Sederhana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        
        initComponents();
        setupLayout();
        setVisible(true);
    }
    
    private void initComponents() {
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(Color.WHITE);
        display.setBorder(BorderFactory.createLoweredBevelBorder());
        
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 16));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            
            if (buttonLabels[i].equals("Exit")) {
                buttons[i].setBackground(Color.RED);
                buttons[i].setForeground(Color.WHITE);
            } else if (buttonLabels[i].equals("Clear")) {
                buttons[i].setBackground(Color.ORANGE);
                buttons[i].setForeground(Color.WHITE);
            } else if (buttonLabels[i].equals("=")) {
                buttons[i].setBackground(Color.GREEN);
                buttons[i].setForeground(Color.WHITE);
            }
        }
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        displayPanel.add(display);
        
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        int[] buttonOrder = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}; // indices for 1-6, 7-0, +-, */, =.
        
        for (int index : buttonOrder) {
            buttonPanel.add(buttons[index]);
        }
        
        JPanel bottomPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        bottomPanel.add(buttons[16]); // Mod
        bottomPanel.add(buttons[17]); // Keluar
        bottomPanel.add(buttons[18]); // Clear
        bottomPanel.add(buttons[19]); // Del
        
        add(displayPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        try {
            if (command.matches("[0-9]")) {
                if (operatorPressed) {
                    display.setText(command);
                    operatorPressed = false;
                } else {
                    display.setText(display.getText().equals("0") ? command : display.getText() + command);
                }
            }
            
            else if (command.equals(".")) {
                if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                }
            }
            
            else if (command.matches("[+\\-*/]") || command.equals("Mod")) {
                if (!display.getText().isEmpty()) {
                    num1 = Double.parseDouble(display.getText());
                    operator = command.equals("Mod") ? '%' : command.charAt(0);
                    operatorPressed = true;
                }
            }
            
            else if (command.equals("=")) {
                if (!display.getText().isEmpty() && operator != 0) {
                    num2 = Double.parseDouble(display.getText());
                    result = calculate(num1, num2, operator);
                    display.setText(formatResult(result));
                    num1 = result;
                    operator = 0;
                }
            }
            
            else if (command.equals("Clear")) {
                display.setText("0");
                num1 = num2 = result = 0;
                operator = 0;
                operatorPressed = false;
            }
            
            else if (command.equals("Del")) {
                String current = display.getText();
                if (current.length() > 1) {
                    display.setText(current.substring(0, current.length() - 1));
                } else {
                    display.setText("0");
                }
            }
            
            else if (command.equals("Exit")) {
                int option = JOptionPane.showConfirmDialog(this, 
                    "Yakin ingin keluar?", "Konfirmasi", 
                    JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
            
        } catch (NumberFormatException ex) {
            display.setText("Error");
        } catch (ArithmeticException ex) {
            display.setText("Error: " + ex.getMessage());
        }
    }
    
    private double calculate(double n1, double n2, char op) {
        switch (op) {
            case '+': return n1 + n2;
            case '-': return n1 - n2;
            case '*': return n1 * n2;
            case '/': 
                if (n2 == 0) throw new ArithmeticException("Tidak bisa dibagi nol");
                return n1 / n2;
            case '%': return n1 % n2;
            default: return 0;
        }
    }
    
    private String formatResult(double result) {
        if (result == (long) result) {
            return String.valueOf((long) result);
        } else {
            return String.format("%.10g", result);
        }
    }
    
    public static void main(String[] args) {
        new Kalkulator();
    }
}