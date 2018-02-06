package pr2.guiat;

//STEP 1. Importar els paquets necessàris 
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import pr2.ConnectionManager;

public class SelectPostgreSQL {
 
	public static void main(String[] argv) throws Exception {
		//STEP 2: connectar amb la base de dades
		
		Connection conn = ConnectionManager.getConnection();
		ResultSet result=null;
		ResultSet result2=null;
		ResultSet result3=null;
		Statement stmt = null;
		Statement stmt2 = null;
		Statement stmt3 = null;
		//STEP 3: Crear i executar la sentència de tipus consulta
		try {
 			System.out.println("Executant la consulta...");
      			stmt = conn.createStatement();
    		  	String sql = "SELECT *" +
                   	" from Nadador;";
			
			    result= stmt.executeQuery(sql);
				System.out.println("Dades trobades...");
				
      			stmt2 = conn.createStatement();
				String sql2 = "SELECT nom_nadador, posicio from Classificacio;";
				
				result2= stmt2.executeQuery(sql2);
				System.out.println("Dades trobades...");
					
      			stmt3 = conn.createStatement();
				String sql3 = "SELECT DISTINCT nom_nadador, nom_prova, posicio FROM Classificacio;";
				
				result3= stmt3.executeQuery(sql3);
				System.out.println("Dades trobades...");
 		}
		catch (SQLException e) {
			System.out.println("No ha sigut possible executar la consulta.... ");
			e.printStackTrace();
			return;
		}
		//Mostrar el ResultSet
		if (result != null) // Si result == null no hi ha dades que mostrar
			if ( result.next() ) // amb aquest while processem totes les tuples que hi ha en result
			{   /* Per a cada columna hem de buscar la seua dada:*/
				System.out.println("Nom del nadador: " + result.getString(1)); //en aquest cas accedim per número columna
				System.out.println("Num. federat: " + result.getString(2)); 
				System.out.println("País del nadador " + result.getString(3));
				System.out.println("Edat del nadador" + result.getInt(4));
				System.out.println("Sexe del nadador " + result.getString(5));
				System.out.println("----------------------------------");
			}
			if (result2.next()) {
				System.out.println("Nom del nadador: " + result2.getString(1));
				System.out.println("Posicio del nadador: " + result2.getString(2));
				System.out.println("----------------------------------");
			}
			if (result3.next()) {
				System.out.println("Nom del nadador: " + result3.getString(1));
				System.out.println("Nom de la prova: " + result3.getString(2));
				System.out.println("Posicio del nadador: " + result3.getString(3));
			
			}	
				
		
		
	}

}

