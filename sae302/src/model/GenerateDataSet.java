package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

import pokemon.Pokemon;
import titanic.Titanic;

public class GenerateDataSet {
	
	public DataSet generateDataSet(String fileName) {
	
		List<String> pokemonField = this.getPokemonFieldName();
        System.out.println(pokemonField);
    	return null;
	}
	
	public static void main(String[] args) {
		GenerateDataSet g = new GenerateDataSet();
		g.generateDataSet("/home/infoetu/adrien.degand.etu/2ème année/sae302/equipe-I2/sae302/res/pokemon_train.csv");
	}
	
	public List<String> getPokemonFieldName() {
		try {
			//on récuère la liste des attributs déclaré ex: private java.lang.String pokemon.Pokemon.name
	    	Field[] field = Pokemon.class.getDeclaredFields();
	    	
	    	List<String> parameterName = new ArrayList<String>();
	    	
	    	//récupère une partie de la chaine ex: pokemon.Pokemon.name
	    	for(int i = 0; i < field.length; i ++) {
	    		String[] type = field[i].toString().split(" ");
	    		parameterName.add(type[2]);
	    	}
	    	
	    	//récupère le nom de la colonne : name
	    	List<String> colName = new ArrayList<String>();
	    	for(int i = 0; i < parameterName.size(); i ++) {
	    		String[] name = parameterName.get(i).split("pokemon.Pokemon.");
	    		colName.add(name[1]);
	    	}
	    	
	    	return colName;
		
		} catch (InvalidPathException e) {
        	System.out.println("Le fichier n'existe pas");
        	return null;
        } catch(IllegalStateException e) {
        	System.out.println("Java n'a pas pu executer la requête");
        } 
		return null;
	}
	
	public List<String> getTitanicFieldName() {
		try {
			//on récuère la liste des attributs déclaré ex: private java.lang.String pokemon.Pokemon.name
	    	Field[] field = Titanic.class.getDeclaredFields();
	    	
	    	List<String> parameterName = new ArrayList<String>();
	    	
	    	//récupère une partie de la chaine ex: pokemon.Pokemon.name
	    	for(int i = 0; i < field.length; i ++) {
	    		String[] type = field[i].toString().split(" ");
	    		parameterName.add(type[2]);
	    	}
	    	
	    	//récupère le nom de la colonne : name
	    	List<String> colName = new ArrayList<String>();
	    	for(int i = 0; i < parameterName.size(); i ++) {
	    		String[] name = parameterName.get(i).split("titanic.Titanic.");
	    		colName.add(name[1]);
	    	}
	    	
	    	return colName;
		
		} catch (InvalidPathException e) {
        	System.out.println("Le fichier n'existe pas");
        	return null;
        } catch(IllegalStateException e) {
        	System.out.println("Java n'a pas pu executer la requête");
        } 
		return null;
	}
}
  