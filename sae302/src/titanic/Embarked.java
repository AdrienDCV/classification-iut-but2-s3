package titanic;

public enum Embarked {
	S(0), C(0.5), Q(1);
	
	double valeur;

	Embarked(double valeur) {
		this.valeur = valeur;
	}

	public double getValeur() {
		return valeur;
	}
}