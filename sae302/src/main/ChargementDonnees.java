package main;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;


public class ChargementDonnees {
	public static List<Pokemon> charger(String fileName) {
        try {
        	return new CsvToBeanBuilder<Pokemon>(Files.newBufferedReader(Paths.get(fileName)))
                    .withSeparator(',')
                    .withType(Pokemon.class)
                    .build().parse();
        } catch (InvalidPathException e) {
        	System.out.println("Le fichier n'existe pas");
        	return new ArrayList<Pokemon>();
        } catch(IllegalStateException e) {
        	System.out.println("Java n'a pas pu executer la requête");
        	return new ArrayList<Pokemon>();
        } catch(IOException e) {
        	System.out.println("Ioexception");
        	return new ArrayList<Pokemon>();
        }
    }
}
