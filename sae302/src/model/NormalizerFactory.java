package model;

public class NormalizerFactory {

    public static ValueNormalizer creatValueNormalizer(Column column) {
        if (getColumClassName(column).equals("NumberColumn")) {
            return new NumberValueNormalizer(column);
        }
        if (getColumClassName(column).equals("EnumColumn")) {
            return new EnumValueNormalizer(column);
        }
        if (getColumClassName(column).equals("BooleanColumn")) {
            return new BooleanValueNormalizer(column);
        }
        return new ValueNormalizerNull(column);

    }

    private static String getColumClassName(Column column) {
        String[] columnClassName = column.getClass().getName().split("\\.");
        int idxClassName = (columnClassName.length)-1;
        return columnClassName[idxClassName];
    }

}
