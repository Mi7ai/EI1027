package pr2.guiat;

//STEP 1. Importar els paquets necessàris 
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pr2.ConnectionManager;

public class SelectPreparedStatementPostgreSQL {
 
	public static void main(String[] argv) throws Exception {
		//STEP 2: connectar amb la base de dades
		
		Connection conn = ConnectionManager.getConnection();
		ResultSet result=null;
		ResultSet result2=null;
		ResultSet result3=null;
		
		//STEP 3: Crear i executar la sentència de tipus consulta
		try {
 			System.out.println("Executant la consulta...");
			
			String sql = "SELECT num_federat, pais, edat" +
			" from Nadador " +
			" where nom= ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
         		  	
			//Donar el valor del paràmetre d'entrada   
			stmt.setString(1,"Gemma Mengual");
			
			result= stmt.executeQuery();
			System.out.println("Dades Nadador trobades...");
			//--------------------------------------
			String sql2 = "SELECT * from Classificacio where posicio = ? ;";

			PreparedStatement stmt2 = conn.prepareStatement(sql2);

			//Donar el valor del paràmetre d'entrada   
			stmt2.setInt(1,1);

			result2= stmt2.executeQuery();
			System.out.println("Dades Classificacio trobades...");
			//--------------------------------------
			String sql3 = "SELECT nom, edat from Nadador where pais = ? ;";

			PreparedStatement stmt3 = conn.prepareStatement(sql3);

			//Donar el valor del paràmetre d'entrada   
			stmt3.setString(1,"Espanya");

			result3= stmt3.executeQuery();
			System.out.println("Dades Nadador trobades...");
 		}
		catch (SQLException e) {
			System.out.println("No ha sigut possible executar la consulta.... ");
			e.printStackTrace();
			return;
		}
		try {	
			//Mostrar el ResultSet
			if (result != null) { // Si result == null no hi ha dades que mostrar
				if ( result.next() ) // amb aquest while processem totes les tuples que hi ha en result
				{   /* Per a cada columna hem de buscar la seua dada:*/
					System.out.println("Num. federat: " + result.getString("num_federat")); //en aquest cas accedim per el nom de la columna
					System.out.println("País del nadador " + result.getString("pais"));
					System.out.println("Edat del nadador" + result.getInt("edat"));
					System.out.println("----------------------------------");
				}
				result.close();
			}

			if (result2 != null) { // Si result == null no hi ha dades que mostrar
				if ( result2.next() ) // amb aquest while processem totes les tuples que hi ha en result
				{   /* Per a cada columna hem de buscar la seua dada:*/
					System.out.println("Nom del nadador: " + result2.getString("nom_nadador"));
					System.out.println("Nom de la prova: " + result2.getString("nom_prova"));
					System.out.println("Posicio del nadador" + result2.getInt("posicio"));
					System.out.println("----------------------------------");
				}
				result2.close();
			}

			if (result3 != null) { // Si result == null no hi ha dades que mostrar
				if ( result3.next() ) // amb aquest while processem totes les tuples que hi ha en result
				{   /* Per a cada columna hem de buscar la seua dada:*/
					System.out.println("Nom del nadador: " + result3.getString("nom_nadador"));
					System.out.println("Edat del nadador" + result3.getInt("edat"));

					System.out.println("----------------------------------");
				}
				result3.close();
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
 		}
	}

}

