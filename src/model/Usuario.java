package model;

public class Usuario {

	private String nombreCompleto;
	private int edad;
	private double pesoKg;
	private double alturaM;
	private double indiceMasa;
	private String estado;

	public Usuario() {
	}

	public Usuario(String nombreCompleto, int edad, double pesoKg, double alturaM) {
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.pesoKg = pesoKg;
		this.alturaM = alturaM;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPesoKg() {
		return pesoKg;
	}

	public void setPesoKg(double pesoKg) {
		this.pesoKg = pesoKg;
	}

	public double getAlturaM() {
		return alturaM;
	}

	public void setAlturaM(double alturaM) {
		this.alturaM = alturaM;
	}

	public double getIndiceMasa() {
		return indiceMasa;
	}

	public void setIndiceMasa(double indiceMasa) {
		this.indiceMasa = indiceMasa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
