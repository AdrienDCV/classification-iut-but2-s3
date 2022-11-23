package model;

import intefarces.IColumn;

public class DataSetNull extends DataSet {

    public DataSetNull() {
        super();
    }

    @Override
    public void loadFromFile(String datafile) {
        /* nothing */
    }

    @Override
    public void loadFromString(String data) {
        /* nothing */
        
    }

    @Override
    public IColumn defaultXCol() {
        /* nothing */
        return new ColumnNull();
    }

    @Override
    public IColumn defaultYCol() {
        /* nothing */
        return new ColumnNull();
    }

}
