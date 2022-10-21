package main;

import com.opencsv.bean.CsvBindByName;

public class Pokemon {
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

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseEggSteps() {
		return baseEggSteps;
	}

	public void setBaseEggSteps(int baseEggSteps) {
		this.baseEggSteps = baseEggSteps;
	}

	public double getCaptureRate() {
		return captureRate;
	}

	public void setCaptureRate(double captureRate) {
		this.captureRate = captureRate;
	}

	public int getExperienceGrowth() {
		return experienceGrowth;
	}

	public void setExperienceGrowth(int experienceGrowth) {
		this.experienceGrowth = experienceGrowth;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public boolean isLegendary() {
		return isLegendary;
	}

	public void setLegendary(boolean isLegendary) {
		this.isLegendary = isLegendary;
	}
	
	
}
