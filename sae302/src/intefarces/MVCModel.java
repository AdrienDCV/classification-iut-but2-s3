package intefarces;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;


import com.opencsv.bean.CsvToBeanBuilder;



public abstract class MVCModel implements IMVCModel {
	public abstract void loadFromFile(String datafile);

	@Override
	public abstract void loadFromString(String data);

	@Override
	public IColumn defaultXCol() {
		// return new IColumn ...
		return null;
	}

	@Override
	public IColumn defaultYCol() {
		// return new IColumn ...
		return null;
	}

	@Override
	public void addCategory(ICategory classe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<ICategory> allCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nbColumns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<IColumn> getNormalizableColumns() {
		// TODO Auto-generated method stub
		return null;
	}

}
