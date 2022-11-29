package pokemon;

import com.opencsv.bean.CsvBindByName;


import intefarces.IPoint;
import model.Category;
import model.Column;

public class Pokemon implements IPoint {
	@CsvBindByName(column = "name")
	private String name;
	@CsvBindByName(column = "attack")
	private int attack;
	@CsvBindByName(column = "base_egg_steps")
	private int baseEggSteps;
	@CsvBindByName(column = "capture_rate")
	private double captureRate;
	@CsvBindByName(column = "defense")
	private int defense;
	@CsvBindByName(column = "experience_growth")
	private int experienceGrowth;
	@CsvBindByName(column = "hp")
	private int hp;
	@CsvBindByName(column = "sp_attack")
	private int spAttack;
	@CsvBindByName(column = "sp_defense")
	private int spDefense;
	@CsvBindByName(column = "type1")
	private String type1;
	@CsvBindByName(column = "type2")
	private String type2;
	@CsvBindByName(column = "speed")
	private double speed;
	@CsvBindByName(column = "is_legendary")
	private boolean isLegendary;
	
	
	public Pokemon(String name, int attack, int baseEggSteps, double captureRate, int defense, int experienceGrowth,
			int hp, int sp_attack, int sp_defense, String type1, String type2, double speed, boolean isLegendary) {

		this.name = name;
		this.attack = attack;
		this.baseEggSteps = baseEggSteps;
		this.captureRate = captureRate;
		this.defense = defense;
		this.experienceGrowth = experienceGrowth;
		this.hp = hp;
		this.spAttack = sp_attack;
		this.spDefense = sp_defense;
		this.type1 = type1;
		this.type2 = type2;
		this.speed = speed;
		this.isLegendary = isLegendary;
	}

	public Pokemon(String name, int attack, int baseEggSteps, double captureRate, int defense, int experienceGrowth,
			int hp, int sp_attack, int sp_defense, String type1, String type2, double speed) {

		this.name = name;
		this.attack = attack;
		this.baseEggSteps = baseEggSteps;
		this.captureRate = captureRate;
		this.defense = defense;
		this.experienceGrowth = experienceGrowth;
		this.hp = hp;
		this.spAttack = sp_attack;
		this.spDefense = sp_defense;
		this.type1 = type1;
		this.type2 = type2;
		this.speed = speed;
	}

	public Pokemon() {};

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", attack=" + attack + ", baseEggSteps=" + baseEggSteps + ", captureRate="
				+ captureRate + ", defense=" + defense + ", experienceGrowth=" + experienceGrowth + ", hp=" + hp
				+ ", sp_attack=" + spAttack + ", sp_defense=" + spDefense + ", type1=" + type1 + ", type2=" + type2
				+ ", speed=" + speed + ", isLegendary=" + isLegendary + "]";
	}

	
	public String getName() {
		return name;
	}

	public int getAttack() {
		return attack;
	}

	public int getBaseEggSteps() {
		return baseEggSteps;
	}

	public double getCaptureRate() {
		return captureRate;
	}

	public int getDefense() {
		return defense;
	}

	public int getExperienceGrowth() {
		return experienceGrowth;
	}

	public int getHp() {
		return hp;
	}

	public int getSpAttack() {
		return spAttack;
	}

	public int getSpDefense() {
		return spDefense;
	}

	public String getType1() {
		return type1;
	}

	public String getType2() {
		return type2;
	}

	public double getSpeed() {
		return speed;
	}

	public boolean isLegendary() {
		return isLegendary;
	}

	@Override
	public Object getValue(Column col) {
        if (col.getName().equals("name")) return this.name;
        if (col.getName().equals("attack")) return this.attack;
		if (col.getName().equals("base_egg_steps")) return this.baseEggSteps;
		if (col.getName().equals("capture_rate")) return this.captureRate;
		if (col.getName().equals("defense")) return this.defense;
		if (col.getName().equals("experience_growth")) return this.experienceGrowth;
		if (col.getName().equals("hp")) return this.hp;
		if (col.getName().equals("sp_attack")) return this.spAttack;
		if (col.getName().equals("sp_defense")) return this.spDefense;
		if (col.getName().equals("type1")) return this.type1;
		if (col.getName().equals("type2")) return this.type2;
		if (col.getName().equals("speed")) return this.speed;
		if (col.getName().equals("is_legendary")) return this.isLegendary;
		return null;
	}

	@Override
	public double getNormalizedValue(Column xcol) {
		return xcol.getNormalizedValue(this);
	}

	public void setIsLegendary(Category category) {
		if(category.getCategoryName().equals("Legendary")) {
			this.isLegendary = true;
		} else {
			this.isLegendary = false;
		}
	}
	
	
	
	
}