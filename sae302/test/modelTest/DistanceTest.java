package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DistanceEuclidienne;
import model.DistanceManhattan;
import model.pokemon.Pokemon;
import model.pokemon.PokemonDataSet;

public class DistanceTest {

	PokemonDataSet pokemons;
	Pokemon poke1, poke2;
	DistanceEuclidienne distanceEuclidienne;
	DistanceManhattan distanceManhattan;
	
	@BeforeEach
	public void setup() {
		pokemons=new PokemonDataSet();
		pokemons.loadFromFile("./res/pokemon_train.csv");
		poke1=new Pokemon("test1",1000,30720,45, 0, 0, 0, 0, 0, "", "", 0, true);
		poke2=new Pokemon("test2",1000,30720,3, 0, 0, 0, 0, 0, "", "", 0, true);
		distanceEuclidienne=new DistanceEuclidienne();
		distanceManhattan=new DistanceManhattan();
	}
	
	@Test
	public void distanceEuclidienneTest() {
		assertEquals(0.16,distanceEuclidienne.calculDistance(poke1, poke2,pokemons.defaultXCol(),pokemons.defaultYCol()),0.01);
	
	}
	
	@Test
	public void distanceManhatanTest() {
		assertEquals(0.20,distanceManhattan.calculDistance(poke1, poke2,pokemons.defaultXCol(),pokemons.defaultYCol()),0.01);
	}
}
