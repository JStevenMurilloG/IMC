package views;

import controllers.UsuarioControlador;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaConsulta extends JFrame {

    private JTextArea area;
    private UsuarioControlador ctrl;

    public VentanaConsulta() {
        setTitle("Resultados");
        setSize(400,300);

        area = new JTextArea();
        add(new JScrollPane(area), BorderLayout.CENTER);

        JButton btn = new JButton("Actualizar");
        add(btn, BorderLayout.SOUTH);

        btn.addActionListener(e -> cargar());
    }

    public void setControlador(UsuarioControlador c) {
        this.ctrl = c;
    }

    private void cargar() {
        List<Usuario> lista = ctrl.obtenerLista();
        area.setText("");

        for (Usuario u : lista) {
            area.append(u.getNombreCompleto() + " - IMC: " + u.getIndiceMasa() + " - Clasificación: " + u.getEstado() +  "\n");
        }
    }
}
