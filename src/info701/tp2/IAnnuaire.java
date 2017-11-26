package info701.tp2;

import java.util.HashMap;

public interface IAnnuaire {
    Boolean init(String o);
    Boolean ajouterEntree(String nom, String tel);
    String trouverNumero(String nom);
    int nbNumeros(String o);
    HashMap<String, String> getAll(String o);
    Boolean supprimerEntree(String nom);
    Boolean supprimerTout(String o);
}
