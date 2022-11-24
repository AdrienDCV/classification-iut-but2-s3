package pokemon;

import com.opencsv.bean.CsvBindByName;

import intefarces.IColumn;
import intefarces.IPoint;

public class Pokemon implements IPoint {
	@CsvBindByName(column = "name")
	private String name;
	@CsvBindByName(column = "attack")
	private int attack;
	@CsvBindByName(column = "base_egg_steps")
	private int base_egg_steps;
	@CsvBindByName(column = "capture_rate")
	private double capture_rate;
	@CsvBindByName(column = "defense")
	private int defense;
	@CsvBindByName(column = "experience_growth")
	private int experience_growth;
	@CsvBindByName(column = "hp")
	private int hp;
	@CsvBindByName(column = "sp_attack")
	private int sp_attack;
	@CsvBindByName(column = "sp_defense")
	private int sp_defense;
	@CsvBindByName(column = "type1")
	private String type1;
	@CsvBindByName(column = "type2")
	private String type2;
	@CsvBindByName(column = "speed")
	private double speed;
	@CsvBindByName(column = "is_legendary")
	private boolean is_legendary;
	
	
	public Pokemon(String name, int attack, int baseEggSteps, double captureRate, int defense, int experienceGrowth,
			int hp, int sp_attack, int sp_defense, String type1, String type2, double speed, boolean isLegendary) {

		this.name = name;
		this.attack = attack;
		this.base_egg_steps = baseEggSteps;
		this.capture_rate = captureRate;
		this.defense = defense;
		this.experience_growth = experienceGrowth;
		this.hp = hp;
		this.sp_attack = sp_attack;
		this.sp_defense = sp_defense;
		this.type1 = type1;
		this.type2 = type2;
		this.speed = speed;
		this.is_legendary = isLegendary;
	}

	public Pokemon() {};

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", attack=" + attack + ", baseEggSteps=" + base_egg_steps + ", captureRate="
				+ capture_rate + ", defense=" + defense + ", experienceGrowth=" + experience_growth + ", hp=" + hp
				+ ", sp_attack=" + sp_attack + ", sp_defense=" + sp_defense + ", type1=" + type1 + ", type2=" + type2
				+ ", speed=" + speed + ", isLegendary=" + is_legendary + "]";
	}

	
	public String getName() {
		return name;
	}

	public int getAttack() {
		return attack;
	}

	public int getBaseEggSteps() {
		return base_egg_steps;
	}

	public double getCaptureRate() {
		return capture_rate;
	}

	public int getDefense() {
		return defense;
	}

	public int getExperienceGrowth() {
		return experience_growth;
	}

	public int getHp() {
		return hp;
	}

	public int getSp_attack() {
		return sp_attack;
	}

	public int getSp_defense() {
		return sp_defense;
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
		return is_legendary;
	}

	@Override
	public Object getValue(IColumn col) {
        if (col.getName().equals("name")) return this.name;
        if (col.getName().equals("attack")) return this.attack;
		if (col.getName().equals("base_egg_steps")) return this.base_egg_steps;
		if (col.getName().equals("capture_rate")) return this.capture_rate;
		if (col.getName().equals("defense")) return this.defense;
		if (col.getName().equals("experience_growth")) return this.experience_growth;
		if (col.getName().equals("hp")) return this.hp;
		if (col.getName().equals("sp_attack")) return this.sp_attack;
		if (col.getName().equals("sp_defense")) return this.sp_defense;
		if (col.getName().equals("type1")) return this.type1;
		if (col.getName().equals("type2")) return this.type2;
		if (col.getName().equals("speed")) return this.speed;
		if (col.getName().equals("is_legendary")) return this.is_legendary;
		return null;
	}

	@Override
	public double getNormalizedValue(IColumn xcol) {
		return xcol.getNormalizedValue(this);
	}
	
	
}