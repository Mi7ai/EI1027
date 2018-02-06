package pr2.guiat;

//STEP 1. Importar els paquets necessàris 
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import pr2.ConnectionManager;

public class InsertPostgreSQL {
 
	public static void main(String[] argv) throws Exception {
		//STEP 2: connectar amb la base de dades
		
		Connection conn = ConnectionManager.getConnection();
		
		//STEP 3: Crear i executar la sentència de tipus actualització
		try {
 			System.out.println("Executant el insert...");
      			Statement stmt = conn.createStatement();
      
			    String sql = "INSERT INTO Nadador VALUES ('Gemma Mengual','A123450987','Espanya', 33, 'Femeni');"
			    +"INSERT INTO Nadador VALUES ('Franziska van Almsick','XA1235690','Alemanya', 30, 'Femení');" 		    		
			    +"INSERT INTO Nadador VALUES ('Michael Phelps','AP093456Q','USA', 23, 'Masculí');"
			    +"INSERT INTO Nadador VALUES ('Mireia Belmonte Garcia','A012987523','Espanya', 18, 'Femení');";
			    stmt.executeUpdate(sql);
				System.out.println("Dades taula nadador inserides...");
				
				String sql2 = "INSERT INTO Prova VALUES ('Duos Sincro','Natacio Sincronitzada,modalitat duos','Grupal');"
					    +"INSERT INTO Prova VALUES ('4x100m. Estils','100 metres de cada estil','Individual');" 		    		
					    +"INSERT INTO Prova VALUES ('4x100m. Lliures','400 metres crol','Individual');"
					    +"INSERT INTO Prova VALUES ('2x100m Papallona','200 metres en modalitat papallona','Individual');"
					    +"INSERT INTO Prova VALUES ('Combo','Natacio Sincronitzada, modalitat combo (combinat)','Grupal');";
				stmt.executeUpdate(sql2);
				System.out.println("Dades taula prova inserides...");
				
				String sql3 = "INSERT INTO Classificacio VALUES ('Gemma Mengual','Duos Sincro', 1);"
					    +"INSERT INTO Classificacio VALUES ('Mireia Belmonte Garcia','2x100m Papallona',3,'4:20:00');" 		    		
					    +"INSERT INTO Classificacio VALUES ('Michael Phelps','4x100m. Estils',1,'1:54:00');"
					    +"INSERT INTO Classificacio VALUES ('Gemma Mengual','Combo',1);"
					    +"INSERT INTO Classificacio VALUES ('Michael Phelps','4x100m. Lliures',1,'1:00:00');";
				stmt.executeUpdate(sql3);
				System.out.println("Dades taula classificacio inserides...");
				System.out.println("----> Ok!");
 		}
		catch (SQLException e) {
			System.out.println("No ha segut possible executar la consulta.... ");
			e.printStackTrace();
			return;
		}
		
	}

}

