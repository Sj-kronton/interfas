/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package freetimeflex;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author juana
 */
class BorderFactoryExtension {
    public static javax.swing.border.Border createRoundedBorder(int radius) {
        return new RoundedBorder(radius);
    }
}
public class Jpestaña2 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Jpestaña2.class.getName());
    
    // Colores del diseño
    private static final Color PRIMARY_COLOR = new Color(165, 0, 63); // #A5003F
    private static final Color SECONDARY_COLOR = new Color(188, 66, 113); // #BC4271
    private static final Color WHITE = Color.WHITE;
    private static final Color LIGHT_GRAY = new Color(239, 239, 239);
    
    /**
     * Creates new form Jpestaña2
     */
    public Jpestaña2() {
        initComponents();
        setupCustomDesign();
    }
    
    /**
     * Configura el diseño personalizado después de initComponents
     */
    private void setupCustomDesign() {
        // Configurar la ventana principal
        setTitle("Freetimeflex UNAB");
        setSize(800, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(WHITE);
        setLayout(null);
        
        // Header
        createHeader();
        
        // Barra de progreso
        createProgressSection();
        
        // Sección de próximos eventos
        createEventsSection();
        
        // Calendario
        createCalendarSection();
    }
    
    /**
     * Crea el header de la aplicación
     */
    private void createHeader() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 800, 50);
        headerPanel.setBackground(PRIMARY_COLOR);
        headerPanel.setLayout(null);
        
        // Título de la aplicación
        JLabel titleLabel = new JLabel("Freetimeflex UNAB");
        titleLabel.setBounds(10, 10, 250, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(titleLabel);
        
        // Avatar/Profile circle (simulado con un JLabel)
        JLabel avatarLabel = new JLabel();
        avatarLabel.setBounds(740, 5, 45, 40);
        avatarLabel.setOpaque(true);
        avatarLabel.setBackground(LIGHT_GRAY);
        avatarLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(WHITE, 2),
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
        headerPanel.add(avatarLabel); //<- para que salga la imagen
        add(headerPanel); //<- en teoria lo de antes es para esto, pero ni idea
    }
    
    /**
     * Crea la sección de progreso de horas libres
     */
    private void createProgressSection() {
        // Título del progreso
        JLabel progressTitle = new JLabel("Tu progreso de horas libres");
        progressTitle.setBounds(100, 80, 600, 25);
        progressTitle.setFont(new Font("Arial", Font.BOLD, 18));
        progressTitle.setForeground(PRIMARY_COLOR);
        add(progressTitle);
        
        // Barra de progreso de fondo
        JPanel progressBackground = new JPanel();
        progressBackground.setBounds(90, 110, 366, 35); //
        progressBackground.setBackground(SECONDARY_COLOR/*PRIMARY_COLOR*/);
        add(progressBackground);
        
        // Barra de progreso actual (60%) 
        JPanel progressFill = new JPanel();
        progressFill.setBounds(90, 110, 610, 35);
        progressFill.setBackground(new Color(199,199,199,199)); //239, 239, 239, 60
        add(progressFill);
        
        // Texto de porcentaje
        JLabel percentageLabel = new JLabel("60%");
        percentageLabel.setBounds(710, 115, 70, 25);
        percentageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        percentageLabel.setForeground(SECONDARY_COLOR);
        add(percentageLabel);
    }
    
    /**
     * Crea la sección de próximos eventos
     */
    private void createEventsSection() {
        // Título de próximos eventos
        JLabel eventsTitle = new JLabel("Próximos eventos");
        eventsTitle.setBounds(320, 170, 160, 25);
        eventsTitle.setFont(new Font("Arial", Font.BOLD, 18));
        eventsTitle.setForeground(PRIMARY_COLOR);
        eventsTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(eventsTitle);
        
        // Crear tarjetas de eventos
        createEventCard(60, 205, "UNAB FEST 2025 - Fechas", true);
        createEventCard(295, 205, "Evento 2", false);
        createEventCard(530, 205, "Evento 3", false);
        
        // Flecha de navegación
        JButton nextButton = new JButton("▶");
        nextButton.setBounds(740, 265, 30, 25);
        nextButton.setBackground(PRIMARY_COLOR);
        nextButton.setForeground(WHITE);
        nextButton.setBorder(null);
        add(nextButton);
    }
    
    /**
     * Crea una tarjeta de evento
     */
    private void createEventCard(int x, int y, String title, boolean hasImage) {
        JPanel eventCard = new JPanel();
        eventCard.setBounds(x, y, 200, 150);
        eventCard.setLayout(null);
        
        if (hasImage) {
            // Cargar imagen de fondo
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource("/resources/fest.png"));
                Image img = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                JLabel imageLabel = new JLabel(new ImageIcon(img));
                imageLabel.setBounds(0, 0, 200, 150);
                eventCard.add(imageLabel);
            } catch (Exception e) {
                // Si no se puede cargar la imagen, usar color de fondo
                eventCard.setBackground(LIGHT_GRAY);
            }
        } else {
            eventCard.setBackground(PRIMARY_COLOR);
        }
        
        // Footer de la tarjeta
        JPanel cardFooter = new JPanel();
        cardFooter.setBounds(0, 120, 200, 30);
        cardFooter.setBackground(new Color(165, 0, 63, 174));
        eventCard.add(cardFooter);
        
        // Título del evento
        JLabel eventTitle = new JLabel(title);
        eventTitle.setBounds(10, 130, 180, 15);
        eventTitle.setFont(new Font("Arial", Font.BOLD, 12));
        eventTitle.setForeground(WHITE);
        eventCard.add(eventTitle);
        
        add(eventCard);
    }
    
    /**
     * Crea la sección del calendario
     */
    private void createCalendarSection() {
        // Título del calendario
        JLabel calendarTitle = new JLabel("Calendario de eventos con horas libres");
        calendarTitle.setBounds(170, 380, 460, 35);
        calendarTitle.setFont(new Font("Poppins", Font.BOLD, 23));
        calendarTitle.setForeground(PRIMARY_COLOR);
        calendarTitle.setHorizontalAlignment(SwingConstants.CENTER);
        //calendarTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(calendarTitle);
        
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
        JLabel monthTitle = new JLabel("Mayo 2025");
        monthTitle.setBounds(50, 10, 150, 35);
        monthTitle.setFont(new Font("Poppins", Font.BOLD, 22));
        monthTitle.setForeground(WHITE);
        calendarInner.add(monthTitle);
        
        // Flechas de navegación del calendario
        JButton prevButton = new JButton("◀");
        prevButton.setBounds(30, 100, 25, 70);
        prevButton.setBackground(WHITE);
        prevButton.setForeground(PRIMARY_COLOR);
        prevButton.setBorder(null);
        calendarInner.add(prevButton);
        
        JButton nextCalButton = new JButton("▶");
        nextCalButton.setBounds(645, 100, 25, 70);
        nextCalButton.setBackground(WHITE);
        nextCalButton.setForeground(PRIMARY_COLOR);
        nextCalButton.setBorder(null);
        calendarInner.add(nextCalButton);
        
        // Crear grid del calendario
        createCalendarGrid(calendarInner);
        
        add(calendarContainer);
    }
    
    /**
     * Crea el grid de días del calendario
     */
    private void createCalendarGrid(JPanel parent) {
        // Días especiales que tienen eventos
        int[] eventDays = {14, 15, 16};
        
        int startX = 63;
        int startY = 10;
        int dayWidth = 45;
        int dayHeight = 45;
        int spacingX = 8;
        int spacingY = 8;
        
        // Crear días del calendario (representando Mayo 2025 - empezando en jueves)
        // Mayo 2025 empieza en jueves (día 4 de la semana, 0=domingo)
        int dayNumber = 1;
        
        for (int week = 0; week < 5; week++) {
            for (int day = 0; day < 11; day++) {
                // Solo mostrar días válidos del mes
                if (week == 0 && day < 4) {
                    // Primeros días vacíos (mayo empieza en jueves)
                    continue;
                }
                if (dayNumber > 31) {
                    // No más días en mayo
                    break;
                }
                
                int x = startX + day * (dayWidth + spacingX);
                int y = startY + week * (dayHeight + spacingY);
                
                createCalendarDay(parent, x, y, dayNumber, isEventDay(dayNumber, eventDays));
                dayNumber++;
            }
            if (dayNumber > 31) break;
        }
    }
    
    /**
     * Crea un día individual del calendario
     */
    private void createCalendarDay(JPanel parent, int x, int y, int dayNumber, boolean hasEvent) {
        JPanel dayPanel = new JPanel();
        dayPanel.setBounds(x, y, 45, 45);
        dayPanel.setLayout(null);
        
        if (hasEvent) {
            dayPanel.setBackground(PRIMARY_COLOR);
        } else {
            dayPanel.setBackground(WHITE);
        }
        
        JLabel dayLabel = new JLabel(String.valueOf(dayNumber));
        dayLabel.setBounds(0, 0, 45, 45);
        dayLabel.setFont(new Font("Arial", Font.BOLD, 16));
        dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dayLabel.setVerticalAlignment(SwingConstants.CENTER);
        
        if (hasEvent) {
            dayLabel.setForeground(WHITE);
        } else {
            dayLabel.setForeground(PRIMARY_COLOR);
        }
        
        dayPanel.add(dayLabel);
        parent.add(dayPanel);
    }
    
    /**
     * Verifica si un día tiene eventos
     */
    private boolean isEventDay(int day, int[] eventDays) {
        for (int eventDay : eventDays) {
            if (day == eventDay) return true;
        }
        return false;
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
        java.awt.EventQueue.invokeLater(() -> new Jpestaña2().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

class RoundedBorder implements javax.swing.border.Border {
    private int radius;
    
    public RoundedBorder(int radius) {
        this.radius = radius;
    }
    
    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius + 1, radius + 1, radius + 2, radius);
    }
    
    @Override
    public boolean isBorderOpaque() {
        return true;
    }
    
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(c.getBackground());
        g2.fillRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2.dispose();
    }
}
/**
 * Extension para BorderFactory con bordes redondeados
 */
