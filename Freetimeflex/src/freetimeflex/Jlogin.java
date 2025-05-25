/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package freetimeflex;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
/**
 *
 * @author juana
 */
public class Jlogin extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Jlogin.class.getName());

    /**
     * Creates new form Jlogin
     */
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private JLabel registerLabel;
    private BufferedImage edificioImg;
    private BufferedImage unabImg;
    private BufferedImage windowsImg;
    private BufferedImage edgeImg;    
    
    
    
    public Jlogin() {
        initComponents();
        setupCustomDesign();
        loadImages();
    }
    private void setupCustomDesign() {
        // Configurar la ventana - reducido a la mitad
        setSize(800, 595/*700*/);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        
        // Usar layout absoluto para posicionamiento preciso
        setLayout(null);
        
        // Crear y posicionar componentes
        createLoginPanel();
        createFooterBar();
    }
    
    private void createLoginPanel() {
        // Panel de login con sombra - dimensiones reducidas a la mitad
        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Sombra del panel de login
                g2d.setColor(new Color(51, 51, 51, 194)); // #333333 con opacity 0.76
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                
                g2d.dispose();
            }
        };
        loginPanel.setBounds(64, 110, 301, 306);
        loginPanel.setOpaque(false);
        loginPanel.setLayout(null);
        
        // Título "Freetimeflex UNAB"
        JLabel titleLabel = new JLabel("<html><div style='text-align: center;'>Freetimeflex<br>UNAB</div></html>");
        titleLabel.setBounds(54, 8, 199, 80); // Relativo al panel de login
        titleLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginPanel.add(titleLabel);
        
        // Label "Usuario"
        JLabel userLabel = new JLabel("Usuario");
        userLabel.setBounds(54, 88, 204, 26); // Relativo al panel de login
        userLabel.setFont(new Font("Open Sans", Font.BOLD, 16));
        userLabel.setForeground(new Color(255, 255, 255, 212)); // opacity 0.83
        loginPanel.add(userLabel);
        
        // Campo de usuario
        userField = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Fondo del campo
                g2d.setColor(new Color(217, 217, 217, 107)); // opacity 0.42
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
                
                // Borde
                g2d.setColor(Color.BLACK);
                g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 12, 12);
                
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        userField.setBounds(54, 114, 204, 31); // Relativo al panel de login
        userField.setOpaque(false);
        userField.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        userField.setFont(new Font("Open Sans", Font.PLAIN, 9));
        loginPanel.add(userField);
        
        // Label "Contraseña"
        JLabel passLabel = new JLabel("Contraseña");
        passLabel.setBounds(54, 160, 199, 27); // Relativo al panel de login
        passLabel.setFont(new Font("Open Sans", Font.BOLD, 16));
        passLabel.setForeground(new Color(255, 255, 255, 212)); // opacity 0.83
        loginPanel.add(passLabel);
        
        // Campo de contraseña
        passField = new JPasswordField() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Fondo del campo
                g2d.setColor(new Color(217, 217, 217, 107)); // opacity 0.42
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
                
                // Borde
                g2d.setColor(Color.BLACK);
                g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 12, 12);
                
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        passField.setBounds(54, 186, 204, 31); // Relativo al panel de login
        passField.setOpaque(false);
        passField.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        passField.setFont(new Font("Open Sans", Font.PLAIN, 9));
        loginPanel.add(passField);
        
        // Botón "Iniciar sesión"
        loginButton = new JButton("Iniciar sesión") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Fondo del botón      //217, 217, 217, 219
                GradientPaint gradient = new GradientPaint(
                    //0, 0, new Color(204, 23, 23, 138),
                    //getWidth(), getHeight(), new Color(150, 15, 15, 138)
                    0, 0, new Color(230, 230, 230, 219),
                    -4, getHeight(), new Color(204, 23, 23, 138)
                );
                g2d.setPaint(gradient);
                g2d.fillRoundRect(1, 7, getWidth(), getHeight(), 10, 10);
                
                // "Sombra" del botón                //204, 23, 23, 138
                g2d.setColor(new Color(217, 217, 217, 219)); // rgba(204, 23, 23, 0.54)
                g2d.fillRoundRect(0, 0, getWidth()-1, getHeight()-7, 10, 10);
                
                // Borde
                g2d.setColor(Color.BLACK);
                g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-7, 10, 10);
                
                g2d.dispose();
                super.paintComponent(g);
            }
        }; //89, 230, 150, 34
        loginButton.setBounds(80, 230, 150, 34); // Relativo al panel de login
        loginButton.setOpaque(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);
        loginButton.setFont(new Font("Poppins", Font.BOLD, 16));
        loginButton.setForeground(new Color(165, 0, 63)); // #A5003F
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(loginButton);//crear una clase que reconozca este jframe para ocultarlo
                Jpestaña2 mForm2 = new Jpestaña2(); //convertir boton en clickeable
                mForm2.setVisible(true);
                currentFrame.setVisible(false);//ocultar el jframe con la, bueno no seria clase, pero la cosa esa porque no se porque de otra forma no parece poderse hacer
                //Jlogin mForm1 = new Jlogin();
                //y que mande a la segunda pestaña
            }

        });  //Advertencia, esto solo es una prueba, le faltaria ponerle un if para comprobar si en
        //los cuadros de texto si se encuentra el login y la contraseña correctas, ademas de un mensaje si son incorrectas
        loginPanel.add(loginButton);
        
        // Label "¿Aun sin cuenta? Registrate"
        registerLabel = new JLabel("¿Aun sin cuenta? Registrate");
        registerLabel.setBounds(72, 277, 167, 13); // Relativo al panel de login
        registerLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
        registerLabel.setForeground(Color.WHITE);
        loginPanel.add(registerLabel);
        
        add(loginPanel);
    }
    private void createFooterBar() {
        // Barra del footer
        JPanel footerBar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                
                // Gradiente de la barra
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(102, 69, 148), // #664594
                    getWidth(), 0, new Color(93, 0, 0) // #5D0000
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                
                g2d.dispose();
            }
        };
        footerBar.setBounds(-2, 526, 866, 33);
        footerBar.setLayout(null);
        
        // Crear iconos de la barra de tareas (simulados con rectángulos de colores)
        createTaskbarIcons(footerBar);
        
        add(footerBar);
    }
    private void createTaskbarIcons(JPanel footerBar) {
        // Icono de Windows (simulado)
        JPanel windowsIcon = new JPanel();
        windowsIcon.setBounds(388, 7, 20, 19); // Ajustado relativo a footerBar
        windowsIcon.setBackground(new Color(0, 120, 215)); // Color azul de Windows
        footerBar.add(windowsIcon);
        
        // Icono de Edge (simulado)
        JPanel edgeIcon = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(0, 120, 215));
                g2d.fillOval(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        edgeIcon.setBounds(422, 5, 23, 23); // Ajustado relativo a footerBar
        footerBar.add(edgeIcon);
        
        // Icono de carpeta (simulado con múltiples colores)
        createFolderIcon(footerBar);
    }
    
    private void createFolderIcon(JPanel footerBar) {
        // seccionFolder4 - Base amarilla
        JPanel folder4 = new JPanel();
        folder4.setBounds(459, 11, 20, 13); // Ajustado relativo a footerBar
        folder4.setBackground(new Color(255, 204, 65)); // #FFCC41
        footerBar.add(folder4);
        
        // seccionFolder3 - Pestaña azul
        JPanel folder3 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(new Color(13, 131, 209)); // #0D83D1
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 4, 4);
                g2d.dispose();
            }
        };
        folder3.setBounds(464, 20, 11, 4); // Ajustado relativo a footerBar
        folder3.setOpaque(false);
        footerBar.add(folder3);
        
        // seccionFolder2 - Línea azul oscura
        JPanel folder2 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(new Color(17, 74, 139)); // #114A8B
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 1, 1);
                g2d.dispose();
            }
        };
        folder2.setBounds(466, 22, 7, 1); // Ajustado relativo a footerBar
        folder2.setOpaque(false);
        footerBar.add(folder2);
        
        // seccionFolder1 - Pestaña naranja
        JPanel folder1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(new Color(224, 159, 0)); // #E09F00
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 3, 3);
                g2d.dispose();
            }
        };
        folder1.setBounds(459, 9, 10, 4); // Ajustado relativo a footerBar
        folder1.setOpaque(false);
        footerBar.add(folder1);
    }
    
