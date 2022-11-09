package titanic;

import com.opencsv.bean.CsvBindByName;

import intefarces.IColumn;
import intefarces.IPoint;

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
	private int age;
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

	public Titanic(int passengerID, int survived, int pClass, String name, Sex sex, int age, int sibSp,
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



	@Override
	public String toString() {
		return "FormatDonneeBrut [passengerID=" + passengerID + ", survived=" + survived + ", pClass=" + pClass
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

	public int getAge() {
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
	public Object getValue(IColumn col) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getNormalizedValue(IColumn xcol) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
