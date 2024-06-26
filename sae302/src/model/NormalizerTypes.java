package model;

/**
* Liste tous les normaliseurs connus par le programme. A chaque valeur
* dans cette liste doit correspondre
* une classe qui implemente <i>INormalizer</i>.
* <ul>
* <li>NUMBER_NORMALIZER: Normalise une valeur numerique (entiere ou
* reelle)</li>
* <li>ENUM_NORMALIZER : Normalise une valeur ordinale en une valeur comprise entre 0 et 1</li>
* <li>etc. Chaque type enumere cree pour un DataSet doit avoir une
* constante associee et un <i>normaliseur</i></li>
* </ul>
*/
public enum NormalizerTypes {
    
    // class attributes
    NUMBER_NORMALIZER("NN"),
    ENUM_NORMALIZER("EN"),
    BOOLEAN_NORMALIZER("BN"),
    NULL("NULL");

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