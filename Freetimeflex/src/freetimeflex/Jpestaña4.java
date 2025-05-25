/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package freetimeflex;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author juana
 */


    /**
     * Creates new form Jpestaña3
     */
public class Jpestaña4 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Jpestaña3.class.getName());
    private static final Color LIGHT_GRAY = new Color(239, 239, 239);
    // Componentes adicionales
    private JPanel headerPanel;
    private JLabel titleLabel;
    private JLabel userIconLabel;
    private JLabel progressTitleLabel;
    private JPanel progressBarBackground;
    private JPanel progressBarFill;
    private JLabel progressPercentLabel;
    private JLabel freeHoursLabel;
    private JPanel detailsPanel;
    private JLabel detailsTitleLabel;
    private JLabel completedHoursLabel;
    private JLabel completedHoursValue;
    private JLabel requiredHoursLabel;
    private JLabel requiredHoursValue;
    private JLabel linkDescriptionLabel;
    private JLabel linkLabel;
    private JLabel calendarTitleLabel;
    private JPanel calendarPanel;
    private JPanel calendarBackground;
    private JLabel monthLabel;
    private JButton prevButton;
    private JButton nextButton;
    private JButton[] dayButtons;
    
    // Colores personalizados
    private final Color PRIMARY_COLOR = new Color(165, 0, 63); // #A5003F
    private final Color SECONDARY_COLOR = new Color(251, 118, 169); // #FB76A9
    private final Color BACKGROUND_COLOR = Color.WHITE;
    private final Color WHITE = Color.WHITE;
    private final Color CALENDAR_BG = new Color(188, 66, 113); // #BC4271
    
    /**
     * Creates new form Jpestaña3
     */
    public Jpestaña4() {
        initComponents();
        setupCustomDesign();
    }
    
    private void setupCustomDesign() {
        // Configurar ventana principal
        setTitle("FreeTimeFlex UNAB");
        setSize(800, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(BACKGROUND_COLOR);
        getContentPane().setLayout(null);
        
        createHeaderPanel();
        createCalendarSection();
        createImagePanel();
    }
    private void createImagePanel(){
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/resources/fest.png"));
            Image img = icon.getImage();
        int maxWidth = 600;
        int maxHeight = 800;
        double scaleFactor = 1.7;
        
        // Calcular nuevas dimensiones
        int newWidth = (int)(img.getWidth(null) * scaleFactor);
        int newHeight = (int)(img.getHeight(null) * scaleFactor);
        
        if (newWidth > maxWidth) {
            newHeight = (int) ((double) newHeight * maxWidth / newWidth);
            newWidth = maxWidth;
        }
        if (newHeight > maxHeight) {
            newWidth = (int) ((double) newWidth * maxHeight / newHeight);
            newHeight = maxHeight;
        }
        
        Double aya =1.5;
        img = img.getScaledInstance(newWidth*(1), (newHeight)*(1), Image.SCALE_SMOOTH);
        
        // Crear panel para la imagen
        JPanel imagePanel = new JPanel();
        imagePanel.setBounds(0, 60, 800, 350); //no olvidar estas medidas para objetos entre el header (50px) y el calendario (425px)
        imagePanel.setLayout(new GridBagLayout()); //imagen centrada
        
        // Crear label con la imagen
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imagePanel.add(imageLabel);
        
        add(imagePanel);
    } catch (Exception e) {
        System.err.println("Error al cargar la imagen: " + e.getMessage()); //<- por si acas
    }
}
    private void createHeaderPanel() {
        // Panel header principal
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 800, 50);
        headerPanel.setBackground(PRIMARY_COLOR);
        headerPanel.setLayout(null);
        
        // Título principal
        titleLabel  = new JLabel("Freetimeflex UNAB");
        titleLabel.setBounds(10, 10, 250, 30);
        titleLabel.setFont(new Font("Poppins", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Icono de usuario (simulado con un círculo)
        JLabel avatarLabel = new JLabel();
        avatarLabel.setBounds(740, 5, 45, 40);
        avatarLabel.setOpaque(true);
        avatarLabel.setBackground(new Color(239, 239, 239));
        avatarLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 2),
            BorderFactory.createEmptyBorder(3, 3, 3, 3)
        ));
        // Hacer el avatar circular (aproximado)
        //avatarLabel.setText("perfil");
        //avatarLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //avatarLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        //headerPanel.add(avatarLabel);
        
        //ImageIcon icon = new ImageIcon(getClass().getResource("/resources/fest.png"));
        
        //cargar imagen
        ImageIcon perfilIcon = new ImageIcon(getClass().getResource("/resources/perfil.png"));
        
        Image img = perfilIcon.getImage().getScaledInstance(
            avatarLabel.getWidth() - 10, // ancho del label menos el padding
            avatarLabel.getHeight() - 10, // alto del label menos el padding
            Image.SCALE_SMOOTH
        );
        avatarLabel.setIcon(new ImageIcon(img));
        avatarLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        userIconLabel = new JLabel();
        headerPanel.add(avatarLabel); //<- para que salga la imagen
        headerPanel.add(titleLabel);
        headerPanel.add(userIconLabel);
        add(headerPanel);
    }
    
    
    
    
    
    
    private void createCalendarSection() {
        // Título del calendario z- oignorar
        
        
        // Contenedor del calendario
        JPanel calendarContainer = new JPanel();
        calendarContainer.setBounds(25, 425, 750, 250); //25, 425, 750, 250
        calendarContainer.setBackground(PRIMARY_COLOR);
        calendarContainer.setLayout(null);
        
        // Fondo interno del calendario
        JPanel calendarInner = new JPanel();
        calendarInner.setBounds(25, 15, 700, 220);
        calendarInner.setBackground(new Color(255, 255, 255, 66));
        calendarInner.setLayout(null);
        calendarContainer.add(calendarInner);
        
        // Título del mes
        JLabel monthTitle = new JLabel("Descripción del evento");
        monthTitle.setBounds(50, 10, 800, 35);
        monthTitle.setFont(new Font("Poppins", Font.BOLD, 23));
        monthTitle.setForeground(WHITE);
        calendarInner.add(monthTitle);
        
        
        JLabel parrafo = new JLabel("Descripcion del evento con enlaces Lorem ipsum dolor sit amet cons");
        parrafo.setBounds(50, 40, 800, 37);
        parrafo.setFont(new Font("Poppins", Font.BOLD, 18));
        parrafo.setForeground(WHITE);
        calendarInner.add(parrafo);
        
        JLabel enlace = new JLabel("Enlace a la pagina del evento");
        enlace.setBounds(50, 180, 800, 35);
        enlace.setFont(new Font("Poppins", Font.ITALIC, 14));
        enlace.setForeground(Color.CYAN);
        calendarInner.add(enlace);
        
        calendarInner.add(enlace);
        calendarInner.add(parrafo);
        add(calendarContainer);
    }
    
    /**
     * Crea el grid de días del calendario
     */
              
               
                
    
    /**
     * Crea un día individual del calendario
     */
    
    
    /**
     * Verifica si un día tiene eventos
     */
    
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
        java.awt.EventQueue.invokeLater(() -> new Jpestaña4().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
