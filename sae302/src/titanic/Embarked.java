package titanic;

public enum Embarked {
	UNKNOWN("unknown"), S("S"), C("C"), Q("Q");

	private String label;

	Embarked(String label) {
		this.label = label;
	}
	public String getLabel() {
		return this.label;
	}

}