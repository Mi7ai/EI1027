package pr2.dao; 

import java.util.Set;
import java.util.HashSet;

public class Nadador {
	String nom;
	String numFederat;
	int edat;
	String sexe;
	Set<Classificacio> classificacions = new HashSet<Classificacio>();
		
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; } 
	public String getNumFederat() { return numFederat; }
	public void setNumFederat(String numFederat) { this.numFederat = numFederat; } 
	public int getEdat() { return edat; }
	public void setEdat(int edat) { this.edat = edat; } 
	public String getSexe() { return sexe; }
	public void setSexe(String sexe) { this.sexe = sexe; } 
	public Categoria getCategoria () {
		Categoria categoria;
		if (edat < 12) 
			categoria = Categoria.ALEVI;
		else if (edat < 14) 
			categoria = Categoria.JUVENIL;
		else if (edat < 16)
			categoria = Categoria.CADET;
		else if (edat < 18) 
			categoria = Categoria.JUNIOR;
		else 
			categoria = Categoria.SENIOR; 
 		return categoria;
	}
	
	@Override
	public String toString() {
		return "Nadador [nom=" + nom + ", numFederat=" + numFederat + ", edat="
				+ edat + ", sexe=" + sexe + ", classificacions="
				+ classificacions + "]";
	} 
}
