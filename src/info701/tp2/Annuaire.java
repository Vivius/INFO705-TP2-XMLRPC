package info701.tp2;

import java.util.HashMap;
import java.util.Map;

public class Annuaire implements IAnnuaire{

    @Override
    public Boolean init(String o) {
        BDD.repertoire = new HashMap<>();
        return true;
    }

    @Override
    public Boolean ajouterEntree(String nom, String tel) {
        BDD.repertoire.put(nom, tel);
        System.out.println(BDD.repertoire.size());
        return true;
    }

    @Override
    public String trouverNumero(String nom) {
        for(Map.Entry<String, String> line : BDD.repertoire.entrySet()) {
            if(line.getKey().equals(nom))
                return  line.getValue();
        }
        return "";
    }

    @Override
    public int nbNumeros(String o) {
        return BDD.repertoire.size();
    }

    @Override
    public HashMap<String, String> getAll(String o) {
        return BDD.repertoire;
    }

    @Override
    public Boolean supprimerEntree(String nom) {
        BDD.repertoire.remove(nom);
        return true;
    }

    @Override
    public Boolean supprimerTout(String o) {
        BDD.repertoire.clear();
        return true;
    }
}
