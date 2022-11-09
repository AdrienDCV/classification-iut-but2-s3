package intefarces;

public interface IValueNormalizer {

    public enum NormalizerTypes {
    
        // class attributes
        NUMBER_NORMALIZER("NN"),
        ENUM_NORMALIZER("EN"),
        BOOLEAN_NORMALIZER("BN"),
        STRING_NORMALIZER("SN");
    
        private String label;
    
        // constructor(s)
        private NormalizerTypes(String label) {
            this.label = label;
        }
    
        // methods
        public String getLabel() {
            return this.label;
        }
    }

/**
* Retourne la valeur en parametre normalisee (entre 0 et 1).
*/
public double normalize(Object value);
/**
* De-normalise la valeur en parametre (qui est entre 0 et 1)
* Retourne la « vraie » valeur correspondante pour la colonne
* associee au normaliseur
*/
public Object denormalize(double value);
}