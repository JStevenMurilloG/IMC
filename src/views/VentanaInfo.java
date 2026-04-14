package views;

import javax.swing.*;

public class VentanaInfo extends JFrame {

	public VentanaInfo() {
		setTitle("Información");
		setSize(250, 150);

		JLabel lbl = new JLabel("<html><center>Autor: Steven Murillo<br>ADSO<br>2026<br>App IMC</center></html>",
				JLabel.CENTER);

		add(lbl);
	}
}
