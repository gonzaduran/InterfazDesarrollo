package Interfaz;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal {
    private JFrame frame;
    private JPanel panelPrincipal; // Mantener para NetBeans
    private JTextField usuarioField, nombreField, correoField;
    private JPasswordField passwordField, registroPasswordField;
    private JCheckBox terminosCheckBox, registroTerminos;
    private JButton accederButton, registrarButton;
    private JComboBox<String> idiomaComboBox;
    private JRadioButton recordarRadioButton;

    public MenuPrincipal() {
        frame = new JFrame("Login - Menu Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 650);

        // Pestañas
        JTabbedPane pestañas = new JTabbedPane();
        pestañas.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pestañas.setBackground(new Color(245, 245, 250));
        pestañas.setForeground(new Color(25, 25, 112));

        // Panel Principal Login
        panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelLogin = crearPanelLogin();
        panelPrincipal.add(panelLogin, BorderLayout.CENTER);
        pestañas.addTab("Login", panelPrincipal);

        // Panel Principal Registro
        JPanel panelPrincipalRegistro = new JPanel(new BorderLayout());
        JPanel panelRegistro = crearPanelRegistro();
        panelPrincipalRegistro.add(panelRegistro, BorderLayout.CENTER);
        pestañas.addTab("Registro", panelPrincipalRegistro);

        frame.setContentPane(pestañas);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel crearPanelLogin() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(138, 43, 226),
                        0, getHeight(), new Color(25, 25, 112));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);

        JPanel contenido = new JPanel(new GridBagLayout());
        contenido.setBackground(new Color(255, 255, 255, 240));
        contenido.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(10, 10, 10, 10);

        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 22);
        Font fuenteTexto = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteBoton = new Font("Segoe UI", Font.BOLD, 16);

        // Logo
        JLabel logo = new JLabel();
        ImageIcon icon = new ImageIcon("ruta/logo.png"); // <-- Pon tu logo aquí
        Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(img));
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.gridwidth = 2;
        contenido.add(logo, gbc2);

        // Título
        JLabel titulo = new JLabel("Bienvenido al sistema");
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(new Color(25, 25, 112));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc2.gridy++;
        contenido.add(titulo, gbc2);

        // Separador decorativo
        JPanel barra = new JPanel();
        barra.setBackground(new Color(138, 43, 226));
        barra.setPreferredSize(new Dimension(200, 4));
        gbc2.gridy++;
        contenido.add(barra, gbc2);

        // Usuario
        gbc2.gridwidth = 1;
        gbc2.gridy++;
        contenido.add(new JLabel("Usuario:"), gbc2);
        usuarioField = crearCampoTexto();
        gbc2.gridx = 1;
        contenido.add(usuarioField, gbc2);

        // Contraseña
        gbc2.gridx = 0;
        gbc2.gridy++;
        contenido.add(new JLabel("Contraseña:"), gbc2);
        passwordField = crearCampoTextoContraseña();
        gbc2.gridx = 1;
        contenido.add(passwordField, gbc2);

        // Idioma
        gbc2.gridx = 0;
        gbc2.gridy++;
        contenido.add(new JLabel("Idioma:"), gbc2);
        idiomaComboBox = new JComboBox<>(new String[]{"Español", "Inglés", "Francés"});
        idiomaComboBox.setFont(fuenteTexto);
        idiomaComboBox.setBackground(Color.WHITE);
        idiomaComboBox.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true));
        gbc2.gridx = 1;
        contenido.add(idiomaComboBox, gbc2);

        // Recordar
        gbc2.gridx = 0;
        gbc2.gridy++;
        contenido.add(new JLabel("Recordar usuario:"), gbc2);
        recordarRadioButton = new JRadioButton();
        recordarRadioButton.setBackground(new Color(255, 255, 255, 240));
        gbc2.gridx = 1;
        contenido.add(recordarRadioButton, gbc2);

        // Términos
        gbc2.gridx = 1;
        gbc2.gridy++;
        terminosCheckBox = new JCheckBox("Acepto los términos");
        terminosCheckBox.setFont(fuenteTexto);
        terminosCheckBox.setBackground(new Color(255, 255, 255, 240));
        contenido.add(terminosCheckBox, gbc2);

        // Botón acceder
        gbc2.gridx = 0;
        gbc2.gridy++;
        gbc2.gridwidth = 2;
        accederButton = crearBoton("Acceder", new Color(0, 122, 204), fuenteBoton);
        contenido.add(accederButton, gbc2);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(contenido, gbc);

        return panel;
    }

    private JPanel crearPanelRegistro() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 153, 76),
                        0, getHeight(), new Color(135, 206, 250));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);

        JPanel contenido = new JPanel(new GridBagLayout());
        contenido.setBackground(new Color(255, 255, 255, 240));
        contenido.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(10, 10, 10, 10);

        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 22);
        Font fuenteTexto = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteBoton = new Font("Segoe UI", Font.BOLD, 16);

        // Logo
        JLabel logo = new JLabel();
        ImageIcon icon = new ImageIcon("ruta/logo.png"); // <- reemplaza con tu logo
        Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(img));
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.gridwidth = 2;
        contenido.add(logo, gbc2);

        // Título Registro
        JLabel titulo = new JLabel("Registro de usuario");
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(new Color(25, 25, 112));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc2.gridy++;
        contenido.add(titulo, gbc2);

        // Separador decorativo
        JPanel barra = new JPanel();
        barra.setBackground(new Color(0, 153, 76));
        barra.setPreferredSize(new Dimension(200, 4));
        gbc2.gridy++;
        contenido.add(barra, gbc2);

        // Nombre
        gbc2.gridwidth = 1;
        gbc2.gridy++;
        contenido.add(new JLabel("Nombre:"), gbc2);
        nombreField = crearCampoTexto();
        gbc2.gridx = 1;
        contenido.add(nombreField, gbc2);

        // Correo
        gbc2.gridx = 0;
        gbc2.gridy++;
        contenido.add(new JLabel("Correo electrónico:"), gbc2);
        correoField = crearCampoTexto();
        gbc2.gridx = 1;
        contenido.add(correoField, gbc2);

        // Contraseña
        gbc2.gridx = 0;
        gbc2.gridy++;
        contenido.add(new JLabel("Contraseña:"), gbc2);
        registroPasswordField = crearCampoTextoContraseña();
        gbc2.gridx = 1;
        contenido.add(registroPasswordField, gbc2);

        // Edad
        gbc2.gridx = 0;
        gbc2.gridy++;
        contenido.add(new JLabel("Edad:"), gbc2);
        JSlider edadSlider = new JSlider(18, 100, 25);
        edadSlider.setMajorTickSpacing(10);
        edadSlider.setPaintTicks(true);
        edadSlider.setPaintLabels(true);
        gbc2.gridx = 1;
        contenido.add(edadSlider, gbc2);

        // Términos
        gbc2.gridx = 1;
        gbc2.gridy++;
        registroTerminos = new JCheckBox("Acepto los términos");
        registroTerminos.setBackground(new Color(255, 255, 255, 240));
        contenido.add(registroTerminos, gbc2);

        // Barra de progreso
        gbc2.gridx = 0;
        gbc2.gridy++;
        contenido.add(new JLabel("Progreso de registro:"), gbc2);
        JProgressBar barraCarga = new JProgressBar();
        barraCarga.setValue(0);
        barraCarga.setStringPainted(true);
        gbc2.gridx = 1;
        contenido.add(barraCarga, gbc2);

        // Botón registrar
        gbc2.gridx = 0;
        gbc2.gridy++;
        gbc2.gridwidth = 2;
        registrarButton = crearBoton("Registrarse", new Color(0, 153, 76), fuenteBoton);
        contenido.add(registrarButton, gbc2);

        registrarButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            String correo = correoField.getText();
            String contraseña = new String(registroPasswordField.getPassword());
            int edad = edadSlider.getValue();
            boolean acepta = registroTerminos.isSelected();

            if (nombre.isEmpty() || correo.isEmpty() || contraseña.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, completa todos los campos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!acepta) {
                JOptionPane.showMessageDialog(frame, "Debes aceptar los términos para registrarte.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            barraCarga.setValue(100);
            JOptionPane.showMessageDialog(frame, "Registro completado con éxito.\nNombre: " + nombre +
                            "\nCorreo: " + correo + "\nEdad: " + edad + " años",
                    "Registro", JOptionPane.INFORMATION_MESSAGE);
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(contenido, gbc);

        return panel;
    }

    private JTextField crearCampoTexto() {
        JTextField campo = new JTextField(15);
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        return campo;
    }

    private JPasswordField crearCampoTextoContraseña() {
        JPasswordField campo = new JPasswordField(15);
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        return campo;
    }

    private JButton crearBoton(String texto, Color color, Font fuente) {
        JButton boton = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isArmed() ? color.darker() : color);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        boton.setFont(fuente);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setOpaque(false);
        return boton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuPrincipal::new);

    }}
