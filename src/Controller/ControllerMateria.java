package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Controllers.ConnectionManagerV1;
import Model.Materia;
import Model.Profesor;

public class ControllerMateria {
	
	
	/**
	 * 
	 */
	public static List<Materia> findByNivel (int idNivel) {
		List<Materia> materias = new ArrayList<Materia>();
		
		try {
			
			Connection conn = ConnectionManagerV1.getConexion();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery ("select * from materia where idNivel = "+ idNivel);
		   

			while (rs.next()) {
				Materia materia = new Materia();
				materia.setId(rs.getInt("id"));
				materia.setNombre(rs.getString("nombre"));
				materia.setIdNivel(rs.getInt("idNivel"));
				materia.setCodigo(rs.getString("codigo"));
				materia.setUrlClassroom(rs.getString("urlClassroom"));
				materia.setAdmiteMatricula(rs.getInt("admiteMatricula"));
				materia.setFechaInicio(rs.getDate("fechaInicio"));
				
				materias.add(materia);
			}

			rs.close();
			conn.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return materias;
	}
	
	
	public static Materia cargarDetallesMateria(int idMateria) {
		
		Materia m = null;

		try {

			Connection conn = ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select * from materia where id = 1");

			if (rs.next()) {

				m = new Materia();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setIdNivel(rs.getInt("idNivel"));
				m.setCodigo(rs.getString("codigo"));
				m.setUrlClassroom(rs.getString("urlClassroom"));
				m.setAdmiteMatricula(rs.getInt("admiteMatricula"));
				m.setFechaInicio(rs.getDate("fechaInicio"));

			}

			st.close();
			rs.close();
			return m;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int modificar (Materia m) {
		
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update materia set nombre = ?, codigo = ?, urlClassroom = ? where id = ?");
		
			ps.setString(1, m.getNombre());
			ps.setString(2, m.getCodigo());
			ps.setString(3, m.getUrlClassroom());
			ps.setInt(4, m.getId());
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
