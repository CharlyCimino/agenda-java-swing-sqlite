package agenda.vista.clases;

import agenda.modelo.clases.Categoria;
import agenda.modelo.clases.Contacto;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public abstract class JFrameVistaFormulario extends JFrameTemplate {

    public static final Locale LOCALE_AR = new Locale("es", "AR");

    public JFrameVistaFormulario(String titulo, Component parent) {
        super(titulo, parent);
        initComponents();
        cargarIconos();
        prepararSelectorDeFecha();
        prepararListaDeCategorias();
        manejarAccionCerrar();
    }

    public JFrameVistaFormulario(String titulo) {
        this(titulo, null);
    }
    
    private void cargarIconos() {
        cargarIcono(jLabelFoto, "silueta-icon.png");
        cargarIcono(jButtonCerrar, "close-icon.png");
        cargarIcono(jLabelIconoCredencial, "user-id-icon.png");
        cargarIcono(jLabelIconoMail, "mail-icon.png");
        cargarIcono(jLabelIconoTelefono, "phone-icon.png");
        cargarIcono(jLabelIconoMapa, "map-icon.png");
        cargarIcono(jLabelIconoCalendario, "calendar-icon.png");
        cargarIcono(jLabelIconoEtiqueta, "tag-icon.png");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenido = new javax.swing.JPanel();
        jLabelFoto = new javax.swing.JLabel();
        jPanelBotonera = new javax.swing.JPanel();
        jButtonCerrar = new javax.swing.JButton();
        jPanelEdicion = new javax.swing.JPanel();
        jPanelIconos = new javax.swing.JPanel();
        jLabelIconoCredencial = new javax.swing.JLabel();
        jLabelIconoMail = new javax.swing.JLabel();
        jLabelIconoTelefono = new javax.swing.JLabel();
        jLabelIconoMapa = new javax.swing.JLabel();
        jLabelIconoCalendario = new javax.swing.JLabel();
        jLabelIconoEtiqueta = new javax.swing.JLabel();
        jPanelCampos = new javax.swing.JPanel();
        jPanelNombreApellido = new javax.swing.JPanel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldMail = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jXDatePickerNacimiento = new org.jdesktop.swingx.JXDatePicker();
        jComboBoxCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabelFoto.setBackground(new java.awt.Color(238, 245, 247));
        jLabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/vista/recursos/silueta-icon.png"))); // NOI18N
        jLabelFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(36, 123, 160), 4, true));

        jPanelBotonera.setLayout(new java.awt.GridLayout(3, 1, 0, 10));

        jButtonCerrar.setBackground(new java.awt.Color(238, 245, 247));
        jButtonCerrar.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        jButtonCerrar.setForeground(new java.awt.Color(24, 19, 9));
        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/vista/recursos/close-icon.png"))); // NOI18N
        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonCerrar.setIconTextGap(20);
        jButtonCerrar.setPreferredSize(new java.awt.Dimension(400, 53));
        jPanelBotonera.add(jButtonCerrar);

        jPanelEdicion.setPreferredSize(new java.awt.Dimension(100, 800));
        jPanelEdicion.setLayout(new javax.swing.BoxLayout(jPanelEdicion, javax.swing.BoxLayout.LINE_AXIS));

        jPanelIconos.setMinimumSize(new java.awt.Dimension(70, 192));
        jPanelIconos.setPreferredSize(new java.awt.Dimension(0, 800));
        jPanelIconos.setLayout(new java.awt.GridLayout(6, 1));

        jLabelIconoCredencial.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabelIconoCredencial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconoCredencial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/vista/recursos/user-id-icon.png"))); // NOI18N
        jLabelIconoCredencial.setIconTextGap(15);
        jPanelIconos.add(jLabelIconoCredencial);

        jLabelIconoMail.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabelIconoMail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconoMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/vista/recursos/mail-icon.png"))); // NOI18N
        jLabelIconoMail.setIconTextGap(15);
        jPanelIconos.add(jLabelIconoMail);

        jLabelIconoTelefono.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabelIconoTelefono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconoTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/vista/recursos/phone-icon.png"))); // NOI18N
        jLabelIconoTelefono.setIconTextGap(15);
        jPanelIconos.add(jLabelIconoTelefono);

        jLabelIconoMapa.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabelIconoMapa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconoMapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/vista/recursos/map-icon.png"))); // NOI18N
        jLabelIconoMapa.setIconTextGap(15);
        jPanelIconos.add(jLabelIconoMapa);

        jLabelIconoCalendario.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabelIconoCalendario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconoCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/vista/recursos/calendar-icon.png"))); // NOI18N
        jLabelIconoCalendario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabelIconoCalendario.setIconTextGap(5);
        jPanelIconos.add(jLabelIconoCalendario);

        jLabelIconoEtiqueta.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        jLabelIconoEtiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconoEtiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/vista/recursos/tag-icon.png"))); // NOI18N
        jLabelIconoEtiqueta.setIconTextGap(15);
        jPanelIconos.add(jLabelIconoEtiqueta);

        jPanelEdicion.add(jPanelIconos);

        jPanelCampos.setLayout(new java.awt.GridLayout(6, 1));

        jPanelNombreApellido.setLayout(new java.awt.GridLayout(1, 2));

        jTextFieldNombre.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        jTextFieldNombre.setForeground(new java.awt.Color(24, 19, 9));
        jTextFieldNombre.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jTextFieldNombre.setName("Nombre"); // NOI18N
        jTextFieldNombre.setSelectionColor(new java.awt.Color(255, 206, 91));
        jPanelNombreApellido.add(jTextFieldNombre);

        jTextFieldApellido.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        jTextFieldApellido.setForeground(new java.awt.Color(24, 19, 9));
        jTextFieldApellido.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jTextFieldApellido.setName("Apellido"); // NOI18N
        jTextFieldApellido.setSelectionColor(new java.awt.Color(255, 206, 91));
        jPanelNombreApellido.add(jTextFieldApellido);

        jPanelCampos.add(jPanelNombreApellido);

        jTextFieldMail.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        jTextFieldMail.setForeground(new java.awt.Color(24, 19, 9));
        jTextFieldMail.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jTextFieldMail.setName("Mail"); // NOI18N
        jTextFieldMail.setSelectionColor(new java.awt.Color(255, 206, 91));
        jPanelCampos.add(jTextFieldMail);

        jTextFieldTelefono.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        jTextFieldTelefono.setForeground(new java.awt.Color(24, 19, 9));
        jTextFieldTelefono.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jTextFieldTelefono.setName("Teléfono"); // NOI18N
        jTextFieldTelefono.setSelectionColor(new java.awt.Color(255, 206, 91));
        jPanelCampos.add(jTextFieldTelefono);

        jTextFieldDireccion.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        jTextFieldDireccion.setForeground(new java.awt.Color(24, 19, 9));
        jTextFieldDireccion.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jTextFieldDireccion.setName("Dirección"); // NOI18N
        jTextFieldDireccion.setSelectionColor(new java.awt.Color(255, 206, 91));
        jPanelCampos.add(jTextFieldDireccion);

        jXDatePickerNacimiento.setForeground(new java.awt.Color(24, 19, 9));
        jXDatePickerNacimiento.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        jXDatePickerNacimiento.setName("Fecha de nacimiento"); // NOI18N
        jPanelCampos.add(jXDatePickerNacimiento);

        jComboBoxCategoria.setEditable(true);
        jComboBoxCategoria.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        jComboBoxCategoria.setToolTipText("");
        jComboBoxCategoria.setName("Categoria"); // NOI18N
        jComboBoxCategoria.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanelCampos.add(jComboBoxCategoria);

        jPanelEdicion.add(jPanelCampos);

        javax.swing.GroupLayout jPanelContenidoLayout = new javax.swing.GroupLayout(jPanelContenido);
        jPanelContenido.setLayout(jPanelContenidoLayout);
        jPanelContenidoLayout.setHorizontalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBotonera, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(394, Short.MAX_VALUE))
            .addGroup(jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenidoLayout.createSequentialGroup()
                    .addContainerGap(158, Short.MAX_VALUE)
                    .addComponent(jPanelEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanelContenidoLayout.setVerticalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanelBotonera, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenidoLayout.createSequentialGroup()
                    .addContainerGap(12, Short.MAX_VALUE)
                    .addComponent(jPanelEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        getContentPane().add(jPanelContenido, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prepararSelectorDeFecha() {
        this.jXDatePickerNacimiento.setFormats(new SimpleDateFormat("d 'de' MMMM 'de' yyyy", LOCALE_AR));
    }

    private void prepararListaDeCategorias() {
        Categoria[] categs = new Categoria[Categoria.values().length - 1];
        for (int i = 1; i < Categoria.values().length; i++) {
            categs[i - 1] = Categoria.values()[i];
        }
        this.jComboBoxCategoria.setModel(new DefaultComboBoxModel(categs));
        this.jComboBoxCategoria.setEditable(false);
    }

    public Contacto getContacto() {
        validarDatos();
        String nom = this.jTextFieldNombre.getText();
        String ape = this.jTextFieldApellido.getText();
        String mail = this.jTextFieldMail.getText();
        String dir = this.jTextFieldDireccion.getText();
        String tel = this.jTextFieldTelefono.getText();
        Date nac = new Date(this.jXDatePickerNacimiento.getDate().getTime());
        Categoria cat = (Categoria) this.jComboBoxCategoria.getSelectedItem();
        return new Contacto(0, nom, ape, mail, tel, dir, nac, cat);
    }

    private void validarDatos() {
        Component[] campos = this.jPanelCampos.getComponents();
        Component[] nomApe = ((JPanel) campos[0]).getComponents();
        for (int i = 0; i < this.jPanelNombreApellido.getComponents().length; i++) {
            JTextField tf = (JTextField) this.jPanelNombreApellido.getComponent(i);
            if (tf.getText().isEmpty()) {
                throw new IllegalStateException("El campo \"" + tf.getName() + "\" está vacío");
            }
        }
        for (int i = 1; i < this.jPanelCampos.getComponents().length-2; i++) {
            JTextField tf = (JTextField) campos[i];
            if (tf.getText().isEmpty()) {
                throw new IllegalStateException("El campo \"" + tf.getName() + "\" está vacío");
            }
        }
        if (!esNumeroEntero(this.jTextFieldTelefono.getText())) {
            throw new IllegalStateException("El valor del campo \"" + this.jTextFieldTelefono.getName() + "\" no representa un número de teléfono");
        }
        if (this.jXDatePickerNacimiento.getDate() == null) {
            throw new IllegalStateException("El campo \"" + this.jXDatePickerNacimiento.getName() + "\" está vacío");
        }
    }
    
    public final void habilitarCampos (boolean flag) {
        for (int i = 0; i < this.jPanelNombreApellido.getComponents().length; i++) {
            JTextField campo = (JTextField) this.jPanelNombreApellido.getComponent(i);
            campo.setEditable(flag);
        }
        for (int i = 1; i < this.jPanelCampos.getComponents().length-2; i++) {
            JTextField campo = (JTextField) this.jPanelCampos.getComponent(i);
            campo.setEditable(flag);
        }
        this.jXDatePickerNacimiento.setEditable(flag);
        this.jComboBoxCategoria.setEnabled(flag);
    }

    private boolean esNumeroEntero(String cad) {
        boolean esEntero = true;
        try {
            Integer.parseInt(cad);
        } catch (RuntimeException e) {
            esEntero = false;
        }
        return esEntero;
    }

    protected JComboBox<Categoria> getjComboBoxCategoria() {
        return jComboBoxCategoria;
    }

    protected JTextField getjTextFieldApellido() {
        return jTextFieldApellido;
    }

    protected JTextField getjTextFieldDireccion() {
        return jTextFieldDireccion;
    }

    protected JTextField getjTextFieldMail() {
        return jTextFieldMail;
    }

    protected JTextField getjTextFieldNombre() {
        return jTextFieldNombre;
    }

    protected JTextField getjTextFieldTelefono() {
        return jTextFieldTelefono;
    }

    protected JXDatePicker getjXDatePickerNacimiento() {
        return jXDatePickerNacimiento;
    }

    protected JLabel getjLabelIconoCalendario() {
        return jLabelIconoCalendario;
    }   

    protected JPanel getJPanelBotonera() {
        return jPanelBotonera;
    }

    private void manejarAccionCerrar() {
        this.jButtonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarVentana();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JComboBox<Categoria> jComboBoxCategoria;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelIconoCalendario;
    private javax.swing.JLabel jLabelIconoCredencial;
    private javax.swing.JLabel jLabelIconoEtiqueta;
    private javax.swing.JLabel jLabelIconoMail;
    private javax.swing.JLabel jLabelIconoMapa;
    private javax.swing.JLabel jLabelIconoTelefono;
    private javax.swing.JPanel jPanelBotonera;
    private javax.swing.JPanel jPanelCampos;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelEdicion;
    private javax.swing.JPanel jPanelIconos;
    private javax.swing.JPanel jPanelNombreApellido;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerNacimiento;
    // End of variables declaration//GEN-END:variables
}
