package controllers;

import daos.UsuarioDAO;
import model.Usuario;
import model.CalculadoraIMC;

import java.util.List;

public class UsuarioControlador {

	private CalculadoraIMC calc = new CalculadoraIMC();
	private UsuarioDAO dao = new UsuarioDAO();

	public boolean guardarUsuario(String nombre, String edad, String peso, String altura) {

		try {
			int e = Integer.parseInt(edad);
			double p = Double.parseDouble(peso);
			double a = Double.parseDouble(altura);

			if (nombre.isBlank() || e <= 0 || p <= 0 || a <= 0)
				return false;

			Usuario u = new Usuario(nombre, e, p, a);

			double imc = calc.obtenerIMC(p, a);
			u.setIndiceMasa(imc);
			u.setEstado(calc.clasificar(imc));

			return dao.guardar(u);

		} catch (Exception ex) {
			return false;
		}
	}

	public List<Usuario> obtenerLista() {
		return dao.listar();
	}
}
