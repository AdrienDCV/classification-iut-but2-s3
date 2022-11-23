package titanic;

public enum Sex {
	UNKNOWN("unknown"), MALE("male"), FEMALE("female");
	
	String valeur;

	Sex(String valeur) {
		this.valeur = valeur;
	}	
}