import java.util.ArrayList;
import java.util.LinkedList;

public class KassaRij {

    ArrayList<Dienblad> positieInRij;


    public KassaRij() {
        positieInRij = new ArrayList<>();
    }

    public void sluitAchteraan(Dienblad klant) {
        positieInRij.add(klant);
    }

    public Dienblad eerstePersoonInRij() {
        if(positieInRij.get(0) == null) {
            return null;
        }
        Dienblad eerste = positieInRij.get(0);
        positieInRij.remove(0);
        return eerste;
    }

    public boolean erIsEenRij() {
        if(positieInRij.size() > 0){
            return true;
        }    else{
            return false;
        }
    }
}