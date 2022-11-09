package main;

import intefarces.IColumn;
import intefarces.IDataSet;
import intefarces.IPoint;
import intefarces.IValueNormalizer;

public class PokemonColumn implements IColumn{
	ChargementDonneesPokemon dataset;
	@Override
	public void setNormalizer(IValueNormalizer valueNormalizer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getNormalizedValue(IPoint point) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getDenormalizedValue(double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "nom";
	}

	@Override
	public IDataSet getDataset() {
		return this.dataset;
	}

	@Override
	public boolean isNormalizable() {
		// TODO Auto-generated method stub
		return false;
	}

}
