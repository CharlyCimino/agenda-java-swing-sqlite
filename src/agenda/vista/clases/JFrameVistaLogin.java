package agenda.vista.clases;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class JFrameVistaLogin extends JFrameTemplate {

    public JFrameVistaLogin(String titulo, Component parent) {
        super(titulo, parent);
        initComponents();
        cargarIconos();
        manejarAccionCerrar();
    }

    public JFrameVistaLogin(String titulo) {
        this(titulo, null);
    }
    
    private void cargarIconos() {
        cargarIcono(jButtonConectar, "broken-link.png");
        cargarIcono(jButtonCerrar, "close-icon.png");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenido = new javax.swing.JPanel();
        jPanelEdicion = new javax.swing.JPanel();
        jPanelLabels = new javax.swing.JPanel();
        jLabelDriver = new javax.swing.JLabel();
        jLabelUrl = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabelPass = new javax.swing.JLabel();
        jPanelCampos = new javax.swing.JPanel();
        jTextFieldDriver = new javax.swing.JTextField();
        jTextFieldUrl = new javax.swing.JTextField();
        jTextFieldUser = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanelBotonera = new javax.swing.JPanel();
        jButtonConectar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanelEdicion.setPreferredSize(new java.awt.Dimension(100, 800));
        jPanelEdicion.setLayout(new java.awt.BorderLayout(10, 0));

        jPanelLabels.setMinimumSize(new java.awt.Dimension(80, 90));
        jPanelLabels.setPreferredSize(new java.awt.Dimension(120, 800));
        jPanelLabels.setLayout(new java.awt.GridLayout(4, 1));

        jLabelDriver.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabelDriver.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDriver.setText("Driver:");
        jLabelDriver.setIconTextGap(15);
        jLabelDriver.setPreferredSize(new java.awt.Dimension(200, 0));
        jPanelLabels.add(jLabelDriver);

        jLabelUrl.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabelUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUrl.setText("URL:");
        jLabelUrl.setIconTextGap(15);
        jLabelUrl.setPreferredSize(new java.awt.Dimension(200, 0));
        jPanelLabels.add(jLabelUrl);

        jLabelUser.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabelUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUser.setText("User:");
        jLabelUser.setIconTextGap(15);
        jLabelUser.setPreferredSize(new java.awt.Dimension(200, 0));
        jPanelLabels.add(jLabelUser);

        jLabelPass.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabelPass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPass.setText("Pass:");
        jLabelPass.setIconTextGap(15);
        jLabelPass.setPreferredSize(new java.awt.Dimension(200, 0));
        jPanelLabels.add(jLabelPass);

        jPanelEdicion.add(jPanelLabels, java.awt.BorderLayout.WEST);

        jPanelCampos.setMinimumSize(new java.awt.Dimension(320, 148));
        jPanelCampos.setPreferredSize(new java.awt.Dimension(320, 111));
        jPanelCampos.setLayout(new java.awt.GridLayout(4, 1));

        jTextFieldDriver.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        jTextFieldDriver.setForeground(new java.awt.Color(24, 19, 9));
        jTextFieldDriver.setText("org.sqlite.JDBC");
        jTextFieldDriver.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jTextFieldDriver.setSelectionColor(new java.awt.Color(255, 206, 91));
        jPanelCampos.add(jTextFieldDriver);

        jTextFieldUrl.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        jTextFieldUrl.setForeground(new java.awt.Color(24, 19, 9));
        jTextFieldUrl.setText("jdbc:sqlite:src/agenda/modelo/bd/agenda.db");
        jTextFieldUrl.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jTextFieldUrl.setSelectionColor(new java.awt.Color(255, 206, 91));
        jPanelCampos.add(jTextFieldUrl);

        jTextFieldUser.setFont(new java.awt.Font("Lato", 0, 15)); // NOI18N
        jTextFieldUser.setForeground(new java.awt.Color(24, 19, 9));
        jTextFieldUser.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jTextFieldUser.setSelectionColor(new java.awt.Color(255, 206, 91));
        jPanelCampos.add(jTextFieldUser);

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPasswordField1.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jPanelCampos.add(jPasswordField1);

        jPanelEdicion.add(jPanelCampos, java.awt.BorderLayout.CENTER);

        jPanelBotonera.setPreferredSize(new java.awt.Dimension(850, 53));
        jPanelBotonera.setLayout(new javax.swing.BoxLayout(jPanelBotonera, javax.swing.BoxLayout.LINE_AXIS));

        jButtonConectar.setBackground(new java.awt.Color(238, 245, 247));
        jButtonConectar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonConectar.setForeground(new java.awt.Color(24, 19, 9));
        jButtonConectar.setText("Conectar");
        jButtonConectar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonConectar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonConectar.setIconTextGap(20);
        jButtonConectar.setPreferredSize(new java.awt.Dimension(400, 53));
        jPanelBotonera.add(jButtonConectar);

        jButtonCerrar.setBackground(new java.awt.Color(238, 245, 247));
        jButtonCerrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCerrar.setForeground(new java.awt.Color(24, 19, 9));
        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonCerrar.setIconTextGap(20);
        jButtonCerrar.setPreferredSize(new java.awt.Dimension(400, 53));
        jPanelBotonera.add(jButtonCerrar);

        javax.swing.GroupLayout jPanelContenidoLayout = new javax.swing.GroupLayout(jPanelContenido);
        jPanelContenido.setLayout(jPanelContenidoLayout);
        jPanelContenidoLayout.setHorizontalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenidoLayout.createSequentialGroup()
                .addGroup(jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(jPanelEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanelContenidoLayout.setVerticalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenidoLayout.createSequentialGroup()
                .addComponent(jPanelEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotonera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        getContentPane().add(jPanelContenido, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void manejarAccionConectar(ActionListener al) {
        this.jButtonConectar.addActionListener(al);
    }
    
    public String getDriver() {
        return this.jTextFieldDriver.getText();
    }

    public String getUrl() {
        return this.jTextFieldUrl.getText();
    }

    public String getUser() {
        return this.jTextFieldUser.getText();
    }

    public String getPass() {
        return String.valueOf(this.jPasswordField1.getPassword());
    }

    private void manejarAccionCerrar() {
        this.jButtonCerrar.addActionListener((ActionEvent e) -> {
            cerrarVentana();
        });
    }

    public void cerrarVentana() {
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonConectar;
    private javax.swing.JLabel jLabelDriver;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JLabel jLabelUrl;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPanel jPanelBotonera;
    private javax.swing.JPanel jPanelCampos;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelEdicion;
    private javax.swing.JPanel jPanelLabels;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldDriver;
    private javax.swing.JTextField jTextFieldUrl;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
}
