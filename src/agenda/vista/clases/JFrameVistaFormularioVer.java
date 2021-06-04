
package agenda.vista.clases;

import agenda.modelo.clases.Contacto;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JToggleButton;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class JFrameVistaFormularioVer extends JFrameVistaFormulario {

    private JToggleButton jToggleButtonEditar;
    private JButton jButtonBorrar;
    private Contacto contacto;

    public JFrameVistaFormularioVer(String titulo, Component parent, Contacto contacto) {
        super(titulo, parent);
        this.contacto = contacto;
        initComponents();
        cargarIconos();
        llenarCampos();
        habilitarCampos(false);
    }
    
    private void cargarIconos() {
        cargarIcono(jToggleButtonEditar, "edit-user-icon.png");
        cargarIcono(jButtonBorrar, "remove-user-icon.png");
    }

    public JFrameVistaFormularioVer(String titulo, Contacto co) {
        this(titulo, null, co);
    }

    public final void initComponents() {
        this.jToggleButtonEditar = new JToggleButton();
        jToggleButtonEditar.setBackground(new java.awt.Color(238, 245, 247));
        jToggleButtonEditar.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        jToggleButtonEditar.setForeground(new java.awt.Color(24, 19, 9));
        jToggleButtonEditar.setText("Editar");
        jToggleButtonEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButtonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jToggleButtonEditar.setIconTextGap(20);
        jToggleButtonEditar.setPreferredSize(new java.awt.Dimension(400, 53));
        getJPanelBotonera().add(jToggleButtonEditar);
        this.jButtonBorrar = new JButton();
        jButtonBorrar.setBackground(new java.awt.Color(238, 245, 247));
        jButtonBorrar.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        jButtonBorrar.setForeground(new java.awt.Color(24, 19, 9));
        jButtonBorrar.setText("Borrar");
        jButtonBorrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonBorrar.setIconTextGap(20);
        jButtonBorrar.setPreferredSize(new java.awt.Dimension(400, 53));
        getJPanelBotonera().add(jButtonBorrar);
    }

    private void llenarCampos() {
        getjTextFieldNombre().setText(contacto.getNombre());
        getjTextFieldApellido().setText(contacto.getApellido());
        getjTextFieldMail().setText(contacto.getMail());
        getjTextFieldTelefono().setText(contacto.getTelefono());
        getjTextFieldDireccion().setText(contacto.getDireccion());
        getjXDatePickerNacimiento().setDate(contacto.getFechaDeNacimiento());
        getjComboBoxCategoria().setSelectedIndex(contacto.getCategoria().ordinal() - 1);
        getjLabelIconoCalendario().setText("(" + contacto.getEdad() + ")");
    }
    
    @Override
    public Contacto getContacto() {
        Contacto co = super.getContacto();
        co.setId(this.contacto.getId());
        return co;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////// MANEJADORES PARA CADA ACCION //////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////  
    public void manejarAccionEditar(ItemListener il) {
        this.jToggleButtonEditar.addItemListener(il);
    }

    public void manejarAccionBorrar(ActionListener al) {
        this.jButtonBorrar.addActionListener(al);
    }
}
