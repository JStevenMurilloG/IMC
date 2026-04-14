package controllers;

import daos.UsuarioDAO;
import model.Usuario;
import views.VentanaRegistro;
import model.CalculadoraIMC;

import java.util.List;

public class UsuarioControlador {

	private CalculadoraIMC calc;
	private UsuarioDAO dao;
	private VentanaRegistro vr;

	public void setVentana(VentanaRegistro vr) {
		this.vr = vr;
	}

	public boolean guardarUsuario(Usuario usuario) {

		if (dao.guardar(usuario)) {
			return true;
		} else {
			return false;
		}
	}

	public List<Usuario> obtenerLista() {
		return dao.listar();
	}

	public double obtenerIMC(double p, double a) {
		// TODO Auto-generated method stub
		return calc.obtenerIMC(p, a);
	}

	public String clasificar(double imc) {
		return calc.clasificar(imc);
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.dao = usuarioDAO;
	}

	public void setCalculadora(CalculadoraIMC calculadora) {
		// TODO Auto-generated method stub
		this.calc = calculadora;
	}

}
