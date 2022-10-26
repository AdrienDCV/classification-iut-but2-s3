package main;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import intefarces.IDataset;
import intefarces.IPoint;
import intefarces.MVCModel;


public class ChargementDonneesPokemon extends MVCModel implements IDataset {
	List<Pokemon> pokemonList;
	
	public void loadFromFile(String fileName) {
        try {
        	this.pokemonList = new CsvToBeanBuilder<Pokemon>(Files.newBufferedReader(Paths.get(fileName)))
                    .withSeparator(',')
                    .withType(Pokemon.class)
                    .build().parse();
        } catch (InvalidPathException e) {
        	System.out.println("Le fichier n'existe pas");
        } catch(IllegalStateException e) {
        	System.out.println("Java n'a pas pu executer la requête");
        } catch(IOException e) {
        	System.out.println("Ioexception");
        }
    }
	
	@Override
	public void loadFromString(String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<IPoint> iterator() {
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNbLines() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLines(List<IPoint> lines) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLine(IPoint element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAllLine(List<IPoint> element) {
		// TODO Auto-generated method stub
		
	}

	public List<Pokemon> getPokemonList() {
		return pokemonList;
	}
	
	

	
}
