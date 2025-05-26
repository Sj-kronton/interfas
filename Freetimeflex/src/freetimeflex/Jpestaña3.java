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
public class Jpestaña3 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Jpestaña3.class.getName());
    
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
    public Jpestaña3() {
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
        createProgressSection();
        createFreeHoursSection();
        createDetailsPanel();
        createCalendarSection();
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
    
    private void createProgressSection() {
        // Título del progreso
        JLabel progressTitle = new JLabel("Tu progreso de horas libres");
        progressTitle.setBounds(100, 64, 600, 25); //(42, 142, 200, 30)
        progressTitle.setFont(new Font("Arial", Font.BOLD, 18));
        progressTitle.setForeground(new Color(165, 0, 63));
        add(progressTitle);
        
        // Barra de progreso de fondo
        JPanel progressBackground = new JPanel();
        progressBackground.setBounds(90, 90, 366, 35); //
        progressBackground.setBackground(new Color(188, 66, 113)/*PRIMARY_COLOR*/);
        progressBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(progressBackground);
        
        // Barra de progreso actual (60%) 
        JPanel progressFill = new JPanel();
        progressFill.setBounds(90, 90, 610, 35);
        progressFill.setBackground(new Color(199,199,199,199)); //239, 239, 239, 60
        progressFill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        progressFill.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(progressFill);//crear una clase que reconozca este jframe para ocultarlo
                JHome mForm2 = new JHome(); //convertir boton en clickeable
                mForm2.setVisible(true);
                currentFrame.setVisible(false);//ocultar el jframe con la, bueno no seria clase, pero la cosa esa porque no se porque de otra forma no parece poderse hacer
                //Jlogin mForm1 = new Jlogin();
                //y que mande a la segunda pestaña
            }
        });
        add(progressFill);
        
        // Texto de porcentaje
        JLabel percentageLabel = new JLabel("60%");
        percentageLabel.setBounds(710, 94, 70, 25);
        percentageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        percentageLabel.setForeground(new Color(188, 66, 113));
        add(percentageLabel);
    }

    
//ayuda esta mierda me tiene los ojos secos de cuadrar y recueadrar donde ponerlo
private void createFreeHoursSection() {
    // Título de horas libres (reducido 1/6 ≈16.66%)
    freeHoursLabel = new JLabel("Tus horas libres:");
    freeHoursLabel.setBounds(90, 128, 200, 30); // Original: 50,170,240,36 → Reducción 1/6 (42, 142, 200, 30)
    freeHoursLabel.setFont(new Font("Poppins", Font.BOLD, 18)); // Original: 22 → Reducción 1/6
    freeHoursLabel.setForeground(PRIMARY_COLOR);
    
    add(freeHoursLabel);
}

