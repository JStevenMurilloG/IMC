package controllers;

import views.VentanaConsulta;
import views.VentanaInfo;
import views.VentanaRegistro;

public class Relaciones {

    public Relaciones() {

        UsuarioControlador ctrl = new UsuarioControlador();

        VentanaRegistro vr = new VentanaRegistro();
        VentanaConsulta vc = new VentanaConsulta();
        VentanaInfo vi = new VentanaInfo();

        vr.setControlador(ctrl);
        vc.setControlador(ctrl);

        vr.setConsulta(vc);
        vr.setInfo(vi);

        vr.setVisible(true);
    }
}

