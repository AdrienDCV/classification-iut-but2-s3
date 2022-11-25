package model;


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
    public Column defaultXCol() {
        /* nothing */
        return new ColumnNull();
    }

    @Override
    public Column defaultYCol() {
        /* nothing */
        return new ColumnNull();
    }

}
