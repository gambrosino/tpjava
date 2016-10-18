package data;

import java.sql.*;
import entidades.Personaje;
import utils.ApplicationException;

public class DataPersonaje {

	public DataPersonaje() {
		
	}
	
	public void add(Personaje personaje) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into personajes(nombre, vida, energia, defensa, evasion, puntosDisponibles)"+
					" values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
						
			stmt.setString(1, personaje.getNombre());
			stmt.setInt(2, personaje.getVida());
			stmt.setInt(3, personaje.getEnergia());
			stmt.setInt(4, personaje.getDefensa());
			stmt.setInt(5, personaje.getEvasion());
			stmt.setInt(6, personaje.getPuntosDisponibles());
			stmt.execute();
			
			//after executing the insert use the following lines to retrieve the id
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				personaje.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		
	}
	
	public void delete() {
		
	}
}
