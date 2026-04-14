package views;

import controllers.UsuarioControlador;
import model.Usuario;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;

public class VentanaRegistro extends JFrame implements ActionListener {

	private JTextField nombre, edad, peso, altura;
	private UsuarioControlador ctrl;
	private VentanaConsulta vConsulta;
	private VentanaInfo vInfo;
	private JButton btnGuardar;
	private JButton btnVer;
	private JButton btnInfo;

	// ── Paleta de colores unificada ──────────────────────────────────────────
	static final Color C_BG = new Color(0xF5F7FA);
	static final Color C_CARD = Color.WHITE;
	static final Color C_PRIMARY = new Color(0x2563EB); // azul
	static final Color C_PRIMARY_H = new Color(0x1D4ED8); // azul oscuro (hover)
	static final Color C_ACCENT = new Color(0x10B981); // verde
	static final Color C_ACCENT_H = new Color(0x059669);
	static final Color C_SECONDARY = new Color(0x64748B); // gris medio
	static final Color C_SEC_H = new Color(0x475569);
	static final Color C_TEXT = new Color(0x1E293B);
	static final Color C_LABEL = new Color(0x475569);
	static final Color C_BORDER = new Color(0xCBD5E1);
	static final Color C_FOCUS = new Color(0x93C5FD);
	static final Font F_TITLE = new Font("Segoe UI", Font.BOLD, 18);
	static final Font F_LABEL = new Font("Segoe UI", Font.PLAIN, 13);
	static final Font F_FIELD = new Font("Segoe UI", Font.PLAIN, 13);
	static final Font F_BTN = new Font("Segoe UI", Font.BOLD, 12);

	public VentanaRegistro() {

		setTitle("Calculadora IMC");
		setSize(420, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		// ── Contenedor raíz ─────────────────────────────────────────────────
		JPanel root = new JPanel(new BorderLayout());
		root.setBackground(C_BG);
		root.setBorder(new EmptyBorder(24, 24, 24, 24));
		setContentPane(root);

		// ── Cabecera ────────────────────────────────────────────────────────
		JPanel header = new JPanel(new BorderLayout());
		header.setOpaque(false);
		header.setBorder(new EmptyBorder(0, 0, 20, 0));

		JLabel title = new JLabel("Registro de usuario");
		title.setFont(F_TITLE);
		title.setForeground(C_TEXT);

		JLabel subtitle = new JLabel("Complete los datos para calcular su IMC");
		subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		subtitle.setForeground(C_LABEL);

		JPanel titleBlock = new JPanel();
		titleBlock.setOpaque(false);
		titleBlock.setLayout(new BoxLayout(titleBlock, BoxLayout.Y_AXIS));
		titleBlock.add(title);
		titleBlock.add(Box.createVerticalStrut(4));
		titleBlock.add(subtitle);
		header.add(titleBlock, BorderLayout.CENTER);
		root.add(header, BorderLayout.NORTH);

		// ── Tarjeta central ─────────────────────────────────────────────────
		JPanel card = new RoundedPanel(16, C_CARD);
		card.setLayout(new GridBagLayout());
		card.setBorder(new EmptyBorder(24, 24, 24, 24));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(6, 0, 6, 0);

		String[] labels = { "Nombre completo", "Edad (años)", "Peso (kg)", "Altura (m)" };
		String[] hints = { "Ej. Juan García", "Ej. 25", "Ej. 70.5", "Ej. 1.75" };
		JTextField[] fields = new JTextField[4];

		for (int i = 0; i < labels.length; i++) {
			gbc.gridx = 0;
			gbc.gridy = i * 2;
			gbc.weightx = 1;
			card.add(buildLabel(labels[i]), gbc);

			gbc.gridy = i * 2 + 1;
			fields[i] = buildField(hints[i]);
			card.add(fields[i], gbc);
		}

		nombre = fields[0];
		edad = fields[1];
		peso = fields[2];
		altura = fields[3];

		root.add(card, BorderLayout.CENTER);

		// ── Panel de botones ─────────────────────────────────────────────────
		JPanel btnPanel = new JPanel(new GridLayout(1, 3, 10, 0));
		btnPanel.setOpaque(false);
		btnPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

		btnGuardar = buildButton("✔  Registrar", C_ACCENT, C_ACCENT_H, Color.WHITE);
		btnVer = buildButton("☰  Ver datos", C_PRIMARY, C_PRIMARY_H, Color.WHITE);
		btnInfo = buildButton("ℹ  Info", C_SECONDARY, C_SEC_H, Color.WHITE);

		btnPanel.add(btnGuardar);
		btnPanel.add(btnVer);
		btnPanel.add(btnInfo);

		btnGuardar.addActionListener(this);
		btnVer.addActionListener(this);
		btnInfo.addActionListener(this);

		root.add(btnPanel, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnGuardar)
			guardar();
		if (e.getSource() == btnVer)
			vConsulta.setVisible(true);
		if (e.getSource() == btnInfo)
			vInfo.setVisible(true);

	}

	// ── Helpers de construcción ──────────────────────────────────────────────
	private JLabel buildLabel(String text) {
		JLabel l = new JLabel(text);
		l.setFont(F_LABEL);
		l.setForeground(C_LABEL);
		return l;
	}

	private JTextField buildField(String hint) {
		JTextField tf = new JTextField() {
			@Override
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && getBorder() instanceof RoundedBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					g2.setColor(getBackground());
					g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
					g2.dispose();
				}
				super.paintComponent(g);
			}
		};
		tf.setFont(F_FIELD);
		tf.setForeground(C_TEXT);
		tf.setBackground(C_BG);
		tf.setOpaque(false);
		tf.setBorder(new CompoundBorder(new RoundedBorder(10, C_BORDER, 1), new EmptyBorder(8, 12, 8, 12)));
		tf.setPreferredSize(new Dimension(0, 40));

