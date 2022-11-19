package titanic;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;


public class ChargementDonneesTitanic {
	public static List<Titanic> charger(String fileName) {
        try {
        	return new CsvToBeanBuilder<Titanic>(Files.newBufferedReader(Paths.get(fileName)))
                    .withSeparator(',')
                    .withType(Titanic.class)
                    .build().parse();
        } catch (InvalidPathException e) {
        	System.err.println("Le fichier n'existe pas");
        	return new ArrayList<Titanic>();
        } catch(IllegalStateException e) {
        	System.err.println("Java n'a pas pu executer la requête");
        	return new ArrayList<Titanic>();
        } catch(IOException e) {
        	System.err.println("Ioexception");
        	return new ArrayList<Titanic>();
        }
    }
}