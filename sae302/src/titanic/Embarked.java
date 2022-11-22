package titanic;

public enum Embarked {
	S("S"), C("C"), Q("Q");

	private String label;

	Embarked(String label) {
		this.label = label;
	}
	public String getLabel() {
		return this.label;
	}

}