		tf.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				tf.setBorder(new CompoundBorder(new RoundedBorder(10, C_FOCUS, 2), new EmptyBorder(8, 12, 8, 12)));
			}

			public void focusLost(java.awt.event.FocusEvent e) {
				tf.setBorder(new CompoundBorder(new RoundedBorder(10, C_BORDER, 1), new EmptyBorder(8, 12, 8, 12)));
			}
		});
		return tf;
	}

	static JButton buildButton(String text, Color bg, Color hover, Color fg) {
		JButton btn = new JButton(text) {
			private Color current = bg;
			{
				addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent e) {
						current = hover;
						repaint();
					}

					public void mouseExited(java.awt.event.MouseEvent e) {
						current = bg;
						repaint();
					}
				});
			}

			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(current);
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
				g2.dispose();
				super.paintComponent(g);
			}
		};
		btn.setFont(F_BTN);
		btn.setForeground(fg);
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn.setPreferredSize(new Dimension(0, 38));
		return btn;
	}

	public void setControlador(UsuarioControlador c) {
		this.ctrl = c;
	}

	public void setConsulta(VentanaConsulta v) {
		this.vConsulta = v;
	}

	public void setInfo(VentanaInfo v) {
		this.vInfo = v;
	}

	private void guardar() {

		try {
			int e = Integer.parseInt(edad.getText());
			double p = Double.parseDouble(peso.getText());
			double a = Double.parseDouble(altura.getText());

			if (nombre.getText().isBlank() || e <= 0 || p <= 0 || a <= 0) {
				JOptionPane.showMessageDialog(this, "Error en datos");
			} else {
				Usuario u = new Usuario(nombre.getText(), e, p, a);

				double imc = ctrl.obtenerIMC(p, a);
				u.setIndiceMasa(imc);
				u.setEstado(ctrl.clasificar(imc));

				if (ctrl.guardarUsuario(u)) {
					JOptionPane.showMessageDialog(this, "Guardado correctamente");
				} else {
					JOptionPane.showMessageDialog(this, "No se pudo guardar");
				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	static class RoundedPanel extends JPanel {
		private final int radius;
		private final Color bg;

		RoundedPanel(int radius, Color bg) {
			this.radius = radius;
			this.bg = bg;
			setOpaque(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(bg);
			g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius * 2, radius * 2);
			// Sombra sutil
			g2.setColor(new Color(0, 0, 0, 15));
			g2.setStroke(new BasicStroke(1f));
			g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius * 2, radius * 2);
			g2.dispose();
			super.paintComponent(g);
		}
	}

	static class RoundedBorder extends AbstractBorder {
		private final int radius;
		private final Color color;
		private final int thickness;

		RoundedBorder(int radius, Color color, int thickness) {
			this.radius = radius;
			this.color = color;
			this.thickness = thickness;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(color);
			g2.setStroke(new BasicStroke(thickness));
			g2.drawRoundRect(x, y, w - 1, h - 1, radius * 2, radius * 2);
			g2.dispose();
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(thickness, thickness, thickness, thickness);
		}
	}

}