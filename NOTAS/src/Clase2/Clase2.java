package Clase2;

import javax.swing.*;
import java.awt.*;

public class Clase2 {
    private JFrame frame;
    private JPanel panelPrincipal;
    private JTextField usuarioField;
    private JPasswordField passwordField;
    private JCheckBox terminosCheckBox;
    private JButton accederButton;

    public Clase2() {
        frame = new JFrame("Login Clásico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);

        // Panel principal
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        panelPrincipal.setBackground(new Color(240, 240, 240));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Logo (texto simple)
        JLabel logoLabel = new JLabel("BIENVENIDO", SwingConstants.CENTER);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        logoLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelPrincipal.add(logoLabel, gbc);

        // Usuario
        gbc.gridwidth = 1;
        gbc.gridy++;
        panelPrincipal.add(new JLabel("Usuario:"), gbc);
        gbc.gridx = 1;
        usuarioField = new JTextField(15);
        panelPrincipal.add(usuarioField, gbc);

        // Contraseña
        gbc.gridx = 0;
        gbc.gridy++;
        panelPrincipal.add(new JLabel("Contraseña:"), gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        panelPrincipal.add(passwordField, gbc);

        // Aceptar términos
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        terminosCheckBox = new JCheckBox("Acepto los términos");
        panelPrincipal.add(terminosCheckBox, gbc);

        // Botón Acceder
        gbc.gridy++;
        accederButton = new JButton("Acceder");
        panelPrincipal.add(accederButton, gbc);

        // Configurar ventana
        frame.setContentPane(panelPrincipal);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Clase2::new);
    }
}
