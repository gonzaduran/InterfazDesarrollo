package Clase1;

import javax.swing.*;
import java.awt.*;

public class Clase1 {
    private JFrame frame;
    private JPanel panelPrincipal;
    private JTextField usuarioField;
    private JPasswordField passwordField;
    private JCheckBox terminosCheckBox;
    private JButton accederButton;
    private JComboBox<String> idiomaComboBox;
    private JRadioButton recordarRadioButton;

    public Clase1() {
        frame = new JFrame("Login Simplificado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);

        // Panel principal con layout vertical
        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(245, 245, 250));
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Logo de la aplicación
        JLabel logoLabel = new JLabel("BIENVENIDO");
        logoLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        logoLabel.setForeground(new Color(25, 25, 112));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(logoLabel);

        // Separador decorativo
        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(138, 43, 226));
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 3));
        sep.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(sep);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 15)));

        // Usuario
        JPanel usuarioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        usuarioPanel.setBackground(panelPrincipal.getBackground());
        usuarioPanel.add(new JLabel("Usuario:"));
        usuarioField = new JTextField(15);
        usuarioPanel.add(usuarioField);
        panelPrincipal.add(usuarioPanel);

        // Contraseña
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.setBackground(panelPrincipal.getBackground());
        passwordPanel.add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField(15);
        passwordPanel.add(passwordField);
        panelPrincipal.add(passwordPanel);

        // Idioma
        JPanel idiomaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idiomaPanel.setBackground(panelPrincipal.getBackground());
        idiomaPanel.add(new JLabel("Idioma:"));
        idiomaComboBox = new JComboBox<>(new String[]{"Español", "Inglés", "Francés"});
        idiomaPanel.add(idiomaComboBox);
        panelPrincipal.add(idiomaPanel);

        // Recordar usuario
        JPanel recordarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        recordarPanel.setBackground(panelPrincipal.getBackground());
        recordarRadioButton = new JRadioButton("Recordar usuario");
        recordarRadioButton.setBackground(panelPrincipal.getBackground());
        recordarPanel.add(recordarRadioButton);
        panelPrincipal.add(recordarPanel);

        // Aceptar términos
        terminosCheckBox = new JCheckBox("Acepto los términos y condiciones");
        terminosCheckBox.setBackground(panelPrincipal.getBackground());
        terminosCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(terminosCheckBox);

        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 20)));

        // Botón acceder
        accederButton = new JButton("Acceder");
        accederButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        accederButton.setBackground(new Color(0, 122, 204));
        accederButton.setForeground(Color.WHITE);
        accederButton.setFocusPainted(false);
        panelPrincipal.add(accederButton);

        // Mostrar ventana
        frame.setContentPane(panelPrincipal);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Clase1::new);
    }
}
