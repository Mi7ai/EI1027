package pr2.dao; 

import java.util.Calendar;

public class Classificacio {
	int posicio;
	Calendar temps;

	public int getPosicio() { return posicio; }
	public void setPosicio(int posicio) { this.posicio = posicio; }

	public Calendar getTemps() { return temps; }
	public void setTemps(Calendar temps) { this.temps = temps; }

	@Override
	public String toString() {
		return "Classificacio [posicio=" + posicio + ", temps=" + temps + "]";
	}
}
