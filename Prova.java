package pr2.dao; 

import java.util.Set;
import java.util.HashSet;

public class Prova {
    
	String nom;
    String descripcio;
    String tipus;
    Set<Classificacio> classificacions = new HashSet<Classificacio>();

	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; } 
	public String getDescripcio() { return descripcio; }
	public void setDescripcio(String descripcio) { this.descripcio = descripcio; } 
	public String getTipus() { return tipus; }
	public void setTipus(String tipus) { this.tipus = tipus; } 

    @Override
	public String toString() {
		return "Prova [nom=" + nom + ", descripcio=" + descripcio + ", tipus="
				+ tipus + ", classificacions=" + classificacions + "]";
	}

}

