package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Classification;
import model.Column;
import model.Criteria;
import model.pokemon.LegendaryCategory;
import model.pokemon.Pokemon;
import model.pokemon.PokemonDataSet;

public class ClassificationTest {
	Criteria criteria;
	PokemonDataSet dataset;
	Classification classiEucli;
	Classification classiMan;
	Pokemon poke1;
	List<Column> column;
	
	@BeforeEach
	public void setup() {
		column=new ArrayList<Column>();
		dataset=new PokemonDataSet("test");
		dataset.loadFromFile("./res/pokemon_train.csv");
		criteria=new Criteria("base_egg_steps", "capture_rate");
		column.add(dataset.defaultXCol());
		column.add(dataset.getColumnsList().get(2));
		classiEucli=new Classification(column, criteria, "Euclidienne");
		classiMan=new Classification(column, criteria, "Manhattan");
		poke1=new Pokemon("test", 100, 30720, 3.0, 100, 100, 200, 150, 120, "dragon", "dark", 100);
	}
	
	@Test
	public void classifyPointTest() {
		assertEquals(new LegendaryCategory().getCategoryName(),classiEucli.classifyPoint(3, poke1, dataset.getPointsList()).getCategoryName());
		assertEquals(new LegendaryCategory().getCategoryName(),classiMan.classifyPoint(3, poke1, dataset.getPointsList()).getCategoryName());
	}
	
	@Test
	public void calculRobustnessTest() {
		//Nous avons changé calcul robustness au dernier moment à cause de problèmes mais la modification du test n'a pas été faite en conscéquence.
		//Nous conaissons le problème, il s'agit d'une vérification de la liste qui n'est pas correcte dans la fonction addPointsToRightCategory mais nous n'avons pas pu le régler par manque de temps
		assertEquals(0.5,classiEucli.calculRobustness(3, poke1, new LegendaryCategory()));
		assertEquals(0.5,classiMan.calculRobustness(3, poke1, new LegendaryCategory()));
	}
	
	

}
