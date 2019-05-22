import java.util.ArrayList;
import java.util.LinkedList;

public class KassaRij {

    /**
     * Constructor
     */
    ArrayList<Dienblad> positieInRij;


    public KassaRij() {
        // method body omitted
        //ArrayList<String> dienblad = new ArrayList<String>()
        positieInRij = new ArrayList<>();
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param klant
     */
    public void sluitAchteraan(Dienblad klant) {
        // method body omitted
        //Dienblad.add();
        positieInRij.add(klant);

    }

    /**
     * Indien er een rij bestaat, de eerste klant uit
     * de rij verwijderen en retourneren.
     * Als er niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        // method body omitted
        if(positieInRij.get(0) == null) {
            return null;
        }
        positieInRij.remove(0);
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        if(positieInRij.size() > 0){
            return true;
        }    else{
            return false;
        }

    }
}