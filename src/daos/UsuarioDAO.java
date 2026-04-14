package daos;

import db.Conexion;
import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

	Conexion conexion = new Conexion();

	public boolean guardar(Usuario u) {
		String sql = "INSERT INTO usuario(nombre, edad, peso, estatura, imc, clasificacion) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection conn = conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, u.getNombreCompleto());
			ps.setInt(2, u.getEdad());
			ps.setDouble(3, u.getPesoKg());
			ps.setDouble(4, u.getAlturaM());
			ps.setDouble(5, u.getIndiceMasa());
			ps.setString(6, u.getEstado());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			System.out.println("Error DAO: " + e.getMessage());
			return false;
		}
	}

	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<>();
		String sql = "SELECT * FROM usuario";

		try (Connection conn = conexion.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {

			while (rs.next()) {
				Usuario u = new Usuario();
				u.setNombreCompleto(rs.getString("nombre"));
				u.setEdad(rs.getInt("edad"));
				u.setPesoKg(rs.getDouble("peso"));
				u.setAlturaM(rs.getDouble("estatura"));
				u.setIndiceMasa(rs.getDouble("imc"));
				u.setEstado(rs.getString("clasificacion"));

				lista.add(u);
			}

		} catch (Exception e) {
			System.out.println("Error listar: " + e.getMessage());
		}

		return lista;
	}
}