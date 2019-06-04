import java.util.ArrayList;
import java.util.LinkedList;

public class KassaRij {

    private ArrayList<Dienblad> positieInRij;


    public KassaRij() {
        positieInRij = new ArrayList<>();
    }

    public void sluitAchteraan(Dienblad klant) {
        positieInRij.add(klant);
    }

    public Dienblad eerstePersoonInRij() {
        if(!erIsEenRij()) {
            return null;
        }
        return positieInRij.remove(0);
    }

    public boolean erIsEenRij() {
        if(positieInRij.size() > 0){
            return true;
        }    else{
            return false;
        }
    }
}