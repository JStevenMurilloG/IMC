package controllers;

import daos.UsuarioDAO;
import model.CalculadoraIMC;
import views.VentanaConsulta;
import views.VentanaInfo;
import views.VentanaRegistro;

public class Relaciones {

    public Relaciones() {

        UsuarioControlador ctrl = new UsuarioControlador();

        VentanaRegistro vr = new VentanaRegistro();
        VentanaConsulta vc = new VentanaConsulta();
        VentanaInfo vi = new VentanaInfo();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CalculadoraIMC calculadora = new CalculadoraIMC();

        vr.setControlador(ctrl);
        vc.setControlador(ctrl);

        vr.setConsulta(vc);
        vr.setInfo(vi);
        
        ctrl.setVentana(vr);

        vr.setVisible(true);
        
        ctrl.setUsuarioDAO(usuarioDAO);
        ctrl.setCalculadora(calculadora);
        
    }
}

