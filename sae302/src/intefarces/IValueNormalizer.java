package intefarces;
public interface IValueNormalizer {
/**
* Liste tous les normaliseurs connus par le programme. A chaque valeur
* dans cette liste doit correspondre
* une classe qui implemente <i>INormalizer</i>.
* <ul>
* <li>NUMBER_NORMALIZER: Normalise une valeur numerique (entiere ou
* reelle)</li>
* <li>BOOLEAN_NORMALIZER: Normalise une valeur booleenne (typiquement
* <i>false</i>=0 et <i>true</i>=1</li>
* <li>POKEMON_TYPE_NORMALIZER: Normalise une valeur parmis les types
* de Pokemon possible. Chaque type recoit une valeur unique entre 0
* et 1</li>
* <li>etc. Chaque type enumere cree pour un DataSet doit avoir une
* constante associee et un <i>normaliseur</i></li>
* </ul>
*/
public enum NormalizerTypes {
NUMBER_NORMALIZER, BOOLEAN_NORMALIZER, POKEMON_TYPE_NORMALIZER;
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