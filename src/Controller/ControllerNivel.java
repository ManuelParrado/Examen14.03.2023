package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.CentroEducativo;
import Model.Nivel;

public class ControllerNivel {
	
	/**
	 * 
	 */
	public static List<Nivel> findAll () {
		
		List<Nivel> niveles = new ArrayList<Nivel>();
		try {

			Connection conn = ConnectionManagerV1.getConexion();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from nivel");
		   
			while (rs.next()) {
				Nivel nivel = new Nivel();
				nivel.setId(rs.getInt("id"));
				nivel.setDescripcion(rs.getString("descripcion"));
				nivel.setIdCentro(rs.getInt("idCentro"));
				
				niveles.add(nivel);
			}

			rs.close();
			conn.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return niveles;
	}
	
	/**
	 * 
	 */
	public static List<Nivel> findByCentro (int idCentro) {
		List<Nivel> niveles = new ArrayList<Nivel>();
		try {
			
			Connection conn = ConnectionManagerV1.getConexion();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery ("select * from nivel where idCentro = " + idCentro);
		   
	
			while (rs.next()) {
				Nivel nivel = new Nivel(rs.getInt("id"), rs.getString("descripcion"), rs.getInt("idCentro"));
				niveles.add(nivel);
			}
			
			rs.close();
			conn.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return niveles;
	}

}
