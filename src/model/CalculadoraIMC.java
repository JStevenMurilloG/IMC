package model;

public class CalculadoraIMC {

	public double obtenerIMC(double peso, double altura) {
		return peso / Math.pow(altura, 2);
	}

	public String clasificar(double imc) {

		if (imc < 18)
			return "Delgadez";
		if (imc < 25)
			return "Normal";
		if (imc < 30)
			return "Obesidad";
		return "Riesgo";

	}

}