private void createDetailsPanel() {
    // Panel principal de detalles (reducido 1/6)
    detailsPanel = new JPanel();
    detailsPanel.setBounds(138, 157, 517, 213); // Original: 95,220,620,255 → Reducción 1/6
    detailsPanel.setBackground(PRIMARY_COLOR);
    detailsPanel.setLayout(null);
    detailsPanel.setBorder(BorderFactory.createEmptyBorder());
    
    // Título del panel (reducido 1/6)
    detailsTitleLabel = new JLabel("Tu progreso de horas libres:");
    detailsTitleLabel.setBounds(13, 13, 475, 18); // Original: 15,15,570,22 → Reducción 1/6
    detailsTitleLabel.setFont(new Font("Poppins", Font.BOLD, 13)); // Original: 16 → Reducción 1/6
    detailsTitleLabel.setForeground(Color.WHITE);
    
    // Panel interno con borde (reducido 1/6)
    JPanel innerPanel = new JPanel();
    innerPanel.setBounds(13, 42, 475, 154); // Original: 15,50,570,185 → Reducción 1/6
    innerPanel.setBackground(new Color(188, 66, 113, 46));
    innerPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3)); // Mantengo 3px (borde fino)
    innerPanel.setLayout(null);
    
    // Líneas divisorias (reducido 1/6)
    JSeparator line1 = new JSeparator();
    line1.setBounds(0, 50, 475, 3); // Original: 0,60,570,3 → Reducción 1/6
    line1.setBackground(Color.WHITE);
    line1.setForeground(Color.WHITE);
    
    JSeparator line2 = new JSeparator();
    line2.setBounds(0, 104, 475, 3); // Original: 0,125,570,3 → Reducción 1/6
    line2.setBackground(Color.WHITE);
    line2.setForeground(Color.WHITE);
    
    // Horas cumplidas (reducido 1/6)
    completedHoursLabel = new JLabel("Horas cumplidas:");
    completedHoursLabel.setBounds(13, 13, 167, 18); // Original: 15,15,200,22 → Reducción 1/6
    completedHoursLabel.setFont(new Font("Open Sans", Font.BOLD, 13)); // Original: 16 → Reducción 1/6
    completedHoursLabel.setForeground(Color.WHITE);
    
    completedHoursValue = new JLabel("34");
    completedHoursValue.setBounds(392, 8, 67, 33); // Original: 470,10,80,40 → Reducción 1/6
    completedHoursValue.setFont(new Font("Open Sans", Font.BOLD, 25)); // Original: 30 → Reducción 1/6
    completedHoursValue.setForeground(Color.WHITE);
    completedHoursValue.setHorizontalAlignment(SwingConstants.CENTER);
    
    // Horas requeridas (reducido 1/6)
    requiredHoursLabel = new JLabel("Horas requeridas:");
    requiredHoursLabel.setBounds(13, 67, 167, 18); // Original: 15,80,200,22 → Reducción 1/6
    requiredHoursLabel.setFont(new Font("Open Sans", Font.BOLD, 13)); // Original: 16 → Reducción 1/6
    requiredHoursLabel.setForeground(Color.WHITE);
    
    requiredHoursValue = new JLabel("90");
    requiredHoursValue.setBounds(392, 63, 67, 33); // Original: 470,75,80,40 → Reducción 1/6
    requiredHoursValue.setFont(new Font("Open Sans", Font.BOLD, 25)); // Original: 30 → Reducción 1/6
    requiredHoursValue.setForeground(Color.WHITE);
    requiredHoursValue.setHorizontalAlignment(SwingConstants.CENTER);
    
    // Descripción del enlace (reducido 1/6)
    linkDescriptionLabel = new JLabel("Si quiere ver en más detalles su registro de horas libres haga click en el siguiente");
    linkDescriptionLabel.setBounds(13, 120, 333, 17); // Original: 15,140,400,20 → Reducción 1/6
    linkDescriptionLabel.setFont(new Font("Open Sans", Font.BOLD, 8)); // Original: 12 → Reducción 1/6
    linkDescriptionLabel.setForeground(Color.WHITE);
    
    // Enlace (reducido 1/6)
    linkLabel = new JLabel("Enlace...");
    linkLabel.setBounds(312, 120, 67, 17); // Original: 420,140,80,20 → Reducción 1/6
    linkLabel.setFont(new Font("Poppins", Font.ITALIC, 8)); // Original: 14 → Reducción 1/6
    linkLabel.setForeground(Color.CYAN);
    linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    linkLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(linkLabel);//crear una clase que reconozca este jframe para ocultarlo
                calcularHoras mForm2 = new calcularHoras(); //convertir boton en clickeable
                mForm2.setVisible(true);
                currentFrame.setVisible(false);//ocultar el jframe con la, bueno no seria clase, pero la cosa esa porque no se porque de otra forma no parece poderse hacer
                //Jlogin mForm1 = new Jlogin();
                //y que mande a la alculadora
            }

    });
    
    innerPanel.add(completedHoursLabel);
    innerPanel.add(completedHoursValue);
    innerPanel.add(requiredHoursLabel);
    innerPanel.add(requiredHoursValue);
    innerPanel.add(linkDescriptionLabel);
    innerPanel.add(linkLabel);
    innerPanel.add(line1);
    innerPanel.add(line2);
    
    detailsPanel.add(detailsTitleLabel);
    detailsPanel.add(innerPanel);
    
    add(detailsPanel);
}
    
    private void createCalendarSection() {
        // Título del calendario
        JLabel calendarTitle = new JLabel("Calendario de eventos con horas libres");
        calendarTitle.setBounds(170, 380, 460, 35);
        calendarTitle.setFont(new Font("Poppins", Font.BOLD, 23));
        calendarTitle.setForeground(PRIMARY_COLOR);
        calendarTitle.setHorizontalAlignment(SwingConstants.CENTER);
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
        JButton prevButton1 = new JButton("◀");
        prevButton1.setBounds(30, 100, 25, 70);
        prevButton1.setBackground(WHITE);
        prevButton1.setForeground(PRIMARY_COLOR);
        prevButton1.setBorder(null);
        
        prevButton1.addMouseListener(new java.awt.event.MouseAdapter() { //desde esta linea hasta el cierre de corchetes, son 5 lineas para hacer que un jbutton funcione al ser clickeado
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //A los jbutton se les puede crear el evento de cuando sean clickeados con estas 5 lineas de codigo, con el cuidado
                //de que el comienzo del codigo de la linea 296 sea el nombre del jbutton, de resto, con esto se puede idear una forma
                //para que al diseño se le puedan añadir las funcionaldades sin necesidad del entorno grafico o GUI de neatbens.
                JOptionPane.showMessageDialog(null, "guayando");  
            }});
        calendarInner.add(prevButton1);
        
        
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
        java.awt.EventQueue.invokeLater(() -> new Jpestaña3().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