private void loadImages() {
    try {
        edificioImg = ImageIO.read(getClass().getResourceAsStream("/resources/Edificio-Armando-Puyana-Puyana.png"));
        unabImg = ImageIO.read(getClass().getResourceAsStream("/resources/unab.png"));
        windowsImg = ImageIO.read(getClass().getResourceAsStream("/resources/Icono Windows.png"));
        edgeImg = ImageIO.read(getClass().getResourceAsStream("/resources/image.png"));
    } catch (Exception e) {
        System.out.println("No se pudieron cargar las imágenes: " + e.getMessage());
    }
}
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Dibujar la imagen del edificio o un color de fondo
        if (edificioImg != null) {
            g2d.drawImage(edificioImg, 432, 0, 432, 557, null);  //432, 0, 432, 526, null <- configuracion original por si las moscas
        } else {
            // Simular la imagen con un gradiente
            GradientPaint buildingBg = new GradientPaint(
                432, 0, new Color(100, 100, 150),
                432 + 216, 263, new Color(50, 50, 100)
            );
            g2d.setPaint(buildingBg);
            g2d.fillRect(432, 0, 432, 526);
        }
        
        // Sombra sobre la imagen del edificio //quitar esta vaina
        //g2d.setColor(new Color(0, 0, 0, 143)); // rgba(0, 0, 0, 0.56)
        //g2d.fillRect(432, 0, 432, 526);
        
        // Dibujar logo UNAB si está disponible
        if (unabImg != null) {
            g2d.drawImage(unabImg, 18, 30, 46, 51, null);
        } else {
            // Simular logo con un círculo
            g2d.setColor(new Color(165, 0, 63));
            g2d.fillOval(18, 16, 46, 51);
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 8));
            g2d.drawString("UNAB", 28, 43);
        }
        
        g2d.dispose();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Jlogin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
