package agenda;

import agenda.modelo.clases.Contacto;
import agenda.modelo.clases.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import agenda.vista.clases.JFrameVistaLogin;
import agenda.vista.clases.JFrameVistaFormularioAgregar;
import agenda.vista.clases.JFrameVistaFormularioVer;
import agenda.vista.clases.JFrameVistaPrincipal;
import java.util.Collection;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class Controlador {

    private JFrameVistaPrincipal vPrincipal;
    private JFrameVistaFormularioAgregar vFormAgregar;
    private JFrameVistaFormularioVer vFormVer;
    private JFrameVistaLogin vLogin;
    private Modelo model;

    public void iniciar() {
        this.model = new Modelo();
        this.vPrincipal = new JFrameVistaPrincipal("Agenda Java-BBDD");

        this.vPrincipal.manejarAccionAgregar(new HandlerAgregarContactoVP());
        this.vPrincipal.manejarAccionConectar(new HandlerConectarVP());
        this.vPrincipal.manejarAccionVaciar(new HandlerVaciarVP());
        this.vPrincipal.manejarClickEnTabla(new HandlerClickTablaVP());
        this.vPrincipal.manejarCambioItemFiltrar(new HandlerFiltrarVP());

        this.vPrincipal.setVisible(true);

    }

    private void tratarExcepcion(Exception ex) {
        String causeMessage = ex.getCause() == null ? "" : "\n" + ex.getCause().getMessage();
        vPrincipal.mostrarCartelDeError(ex.getMessage() + "\n" + causeMessage);
    }

    private void listarContactosEnVista() {
        try {
            Collection<Contacto> contactos = model.obtenerContactos(vPrincipal.obtenerCategoriaSeleccionada());
            vPrincipal.listarContactos(contactos);
        } catch (Exception ex) {
            tratarExcepcion(ex);
        }
    }

    private void agregarContacto() {
        try {
            Contacto co = vFormAgregar.getContacto();
            model.agregarContacto(co);
            listarContactosEnVista();
            vFormAgregar.cerrarVentana();
            vPrincipal.mostrarCartelDeInfo("Se agregó a " + co.nombreCompleto() + " a la agenda.");
        } catch (Exception ex) {
            tratarExcepcion(ex);
        }
    }

    private void actualizarContacto() {
        try {
            Contacto co = vFormVer.getContacto();
            model.actualizarContacto(co);
        } catch (Exception ex) {
            tratarExcepcion(ex);
        }
    }

    private void borrarContacto() {
        Contacto co = vFormVer.getContacto();
        boolean confirma = vPrincipal.confirmar("¿Estás segur@ de borrar a " + co.nombreCompleto() + "?");
        if (confirma) {
            try {
                model.borrarContacto(co.getId());
                listarContactosEnVista();
                vFormVer.cerrarVentana();
                vPrincipal.mostrarCartelDeInfo("Se borró a " + co.nombreCompleto() + " de la agenda.");
            } catch (Exception ex) {
                tratarExcepcion(ex);
            }
        }
    }

    private void vaciarAgenda() {
        boolean confirma = vPrincipal.confirmar("¿Estás segur@ de vaciar la agenda?");
        if (confirma) {
            try {
                model.vaciarAgenda();
                listarContactosEnVista();
                vPrincipal.mostrarCartelDeInfo("Agenda vacía.");
            } catch (Exception ex) {
                tratarExcepcion(ex);
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////// HANDLERS PARA CADA ACCION /////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////// VISTA PRINCIPAL ///////////////////////////////////////
    private class HandlerConectarVP implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vLogin = new JFrameVistaLogin("Login", vPrincipal);
            vLogin.manejarAccionConectar(new HandlerConectarVA());
            vLogin.setVisible(true);
        }
    }

    private class HandlerAgregarContactoVP implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vFormAgregar = new JFrameVistaFormularioAgregar("Agregar contacto", vPrincipal);
            vFormAgregar.manejarAccionAgregar(new HandlerAgregarContactoVC());
            vFormAgregar.setVisible(true);
        }
    }

    private class HandlerVaciarVP implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vaciarAgenda();
        }
    }

    private class HandlerFiltrarVP implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                listarContactosEnVista();
            }
        }
    }

    private class HandlerClickTablaVP implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                try {
                    Contacto co = model.obtenerContacto(vPrincipal.obtenerIDSeleccionado());
                    vFormVer = new JFrameVistaFormularioVer("Contacto " + co.nombreCompleto(), vPrincipal, co);
                    vFormVer.manejarAccionEditar(new HandlerEditarContactoVC());
                    vFormVer.manejarAccionBorrar(new HandlerBorrarContactoVC());
                    vFormVer.setVisible(true);
                } catch (Exception ex) {
                    tratarExcepcion(ex);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    //////////////////// VISTA DE LOGIN ////////////////////////////////////////
    private class HandlerConectarVA implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.conectarBD(vLogin.getDriver(), vLogin.getUrl(), vLogin.getUser(), vLogin.getPass());
                vLogin.cerrarVentana();
                vPrincipal.actualizarEstado(true);
                listarContactosEnVista();
            } catch (Exception ex) {
                tratarExcepcion(ex);
            }
        }
    }

    //////////////////// VISTA DE CONTACTO /////////////////////////////////////
    private class HandlerEditarContactoVC implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                vFormVer.habilitarCampos(true);
            } else {
                vFormVer.habilitarCampos(false);
                actualizarContacto();
                listarContactosEnVista();
            }
        }
    }

    private class HandlerBorrarContactoVC implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            borrarContacto();
            listarContactosEnVista();

        }
    }

    private class HandlerAgregarContactoVC implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            agregarContacto();
        }
    }

}
