package pr2.dao;

import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

import pr2.ConnectionManager;

public class NadadorDao {
	private final static Logger Log = Logger.getLogger(NadadorDao.class.getName()); 

	Set<Nadador> getNadadors() {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
		}
		catch (ClassNotFoundException e) {
			Log.severe("Driver JDBC no trobat");
			e.printStackTrace();
			return null;
		}
		catch (SQLException e) {
			Log.severe("Error creant connexió JDBC");
			e.printStackTrace();
			return null;
		}
		HashSet<Nadador> nadadors = new HashSet<Nadador>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select nom, num_federat, sexe, edat from Nadador");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Nadador nadador = new Nadador();
				nadador.setNom(rs.getString("nom"));
				nadador.setNumFederat(rs.getString("num_federat"));
				nadador.setSexe(rs.getString("sexe"));
				nadador.setEdat(rs.getInt("edat"));
				nadadors.add(nadador);
			}
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
			return null;
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (SQLException e) {
					Log.warning("Error tancant ResultSet");
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					Log.warning("Error tancant PreparedStatement");
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (SQLException e) {
				Log.warning("Error tancant connexió JDBC");				
				e.printStackTrace();
			}
		}
		return nadadors;
	}
	
	Nadador getNadador(String nom) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
		}
		catch (ClassNotFoundException e) {
			Log.severe("Driver JDBC no trobat");
			e.printStackTrace();
			return null;
		}
		catch (SQLException e) {
			Log.severe("Error creant connexió JDBC");
			e.printStackTrace();
			return null;
		}
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Nadador nadador = null;
		try {
			rs = stmt.executeQuery();
 				 
				  
				for (Nadador n : getNadadors()) {
					if (n.nom.equals(nom)) {
						stmt = conn.prepareStatement("select nom from Nadador where nom like="+nom+"");	
					}
				}
				 
				
				stmt.executeQuery();
			  
		}catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
			return null;
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (SQLException e) {
					Log.warning("Error tancant ResultSet");
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					Log.warning("Error tancant PreparedStatement");
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (SQLException e) {
				Log.warning("Error tancant connexió JDBC");				
				e.printStackTrace();
			}
		}
		return nadador;
	}
	
	void addNadador(Nadador nadador) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
		}
		catch (ClassNotFoundException e) {
			Log.severe("Driver JDBC no trobat");
			e.printStackTrace();
			return;
		}
		catch (SQLException e) {
			Log.severe("Error creant connexió JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			 stmt = conn.prepareStatement(
					"insert into Nadador(nom, num_federat, edat, sexe) "
					+ "values(?, ?, ?, ?)");
			stmt.setString(1, nadador.getNom());
			stmt.setString(2, nadador.getNumFederat());
			stmt.setInt(3, nadador.getEdat());
			stmt.setString(4, nadador.getSexe());
			stmt.execute();	
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
		}
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					Log.warning("Error tancant PreparedStatement");
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (SQLException e) {
				Log.warning("Error tancant connexió JDBC");				
				e.printStackTrace();
			}
		}
	}

	void updateNadador(Nadador nadador) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
		}
		catch (ClassNotFoundException e) {
			Log.severe("Driver JDBC no trobat");
			e.printStackTrace();
			return;
		}
		catch (SQLException e) {
			Log.severe("Error creant connexió JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"update Nadador "
					+ "set num_federat = ?,"
					+ "edat = ?,"
					+ "sexe = ?"
					+ "where nom = ?");
			stmt.setString(1, nadador.getNumFederat());
			stmt.setInt(2, nadador.getEdat());
			stmt.setString(3, nadador.getSexe());
			stmt.setString(4, nadador.getNom());
			stmt.execute();	
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
		}
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					Log.warning("Error tancant PreparedStatement");
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (SQLException e) {
				Log.warning("Error tancant connexió JDBC");				
				e.printStackTrace();
			}
		}
	}

	void deleteNadador(Nadador nadador) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
		}
		catch (ClassNotFoundException e) {
			Log.severe("Driver JDBC no trobat");
			e.printStackTrace();
			return;
		}
		catch (SQLException e) {
			Log.severe("Error creant connexió JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			// Codi que esborra  el nadador de la base de dades	
			// A completar
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
		}
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					Log.warning("Error tancant PreparedStatement");
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (SQLException e) {
				Log.warning("Error tancant connexió JDBC");				
				e.printStackTrace();
			}
		}
	}
}
