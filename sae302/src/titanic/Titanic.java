package titanic;

import com.opencsv.bean.CsvBindByName;
import intefarces.IPoint;
import model.Category;
import model.Column;

public class Titanic implements IPoint {
	
	@CsvBindByName(column = "PassengerId")
	private int passengerID;
	@CsvBindByName(column = "Survived")
	private int survived;
	@CsvBindByName(column = "Pclass")
	private int pClass;
	@CsvBindByName(column = "Name")
	private String name;
	@CsvBindByName(column = "Sex")
	private Sex sex;
	@CsvBindByName(column = "Age")
	private double age;
	@CsvBindByName(column = "SibSp")
	private int sibSp;
	@CsvBindByName(column = "Parch")
	private int parch;
	@CsvBindByName(column = "Ticket")
	private String ticket;
	@CsvBindByName(column = "Fare")
	private double fare;
	@CsvBindByName(column = "Cabin")
	private String cabin;
	@CsvBindByName(column = "Embarked")
	private Embarked embarked;

	
	public Titanic() {};

	public Titanic(int passengerID, int survived, int pClass, String name, Sex sex, double age, int sibSp,
			int parch, String ticket, double fare, String cabin, Embarked embarked) {
		super();
		this.passengerID = passengerID;
		this.survived = survived;
		this.pClass = pClass;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.sibSp = sibSp;
		this.parch = parch;
		this.ticket = ticket;
		this.fare = fare;
		this.cabin = cabin;
		this.embarked = embarked;
	}

	public Titanic(int passengerID, int pClass, String name, Sex sex, double age, int sibSp,
			int parch, String ticket, double fare, String cabin, Embarked embarked) {
		super();
		this.passengerID = passengerID;
		this.pClass = pClass;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.sibSp = sibSp;
		this.parch = parch;
		this.ticket = ticket;
		this.fare = fare;
		this.cabin = cabin;
		this.embarked = embarked;
	}



	@Override
	public String toString() {
		return "Titanic [passengerID=" + passengerID + ", survived=" + survived + ", pClass=" + pClass
				+ ", name=" + name + ", sex=" + sex + ", age=" + age + ", sibSp=" + sibSp + ", parch=" + parch
				+ ", ticket=" + ticket + ", fare=" + fare + ", cabin=" + cabin + ", embarked=" + embarked + "]";
	}
	
	

	public int getPassengerID() {
		return passengerID;
	}

	public int getSurvived() {
		return survived;
	}

	public int getpClass() {
		return pClass;
	}

	public String getName() {
		return name;
	}

	public Sex getSex() {
		return sex;
	}

	public double getAge() {
		return age;
	}

	public int getSibSp() {
		return sibSp;
	}

	public int getParch() {
		return parch;
	}

	public String getTicket() {
		return ticket;
	}

	public double getFare() {
		return fare;
	}

	public String getCabin() {
		return cabin;
	}

	public Embarked getEmbarked() {
		return embarked;
	}

	@Override
	public Object getValue(Column col) {
		if (col.getName().equals("PassengerId")) return this.passengerID;
		if (col.getName().equals("Survived")) return this.survived;
		if (col.getName().equals("Pclass")) return this.pClass;
		if (col.getName().equals("Name")) return this.name;
		if (col.getName().equals("Sex") && this.sex != null) {
			return this.sex;
		} else if ((col.getName().equals("Sex"))) {
			return Sex.UNKNOWN;
		}
		if (col.getName().equals("Age")) return this.age;
		if (col.getName().equals("SibSp")) return this.sibSp;
		if (col.getName().equals("Parch")) return this.parch;
		if (col.getName().equals("Ticket")) return this.ticket;
		if (col.getName().equals("Fare")) return this.fare;
		if (col.getName().equals("Cabin")) return this.cabin;
		if (col.getName().equals("Embarked") && this.embarked != null) {
			return this.embarked;
		} else if (col.getName().equals("Embarked")) {
			return Embarked.UNKNOWN;
		}
		return null;
	}

	@Override
	public double getNormalizedValue(Column xcol) {
		return xcol.getNormalizedValue(this);
	}

    public boolean hasSurvived() {
    	
		if (this.survived == 1 ) return true;
		return false;
    }

	public void setSurvived(Category category) {
	    if(category.getCategoryName().equals("Survived")) {
			this.survived = 1;
		} else {
			this.survived = 0;
		}
	}
    
	
}