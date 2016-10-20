package data;

import java.sql.*;
import java.util.ArrayList;

import entidades.Personaje;
import utils.ApplicationException;

public class DataPersonaje {

	public DataPersonaje() {
		
	}
	
	public Personaje getBy(int id) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Personaje personaje = null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("SELECT * FROM personajes WHERE id = ? LIMIT 1");
			
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				personaje = new Personaje(rs.getString("nombre"));
				
				personaje.setDefensa(rs.getInt("defensa"));
				personaje.setEnergia(rs.getInt("energia"));
				personaje.setEvasion(rs.getInt("evasion"));
				personaje.setVida(rs.getInt("vida"));
				personaje.setPuntosDisponibles(rs.getInt("puntosDisponibles"));
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
		
		return personaje;
	}
	
	public ArrayList<Personaje> getAll(){
		
		ArrayList<Personaje> personajes = new ArrayList<Personaje>();
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("SELECT * FROM personajes");
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Personaje personaje = new Personaje(rs.getString("nombre"));
				
				personaje.setId(rs.getInt("id"));
				personaje.setDefensa(rs.getInt("defensa"));
				personaje.setEnergia(rs.getInt("energia"));
				personaje.setEvasion(rs.getInt("evasion"));
				personaje.setVida(rs.getInt("vida"));
				personaje.setPuntosDisponibles(rs.getInt("puntosDisponibles"));
				
				personajes.add(personaje);
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
		
		return personajes;
	}
	
	public void add(Personaje personaje) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"INSERT INTO personajes(nombre, vida, energia, defensa, evasion, puntosDisponibles) "+
					"VALUES(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
						
			stmt.setString(1, personaje.getNombre());
			stmt.setInt(2, personaje.getVida());
			stmt.setInt(3, personaje.getEnergia());
			stmt.setInt(4, personaje.getDefensa());
			stmt.setInt(5, personaje.getEvasion());
			stmt.setInt(6, personaje.getPuntosDisponibles());
			stmt.execute();
			
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
	
	public void update(Personaje personaje) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"UPDATE personajes " +
					"SET nombre = ?, vida = ?, energia = ?, defensa = ?, evasion = ?, puntosDisponibles = ? "+
					"WHERE id = ?");
						
			stmt.setString(1, personaje.getNombre());
			stmt.setInt(2, personaje.getVida());
			stmt.setInt(3, personaje.getEnergia());
			stmt.setInt(4, personaje.getDefensa());
			stmt.setInt(5, personaje.getEvasion());
			stmt.setInt(6, personaje.getPuntosDisponibles());
			stmt.setInt(7, personaje.getId());
			stmt.execute();
			
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
	
	public void delete() {
		
	}
}
