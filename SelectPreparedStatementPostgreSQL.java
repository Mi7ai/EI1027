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
			System.out.println("Dades trobades...");
 		}
		catch (SQLException e) {
			System.out.println("No ha sigut possible executar la consulta.... ");
			e.printStackTrace();
			return;
		}
		//Mostrar el ResultSet
		if (result != null) // Si result == null no hi ha dades que mostrar
			while ( result.next() ) // amb aquest while processem totes les tuples que hi ha en result
			{   /* Per a cada columna hem de buscar la seua dada:*/
				System.out.println("Num. federat: " + result.getString("num_federat")); //en aquest cas accedim per el nom de la columna
				System.out.println("País del nadador " + result.getString("pais"));
				System.out.println("Edat del nadador" + result.getInt("edat"));
				System.out.println("----------------------------------");
			}
	}

}

