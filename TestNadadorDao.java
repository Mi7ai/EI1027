package pr2.dao;

import java.util.Set;

public class TestNadadorDao {
	public static void main(String[] args) { 
		NadadorDao dao = new NadadorDao();
		System.out.println("Llista de nadadors a la base de dades:");
		Set<Nadador> nadadors = dao.getNadadors();
		for (Nadador n : nadadors)
			System.out.println(n);

		
		Nadador unNadador = new Nadador();
		unNadador.setNom("Rafael Muñoz Pérez");
		unNadador.setNumFederat("1234ABC");
		unNadador.setEdat(24);
		unNadador.setSexe("Masculí");
		dao.addNadador(unNadador);

		System.out.println("\nMadador afegit a la base de dades:");
		unNadador = dao.getNadador("Rafael Muñoz Pérez");
		System.out.println(unNadador);

		unNadador.setEdat(25);
		dao.updateNadador(unNadador);

		System.out.println("\nMadador modificat a la base de dades (ara edat=25):");
		unNadador = dao.getNadador("Rafael Muñoz Pérez");
		System.out.println(unNadador);

		dao.deleteNadador(unNadador);

		System.out.println("\nMadador esborrat a la base de dades (deu ser null):");
		unNadador = dao.getNadador("Rafael Muñoz Pérez");
		System.out.println(unNadador);
		
	}
}
