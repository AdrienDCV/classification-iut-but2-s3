package model;

import java.util.ArrayList;

public class ColumnNull extends Column{

    public ColumnNull() {
        super("", null, new ArrayList<>());
    }

    @Override
    public boolean isNormalizable() {
        return false;
    }

}
