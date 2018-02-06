package pr2.guiat;

//STEP 1. Importar els paquets necessàris 
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import pr2.ConnectionManager;
 
public class CreateTablePostgreSQL {
 
	public static void main(String[] argv) throws Exception {
		//STEP 2: connectar amb la base de dades
		
		Connection conn = ConnectionManager.getConnection();
		
		//STEP 3: Crear i executar la sentència de tipus actualització
		try {
 			System.out.println("Creant una taula en la base de dades...");
      			Statement stmt = conn.createStatement();
      
    		  	String sql = "CREATE TABLE NADADOR (" +
                   	"Nom VARCHAR(50), " +
                   	" num_federat VARCHAR(10), " + 
                   	" pais VARCHAR(20), " + 
                   	" edat INTEGER, " +
					" sexe VARCHAR(10), " + 
                   	" CONSTRAINT cp_nadador PRIMARY KEY (nom), " + 
			        " CONSTRAINT calt_nadador UNIQUE (num_federat), "+
			        " CONSTRAINT ri_nadador_edat CHECK (edat>15));";

			    stmt.executeUpdate(sql);
				System.out.println("Taula Nadador creada...");
				
				String sql2 = "CREATE TABLE Prova ("
						+ " nom VARCHAR(50), "
						+ "descripcio VARCHAR(60), "
						+ "tipus VARCHAR(30), "
						+ "CONSTRAINT cp_prova PRIMARY KEY (nom));";

				stmt.executeUpdate(sql2);
				System.out.println("Taula Prova creada...");
				
				String sql3 = "CREATE TABLE Classificacio ("
						+ " nom_nadador VARCHAR(50), "
						+ "nom_prova VARCHAR(50), "
						+ "posicio INTEGER, "
						+ "temps TIME,"
						+ "CONSTRAINT cp_classificacio PRIMARY KEY (nom_nadador, nom_prova),"
						+ "CONSTRAINT ca_classificacio_nad FOREIGN KEY (nom_nadador) REFERENCES Nadador(nom) ON DELETE RESTRICT ON UPDATE CASCADE,"
						+ "CONSTRAINT ca_classificacio_prova FOREIGN KEY (nom_prova) REFERENCES Prova(nom) ON DELETE CASCADE ON UPDATE CASCADE, "
						+ "CONSTRAINT ri_temps CHECK(temps>'00:00:00.00'));";

				stmt.executeUpdate(sql3);
				System.out.println("Taula Classificacio creada...");

		}
		catch (SQLException e) {
			System.out.println("No s'ha pogut crear la taula.... ");
			e.printStackTrace();
			return;
		}
	}

}

