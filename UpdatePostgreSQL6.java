package pr2.guiat;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import pr2.ConnectionManager;

public class UpdatePostgreSQL6 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//STEP 2: connectar amb la base de dades
		
				Connection conn = ConnectionManager.getConnection();
				
				//STEP 3: Crear i executar la sentència de tipus actualització
				try {
		 			System.out.println("Executant el insert...");
		      			Statement stmt = conn.createStatement();
		      
					    String sql = "UPDATE Nadador SET edat=32 WHERE nom = 'Gemma Mengual';"
					    + "UPDATE Nadador SET edat = edat - 1 WHERE Pais = 'Espanya';"
					    + "UPDATE Nadador SET edat = edat + 1, pais = 'Espanya'  WHERE Pais = 'Espanya';"					    
					    + "UPDATE Nadador SET edat = 30 WHERE nom IN (SELECT nom FROM Nadador WHERE sexe = 'Masculí') ; ";
					
					
					    stmt.executeUpdate(sql);
						System.out.println("Dades taula nadador actualitzades...");
		 		}
				catch (SQLException e) {
					System.out.println("No ha segut possible executar la consulta.... ");
					e.printStackTrace();
					return;
				}
	}

}
