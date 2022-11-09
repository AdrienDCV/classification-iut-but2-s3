package titanic;

public enum Sex {
	M("male"), F("female");
	
	String valeur;

	Sex(String valeur) {
		this.valeur = valeur;
	}	
}