package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.CentroEducativo;

public class ControllerCentroEducativo {

	/**
	 * 
	 */
	public static List<CentroEducativo> findAll () {
		
		List<CentroEducativo> centros = new ArrayList<CentroEducativo>();
		try {

			Connection conn = ConnectionManagerV1.getConexion();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from centroeducativo");
		   
			while (rs.next()) {
				CentroEducativo centro = new CentroEducativo();
				centro.setId(rs.getInt("id"));
				centro.setDescripcion(rs.getString("descripcion"));
				centros.add(centro);
			}

			
			rs.close();
			conn.close();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return centros;
	}
	
}
