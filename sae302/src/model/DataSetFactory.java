package model;

import model.iris.IrisDataSet;
import model.pokemon.PokemonDataSet;
import model.titanic.TitanicDataSet;

public class DataSetFactory  {
    
    public static DataSet createDataSet(String dataSetName) {
        if (dataSetName.equals("Pokemon")) return new PokemonDataSet("PokemonDataSet");
        if (dataSetName.equals("Titanic")) return new TitanicDataSet("TitanicDataSet");
        if (dataSetName.equals("Iris")) return new IrisDataSet("IrisDataSet");
        return new DataSetNull();
    }

}
