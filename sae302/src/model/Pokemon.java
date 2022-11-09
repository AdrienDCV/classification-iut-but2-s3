package model;

import com.opencsv.bean.CsvBindByName;

import intefarces.IColumn;
import intefarces.IPoint;

public class Pokemon implements IPoint {
	@CsvBindByName(column = "name")
	private String name;
	@CsvBindByName(column = "base_egg_steps")
	private int baseEggSteps;
	@CsvBindByName(column = "capture_rate")
	private double captureRate;
	@CsvBindByName(column = "experience_growth")
	private int experienceGrowth;
	@CsvBindByName(column = "speed")
	private double speed;
	@CsvBindByName(column = "is_legendary")
	private boolean isLegendary;
	
	public Pokemon(String name, int baseEggSteps, double captureRate, int experienceGrowth, double speed,
			boolean isLegendary) {
		this.name = name;
		this.baseEggSteps = baseEggSteps;
		this.captureRate = captureRate;
		this.experienceGrowth = experienceGrowth;
		this.speed = speed;
		this.isLegendary = isLegendary;
	}

	public Pokemon() {};

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", baseEggSteps=" + baseEggSteps + ", captureRate=" + captureRate
				+ ", experienceGrowth=" + experienceGrowth + ", speed=" + speed + ", isLegendary=" + isLegendary + "]";
	}

	public String getName() {
		return name;
	}
	public int getBaseEggSteps() {
		return baseEggSteps;
	}
	public double getCaptureRate() {
		return captureRate;
	}
	public int getExperienceGrowth() {
		return experienceGrowth;
	}
	public double getSpeed() {
		return speed;
	}
	public boolean isLegendary() {
		return isLegendary;
	}
	@Override
	public Object getValue(IColumn col) {
        if (col.getName().equals("name")) return this.name;
		if (col.getName().equals("baseEggStep")) return this.baseEggSteps;
		if (col.getName().equals("captureRate")) return this.captureRate;
		if (col.getName().equals("experienceGrowth")) return this.experienceGrowth;
		if (col.getName().equals("speed")) return this.speed;
		if (col.getName().equals("isLegendary")) return this.isLegendary;
		return null;
	}

	@Override
	public double getNormalizedValue(IColumn xcol) {
		return xcol.getNormalizedValue(this);
	}
	
	
}
