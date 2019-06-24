import java.util.ArrayList;
import java.util.LinkedList;

public class KassaRij {

    ArrayList<Dienblad> dienBladen;
    LinkedList<Persoon> rijMensen;


    public KassaRij() {
        rijMensen = new LinkedList<>();
        dienBladen = new ArrayList<>();
    }

    public ArrayList<Dienblad> getDienbladen(){
        return this.dienBladen;
    }

    public void sluitAchteraan(Persoon klant, Dienblad dienblad) {
        rijMensen.add(klant);
        dienBladen.add(dienblad);
    }

    public Persoon eerstePersoonInRij() {
        if(!erIsEenRij()) {
            return null;
        }
        return rijMensen.remove(0);
    }

    public boolean erIsEenRij() {
        if(rijMensen.size() > 0){
            return true;
        }    else{
            return false;
        }
    }
}