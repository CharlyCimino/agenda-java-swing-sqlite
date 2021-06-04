package agenda.vista.clases;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class JFrameVistaFormularioAgregar extends JFrameVistaFormulario {

    private JButton jButtonAgregar;

    public JFrameVistaFormularioAgregar(String titulo, Component parent) {
        super(titulo, parent);
        initComponents();
    }

    public JFrameVistaFormularioAgregar(String titulo) {
        this(titulo, null);
    }

    public final void initComponents() {
        this.jButtonAgregar = new JButton();
        jButtonAgregar.setBackground(new java.awt.Color(238, 245, 247));
        jButtonAgregar.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        jButtonAgregar.setForeground(new java.awt.Color(24, 19, 9));
        cargarIcono(jButtonAgregar, "add-user-icon.png");
        jButtonAgregar.setText("Agregar");
        jButtonAgregar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonAgregar.setIconTextGap(20);
        jButtonAgregar.setPreferredSize(new java.awt.Dimension(400, 53));
        getJPanelBotonera().add(jButtonAgregar);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////// MANEJADORES PARA CADA ACCION //////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////  
    public void manejarAccionAgregar(ActionListener al) {
        this.jButtonAgregar.addActionListener(al);
    }

}
