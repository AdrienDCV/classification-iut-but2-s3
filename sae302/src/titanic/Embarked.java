package titanic;

public enum Embarked {
	S("S",1), C("C",2), Q("Q",3);

	private String label;
	private int idx;

	Embarked(String label, int idx) {
		this.label = label;
		this.idx = idx;
	}

	public int getIdx() {
		return this.idx;
	}

	public String getLabel() {
		return this.label;
	}

}